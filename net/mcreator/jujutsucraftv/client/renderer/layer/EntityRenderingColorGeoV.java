package net.mcreator.jujutsucraftv.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.client.renderer.EntityRenderingColorV;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class EntityRenderingColorGeoV<T extends LivingEntity & GeoAnimatable> extends GeoRenderLayer<T> {
   private static final ResourceLocation WHITE_TEXTURE = new ResourceLocation("jujutsucraftv", "textures/misc/entity_white.png");

   public EntityRenderingColorGeoV(GeoRenderer<T> renderer) {
      super(renderer);
   }

   public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      MobEffectInstance effect = animatable.m_21124_((MobEffect)JujutsucraftvModMobEffects.ENTITY_RENDERING_COLOR.get());
      if (effect != null) {
         float[] color = EntityRenderingColorV.getColor(effect.m_19564_());
         RenderType colorRenderType = RenderType.m_110473_(WHITE_TEXTURE);
         VertexConsumer colorBuffer = bufferSource.m_6299_(colorRenderType);
         poseStack.m_85836_();
         poseStack.m_85841_(1.002F, 1.002F, 1.002F);
         this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, colorRenderType, colorBuffer, partialTick, packedLight, packedOverlay, color[0], color[1], color[2], 1.0F);
         poseStack.m_85849_();
      }
   }
}
