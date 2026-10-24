package net.mcreator.jujutsucraftv.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier2Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class PlojectileBarrier2Layer extends GeoRenderLayer<PlojectileBarrier2Entity> {
   private static final ResourceLocation LAYER1 = new ResourceLocation("jujutsucraftv", "textures/entities/plojectile_barrier1_blue.png");
   private static final ResourceLocation LAYER5 = new ResourceLocation("jujutsucraftv", "textures/entities/plojectile_barrier1_purple.png");
   private static final ResourceLocation LAYER7 = new ResourceLocation("jujutsucraftv", "textures/entities/plojectile_barrier1_red.png");

   public PlojectileBarrier2Layer(GeoRenderer<PlojectileBarrier2Entity> entityRenderer) {
      super(entityRenderer);
   }

   private static RenderType getDoubleSidedEyes(ResourceLocation texture) {
      return RenderType.m_234335_(texture, false);
   }

   public void render(PoseStack poseStack, PlojectileBarrier2Entity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      int mode = (Integer)animatable.m_20088_().m_135370_(PlojectileBarrier2Entity.DATA_tex);
      ResourceLocation texture;
      if (mode == 5) {
         texture = LAYER5;
      } else if (mode == 7) {
         texture = LAYER7;
      } else {
         texture = LAYER1;
      }

      RenderType glowRenderType = getDoubleSidedEyes(texture);
      VertexConsumer consumer = bufferSource.m_6299_(glowRenderType);
      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, consumer, partialTick, 15728880, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
