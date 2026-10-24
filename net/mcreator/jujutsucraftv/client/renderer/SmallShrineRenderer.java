package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.SmallShrineEntity;
import net.mcreator.jujutsucraftv.entity.model.SmallShrineModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SmallShrineRenderer extends GeoEntityRenderer<SmallShrineEntity> {
   private static final TagKey<EntityType<?>> NOT_LIVING_TAG;

   public SmallShrineRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new SmallShrineModel());
      this.f_114477_ = 0.5F;
   }

   public RenderType getRenderType(SmallShrineEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, SmallShrineEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      if (entity.m_6095_().m_204039_(NOT_LIVING_TAG)) {
         entity.f_20916_ = 0;
      }

      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SmallShrineEntity entityLivingBaseIn) {
      return 0.0F;
   }

   static {
      NOT_LIVING_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"));
   }
}
