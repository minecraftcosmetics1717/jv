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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Modelcursedspirit_renkon<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_renkon"), "main");
   public final ModelPart head;
   public final ModelPart left_arm;
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_arm;
   public final ModelPart bone;

   public Modelcursedspirit_renkon(ModelPart root) {
      this.head = root.m_171324_("head");
      this.left_arm = root.m_171324_("left_arm");
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.right_arm = root.m_171324_("right_arm");
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -14.2891F, -11.8893F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 30).m_171488_(-1.2893F, -1.2893F, -2.075F, 6.0F, 6.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.1781F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-4.0F, -7.4193F, -1.925F, 8.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.3927F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, -7.0F, -9.0F));
      left_arm.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(28, -4).m_171480_().m_171488_(0.5F, 5.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(3.959F, 13.4944F, 0.0295F, -0.1042F, 0.0513F, 0.0024F));
      left_arm.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.5F, -6.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(3.959F, 13.4944F, -0.2205F, -0.1042F, 0.0513F, 0.0024F));
      left_arm.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0587F, 0.0076F, -0.3881F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 16.0F, 0.0F));
      right_leg.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.5F, -8.0F, 3.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-3.959F, 12.4944F, -3.2205F, 0.6812F, -0.0513F, -0.0024F));
      right_leg.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.9754F, 2.5064F, -2.7692F, -0.7459F, 0.274F, 0.2849F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 16.0F, 0.0F));
      left_leg.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-3.5F, -8.0F, 3.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(3.959F, 12.4944F, -3.2205F, 0.6812F, 0.0513F, 0.0024F));
      left_leg.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-2.5F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.9754F, 2.5064F, -2.7692F, -0.7459F, -0.274F, -0.2849F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.0F, -7.0F, -9.0F));
      right_arm.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(28, -4).m_171488_(-0.5F, 5.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.959F, 13.4944F, 0.0295F, -0.1042F, -0.0513F, -0.0024F));
      right_arm.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.5F, -6.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-3.959F, 13.4944F, -0.2205F, -0.1042F, -0.0513F, -0.0024F));
      right_arm.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0587F, -0.0076F, 0.3881F));
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 0).m_171488_(-8.0F, -27.7084F, -9.8143F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(3.0F, 18.0F, -3.0F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.0F, -27.7084F, -7.8143F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171480_().m_171488_(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.5F, -24.2084F, -9.8143F, 0.0F, 0.1309F, 0.0F));
      bone.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, -24.2084F, -9.8143F, 0.0F, -0.1309F, 0.0F));
      bone.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-3.0F, -18.7084F, -3.8143F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-4.0F, -0.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.0F, -16.2336F, -3.3394F, 0.7854F, 0.0F, 0.0F));
      bone.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, 3.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-3.0F, -16.0F, -1.0F, 0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
