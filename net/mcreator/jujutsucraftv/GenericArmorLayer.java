package net.mcreator.jujutsucraftv;

import java.util.Collections;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class GenericArmorLayer<T extends LivingEntity & GeoAnimatable> extends ItemArmorGeoLayer<T> {
   private static final TagKey<Item> WAIST_TAG;
   private static final ModelPart EMPTY;

   public GenericArmorLayer(DynamicGeoEntityRenderer<T> geoRenderer) {
      super(geoRenderer);
   }

   @Nullable
   protected ItemStack getArmorItemForBone(GeoBone bone, T animatable) {
      String name = bone.getName();
      if (!"armorWaist".equals(name)) {
         ItemStack var10000;
         switch (name) {
            case "armorHead":
               var10000 = this.helmetStack;
               break;
            case "armorBody":
            case "armorLeftArm":
            case "armorRightArm":
               var10000 = this.chestplateStack;
               break;
            case "armorLeftLeg":
            case "armorRightLeg":
               var10000 = this.leggingsStack;
               break;
            case "armorLeftBoot":
            case "armorRightBoot":
               var10000 = this.bootsStack;
               break;
            default:
               var10000 = null;
         }

         return var10000;
      } else {
         ItemStack stack = animatable.m_6844_(EquipmentSlot.LEGS);
         return !stack.m_41619_() && stack.m_204117_(WAIST_TAG) ? stack : null;
      }
   }

   @Nonnull
   protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, T animatable, HumanoidModel<?> baseModel) {
      String name = bone.getName();
      if ("armorWaist".equals(name)) {
         if (stack == this.leggingsStack && !stack.m_41619_() && stack.m_204117_(WAIST_TAG)) {
            this.getRenderer().getGeoModel().getBone("armorBody").ifPresent((bodyBone) -> {
               bone.setRotX(bodyBone.getRotX());
               bone.setRotY(bodyBone.getRotY());
               bone.setRotZ(bodyBone.getRotZ());
               bone.setPosX(bodyBone.getPosX());
               bone.setPosY(bodyBone.getPosY());
               bone.setPosZ(bodyBone.getPosZ());
            });
            return baseModel.f_102810_;
         } else {
            return EMPTY;
         }
      } else if (stack == this.helmetStack && name.equals("armorHead")) {
         return baseModel.f_102808_;
      } else {
         if (stack == this.chestplateStack) {
            if (name.equals("armorBody")) {
               return baseModel.f_102810_;
            }

            if (name.equals("armorRightArm")) {
               return baseModel.f_102811_;
            }

            if (name.equals("armorLeftArm")) {
               return baseModel.f_102812_;
            }
         }

         if (stack == this.leggingsStack) {
            if (name.equals("armorRightLeg")) {
               return baseModel.f_102813_;
            }

            if (name.equals("armorLeftLeg")) {
               return baseModel.f_102814_;
            }
         }

         if (stack == this.bootsStack) {
            if (name.equals("armorRightBoot") || name.equals("armorRightLeg")) {
               return baseModel.f_102813_;
            }

            if (name.equals("armorLeftBoot") || name.equals("armorLeftLeg")) {
               return baseModel.f_102814_;
            }
         }

         return EMPTY;
      }
   }

   static {
      WAIST_TAG = TagKey.m_203882_(Registries.f_256913_, new ResourceLocation("forge", "armor_waist_part"));
      EMPTY = new ModelPart(Collections.emptyList(), Collections.emptyMap());
   }
}
