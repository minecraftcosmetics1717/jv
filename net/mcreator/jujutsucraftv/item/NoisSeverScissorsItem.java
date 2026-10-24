package net.mcreator.jujutsucraftv.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.item.renderer.NoisSeverScissorsItemRenderer;
import net.mcreator.jujutsucraftv.procedures.ItemInfoReturnCursedtoolProcedure;
import net.mcreator.jujutsucraftv.procedures.WeaponUseStartProcedure;
import net.mcreator.jujutsucraftv.procedures.WeaponUseStopProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class NoisSeverScissorsItem extends Item implements GeoItem {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private final Map<Object, Long> handledAnimationRequests = new WeakHashMap();
   private final Map<Object, Boolean> activeProcedureAnimations = new WeakHashMap();
   private final Map<Object, String> activeBaseAnimations = new WeakHashMap();

   public NoisSeverScissorsItem() {
      super((new Item.Properties()).m_41503_(1200).m_41497_(Rarity.COMMON));
      SingletonGeoAnimatable.registerSyncedAnimatable(this);
   }

   public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
      return false;
   }

   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      super.initializeClient(consumer);
      consumer.accept(new IClientItemExtensions() {
         private final BlockEntityWithoutLevelRenderer renderer = new NoisSeverScissorsItemRenderer();

         public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return this.renderer;
         }
      });
   }

   private PlayState animationPredicate(AnimationState event) {
      ItemStack stack = (ItemStack)event.getData(DataTickets.ITEMSTACK);
      String requestedAnimation = stack != null && stack.m_41782_() ? stack.m_41783_().m_128461_("geckoAnim") : "";
      long request = stack != null && stack.m_41782_() ? stack.m_41783_().m_128454_("geckoAnimRequest") : 0L;
      long handledRequest = (Long)this.handledAnimationRequests.getOrDefault(event.getController(), 0L);
      if (!requestedAnimation.isEmpty() && request != 0L && request != handledRequest) {
         this.handledAnimationRequests.put(event.getController(), request);
         this.activeBaseAnimations.remove(event.getController());
         event.getController().forceAnimationReset();
         if (!requestedAnimation.equals("empty")) {
            this.activeProcedureAnimations.put(event.getController(), true);
            event.getController().setAnimation(RawAnimation.begin().thenPlay(requestedAnimation));
            return PlayState.CONTINUE;
         }

         this.activeProcedureAnimations.remove(event.getController());
      }

      if (this.activeProcedureAnimations.containsKey(event.getController())) {
         if (event.getController().getAnimationState() != State.STOPPED) {
            return PlayState.CONTINUE;
         }

         this.activeProcedureAnimations.remove(event.getController());
         this.activeBaseAnimations.remove(event.getController());
      }

      String movementAnimation = "idle";
      long gameTime = Minecraft.m_91087_().f_91073_ == null ? 0L : Minecraft.m_91087_().f_91073_.m_46467_();
      long swingEnd = stack != null && stack.m_41782_() ? stack.m_41783_().m_128454_("geckoSwingEnd") : 0L;
      boolean playSwing = gameTime < swingEnd;
      String animationKey = playSwing ? "swing:" + swingEnd : "base:" + movementAnimation;
      if (!animationKey.equals(this.activeBaseAnimations.get(event.getController())) || event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         if (playSwing) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay("swing").thenLoop(movementAnimation));
         } else {
            event.getController().setAnimation(RawAnimation.begin().thenLoop(movementAnimation));
         }

         this.activeBaseAnimations.put(event.getController(), animationKey);
      }

      return PlayState.CONTINUE;
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "mainController", 0, this::animationPredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }

   public float m_8102_(ItemStack par1ItemStack, BlockState par2Block) {
      return 1.2F;
   }

   public Multimap<Attribute, AttributeModifier> m_7167_(EquipmentSlot equipmentSlot) {
      if (equipmentSlot == EquipmentSlot.MAINHAND) {
         ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
         builder.putAll(super.m_7167_(equipmentSlot));
         builder.put(Attributes.f_22281_, new AttributeModifier(f_41374_, "Item modifier", (double)6.0F, Operation.ADDITION));
         builder.put(Attributes.f_22283_, new AttributeModifier(f_41375_, "Item modifier", -2.4, Operation.ADDITION));
         return builder.build();
      } else {
         return super.m_7167_(equipmentSlot);
      }
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      Entity entity = itemstack.m_41609_();
      String hoverText = ItemInfoReturnCursedtoolProcedure.execute(itemstack);
      if (hoverText != null) {
         for(String line : hoverText.split("\n")) {
            list.add(Component.m_237113_(line));
         }
      }

   }

   public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
      boolean retval = super.onEntitySwing(itemstack, entity);
      if (entity.m_21205_() == itemstack || entity.m_21206_() == itemstack) {
         itemstack.m_41784_().m_128356_("geckoSwingEnd", entity.m_9236_().m_46467_() + 10L);
      }

      return retval;
   }

   public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.m_6883_(itemstack, world, entity, slot, selected);
      if (world instanceof ServerLevel serverLevel) {
         GeoItem.getOrAssignId(itemstack, serverLevel);
      }

   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      ItemStack itemstack = entity.m_21120_(hand);
      entity.m_6672_(hand);
      WeaponUseStartProcedure.execute(world, entity, itemstack);
      return InteractionResultHolder.m_19096_(itemstack);
   }

   public int m_8105_(ItemStack itemstack) {
      return 72000;
   }

   public UseAnim m_6164_(ItemStack itemstack) {
      return UseAnim.NONE;
   }

   public void m_5551_(ItemStack itemstack, Level world, LivingEntity entity, int time) {
      WeaponUseStopProcedure.execute(world, entity, itemstack);
   }
}
