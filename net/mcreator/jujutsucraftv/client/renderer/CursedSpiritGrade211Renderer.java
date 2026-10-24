package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.GenericItemLayer;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade211Entity;
import net.mcreator.jujutsucraftv.entity.model.CursedSpiritGrade211Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;

public class CursedSpiritGrade211Renderer extends DynamicGeoEntityRenderer<CursedSpiritGrade211Entity> {
   public CursedSpiritGrade211Renderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new CursedSpiritGrade211Model());
      this.f_114477_ = 0.0F;
      this.addRenderLayer(new GenericItemLayer(this));
   }

   public RenderType getRenderType(CursedSpiritGrade211Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, CursedSpiritGrade211Entity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(CursedSpiritGrade211Entity entityLivingBaseIn) {
      return 0.0F;
   }
}
