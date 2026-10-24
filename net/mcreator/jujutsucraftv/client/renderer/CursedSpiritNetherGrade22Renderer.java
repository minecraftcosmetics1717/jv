package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.entity.CursedSpiritNetherGrade22Entity;
import net.mcreator.jujutsucraftv.entity.layer.CursedSpiritNetherGrade22Layer;
import net.mcreator.jujutsucraftv.entity.model.CursedSpiritNetherGrade22Model;
import net.mcreator.jujutsucraftv.procedures.SetEntitySizeProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CursedSpiritNetherGrade22Renderer extends GeoEntityRenderer<CursedSpiritNetherGrade22Entity> {
   public CursedSpiritNetherGrade22Renderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new CursedSpiritNetherGrade22Model());
      this.f_114477_ = 0.0F;
      this.addRenderLayer(new CursedSpiritNetherGrade22Layer(this));
   }

   public RenderType getRenderType(CursedSpiritNetherGrade22Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   public void preRender(PoseStack poseStack, CursedSpiritNetherGrade22Entity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SetEntitySizeProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(CursedSpiritNetherGrade22Entity entityLivingBaseIn) {
      return 0.0F;
   }
}
