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

public class WaistArmorEntityLayer<T extends LivingEntity & GeoAnimatable> extends ItemArmorGeoLayer<T> {
   private static final TagKey<Item> WAIST_TAG;
   private static final ModelPart EMPTY;

   public WaistArmorEntityLayer(DynamicGeoEntityRenderer<T> geoRenderer) {
      super(geoRenderer);
   }

   @Nullable
   protected ItemStack getArmorItemForBone(GeoBone bone, T animatable) {
      if ("armorWaist".equals(bone.getName())) {
         ItemStack stack = animatable.m_6844_(EquipmentSlot.LEGS);
         if (!stack.m_41619_() && stack.m_204117_(WAIST_TAG)) {
            return stack;
         }
      }

      return null;
   }

   @Nonnull
   protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, T animatable) {
      return "armorWaist".equals(bone.getName()) ? EquipmentSlot.CHEST : super.getEquipmentSlotForBone(bone, stack, animatable);
   }

   @Nonnull
   protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, T animatable, HumanoidModel<?> baseModel) {
      return "armorWaist".equals(bone.getName()) ? baseModel.f_102810_ : EMPTY;
   }

   static {
      WAIST_TAG = TagKey.m_203882_(Registries.f_256913_, new ResourceLocation("forge", "armor_waist_part"));
      EMPTY = new ModelPart(Collections.emptyList(), Collections.emptyMap());
   }
}
