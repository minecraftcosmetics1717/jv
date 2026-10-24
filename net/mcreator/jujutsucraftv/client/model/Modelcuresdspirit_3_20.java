package net.mcreator.jujutsucraftv.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Modelcuresdspirit_3_20<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcuresdspirit_3_20"), "main");
   public final ModelPart head;

   public Modelcuresdspirit_3_20(ModelPart root) {
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 11).m_171488_(-3.0F, -2.5331F, -6.0806F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)).m_171514_(0, 0).m_171488_(-3.0F, -2.5331F, -0.0806F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)).m_171514_(0, 0).m_171488_(-3.0F, -1.7831F, -8.5806F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-1.25F)).m_171514_(0, 0).m_171488_(-3.0F, -3.2831F, 2.4194F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-1.25F)).m_171514_(0, 0).m_171488_(-3.0F, -2.5331F, -2.0806F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 19.5331F, 0.0806F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(18, 25).m_171488_(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.9669F, -8.5806F, 0.1745F, 0.0F, 0.0F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(-6, 26).m_171480_().m_171488_(-4.5F, -0.5F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.0F, -1.0331F, 8.4194F, 0.4105F, -0.4275F, 0.354F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(-6, 26).m_171488_(-1.5F, -0.5F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.0F, -1.0331F, 8.4194F, 0.4105F, 0.4275F, -0.354F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(18, 25).m_171488_(-1.5F, -0.5F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.5F, -1.5331F, 6.4194F, 0.1745F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
   }
}
