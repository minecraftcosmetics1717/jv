package net.mcreator.jujutsucraftv.item;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.client.renderer.ClothesRozetsuShikigamiVesselArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
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
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ClothesRozetsuShikigamiVesselItem extends ArmorItem implements GeoItem {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   private final Map<Object, Long> handledAnimationRequests = new WeakHashMap();
   private final Map<Object, Boolean> activeProcedureAnimations = new WeakHashMap();
   private final Map<Object, String> activeBaseAnimations = new WeakHashMap();

   public ClothesRozetsuShikigamiVesselItem(ArmorItem.Type type, Item.Properties properties) {
      super(new ArmorMaterial() {
         public int m_266425_(ArmorItem.Type type) {
            return (new int[]{13, 15, 16, 11})[type.m_266308_().m_20749_()] * 0;
         }

         public int m_7366_(ArmorItem.Type type) {
            return (new int[]{2, 0, 0, 2})[type.m_266308_().m_20749_()];
         }

         public int m_6646_() {
            return 9;
         }

         public SoundEvent m_7344_() {
            return SoundEvents.f_271165_;
         }

         public Ingredient m_6230_() {
            return Ingredient.m_151265_();
         }

         public String m_6082_() {
            return "clothes_rozetsu_shikigami_vessel";
         }

         public float m_6651_() {
            return 0.0F;
         }

         public float m_6649_() {
            return 0.0F;
         }
      }, type, properties);
      SingletonGeoAnimatable.registerSyncedAnimatable(this);
   }

   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      consumer.accept(new IClientItemExtensions() {
         private GeoArmorRenderer<?> renderer;

         public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
            if (this.renderer == null) {
               this.renderer = new ClothesRozetsuShikigamiVesselArmorRenderer();
            }

            this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
            return this.renderer;
         }
      });
   }

   public void m_7373_(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, world, list, flag);
   }

   private boolean canAnimate(Entity entity) {
      return entity instanceof ArmorStand ? true : true;
   }

   private PlayState animationPredicate(AnimationState event) {
      Entity entity = (Entity)event.getData(DataTickets.ENTITY);
      if (entity != null && this.canAnimate(entity)) {
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
      } else {
         return PlayState.STOP;
      }
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "mainController", 5, this::animationPredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
