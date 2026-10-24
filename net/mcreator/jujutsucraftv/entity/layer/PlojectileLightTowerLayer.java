package net.mcreator.jujutsucraftv.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.PlojectileLightTowerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class PlojectileLightTowerLayer extends GeoRenderLayer<PlojectileLightTowerEntity> {
   private static final ResourceLocation LAYER = new ResourceLocation("jujutsucraftv", "textures/entities/plojectile_light_beam_red.png");

   public PlojectileLightTowerLayer(GeoRenderer<PlojectileLightTowerEntity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, PlojectileLightTowerEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType = RenderType.m_110488_(LAYER);
      float brightness = 0.3F;
      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.m_6299_(glowRenderType), partialTick, packedLight, OverlayTexture.f_118083_, brightness, brightness, brightness, 1.0F);
   }
}
