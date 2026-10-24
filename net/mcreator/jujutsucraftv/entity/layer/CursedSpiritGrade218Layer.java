package net.mcreator.jujutsucraftv.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade218Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CursedSpiritGrade218Layer extends GeoRenderLayer<CursedSpiritGrade218Entity> {
   private static final ResourceLocation LAYER = new ResourceLocation("jujutsucraftv", "textures/entities/cursedspirit_lanthan_light.png");

   public CursedSpiritGrade218Layer(GeoRenderer<CursedSpiritGrade218Entity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, CursedSpiritGrade218Entity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType = RenderType.m_234338_(LAYER);
      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.m_6299_(glowRenderType), partialTick, 15728880, OverlayTexture.f_118083_, 0.15F, 0.35F, 1.0F, 1.0F);
   }
}
