package net.mcreator.jujutsucraftv.item;

import java.util.List;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.client.renderer.ClothesMahito2ArmorRenderer;
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

public class ClothesMahito2Item extends ArmorItem implements GeoItem {
   private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
   public String animationprocedure = "empty";
   String prevAnim = "empty";

   public ClothesMahito2Item(ArmorItem.Type type, Item.Properties properties) {
      super(new ArmorMaterial() {
         public int m_266425_(ArmorItem.Type type) {
            return (new int[]{13, 15, 16, 11})[type.m_266308_().m_20749_()] * 0;
         }

         public int m_7366_(ArmorItem.Type type) {
            return (new int[]{2, 5, 6, 0})[type.m_266308_().m_20749_()];
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
            return "clothes_mahito_2";
         }

         public float m_6651_() {
            return 0.0F;
         }

         public float m_6649_() {
            return 0.0F;
         }
      }, type, properties);
   }

   public void initializeClient(Consumer<IClientItemExtensions> consumer) {
      consumer.accept(new IClientItemExtensions() {
         private GeoArmorRenderer<?> renderer;

         public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
            if (this.renderer == null) {
               this.renderer = new ClothesMahito2ArmorRenderer();
            }

            this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
            return this.renderer;
         }
      });
   }

   public void m_7373_(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, world, list, flag);
   }

   private PlayState predicate(AnimationState event) {
      if (this.animationprocedure.equals("empty")) {
         Entity entity = (Entity)event.getData(DataTickets.ENTITY);
         if (entity instanceof ArmorStand) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("idle2"));
            return PlayState.CONTINUE;
         } else {
            if (entity.m_20142_()) {
               event.getController().setAnimation(RawAnimation.begin().thenLoop("sprint2"));
            } else if (entity.m_20184_().m_82556_() > 0.01) {
               event.getController().setAnimation(RawAnimation.begin().thenLoop("walk2"));
            } else {
               event.getController().setAnimation(RawAnimation.begin().thenLoop("idle2"));
            }

            return PlayState.CONTINUE;
         }
      } else {
         return PlayState.STOP;
      }
   }

   private PlayState procedurePredicate(AnimationState event) {
      if ((this.animationprocedure.equals("empty") || event.getController().getAnimationState() != State.STOPPED) && (this.animationprocedure.equals(this.prevAnim) || this.animationprocedure.equals("empty"))) {
         if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
         } else {
            this.prevAnim = this.animationprocedure;
            return PlayState.CONTINUE;
         }
      } else {
         if (!this.animationprocedure.equals(this.prevAnim)) {
            event.getController().forceAnimationReset();
         }

         event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
         if (event.getController().getAnimationState() == State.STOPPED) {
            this.animationprocedure = "empty";
            event.getController().forceAnimationReset();
         }

         Entity entity = (Entity)event.getData(DataTickets.ENTITY);
         return entity instanceof ArmorStand ? PlayState.CONTINUE : PlayState.CONTINUE;
      }
   }

   public void registerControllers(AnimatableManager.ControllerRegistrar data) {
      data.add(new AnimationController[]{new AnimationController(this, "controller", 5, this::predicate)});
      data.add(new AnimationController[]{new AnimationController(this, "procedureController", 5, this::procedurePredicate)});
   }

   public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
   }
}
