package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.PlojectileBarrier4Entity;
import net.mcreator.jujutsucraftv.entity.layer.PlojectileBarrier4Layer;
import net.mcreator.jujutsucraftv.entity.model.PlojectileBarrier4Model;
import net.mcreator.jujutsucraftv.procedures.SetEntitySizeProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PlojectileBarrier4Renderer extends GeoEntityRenderer<PlojectileBarrier4Entity> {
   public PlojectileBarrier4Renderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new PlojectileBarrier4Model());
      this.f_114477_ = 0.0F;
      this.addRenderLayer(new PlojectileBarrier4Layer(this));
   }

   public RenderType getRenderType(PlojectileBarrier4Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, PlojectileBarrier4Entity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SetEntitySizeProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(PlojectileBarrier4Entity entityLivingBaseIn) {
      return 0.0F;
   }
}
