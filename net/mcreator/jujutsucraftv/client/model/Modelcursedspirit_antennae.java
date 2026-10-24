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

public class Modelcursedspirit_antennae<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_antennae"), "main");
   public final ModelPart left_leg;
   public final ModelPart right_leg;
   public final ModelPart right_arm;
   public final ModelPart torso;
   public final ModelPart head;

   public Modelcursedspirit_antennae(ModelPart root) {
      this.left_leg = root.m_171324_("left_leg");
      this.right_leg = root.m_171324_("right_leg");
      this.right_arm = root.m_171324_("right_arm");
      this.torso = root.m_171324_("torso");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.0F, 2.0F, 1.5F));
      left_leg.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(34, 11).m_171488_(3.2688F, -3.5F, -1.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(-2.0F, 19.9986F, -1.5524F, 1.5708F, 0.0F, 0.0F));
      left_leg.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(34, 10).m_171488_(-1.5F, -8.25F, 0.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(2.3312F, 17.6748F, -2.5646F, 0.3927F, 0.0F, -0.1309F));
      left_leg.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(48, 9).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, 0.0F, 0.5F, -0.3927F, 0.0F, -0.1309F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.0F, 2.0F, 1.5F));
      right_leg.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(34, 11).m_171480_().m_171488_(-6.2688F, -3.5F, -1.5F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(2.0F, 19.9986F, -1.5524F, 1.5708F, 0.0F, 0.0F));
      right_leg.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(34, 10).m_171480_().m_171488_(-1.5F, -8.25F, 0.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.3312F, 17.6748F, -2.5646F, 0.3927F, 0.0F, 0.1309F));
      right_leg.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(48, 9).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.5F, -0.3927F, 0.0F, 0.1309F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -9.1059F, 0.7412F));
      right_arm.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(33, 9).m_171488_(-0.8285F, -11.7122F, -6.5356F, 3.0F, 14.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(10.1291F, 17.4106F, -3.3918F, -1.2805F, 0.2159F, -0.2129F));
      right_arm.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(32, 9).m_171488_(0.1715F, -5.2773F, -4.5381F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(10.1291F, 17.4106F, -3.3918F, -0.1024F, 0.2159F, -0.2129F));
      right_arm.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(33, 10).m_171488_(0.1715F, -1.1276F, -4.0073F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(10.1291F, 17.4106F, -3.3918F, 0.2903F, 0.2159F, -0.2129F));
      right_arm.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(34, 11).m_171488_(0.1715F, 2.5827F, -4.9902F, 1.0F, 6.0F, 2.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(10.1291F, 17.4106F, -3.3918F, 0.683F, 0.2159F, -0.2129F));
      right_arm.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(32, 9).m_171488_(-1.0F, -2.0F, -3.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(4.9268F, 0.9291F, 1.2207F, 0.3897F, 0.05F, -0.5137F));
      right_arm.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(32, 9).m_171480_().m_171488_(-3.0F, -2.0F, -3.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-4.9268F, 0.9291F, 1.2207F, 0.3897F, -0.05F, 0.5137F));
      right_arm.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(34, 11).m_171480_().m_171488_(-1.1715F, 2.5827F, -4.9902F, 1.0F, 6.0F, 2.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(-10.1291F, 17.4106F, -3.3918F, 0.683F, -0.2159F, 0.2129F));
      right_arm.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(33, 10).m_171480_().m_171488_(-1.1715F, -1.1276F, -4.0073F, 1.0F, 6.0F, 3.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-10.1291F, 17.4106F, -3.3918F, 0.2903F, -0.2159F, 0.2129F));
      right_arm.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(32, 9).m_171480_().m_171488_(-1.1715F, -5.2773F, -4.5381F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-10.1291F, 17.4106F, -3.3918F, -0.1024F, -0.2159F, 0.2129F));
      right_arm.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(33, 9).m_171480_().m_171488_(-2.1715F, -11.7122F, -6.5356F, 3.0F, 14.0F, 4.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-10.1291F, 17.4106F, -3.3918F, -1.2805F, -0.2159F, 0.2129F));
      PartDefinition torso = partdefinition.m_171599_("torso", CubeListBuilder.m_171558_().m_171514_(0, 27).m_171488_(-7.0F, -1.0F, 2.0F, 8.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 12).m_171488_(-7.0F, -12.0F, -7.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171488_(-6.0F, -5.0F, -7.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(3.0F, -6.0F, -3.0F));
      torso.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(32, 9).m_171488_(-2.0F, -3.5F, 0.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.0F, -2.5F, 0.0F, 1.1781F, 0.0F, 0.0F));
      torso.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(4, 15).m_171480_().m_171488_(3.5F, -1.5F, -4.25F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(4, 15).m_171488_(-6.5F, -1.5F, -4.25F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -2.0F, -4.75F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(-3.0F, -4.0F, 5.0F, 0.3927F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, -14.4063F, -9.4286F));
      head.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(14, 19).m_171480_().m_171488_(-3.2079F, -1.9134F, -1.5248F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-1.0F, -1.4656F, -2.4939F, 1.0409F, 0.7119F, -0.3655F));
      head.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(12, 18).m_171480_().m_171488_(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(-4.9676F, -1.6546F, -3.5273F, 0.7566F, 0.3614F, -0.1572F));
      head.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(12, 18).m_171480_().m_171488_(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-5.4303F, -2.9501F, -5.9777F, 1.2124F, 0.081F, 0.1257F));
      head.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(22, 20).m_171480_().m_171488_(-1.5F, -0.75F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-5.4849F, -3.0758F, -7.6111F, 1.602F, 0.0269F, 0.147F));
      head.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171480_().m_171488_(-1.5F, -1.5F, -1.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-5.4849F, -3.0758F, -7.6111F, 0.0312F, 0.0269F, 0.147F));
      head.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(22, 27).m_171488_(-1.5F, -1.5F, -1.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(5.4849F, -3.0758F, -7.6111F, 0.0312F, -0.0269F, -0.147F));
      head.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(22, 20).m_171488_(-1.5F, -0.75F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(5.4849F, -3.0758F, -7.6111F, 1.602F, -0.0269F, -0.147F));
      head.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(12, 18).m_171488_(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(5.4303F, -2.9501F, -5.9777F, 1.2124F, -0.081F, -0.1257F));
      head.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(12, 18).m_171488_(-1.0F, -1.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(4.9676F, -1.6546F, -3.5273F, 0.7566F, -0.3614F, 0.1572F));
      head.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(14, 19).m_171488_(2.2079F, -1.9134F, -1.5248F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(1.0F, -1.4656F, -2.4939F, 1.0409F, -0.7119F, 0.3655F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.torso.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
