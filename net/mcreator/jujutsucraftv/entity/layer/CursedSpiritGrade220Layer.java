package net.mcreator.jujutsucraftv.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.HashMap;
import java.util.Map;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade220Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CursedSpiritGrade220Layer extends GeoRenderLayer<CursedSpiritGrade220Entity> {
   private static final Map<String, ResourceLocation> TEXTURE_CACHE = new HashMap();

   public CursedSpiritGrade220Layer(GeoRenderer<CursedSpiritGrade220Entity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, CursedSpiritGrade220Entity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      String textureName = animatable.getGlowTexture();
      if (textureName != null && !textureName.isBlank() && !textureName.equals("empty")) {
         ResourceLocation layerTexture = (ResourceLocation)TEXTURE_CACHE.computeIfAbsent(textureName, CursedSpiritGrade220Layer::resolveTexture);
         RenderType glowRenderType = RenderType.m_110488_(layerTexture);
         this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.m_6299_(glowRenderType), partialTick, packedLight, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private static ResourceLocation resolveTexture(String textureName) {
      String value = textureName.replace('\\', '/');
      String namespace = "jujutsucraftv";
      if (value.contains(":")) {
         ResourceLocation supplied = ResourceLocation.m_135820_(value);
         if (supplied == null) {
            return new ResourceLocation("minecraft", "textures/missing.png");
         }

         namespace = supplied.m_135827_();
         value = supplied.m_135815_();
      }

      if (!value.startsWith("textures/")) {
         value = "textures/entities/" + value;
      }

      if (!value.endsWith(".png")) {
         value = value + ".png";
      }

      ResourceLocation resolved = ResourceLocation.m_135820_(namespace + ":" + value);
      return resolved != null ? resolved : new ResourceLocation("minecraft", "textures/missing.png");
   }
}
