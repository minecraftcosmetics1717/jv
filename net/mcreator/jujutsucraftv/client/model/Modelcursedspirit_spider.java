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

public class Modelcursedspirit_spider<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_spider"), "main");
   public final ModelPart bone;
   public final ModelPart head;
   public final ModelPart torso;
   public final ModelPart right_arm;
   public final ModelPart left_arm;
   public final ModelPart right_arm2;
   public final ModelPart left_arm2;
   public final ModelPart right_arm3;
   public final ModelPart left_arm3;

   public Modelcursedspirit_spider(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.head = this.bone.m_171324_("head");
      this.torso = this.bone.m_171324_("torso");
      this.right_arm = this.bone.m_171324_("right_arm");
      this.left_arm = this.bone.m_171324_("left_arm");
      this.right_arm2 = this.bone.m_171324_("right_arm2");
      this.left_arm2 = this.bone.m_171324_("left_arm2");
      this.right_arm3 = this.bone.m_171324_("right_arm3");
      this.left_arm3 = this.bone.m_171324_("left_arm3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 24.0F, -3.9571F));
      PartDefinition head = bone.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(22, 12).m_171488_(-1.75F, -0.5858F, -2.8284F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)).m_171514_(22, 12).m_171480_().m_171488_(-2.25F, 0.5142F, -2.7284F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)).m_171555_(false).m_171514_(0, 0).m_171488_(-3.0F, -0.5858F, -2.8284F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(2.0F, -0.5858F, -2.8284F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, -3.0F, -4.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, 1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -2.0F, 1.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 12).m_171488_(-4.0F, -3.0F, -1.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -2.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
      PartDefinition torso = bone.m_171599_("torso", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      torso.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(2.4825F, -3.5675F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, -1.4136F, -0.3614F, -0.4215F));
      torso.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(2.1945F, -2.0F, 0.0303F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, -1.5708F, 0.0F, -0.3927F));
      torso.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(2.4825F, -0.4325F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, -1.728F, 0.3614F, -0.4215F));
      torso.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.4825F, -3.5675F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, -1.4136F, 0.3614F, 0.4215F));
      torso.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.4825F, -0.4325F, 0.1496F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, -1.728F, -0.3614F, 0.4215F));
      torso.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, 4.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-2.0F, 2.5F, -2.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, -7.75F, 10.0F, 2.3562F, 0.0F, 0.0F));
      torso.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(21, 14).m_171480_().m_171488_(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.0F, -9.1642F, 10.0F, -0.5299F, 0.7119F, -0.3655F));
      torso.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(21, 14).m_171488_(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, -9.1642F, 10.0F, -0.5299F, -0.7119F, 0.3655F));
      torso.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 20).m_171488_(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -6.6893F, 9.6464F, -0.7854F, 0.0F, 0.0F));
      torso.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.5F, -5.0216F, -1.5F, 5.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, 1.5708F, 0.0F, 0.0F));
      torso.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.1945F, -2.0F, 0.0303F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -4.0F, 3.0216F, -1.5708F, 0.0F, 0.3927F));
      PartDefinition right_arm = bone.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171423_(-3.0F, -3.75F, -1.0F, 0.0F, -0.3927F, 0.0F));
      right_arm.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.25F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(22, 4).m_171488_(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(0.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, 0.3927F));
      right_arm.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
      PartDefinition left_arm = bone.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171423_(3.0F, -3.75F, -1.0F, 0.0F, 0.3927F, 0.0F));
      left_arm.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.75F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(22, 4).m_171480_().m_171488_(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-1.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, -0.3927F));
      left_arm.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));
      PartDefinition right_arm2 = bone.m_171599_("right_arm2", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, -3.75F, 3.0F));
      right_arm2.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.25F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm2.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(22, 4).m_171488_(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm2.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(0.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, 0.3927F));
      right_arm2.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
      PartDefinition left_arm2 = bone.m_171599_("left_arm2", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, -3.75F, 3.0F));
      left_arm2.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.75F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm2.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(22, 4).m_171480_().m_171488_(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm2.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-1.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, -0.3927F));
      left_arm2.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));
      PartDefinition right_arm3 = bone.m_171599_("right_arm3", CubeListBuilder.m_171558_(), PartPose.m_171423_(-4.0F, -3.75F, 7.0F, 0.0F, 0.3927F, 0.0F));
      right_arm3.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.25F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm3.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(22, 4).m_171488_(-0.75F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, 1.5708F));
      right_arm3.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(0.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, 0.3927F));
      right_arm3.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
      PartDefinition left_arm3 = bone.m_171599_("left_arm3", CubeListBuilder.m_171558_(), PartPose.m_171423_(4.0F, -3.75F, 7.0F, 0.0F, -0.3927F, 0.0F));
      left_arm3.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.75F, -0.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(6.0052F, -2.4874F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm3.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(22, 4).m_171480_().m_171488_(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(7.7041F, 3.5738F, 0.0F, 0.0F, 0.0F, -1.5708F));
      left_arm3.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-1.25F, 0.25F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(6.4672F, -2.6788F, 0.0F, 0.0F, 0.0F, -0.3927F));
      left_arm3.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(22, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.left_arm3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.left_arm2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.right_arm2.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.right_arm3.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
   }
}
