package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiShrineEntity;
import net.mcreator.jujutsucraftv.entity.layer.RozetsuShikigamiShrineLayer;
import net.mcreator.jujutsucraftv.entity.model.RozetsuShikigamiShrineModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RozetsuShikigamiShrineRenderer extends GeoEntityRenderer<RozetsuShikigamiShrineEntity> {
   public RozetsuShikigamiShrineRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new RozetsuShikigamiShrineModel());
      this.f_114477_ = 0.0F;
      this.addRenderLayer(new RozetsuShikigamiShrineLayer(this));
   }

   public RenderType getRenderType(RozetsuShikigamiShrineEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, RozetsuShikigamiShrineEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(RozetsuShikigamiShrineEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
