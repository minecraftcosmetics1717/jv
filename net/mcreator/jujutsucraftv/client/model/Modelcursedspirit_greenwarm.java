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

public class Modelcursedspirit_greenwarm<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_greenwarm"), "main");
   public final ModelPart head;

   public Modelcursedspirit_greenwarm(ModelPart root) {
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -1.25F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.05F)).m_171514_(0, 0).m_171488_(-2.0F, -2.5F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.55F)).m_171514_(12, 8).m_171480_().m_171488_(-1.5F, -1.7087F, -5.2619F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(0, 0).m_171488_(-2.0F, -2.55F, 5.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)).m_171514_(0, 0).m_171488_(-2.0F, -2.55F, 1.6F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.m_171419_(0.0F, 20.0F, -9.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.55F, 13.2F, 1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 13).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -0.55F, 25.2F, 1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(15, 0).m_171488_(-0.5F, -0.5F, -15.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).m_171514_(16, 1).m_171488_(-0.5F, -0.5F, -8.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.05F, 11.8F, 0.0F, 0.0F, -0.7854F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171480_().m_171488_(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.1913F, -4.9619F, 0.0F, 0.7854F, -1.5708F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(12, 8).m_171488_(-0.526F, -0.3044F, -0.526F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 1).m_171488_(-1.026F, -0.2044F, -1.026F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(20, 8).m_171480_().m_171488_(-0.7222F, -1.2956F, -1.1258F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.0456F, -5.6703F, 0.5299F, -0.7119F, 2.7761F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(20, 8).m_171488_(-2.2778F, -1.2956F, -1.1258F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.0F, -1.0456F, -5.6703F, 0.5299F, 0.7119F, -2.7761F));
      head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171488_(-0.7678F, -0.9804F, -1.0581F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -1.0456F, -5.6703F, 0.7166F, 0.1037F, 1.2953F));
      head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171480_().m_171488_(-0.2322F, -0.9804F, -1.0581F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, -1.0456F, -5.6703F, 0.7166F, -0.1037F, -1.2953F));
      head.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(20, 8).m_171488_(-2.2321F, -1.0397F, -1.1714F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.0F, 2.0357F, -5.4203F, 0.9553F, 0.5236F, 0.6155F));
      head.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(20, 8).m_171480_().m_171488_(-0.7679F, -1.0397F, -1.1714F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false).m_171514_(12, 8).m_171488_(-0.5717F, -0.0985F, -0.5717F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(2, 1).m_171488_(-1.0717F, -0.0485F, -1.0717F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 2.0357F, -5.4203F, 0.9553F, -0.5236F, -0.6155F));
      head.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171488_(-0.9293F, -1.0261F, -1.0406F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, 2.0357F, -5.4203F, 0.5989F, 0.4802F, -1.8808F));
      head.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171480_().m_171488_(-0.0707F, -1.0261F, -1.0406F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 2.0357F, -5.4203F, 0.5989F, -0.4802F, 1.8808F));
      head.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171488_(-1.5F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.95F)), PartPose.m_171423_(-2.0782F, -2.4583F, -4.3463F, 0.0F, 0.3927F, 0.0F));
      head.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171480_().m_171488_(-2.5F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.95F)).m_171555_(false), PartPose.m_171423_(2.0782F, -2.4583F, -4.3463F, 0.0F, -0.3927F, 0.0F));
      head.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(2, 0).m_171480_().m_171488_(-1.75F, -1.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-1.0F, -1.0F, -3.0F, -0.3927F, 0.3927F, 0.0F));
      head.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(2, 0).m_171488_(-0.25F, -1.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(1.0F, -1.0F, -3.0F, -0.3927F, -0.3927F, 0.0F));
      head.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(0.0F, -2.3071F, -3.537F, -0.5299F, -0.7119F, 0.3655F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
