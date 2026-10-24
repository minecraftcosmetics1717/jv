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

public class Modelcuresedspirit_3_23<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcuresedspirit_3_23"), "main");
   public final ModelPart body;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart head;

   public Modelcuresedspirit_3_23(ModelPart root) {
      this.body = root.m_171324_("body");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 26).m_171488_(-3.0F, -6.0F, -2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 19.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      body.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-4.0F, -5.25F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -6.0F, 0.0F, -0.3054F, 0.0F, 0.0F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(0, 36).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.9537F, 18.8849F, -0.7222F, -1.1611F, 0.2815F, 0.1201F));
      right_leg.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 36).m_171480_().m_171488_(-1.8932F, -6.9796F, 1.0084F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.35F)).m_171555_(false).m_171514_(0, 36).m_171480_().m_171488_(-1.8932F, -5.9796F, 1.0084F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)).m_171555_(false).m_171514_(0, 36).m_171480_().m_171488_(-1.8932F, -1.9796F, 1.0084F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 36).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.9537F, 18.8849F, -0.7222F, -1.1611F, -0.2815F, -0.1201F));
      left_leg.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 36).m_171488_(-2.1068F, -6.9796F, 1.0084F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.35F)).m_171514_(0, 36).m_171488_(-2.1068F, -5.9796F, 1.0084F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.5F)).m_171514_(0, 36).m_171488_(-2.1068F, -1.9796F, 1.0084F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171480_().m_171488_(-3.0F, -5.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.0F, 10.0F, -3.25F, 0.0F, 0.0F, 0.3491F));
      right_arm.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171480_().m_171488_(-0.5F, -1.5F, 0.15F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(6, 36).m_171480_().m_171488_(-0.5F, -1.5F, 1.65F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(6, 36).m_171480_().m_171488_(-0.5F, -1.5F, 0.9F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(6, 36).m_171480_().m_171488_(-0.5F, -1.5F, 0.15F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(6, 36).m_171480_().m_171488_(-0.5F, -1.5F, -0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-1.3342F, -12.4727F, -0.5F, 0.0F, 0.0F, 0.3491F));
      right_arm.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171480_().m_171488_(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-0.1978F, -10.9482F, 1.75F, -0.0873F, 0.0F, 0.5236F));
      right_arm.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171480_().m_171488_(-1.0F, -6.5F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.35F)).m_171555_(false).m_171514_(6, 36).m_171480_().m_171488_(-1.0F, -4.5F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-2.0F, -5.5F, 0.5F, 0.0F, 0.0F, 0.1309F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171488_(0.0F, -5.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.0F, 10.0F, -3.25F, 0.0F, 0.0F, -0.3491F));
      left_arm.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171488_(-0.5F, -1.5F, 0.15F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(6, 36).m_171488_(-0.5F, -1.5F, 1.65F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(6, 36).m_171488_(-0.5F, -1.5F, 0.9F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(6, 36).m_171488_(-0.5F, -1.5F, 0.15F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171514_(6, 36).m_171488_(-0.5F, -1.5F, -0.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(1.3342F, -12.4727F, -0.5F, 0.0F, 0.0F, -0.3491F));
      left_arm.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171488_(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1978F, -10.9482F, 1.75F, -0.0873F, 0.0F, -0.5236F));
      left_arm.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(6, 36).m_171488_(-1.0F, -6.5F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(-0.35F)).m_171514_(6, 36).m_171488_(-2.0F, -4.5F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(2.0F, -5.5F, 0.5F, 0.0F, 0.0F, -0.1309F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.m_171419_(0.0F, 9.0F, -4.0F));
      head.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171488_(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, -0.9032F, -3.1078F, 0.1745F, 0.0F, 0.0F));
      head.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(2, 9).m_171488_(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.35F, -2.75F, -0.1745F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.right_arm.f_104203_ = ageInTicks;
      this.left_arm.f_104203_ = ageInTicks;
   }
}
