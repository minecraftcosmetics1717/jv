package net.mcreator.jujutsucraftv.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.item.BlackKnifeItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class BlackKnifeItemLayer extends GeoRenderLayer<BlackKnifeItem> {
   public BlackKnifeItemLayer(GeoRenderer<BlackKnifeItem> renderer) {
      super(renderer);
   }

   public void render(PoseStack poseStack, BlackKnifeItem animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      ResourceLocation layerTexture = ((BlackKnifeItemRenderer)this.getRenderer()).getGlowTextureLocation();
      if (layerTexture != null) {
         RenderType glowRenderType = RenderType.m_110488_(layerTexture);
         this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, glowRenderType, bufferSource.m_6299_(glowRenderType), partialTick, 15728880, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
      }
   }
}
