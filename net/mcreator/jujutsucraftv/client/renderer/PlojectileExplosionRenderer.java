package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.PlojectileExplosionEntity;
import net.mcreator.jujutsucraftv.entity.layer.PlojectileExplosionLayer;
import net.mcreator.jujutsucraftv.entity.model.PlojectileExplosionModel;
import net.mcreator.jujutsucraftv.procedures.SetEntitySizeProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlojectileExplosionRenderer extends GeoEntityRenderer<PlojectileExplosionEntity> {
   public PlojectileExplosionRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new PlojectileExplosionModel());
      this.f_114477_ = 0.0F;
      this.addRenderLayer(new PlojectileExplosionLayer(this));
   }

   public RenderType getRenderType(PlojectileExplosionEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, PlojectileExplosionEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SetEntitySizeProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(PlojectileExplosionEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
