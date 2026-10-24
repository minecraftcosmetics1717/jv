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

public class Modelcursedspirit_fatigue<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_fatigue"), "main");
   public final ModelPart left_leg;
   public final ModelPart right_leg;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart torso;
   public final ModelPart head;

   public Modelcursedspirit_fatigue(ModelPart root) {
      this.left_leg = root.m_171324_("left_leg");
      this.right_leg = root.m_171324_("right_leg");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.torso = root.m_171324_("torso");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(2.0F, 2.0F, 1.5F));
      left_leg.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171488_(-1.5F, 2.75F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.15F)).m_171514_(14, 0).m_171488_(-1.5F, -8.25F, 0.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(2.8312F, 17.6748F, -2.5646F, 0.3927F, 0.0F, -0.1309F));
      left_leg.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171488_(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.5F, -0.3927F, 0.0F, -0.1309F));
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(-2.0F, 2.0F, 1.5F));
      right_leg.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171480_().m_171488_(-1.5F, 2.75F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.15F)).m_171555_(false).m_171514_(14, 0).m_171480_().m_171488_(-1.5F, -8.25F, 0.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.8312F, 17.6748F, -2.5646F, 0.3927F, 0.0F, 0.1309F));
      right_leg.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.5F, -0.3927F, 0.0F, 0.1309F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-5.0F, -11.0F, 2.5F));
      right_arm.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171480_().m_171488_(-1.5F, 4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.15F)).m_171555_(false).m_171514_(14, 0).m_171480_().m_171488_(-1.5F, -7.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.8312F, 17.6748F, -2.5646F, -0.3927F, 0.0F, 0.1309F));
      right_arm.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171480_().m_171488_(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1309F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(5.0F, -11.0F, 2.5F));
      left_arm.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171488_(-1.5F, 4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.15F)).m_171514_(14, 0).m_171488_(-1.5F, -7.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(2.8312F, 17.6748F, -2.5646F, -0.3927F, 0.0F, -0.1309F));
      left_arm.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(14, 0).m_171488_(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));
      partdefinition.m_171599_("torso", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-8.0F, -7.0F, 2.0F, 10.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171488_(-8.0F, -1.0F, 0.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(3.0F, -6.0F, -3.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 22).m_171488_(-4.0F, -11.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(32, 32).m_171488_(-4.0F, -11.0F, -8.0F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.25F)).m_171514_(0, 36).m_171488_(-4.0F, -6.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.5F)).m_171514_(3, 24).m_171488_(-3.0F, -12.5F, -7.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(32, 12).m_171488_(-3.0F, -5.0F, -8.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(48, 28).m_171488_(-2.0F, -2.0F, -8.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -13.0F, 2.0F));
      head.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(32, 21).m_171488_(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.5F, -1.0F, 0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.torso.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
