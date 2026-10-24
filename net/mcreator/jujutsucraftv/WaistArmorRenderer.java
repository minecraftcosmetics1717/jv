package net.mcreator.jujutsucraftv;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WaistArmorRenderer<T extends Item & GeoItem> extends GeoArmorRenderer<T> {
   private static final TagKey<Item> WAIST_TAG;

   public WaistArmorRenderer(GeoModel<T> model) {
      super(model);
   }

   protected void applyBoneVisibilityBySlot(EquipmentSlot slot) {
      super.applyBoneVisibilityBySlot(slot);
      this.model.getBone("armorWaist").ifPresent((waistBone) -> {
         ItemStack stack = this.getCurrentStack();
         if (slot == EquipmentSlot.LEGS && stack != null && stack.m_204117_(WAIST_TAG)) {
            waistBone.setHidden(false);
            this.model.getBone("armorBody").ifPresent((bodyBone) -> {
               waistBone.setRotX(bodyBone.getRotX());
               waistBone.setRotY(bodyBone.getRotY());
               waistBone.setRotZ(bodyBone.getRotZ());
               waistBone.setPosX(bodyBone.getPosX());
               waistBone.setPosY(bodyBone.getPosY());
               waistBone.setPosZ(bodyBone.getPosZ());
            });
         } else {
            waistBone.setHidden(true);
         }

      });
   }

   static {
      WAIST_TAG = TagKey.m_203882_(Registries.f_256913_, new ResourceLocation("forge", "armor_waist_part"));
   }
}
