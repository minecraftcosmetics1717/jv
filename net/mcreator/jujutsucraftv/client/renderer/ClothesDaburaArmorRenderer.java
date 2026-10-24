package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.item.ClothesDaburaItem;
import net.mcreator.jujutsucraftv.item.model.ClothesDaburaModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ClothesDaburaArmorRenderer extends GeoArmorRenderer<ClothesDaburaItem> {
   private static final TagKey<Item> WAIST_TAG;

   public ClothesDaburaArmorRenderer() {
      super(new ClothesDaburaModel());
   }

   public RenderType getRenderType(ClothesDaburaItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.getTextureLocation(animatable));
   }

   public void actuallyRender(PoseStack poseStack, ClothesDaburaItem animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.model.getBone("armorWaist").ifPresent((waistBone) -> {
         ItemStack stack = this.getCurrentStack();
         if (this.currentSlot == EquipmentSlot.LEGS && stack != null && stack.m_204117_(WAIST_TAG)) {
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
      super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected void applyBoneVisibilityBySlot(EquipmentSlot slot) {
      super.applyBoneVisibilityBySlot(slot);
      this.model.getBone("armorWaist").ifPresent((waistBone) -> {
         ItemStack stack = this.getCurrentStack();
         if (slot != EquipmentSlot.LEGS || stack == null || !stack.m_204117_(WAIST_TAG)) {
            waistBone.setHidden(true);
         }

      });
   }

   static {
      WAIST_TAG = TagKey.m_203882_(Registries.f_256913_, new ResourceLocation("forge", "armor_waist_part"));
   }
}
