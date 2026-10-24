package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.GenericArmorLayer;
import net.mcreator.jujutsucraftv.GenericItemLayer;
import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.mcreator.jujutsucraftv.entity.model.CloneModel;
import net.mcreator.jujutsucraftv.procedures.SetEntitySizeProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;

public class CloneRenderer extends DynamicGeoEntityRenderer<CloneEntity> {
   protected final ResourceLocation CAPE_TEXTURE = new ResourceLocation("geckolib", "textures/entity/dynamic_entity_cape.png");

   public CloneRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new CloneModel());
      this.f_114477_ = 0.5F;
      this.addRenderLayer(new GenericArmorLayer(this));
      this.addRenderLayer(new GenericItemLayer(this));
   }

   public RenderType getRenderType(CloneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.m_110473_(this.m_5478_(animatable));
   }

   @Nullable
   protected ResourceLocation getTextureOverrideForBone(GeoBone bone, CloneEntity animatable, float partialTick) {
      return "bipedCape".equals(bone.getName()) ? this.CAPE_TEXTURE : null;
   }

   public void preRender(PoseStack poseStack, CloneEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SetEntitySizeProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }
}
