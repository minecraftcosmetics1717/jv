package net.mcreator.jujutsucraftv.procedures;

import com.mojang.logging.LogUtils;
import dev.kosmx.playerAnim.api.firstPerson.FirstPersonConfiguration;
import dev.kosmx.playerAnim.api.firstPerson.FirstPersonMode;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.slf4j.Logger;
import software.bernie.geckolib.animatable.GeoEntity;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.MOD
)
public class SetupAnimationsProcedure {
   private static final Logger LOGGER = LogUtils.getLogger();
   private static final ResourceLocation ANIMATION_LAYER_ID = new ResourceLocation("jujutsucraftv", "player_animation");
   private static final int ANIMATION_LAYER_PRIORITY = 1000;
   private static final int NO_REPLAY_CODE = Integer.MIN_VALUE;
   private static final ThreadLocal<Integer> REPLAY_CODE = ThreadLocal.withInitial(() -> Integer.MIN_VALUE);
   private static final ThreadLocal<Boolean> REPLAY_MATCHED = ThreadLocal.withInitial(() -> false);
   private static final String DISPATCH_GUARD = "jujutsucraftv_animation_dispatch_guard";
   private static final String LAST_CODE = "jujutsucraftv_animation_last_code";
   private static final String LAST_TICK = "jujutsucraftv_animation_last_tick";
   private static final Set<EntityType<?>> MISSING_ATTRIBUTE_TYPES = Collections.newSetFromMap(new ConcurrentHashMap());

   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(ANIMATION_LAYER_ID, 1000, SetupAnimationsProcedure::createAnimationLayer);
         LOGGER.info("[jujutsucraftv AnimationBridge] Registered player layer {}", ANIMATION_LAYER_ID);
      });
   }

   @OnlyIn(Dist.CLIENT)
   private static IAnimation createAnimationLayer(AbstractClientPlayer player) {
      return new ModifierLayer();
   }

   @SubscribeEvent
   public static void attachAnimationAttribute(EntityAttributeModificationEvent event) {
      Attribute attribute = (Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get();
      int added = 0;

      for(EntityType<? extends LivingEntity> type : event.getTypes()) {
         if (!event.has(type, attribute)) {
            event.add(type, attribute);
            ++added;
         }
      }

      LOGGER.info("[jujutsucraftv AnimationBridge] Attached ANIMATION_V_1 to {} living entity types", added);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(JujutsucraftvModAnimationSignal.class, JujutsucraftvModAnimationSignal::encode, JujutsucraftvModAnimationSignal::new, JujutsucraftvModAnimationSignal::handle);
      LOGGER.info("[jujutsucraftv AnimationBridge] Registered bidirectional numeric animation signal");
   }

   public static void playMappedIfCode(LevelAccessor world, Entity entity, int animationCode, String animationName) {
      playResolved(world, entity, animationCode, animationName);
   }

   public static void playConfiguredFromAttribute(LevelAccessor world, Entity entity, String animationName) {
      if (entity != null && animationName != null) {
         int code = readAnimationCode(entity);
         if (code != 0) {
            playResolved(world, entity, code, animationName);
         }

      }
   }

   public static void playResolved(LevelAccessor world, Entity entity, int animationCode, String animationName) {
      if (entity != null && animationName != null && animationCode != 0) {
         LevelAccessor effectiveWorld = (LevelAccessor)(world != null ? world : entity.m_9236_());
         boolean replay = (Integer)REPLAY_CODE.get() != Integer.MIN_VALUE;
         if (replay) {
            REPLAY_MATCHED.set(true);
         }

         LOGGER.info("[jujutsucraftv AnimationBridge] Resolved code={} animation={} side={} replay={} target={}", new Object[]{animationCode, animationName, effectiveWorld.m_5776_() ? "CLIENT" : "SERVER", replay, entity.m_19879_()});
         if (effectiveWorld.m_5776_()) {
            if (entity instanceof Player) {
               Player player = (Player)entity;
               if (replay) {
                  DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> SetupAnimationsProcedure.ClientBridge.playPlayer(player, animationName, true, true, true));
               } else {
                  DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> SetupAnimationsProcedure.ClientBridge.requestServer(animationCode, entity.m_19879_(), entity.m_20148_()));
                  clearAnimationCode(entity);
               }
            }
         } else if (entity instanceof Player) {
            sendPlayerSignal(entity, animationCode);
            clearAnimationCode(entity);
         } else {
            if (entity instanceof GeoEntity && playGeckoEntity(entity, animationName)) {
               clearAnimationCode(entity);
            }

         }
      }
   }

   private static int readAnimationCode(Entity entity) {
      int replayCode = (Integer)REPLAY_CODE.get();
      return replayCode != Integer.MIN_VALUE ? replayCode : readBaseAnimationCode(entity);
   }

   private static int readBaseAnimationCode(Entity entity) {
      if (entity instanceof LivingEntity livingEntity) {
         Attribute attribute = (Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get();
         if (!livingEntity.m_21204_().m_22171_(attribute)) {
            if (MISSING_ATTRIBUTE_TYPES.add(entity.m_6095_())) {
               LOGGER.error("[jujutsucraftv AnimationBridge] {} does not contain ANIMATION_V_1", entity.m_6095_());
            }

            return 0;
         } else {
            AttributeInstance instance = livingEntity.m_21051_(attribute);
            if (instance == null) {
               return 0;
            } else {
               int baseCode = (int)Math.round(instance.m_22115_());
               return baseCode != 0 ? baseCode : (int)Math.round(instance.m_22135_());
            }
         }
      } else {
         return 0;
      }
   }

   private static void setAnimationCode(Entity entity, int animationCode) {
      if (entity instanceof LivingEntity livingEntity) {
         Attribute attribute = (Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get();
         if (livingEntity.m_21204_().m_22171_(attribute)) {
            AttributeInstance instance = livingEntity.m_21051_(attribute);
            if (instance != null) {
               instance.m_22100_((double)animationCode);
            }

         }
      }
   }

   private static void clearAnimationCode(Entity entity) {
      setAnimationCode(entity, 0);
   }

   private static void sendPlayerSignal(Entity entity, int animationCode) {
      if (!entity.m_9236_().m_5776_() && entity instanceof Player) {
         JujutsucraftvModAnimationSignal message = new JujutsucraftvModAnimationSignal(animationCode, entity.m_19879_(), entity.m_20148_());
         JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), message);
         LOGGER.info("[jujutsucraftv AnimationBridge] S2C code={} target={}", animationCode, entity.m_19879_());
      }
   }

   private static boolean playGeckoEntity(Entity entity, String animationName) {
      if (!entity.m_9236_().m_5776_() && entity instanceof GeoEntity && !animationName.isBlank()) {
         try {
            Method method = entity.getClass().getMethod("setAnimation", String.class);
            method.invoke(entity, animationName);
            LOGGER.info("[jujutsucraftv AnimationBridge] GeckoLib play {} on {}", animationName, entity.m_6095_());
            return true;
         } catch (ReflectiveOperationException exception) {
            LOGGER.error("[jujutsucraftv AnimationBridge] Could not call setAnimation(String) on {}", entity.m_6095_(), exception);
            return false;
         }
      } else {
         return false;
      }
   }

   public static void playAnimation(LevelAccessor world, Entity entity, String animationName, boolean override) {
      playAnimation(world, entity, animationName, override, true, true);
   }

   public static void playAnimation(LevelAccessor world, Entity entity, String animationName, boolean override, boolean showLeftArm, boolean showRightArm) {
      if (entity != null && animationName != null) {
         LevelAccessor effectiveWorld = (LevelAccessor)(world != null ? world : entity.m_9236_());
         if (effectiveWorld.m_5776_() && entity instanceof Player) {
            Player player = (Player)entity;
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> SetupAnimationsProcedure.ClientBridge.playPlayer(player, animationName, override, showLeftArm, showRightArm));
         }

      }
   }

   @OnlyIn(Dist.CLIENT)
   public static void setAnimationClientside(Player player, String animationName, boolean override) {
      SetupAnimationsProcedure.ClientBridge.playPlayer(player, animationName, override, true, true);
   }

   private static void handleServerRequest(JujutsucraftvModAnimationSignal message, NetworkEvent.Context context) {
      ServerPlayer sender = context.getSender();
      if (sender != null && message.animationCode != 0) {
         LOGGER.info("[jujutsucraftv AnimationBridge] C2S code={} sender={}", message.animationCode, sender.m_36316_().getName());
         setAnimationCode(sender, message.animationCode);

         try {
            PlayAnimationVProcedure.execute(sender.m_9236_(), sender);
         } finally {
            if (readBaseAnimationCode(sender) == message.animationCode) {
               clearAnimationCode(sender);
            }

         }

      }
   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
   }

   public static class JujutsucraftvModAnimationSignal {
      private final int animationCode;
      private final int targetId;
      private final UUID targetUuid;

      public JujutsucraftvModAnimationSignal(int animationCode, int targetId, UUID targetUuid) {
         this.animationCode = animationCode;
         this.targetId = targetId;
         this.targetUuid = targetUuid;
      }

      public JujutsucraftvModAnimationSignal(FriendlyByteBuf buffer) {
         this.animationCode = buffer.readInt();
         this.targetId = buffer.readInt();
         this.targetUuid = buffer.m_130259_();
      }

      public static void encode(JujutsucraftvModAnimationSignal message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.animationCode);
         buffer.writeInt(message.targetId);
         buffer.m_130077_(message.targetUuid);
      }

      public static void handle(JujutsucraftvModAnimationSignal message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         if (context.getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
            context.enqueueWork(() -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> SetupAnimationsProcedure.ClientBridge.receive(message)));
         } else if (context.getDirection() == NetworkDirection.PLAY_TO_SERVER) {
            context.enqueueWork(() -> SetupAnimationsProcedure.handleServerRequest(message, context));
         }

         context.setPacketHandled(true);
      }
   }

   @OnlyIn(Dist.CLIENT)
   private static class ClientBridge {
      private static final Map<UUID, PendingSignal> PENDING = new HashMap();
      private static int lastRequestedCode = 0;
      private static long lastRequestedTick = Long.MIN_VALUE;

      private static void requestServer(int animationCode, int targetId, UUID targetUuid) {
         Minecraft minecraft = Minecraft.m_91087_();
         if (minecraft.f_91074_ != null && animationCode != 0) {
            long gameTime = minecraft.f_91074_.m_9236_().m_46467_();
            if (lastRequestedCode != animationCode || gameTime - lastRequestedTick > 2L) {
               lastRequestedCode = animationCode;
               lastRequestedTick = gameTime;
               JujutsucraftvMod.PACKET_HANDLER.sendToServer(new JujutsucraftvModAnimationSignal(animationCode, targetId, targetUuid));
               SetupAnimationsProcedure.LOGGER.info("[jujutsucraftv AnimationBridge] C2S request code={}", animationCode);
            }
         }
      }

      private static void receive(JujutsucraftvModAnimationSignal message) {
         if (!playSignal(message)) {
            PENDING.put(message.targetUuid, new PendingSignal(message, 100));
         }

      }

      private static boolean playSignal(JujutsucraftvModAnimationSignal message) {
         Minecraft minecraft = Minecraft.m_91087_();
         if (minecraft.f_91073_ == null) {
            return false;
         } else {
            Entity target = minecraft.f_91073_.m_6815_(message.targetId);
            if (!(target instanceof Player)) {
               for(Player player : minecraft.f_91073_.m_6907_()) {
                  if (message.targetUuid.equals(player.m_20148_())) {
                     target = player;
                     break;
                  }
               }
            }

            if (target instanceof LivingEntity) {
               LivingEntity livingTarget = (LivingEntity)target;
               Attribute attribute = (Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get();
               if (!livingTarget.m_21204_().m_22171_(attribute)) {
                  return false;
               } else {
                  AttributeInstance instance = livingTarget.m_21051_(attribute);
                  if (instance == null) {
                     return false;
                  } else {
                     double previousBase = instance.m_22115_();
                     SetupAnimationsProcedure.REPLAY_CODE.set(message.animationCode);
                     SetupAnimationsProcedure.REPLAY_MATCHED.set(false);
                     instance.m_22100_((double)message.animationCode);

                     try {
                        SetupAnimationsProcedure.LOGGER.info("[jujutsucraftv AnimationBridge] S2C receive code={} target={}", message.animationCode, target.m_19879_());
                        PlayAnimationVProcedure.execute(minecraft.f_91073_, target);
                        if (!(Boolean)SetupAnimationsProcedure.REPLAY_MATCHED.get()) {
                           SetupAnimationsProcedure.LOGGER.error("[jujutsucraftv AnimationBridge] PlayAnimationV has no mapping for code {}", message.animationCode);
                        }
                     } finally {
                        instance.m_22100_(previousBase == (double)message.animationCode ? (double)0.0F : previousBase);
                        SetupAnimationsProcedure.REPLAY_CODE.remove();
                        SetupAnimationsProcedure.REPLAY_MATCHED.remove();
                     }

                     return true;
                  }
               }
            } else {
               return false;
            }
         }
      }

      private static void tickPending() {
         Iterator<Map.Entry<UUID, PendingSignal>> iterator = PENDING.entrySet().iterator();

         while(iterator.hasNext()) {
            PendingSignal pending = (PendingSignal)((Map.Entry)iterator.next()).getValue();
            if (playSignal(pending.message)) {
               iterator.remove();
            } else {
               --pending.ticksLeft;
               if (pending.ticksLeft <= 0) {
                  SetupAnimationsProcedure.LOGGER.error("[jujutsucraftv AnimationBridge] Timed out finding player {}", pending.message.targetUuid);
                  iterator.remove();
               }
            }
         }

      }

      private static void tickLocalAttribute() {
         Minecraft minecraft = Minecraft.m_91087_();
         if (minecraft.f_91073_ != null && minecraft.f_91074_ != null) {
            int code = SetupAnimationsProcedure.readBaseAnimationCode(minecraft.f_91074_);
            if (code != 0) {
               PlayAnimationVProcedure.execute(minecraft.f_91073_, minecraft.f_91074_);
            }
         }
      }

      private static ModifierLayer<IAnimation> getOrCreateLayer(AbstractClientPlayer player) {
         IAnimation stored = PlayerAnimationAccess.getPlayerAssociatedData(player).get(SetupAnimationsProcedure.ANIMATION_LAYER_ID);
         if (stored instanceof ModifierLayer<?> modifierLayer) {
            return modifierLayer;
         } else {
            try {
               ModifierLayer<IAnimation> layer = new ModifierLayer();
               PlayerAnimationAccess.getPlayerAnimLayer(player).addAnimLayer(1000, layer);
               PlayerAnimationAccess.getPlayerAssociatedData(player).set(SetupAnimationsProcedure.ANIMATION_LAYER_ID, layer);
               SetupAnimationsProcedure.LOGGER.info("[jujutsucraftv AnimationBridge] Created fallback layer for {}", player.m_36316_().getName());
               return layer;
            } catch (RuntimeException exception) {
               SetupAnimationsProcedure.LOGGER.error("[jujutsucraftv AnimationBridge] Could not create player animation layer", exception);
               return null;
            }
         }
      }

      private static boolean playPlayer(Player player, String animationName, boolean override, boolean showLeftArm, boolean showRightArm) {
         if (player instanceof AbstractClientPlayer clientPlayer) {
            ModifierLayer<IAnimation> layer = getOrCreateLayer(clientPlayer);
            if (layer == null) {
               return false;
            } else if (animationName != null && !animationName.isBlank() && !animationName.equalsIgnoreCase("stop")) {
               if (!override && layer.isActive()) {
                  return true;
               } else {
                  ResourceLocation animationId = animationName.contains(":") ? ResourceLocation.m_135820_(animationName) : new ResourceLocation("jujutsucraftv", animationName);
                  if (animationId == null) {
                     return false;
                  } else {
                     KeyframeAnimation keyframes = PlayerAnimationRegistry.getAnimation(animationId);
                     if (keyframes == null) {
                        SetupAnimationsProcedure.LOGGER.error("[jujutsucraftv AnimationBridge] Animation {} is not registered", animationId);
                        return false;
                     } else {
                        KeyframeAnimationPlayer animationPlayer = new KeyframeAnimationPlayer(keyframes);
                        if (showLeftArm || showRightArm) {
                           animationPlayer.setFirstPersonMode(FirstPersonMode.THIRD_PERSON_MODEL).setFirstPersonConfiguration((new FirstPersonConfiguration()).setShowLeftArm(showLeftArm).setShowRightArm(showRightArm));
                        }

                        layer.setAnimation(animationPlayer);
                        SetupAnimationsProcedure.LOGGER.info("[jujutsucraftv AnimationBridge] Playing {} on {}", animationId, clientPlayer.m_36316_().getName());
                        return true;
                     }
                  }
               }
            } else {
               layer.setAnimation((IAnimation)null);
               return true;
            }
         } else {
            return false;
         }
      }

      private static class PendingSignal {
         private final JujutsucraftvModAnimationSignal message;
         private int ticksLeft;

         private PendingSignal(JujutsucraftvModAnimationSignal message, int ticksLeft) {
            this.message = message;
            this.ticksLeft = ticksLeft;
         }
      }
   }

   @EventBusSubscriber(
      modid = "jujutsucraftv",
      bus = Bus.FORGE,
      value = {Dist.CLIENT}
   )
   public static class ClientEvents {
      @SubscribeEvent
      public static void onClientTick(TickEvent.ClientTickEvent event) {
         if (event.phase == Phase.END) {
            SetupAnimationsProcedure.ClientBridge.tickPending();
            SetupAnimationsProcedure.ClientBridge.tickLocalAttribute();
         }
      }
   }

   @EventBusSubscriber(
      modid = "jujutsucraftv",
      bus = Bus.FORGE
   )
   public static class ServerEvents {
      @SubscribeEvent
      public static void onLivingTick(LivingEvent.LivingTickEvent event) {
         LivingEntity entity = event.getEntity();
         if (!entity.m_9236_().m_5776_()) {
            if (entity instanceof Player || entity instanceof GeoEntity) {
               int code = SetupAnimationsProcedure.readBaseAnimationCode(entity);
               if (code != 0) {
                  CompoundTag data = entity.getPersistentData();
                  if (!data.m_128471_("jujutsucraftv_animation_dispatch_guard")) {
                     long gameTime = entity.m_9236_().m_46467_();
                     if (data.m_128451_("jujutsucraftv_animation_last_code") != code || gameTime - data.m_128454_("jujutsucraftv_animation_last_tick") >= 3L) {
                        data.m_128405_("jujutsucraftv_animation_last_code", code);
                        data.m_128356_("jujutsucraftv_animation_last_tick", gameTime);
                        data.m_128379_("jujutsucraftv_animation_dispatch_guard", true);

                        try {
                           PlayAnimationVProcedure.execute(entity.m_9236_(), entity);
                        } finally {
                           data.m_128473_("jujutsucraftv_animation_dispatch_guard");
                        }

                     }
                  }
               }
            }
         }
      }
   }
}
