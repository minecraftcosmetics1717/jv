package net.mcreator.jujutsucraftv.network;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModVariables {
   public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
   });

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
      JujutsucraftvMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.register(PlayerVariables.class);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
   }

   @EventBusSubscriber
   public static class EventBusVariableHandlers {
      @SubscribeEvent
      public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void clonePlayer(PlayerEvent.Clone event) {
         event.getOriginal().revive();
         PlayerVariables original = (PlayerVariables)event.getOriginal().getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
         PlayerVariables clone = (PlayerVariables)event.getEntity().getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
         clone.CloneDefolt = original.CloneDefolt;
         clone.CursePowerFormerBackup = original.CursePowerFormerBackup;
         clone.Debug = original.Debug;
         clone.following = original.following;
         clone.Player_CS = original.Player_CS;
         clone.Player_CU = original.Player_CU;
         clone.Player_JS = original.Player_JS;
         clone.PlayerParticleColor = original.PlayerParticleColor;
         clone.PlayerParticleSet = original.PlayerParticleSet;
         clone.PlayerRespawn = original.PlayerRespawn;
         clone.PlayerWorldIn = original.PlayerWorldIn;
         clone.slotc_save = original.slotc_save;
         clone.test_txt = original.test_txt;
         clone.uiui_slot0 = original.uiui_slot0;
         clone.uiui_slot1 = original.uiui_slot1;
         clone.uiui_slot2 = original.uiui_slot2;
         clone.uiui_slot3 = original.uiui_slot3;
         clone.uiui_slot4 = original.uiui_slot4;
         clone.uiui_slot5 = original.uiui_slot5;
         clone.uiui_slot6 = original.uiui_slot6;
         clone.uiui_slot7 = original.uiui_slot7;
         clone.uiui_slot8 = original.uiui_slot8;
         clone.PlayerDomainInside = original.PlayerDomainInside;
         clone.PlayerDomainFloor = original.PlayerDomainFloor;
         clone.PlayerParticleSize = original.PlayerParticleSize;
         if (!event.isWasDeath()) {
            clone.CloneCount = original.CloneCount;
            clone.CloneMax = original.CloneMax;
            clone.PlayerCurseTechniqueBackup = original.PlayerCurseTechniqueBackup;
            clone.selected_techniwue_test = original.selected_techniwue_test;
            clone.slotc0 = original.slotc0;
            clone.slotc1 = original.slotc1;
            clone.slotc2 = original.slotc2;
            clone.slotc3 = original.slotc3;
            clone.slotc4 = original.slotc4;
            clone.slotc5 = original.slotc5;
            clone.slotc6 = original.slotc6;
            clone.slotc7 = original.slotc7;
            clone.slotc8 = original.slotc8;
            clone.slot_item_save = original.slot_item_save;
            clone.domain_block_set_inside = original.domain_block_set_inside;
            clone.domain_block_set_floor = original.domain_block_set_floor;
            clone.LifeCount = original.LifeCount;
            clone.bgm_tick = original.bgm_tick;
            clone.bgm_lv = original.bgm_lv;
         }

         if (!event.getEntity().m_9236_().m_5776_()) {
            for(Entity entityiterator : new ArrayList(event.getEntity().m_9236_().m_6907_())) {
               ((PlayerVariables)entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData mapdata = JujutsucraftvModVariables.MapVariables.get(event.getEntity().m_9236_());
            SavedData worlddata = JujutsucraftvModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (mapdata != null) {
               JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(0, mapdata));
            }

            if (worlddata != null) {
               JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
         }

      }

      @SubscribeEvent
      public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
         if (!event.getEntity().m_9236_().m_5776_()) {
            SavedData worlddata = JujutsucraftvModVariables.WorldVariables.get(event.getEntity().m_9236_());
            if (worlddata != null) {
               JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
         }

      }
   }

   public static class WorldVariables extends SavedData {
      public static final String DATA_NAME = "jujutsucraftv_worldvars";
      static WorldVariables clientSide = new WorldVariables();

      public static WorldVariables load(CompoundTag tag) {
         WorldVariables data = new WorldVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level level) {
            if (!level.m_5776_()) {
               SimpleChannel var10000 = JujutsucraftvMod.PACKET_HANDLER;
               PacketDistributor var10001 = PacketDistributor.DIMENSION;
               Objects.requireNonNull(level);
               var10000.send(var10001.with(level::m_46472_), new SavedDataSyncMessage(1, this));
            }
         }

      }

      public static WorldVariables get(LevelAccessor world) {
         if (world instanceof ServerLevel level) {
            return (WorldVariables)level.m_8895_().m_164861_((e) -> load(e), WorldVariables::new, "jujutsucraftv_worldvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class MapVariables extends SavedData {
      public static final String DATA_NAME = "jujutsucraftv_mapvars";
      public double strongest_player_v = (double)0.0F;
      public boolean vanilla_entity_spawn = false;
      public boolean jjcv_config_mahoraga_19 = false;
      public boolean jjcv_config_cp_color_get = true;
      public boolean jjcv_config_add_all_domain = true;
      public boolean jjcv_config_add_without_ct_domain = false;
      public boolean jjcv_config_gui_jjc_key = true;
      public boolean jjcv_config_job_selector_get = true;
      public boolean jjcv_config_sukuna_dismantle_combo = false;
      static MapVariables clientSide = new MapVariables();

      public static MapVariables load(CompoundTag tag) {
         MapVariables data = new MapVariables();
         data.read(tag);
         return data;
      }

      public void read(CompoundTag nbt) {
         if (nbt == null) {
            nbt = this.m_7176_(new CompoundTag());
         }

         this.strongest_player_v = nbt.m_128459_("strongest_player_v");
         this.vanilla_entity_spawn = nbt.m_128471_("vanilla_entity_spawn");
         this.jjcv_config_mahoraga_19 = nbt.m_128471_("jjcv_config_mahoraga_19");
         this.jjcv_config_cp_color_get = nbt.m_128471_("jjcv_config_cp_color_get");
         this.jjcv_config_add_all_domain = nbt.m_128471_("jjcv_config_add_all_domain");
         this.jjcv_config_add_without_ct_domain = nbt.m_128471_("jjcv_config_add_without_ct_domain");
         this.jjcv_config_gui_jjc_key = nbt.m_128471_("jjcv_config_gui_jjc_key");
         this.jjcv_config_job_selector_get = nbt.m_128471_("jjcv_config_job_selector_get");
         this.jjcv_config_sukuna_dismantle_combo = nbt.m_128471_("jjcv_config_sukuna_dismantle_combo");
      }

      public CompoundTag m_7176_(CompoundTag nbt) {
         nbt.m_128347_("strongest_player_v", this.strongest_player_v);
         nbt.m_128379_("vanilla_entity_spawn", this.vanilla_entity_spawn);
         nbt.m_128379_("jjcv_config_mahoraga_19", this.jjcv_config_mahoraga_19);
         nbt.m_128379_("jjcv_config_cp_color_get", this.jjcv_config_cp_color_get);
         nbt.m_128379_("jjcv_config_add_all_domain", this.jjcv_config_add_all_domain);
         nbt.m_128379_("jjcv_config_add_without_ct_domain", this.jjcv_config_add_without_ct_domain);
         nbt.m_128379_("jjcv_config_gui_jjc_key", this.jjcv_config_gui_jjc_key);
         nbt.m_128379_("jjcv_config_job_selector_get", this.jjcv_config_job_selector_get);
         nbt.m_128379_("jjcv_config_sukuna_dismantle_combo", this.jjcv_config_sukuna_dismantle_combo);
         return nbt;
      }

      public void syncData(LevelAccessor world) {
         this.m_77762_();
         if (world instanceof Level && !world.m_5776_()) {
            JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
         }

      }

      public static MapVariables get(LevelAccessor world) {
         if (world instanceof ServerLevelAccessor serverLevelAcc) {
            return (MapVariables)serverLevelAcc.m_6018_().m_7654_().m_129880_(Level.f_46428_).m_8895_().m_164861_((e) -> load(e), MapVariables::new, "jujutsucraftv_mapvars");
         } else {
            return clientSide;
         }
      }
   }

   public static class SavedDataSyncMessage {
      private final int type;
      private SavedData data;

      public SavedDataSyncMessage(FriendlyByteBuf buffer) {
         this.type = buffer.readInt();
         CompoundTag nbt = buffer.m_130260_();
         if (nbt != null) {
            this.data = (SavedData)(this.type == 0 ? new MapVariables() : new WorldVariables());
            SavedData var5 = this.data;
            if (var5 instanceof MapVariables) {
               MapVariables mapVariables = (MapVariables)var5;
               mapVariables.read(nbt);
            } else {
               var5 = this.data;
               if (var5 instanceof WorldVariables) {
                  WorldVariables worldVariables = (WorldVariables)var5;
                  worldVariables.read(nbt);
               }
            }
         }

      }

      public SavedDataSyncMessage(int type, SavedData data) {
         this.type = type;
         this.data = data;
      }

      public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.type);
         if (message.data != null) {
            buffer.m_130079_(message.data.m_7176_(new CompoundTag()));
         }

      }

      public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
               if (message.type == 0) {
                  JujutsucraftvModVariables.MapVariables.clientSide = (MapVariables)message.data;
               } else {
                  JujutsucraftvModVariables.WorldVariables.clientSide = (WorldVariables)message.data;
               }
            }

         });
         context.setPacketHandled(true);
      }
   }

   @EventBusSubscriber
   private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
      private final PlayerVariables playerVariables = new PlayerVariables();
      private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> this.playerVariables);

      @SubscribeEvent
      public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
         if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(new ResourceLocation("jujutsucraftv", "player_variables"), new PlayerVariablesProvider());
         }

      }

      public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
         return cap == JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY ? this.instance.cast() : LazyOptional.empty();
      }

      public Tag serializeNBT() {
         return this.playerVariables.writeNBT();
      }

      public void deserializeNBT(Tag nbt) {
         this.playerVariables.readNBT(nbt);
      }
   }

   public static class PlayerVariables {
      public double CloneCount = (double)0.0F;
      public double CloneDefolt = (double)4.0F;
      public double CloneMax = (double)4.0F;
      public double CursePowerFormerBackup = (double)0.0F;
      public boolean Debug = false;
      public boolean following = false;
      public boolean Player_CS = false;
      public boolean Player_CU = false;
      public boolean Player_JS = false;
      public double PlayerCurseTechniqueBackup = (double)0.0F;
      public double PlayerParticleColor = (double)0.0F;
      public boolean PlayerParticleSet = false;
      public boolean PlayerRespawn = false;
      public boolean PlayerWorldIn = false;
      public double selected_techniwue_test = (double)0.0F;
      public boolean slotc_save = true;
      public ItemStack slotc0;
      public ItemStack slotc1;
      public ItemStack slotc2;
      public ItemStack slotc3;
      public ItemStack slotc4;
      public ItemStack slotc5;
      public ItemStack slotc6;
      public ItemStack slotc7;
      public ItemStack slotc8;
      public String test_txt;
      public ItemStack slot_item_save;
      public String uiui_slot0;
      public String uiui_slot1;
      public String uiui_slot2;
      public String uiui_slot3;
      public String uiui_slot4;
      public String uiui_slot5;
      public String uiui_slot6;
      public String uiui_slot7;
      public String uiui_slot8;
      public String domain_block_set_inside;
      public String domain_block_set_floor;
      public boolean PlayerDomainInside;
      public boolean PlayerDomainFloor;
      public double PlayerParticleSize;
      public double LifeCount;
      public double bgm_tick;
      public double bgm_lv;

      public PlayerVariables() {
         this.slotc0 = ItemStack.f_41583_;
         this.slotc1 = ItemStack.f_41583_;
         this.slotc2 = ItemStack.f_41583_;
         this.slotc3 = ItemStack.f_41583_;
         this.slotc4 = ItemStack.f_41583_;
         this.slotc5 = ItemStack.f_41583_;
         this.slotc6 = ItemStack.f_41583_;
         this.slotc7 = ItemStack.f_41583_;
         this.slotc8 = ItemStack.f_41583_;
         this.test_txt = "\"\"";
         this.slot_item_save = ItemStack.f_41583_;
         this.uiui_slot0 = "\"\"";
         this.uiui_slot1 = "\"\"";
         this.uiui_slot2 = "\"\"";
         this.uiui_slot3 = "\"\"";
         this.uiui_slot4 = "\"\"";
         this.uiui_slot5 = "\"\"";
         this.uiui_slot6 = "\"\"";
         this.uiui_slot7 = "\"\"";
         this.uiui_slot8 = "\"\"";
         this.domain_block_set_inside = "\"\"";
         this.domain_block_set_floor = "\"\"";
         this.PlayerDomainInside = false;
         this.PlayerDomainFloor = false;
         this.PlayerParticleSize = (double)1.0F;
         this.LifeCount = (double)0.0F;
         this.bgm_tick = (double)0.0F;
         this.bgm_lv = (double)0.0F;
      }

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            SimpleChannel var10000 = JujutsucraftvMod.PACKET_HANDLER;
            PacketDistributor var10001 = PacketDistributor.DIMENSION;
            Level var10002 = entity.m_9236_();
            Objects.requireNonNull(var10002);
            var10000.send(var10001.with(var10002::m_46472_), new PlayerVariablesSyncMessage(this, entity.m_19879_()));
         }

      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.m_128347_("CloneCount", this.CloneCount);
         nbt.m_128347_("CloneDefolt", this.CloneDefolt);
         nbt.m_128347_("CloneMax", this.CloneMax);
         nbt.m_128347_("CursePowerFormerBackup", this.CursePowerFormerBackup);
         nbt.m_128379_("Debug", this.Debug);
         nbt.m_128379_("following", this.following);
         nbt.m_128379_("Player_CS", this.Player_CS);
         nbt.m_128379_("Player_CU", this.Player_CU);
         nbt.m_128379_("Player_JS", this.Player_JS);
         nbt.m_128347_("PlayerCurseTechniqueBackup", this.PlayerCurseTechniqueBackup);
         nbt.m_128347_("PlayerParticleColor", this.PlayerParticleColor);
         nbt.m_128379_("PlayerParticleSet", this.PlayerParticleSet);
         nbt.m_128379_("PlayerRespawn", this.PlayerRespawn);
         nbt.m_128379_("PlayerWorldIn", this.PlayerWorldIn);
         nbt.m_128347_("selected_techniwue_test", this.selected_techniwue_test);
         nbt.m_128379_("slotc_save", this.slotc_save);
         nbt.m_128365_("slotc0", this.slotc0.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc1", this.slotc1.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc2", this.slotc2.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc3", this.slotc3.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc4", this.slotc4.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc5", this.slotc5.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc6", this.slotc6.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc7", this.slotc7.m_41739_(new CompoundTag()));
         nbt.m_128365_("slotc8", this.slotc8.m_41739_(new CompoundTag()));
         nbt.m_128359_("test_txt", this.test_txt);
         nbt.m_128365_("slot_item_save", this.slot_item_save.m_41739_(new CompoundTag()));
         nbt.m_128359_("uiui_slot0", this.uiui_slot0);
         nbt.m_128359_("uiui_slot1", this.uiui_slot1);
         nbt.m_128359_("uiui_slot2", this.uiui_slot2);
         nbt.m_128359_("uiui_slot3", this.uiui_slot3);
         nbt.m_128359_("uiui_slot4", this.uiui_slot4);
         nbt.m_128359_("uiui_slot5", this.uiui_slot5);
         nbt.m_128359_("uiui_slot6", this.uiui_slot6);
         nbt.m_128359_("uiui_slot7", this.uiui_slot7);
         nbt.m_128359_("uiui_slot8", this.uiui_slot8);
         nbt.m_128359_("domain_block_set_inside", this.domain_block_set_inside);
         nbt.m_128359_("domain_block_set_floor", this.domain_block_set_floor);
         nbt.m_128379_("PlayerDomainInside", this.PlayerDomainInside);
         nbt.m_128379_("PlayerDomainFloor", this.PlayerDomainFloor);
         nbt.m_128347_("PlayerParticleSize", this.PlayerParticleSize);
         nbt.m_128347_("LifeCount", this.LifeCount);
         nbt.m_128347_("bgm_tick", this.bgm_tick);
         nbt.m_128347_("bgm_lv", this.bgm_lv);
         return nbt;
      }

      public void readNBT(Tag tag) {
         if (tag == null) {
            tag = this.writeNBT();
         }

         CompoundTag nbt = (CompoundTag)tag;
         if (nbt == null) {
            nbt = (CompoundTag)this.writeNBT();
         }

         this.CloneCount = nbt.m_128459_("CloneCount");
         this.CloneDefolt = nbt.m_128459_("CloneDefolt");
         this.CloneMax = nbt.m_128459_("CloneMax");
         this.CursePowerFormerBackup = nbt.m_128459_("CursePowerFormerBackup");
         this.Debug = nbt.m_128471_("Debug");
         this.following = nbt.m_128471_("following");
         this.Player_CS = nbt.m_128471_("Player_CS");
         this.Player_CU = nbt.m_128471_("Player_CU");
         this.Player_JS = nbt.m_128471_("Player_JS");
         this.PlayerCurseTechniqueBackup = nbt.m_128459_("PlayerCurseTechniqueBackup");
         this.PlayerParticleColor = nbt.m_128459_("PlayerParticleColor");
         this.PlayerParticleSet = nbt.m_128471_("PlayerParticleSet");
         this.PlayerRespawn = nbt.m_128471_("PlayerRespawn");
         this.PlayerWorldIn = nbt.m_128471_("PlayerWorldIn");
         this.selected_techniwue_test = nbt.m_128459_("selected_techniwue_test");
         this.slotc_save = nbt.m_128471_("slotc_save");
         this.slotc0 = ItemStack.m_41712_(nbt.m_128469_("slotc0"));
         this.slotc1 = ItemStack.m_41712_(nbt.m_128469_("slotc1"));
         this.slotc2 = ItemStack.m_41712_(nbt.m_128469_("slotc2"));
         this.slotc3 = ItemStack.m_41712_(nbt.m_128469_("slotc3"));
         this.slotc4 = ItemStack.m_41712_(nbt.m_128469_("slotc4"));
         this.slotc5 = ItemStack.m_41712_(nbt.m_128469_("slotc5"));
         this.slotc6 = ItemStack.m_41712_(nbt.m_128469_("slotc6"));
         this.slotc7 = ItemStack.m_41712_(nbt.m_128469_("slotc7"));
         this.slotc8 = ItemStack.m_41712_(nbt.m_128469_("slotc8"));
         this.test_txt = nbt.m_128461_("test_txt");
         this.slot_item_save = ItemStack.m_41712_(nbt.m_128469_("slot_item_save"));
         this.uiui_slot0 = nbt.m_128461_("uiui_slot0");
         this.uiui_slot1 = nbt.m_128461_("uiui_slot1");
         this.uiui_slot2 = nbt.m_128461_("uiui_slot2");
         this.uiui_slot3 = nbt.m_128461_("uiui_slot3");
         this.uiui_slot4 = nbt.m_128461_("uiui_slot4");
         this.uiui_slot5 = nbt.m_128461_("uiui_slot5");
         this.uiui_slot6 = nbt.m_128461_("uiui_slot6");
         this.uiui_slot7 = nbt.m_128461_("uiui_slot7");
         this.uiui_slot8 = nbt.m_128461_("uiui_slot8");
         this.domain_block_set_inside = nbt.m_128461_("domain_block_set_inside");
         this.domain_block_set_floor = nbt.m_128461_("domain_block_set_floor");
         this.PlayerDomainInside = nbt.m_128471_("PlayerDomainInside");
         this.PlayerDomainFloor = nbt.m_128471_("PlayerDomainFloor");
         this.PlayerParticleSize = nbt.m_128459_("PlayerParticleSize");
         this.LifeCount = nbt.m_128459_("LifeCount");
         this.bgm_tick = nbt.m_128459_("bgm_tick");
         this.bgm_lv = nbt.m_128459_("bgm_lv");
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final int target;
      private final PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new PlayerVariables();
         this.data.readNBT(buffer.m_130260_());
         this.target = buffer.readInt();
      }

      public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
         this.data = data;
         this.target = entityid;
      }

      public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.m_130079_((CompoundTag)message.data.writeNBT());
         buffer.writeInt(message.target);
      }

      public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               PlayerVariables variables = (PlayerVariables)Minecraft.m_91087_().f_91074_.m_9236_().m_6815_(message.target).getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new PlayerVariables());
               variables.CloneCount = message.data.CloneCount;
               variables.CloneDefolt = message.data.CloneDefolt;
               variables.CloneMax = message.data.CloneMax;
               variables.CursePowerFormerBackup = message.data.CursePowerFormerBackup;
               variables.Debug = message.data.Debug;
               variables.following = message.data.following;
               variables.Player_CS = message.data.Player_CS;
               variables.Player_CU = message.data.Player_CU;
               variables.Player_JS = message.data.Player_JS;
               variables.PlayerCurseTechniqueBackup = message.data.PlayerCurseTechniqueBackup;
               variables.PlayerParticleColor = message.data.PlayerParticleColor;
               variables.PlayerParticleSet = message.data.PlayerParticleSet;
               variables.PlayerRespawn = message.data.PlayerRespawn;
               variables.PlayerWorldIn = message.data.PlayerWorldIn;
               variables.selected_techniwue_test = message.data.selected_techniwue_test;
               variables.slotc_save = message.data.slotc_save;
               variables.slotc0 = message.data.slotc0;
               variables.slotc1 = message.data.slotc1;
               variables.slotc2 = message.data.slotc2;
               variables.slotc3 = message.data.slotc3;
               variables.slotc4 = message.data.slotc4;
               variables.slotc5 = message.data.slotc5;
               variables.slotc6 = message.data.slotc6;
               variables.slotc7 = message.data.slotc7;
               variables.slotc8 = message.data.slotc8;
               variables.test_txt = message.data.test_txt;
               variables.slot_item_save = message.data.slot_item_save;
               variables.uiui_slot0 = message.data.uiui_slot0;
               variables.uiui_slot1 = message.data.uiui_slot1;
               variables.uiui_slot2 = message.data.uiui_slot2;
               variables.uiui_slot3 = message.data.uiui_slot3;
               variables.uiui_slot4 = message.data.uiui_slot4;
               variables.uiui_slot5 = message.data.uiui_slot5;
               variables.uiui_slot6 = message.data.uiui_slot6;
               variables.uiui_slot7 = message.data.uiui_slot7;
               variables.uiui_slot8 = message.data.uiui_slot8;
               variables.domain_block_set_inside = message.data.domain_block_set_inside;
               variables.domain_block_set_floor = message.data.domain_block_set_floor;
               variables.PlayerDomainInside = message.data.PlayerDomainInside;
               variables.PlayerDomainFloor = message.data.PlayerDomainFloor;
               variables.PlayerParticleSize = message.data.PlayerParticleSize;
               variables.LifeCount = message.data.LifeCount;
               variables.bgm_tick = message.data.bgm_tick;
               variables.bgm_lv = message.data.bgm_lv;
            }

         });
         context.setPacketHandled(true);
      }
   }
}
