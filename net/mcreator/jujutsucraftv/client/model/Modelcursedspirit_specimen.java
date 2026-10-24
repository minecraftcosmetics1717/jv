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

public class Modelcursedspirit_specimen<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_specimen"), "main");
   public final ModelPart right_leg;
   public final ModelPart left_leg;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart torso;
   public final ModelPart head;

   public Modelcursedspirit_specimen(ModelPart root) {
      this.right_leg = root.m_171324_("right_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
      this.torso = root.m_171324_("torso");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition right_leg = partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-5.6896F, 20.8642F, -3.1666F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.15F)), PartPose.m_171419_(-3.0F, 1.0F, 1.0E-4F));
      right_leg.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.5F, -8.25F, 1.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-2.8312F, 17.6748F, -2.5646F, 0.3927F, 0.0F, 0.1309F));
      right_leg.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-3.0F, -2.0F, -1.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.5F, -0.3927F, 0.0F, 0.1309F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(1.6896F, 20.8642F, -3.1666F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171419_(3.0F, 1.0F, 1.0E-4F));
      left_leg.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.5F, -8.25F, 1.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(2.8312F, 17.6748F, -2.5646F, 0.3927F, 0.0F, -0.1309F));
      left_leg.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, -2.0F, -1.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.5F, -0.3927F, 0.0F, -0.1309F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-6.0F, -15.0F, 2.0001F));
      right_arm.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-0.25F, -2.5F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.15F)).m_171514_(32, 0).m_171488_(-0.25F, -2.5F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)).m_171514_(32, 0).m_171488_(-0.25F, -2.5F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)).m_171514_(32, 0).m_171488_(-0.25F, -2.5F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-3.8063F, 25.0812F, -6.7413F, -0.2849F, -0.274F, -0.615F));
      right_arm.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(0.0F, 0.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(-3.9902F, 22.6474F, -4.6694F, -0.7459F, -0.274F, -0.154F));
      right_arm.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-1.5F, 4.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.15F)).m_171514_(32, 0).m_171488_(-1.5F, -7.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-2.8312F, 17.6748F, -2.5646F, -0.3927F, 0.0F, 0.1309F));
      right_arm.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 15).m_171488_(-2.0F, 9.0F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1309F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(6.0F, -15.0F, 2.0001F));
      left_arm.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-0.75F, -2.5F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.15F)).m_171555_(false).m_171514_(32, 0).m_171480_().m_171488_(-0.75F, -2.5F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)).m_171555_(false).m_171514_(32, 0).m_171480_().m_171488_(-0.75F, -2.5F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)).m_171555_(false).m_171514_(32, 0).m_171480_().m_171488_(-0.75F, -2.5F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.15F)).m_171555_(false), PartPose.m_171423_(3.8063F, 25.0812F, -6.7413F, -0.2849F, 0.274F, 0.615F));
      left_arm.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, 0.5F, -1.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(3.9902F, 22.6474F, -4.6694F, -0.7459F, 0.274F, 0.154F));
      left_arm.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-0.5F, 4.0F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.15F)).m_171555_(false).m_171514_(32, 0).m_171480_().m_171488_(-1.5F, -7.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(2.8312F, 17.6748F, -2.5646F, -0.3927F, 0.0F, -0.1309F));
      left_arm.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 15).m_171480_().m_171488_(0.0F, 9.0F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));
      PartDefinition torso = partdefinition.m_171599_("torso", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-6.0F, -2.0F, -1.0F, 12.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 15).m_171488_(-5.0F, 2.0F, 4.0F, 10.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171488_(-4.0F, 11.0F, -2.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -16.0F, 0.5001F));
      torso.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.7381F, 10.6173F, 0.0F, -1.5708F, 0.1309F, 0.3927F));
      torso.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-3.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.7381F, 10.6173F, 0.0F, -1.5708F, -0.1309F, -0.3927F));
      torso.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.7381F, 8.6173F, 0.0F, -1.5708F, 0.1309F, 0.3927F));
      torso.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-3.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.7381F, 8.6173F, 0.0F, -1.5708F, -0.1309F, -0.3927F));
      torso.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-3.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.7381F, 6.6173F, 0.0F, -1.5708F, -0.1309F, -0.3927F));
      torso.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.7381F, 6.6173F, 0.0F, -1.5708F, 0.1309F, 0.3927F));
      torso.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-2.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.7381F, 4.6173F, 0.0F, -1.5708F, 0.1309F, 0.3927F));
      torso.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-3.0F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.7381F, 4.6173F, 0.0F, -1.5708F, -0.1309F, -0.3927F));
      torso.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-4.0F, -2.5F, -1.0F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.9021F, 0.5F, 4.1059F, 0.0479F, -0.2129F, -0.2233F));
      torso.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-3.0F, -2.5F, -1.0F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.9021F, 0.5F, 4.1059F, 0.0479F, 0.2129F, 0.2233F));
      torso.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-3.0F, -2.5F, -1.0F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(2.9021F, 1.5F, -1.1059F, -0.0479F, -0.2129F, 0.2233F));
      torso.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-4.0F, -2.5F, -1.0F, 7.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.9021F, 1.5F, -1.1059F, -0.0479F, 0.2129F, -0.2233F));
      torso.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-3.0F, -6.0F, -2.5F, 6.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-3.0F, 9.0F, 1.5F, 0.0F, 0.0F, -0.1309F));
      torso.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-3.0F, -6.0F, -2.5F, 6.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, 9.0F, 1.5F, 0.0F, 0.0F, 0.1309F));
      torso.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(-3.0F, -2.5F, -1.5F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 15.5F, 1.5F, 1.5708F, 0.0F, 0.0F));
      torso.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171488_(1.0F, -1.5F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-8.9693F, 0.6819F, 1.5F, 0.0F, 0.0F, -0.3927F));
      torso.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(0, 15).m_171480_().m_171488_(-6.0F, -1.5F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(8.9693F, 0.6819F, 1.5F, 0.0F, 0.0F, 0.3927F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -9.0F, -8.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.m_171419_(0.0F, -18.0F, 2.5001F));
      head.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(0.0F, -9.2929F, -3.2346F, -0.7854F, 0.0F, 0.0F));
      head.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171480_().m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(3.2071F, -8.2929F, -3.2346F, 0.3927F, 0.0F, -2.3562F));
      head.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171480_().m_171488_(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(2.5F, -6.5F, -5.0F, 0.3927F, 0.0F, -1.1781F));
      head.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171480_().m_171488_(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)).m_171555_(false), PartPose.m_171423_(2.5F, -4.0F, -4.0F, 0.0F, 0.0F, -0.7854F));
      head.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-3.2071F, -8.2929F, -3.2346F, 0.3927F, 0.0F, 2.3562F));
      head.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-2.5F, -6.5F, -5.0F, 0.3927F, 0.0F, 1.1781F));
      head.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-2.5F, -4.0F, -4.0F, 0.0F, 0.0F, 0.7854F));
      head.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(22, 23).m_171488_(-3.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.5F, -4.75F, 0.0F, 0.0F, -3.1416F));
      head.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(22, 23).m_171488_(-3.0F, -0.5F, -2.25F, 6.0F, 2.0F, 5.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -1.5F, -5.0F, 0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(32, 0).m_171488_(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.m_171423_(0.0F, -2.2346F, -3.8478F, 0.2182F, 0.0F, 0.0F));
      head.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(0, 29).m_171488_(-2.0F, -3.0F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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
