package net.mcreator.jujutsucraftv.item;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.item.renderer.FoundationStoneItemRenderer;
import net.mcreator.jujutsucraftv.procedures.ItemUseMainProcedure;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
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

public class FoundationStoneItem extends Item implements GeoItem {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private final Map<Object, Long> handledAnimationRequests = new WeakHashMap();
   private final Map<Object, Boolean> activeProcedureAnimations = new WeakHashMap();
   private final Map<Object, String> activeBaseAnimations = new WeakHashMap();

   public FoundationStoneItem() {
      super((new Item.Properties()).m_41503_(10).m_41497_(Rarity.COMMON));
      SingletonGeoAnimatable.registerSyncedAnimatable(this);
   }

   public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
      return false;
   }

   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      super.initializeClient(consumer);
      consumer.accept(new IClientItemExtensions() {
         private final BlockEntityWithoutLevelRenderer renderer = new FoundationStoneItemRenderer();

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
      String animationKey = "base:" + movementAnimation;
      if (!animationKey.equals(this.activeBaseAnimations.get(event.getController())) || event.getController().getAnimationState() == State.STOPPED) {
         event.getController().forceAnimationReset();
         event.getController().setAnimation(RawAnimation.begin().thenLoop(movementAnimation));
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

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      ItemStack itemstack = (ItemStack)ar.m_19095_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      ItemUseMainProcedure.execute(world, x, y, z, entity);
      return ar;
   }

   public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.m_6883_(itemstack, world, entity, slot, selected);
      if (world instanceof ServerLevel serverLevel) {
         GeoItem.getOrAssignId(itemstack, serverLevel);
      }

   }
}
