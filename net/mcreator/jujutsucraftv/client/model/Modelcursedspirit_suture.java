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

public class Modelcursedspirit_suture<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_suture"), "main");
   public final ModelPart head;
   public final ModelPart bone;
   public final ModelPart left_arm;
   public final ModelPart right_arm;

   public Modelcursedspirit_suture(ModelPart root) {
      this.head = root.m_171324_("head");
      this.bone = root.m_171324_("bone");
      this.left_arm = root.m_171324_("left_arm");
      this.right_arm = root.m_171324_("right_arm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 20.9F, 3.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171480_().m_171488_(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)).m_171555_(false), PartPose.m_171423_(-1.3F, 0.625F, -6.25F, 1.5708F, 0.7854F, 1.5708F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171480_().m_171488_(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)).m_171555_(false), PartPose.m_171423_(-1.3F, 0.625F, -4.75F, 1.5708F, 0.7854F, 1.5708F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171480_().m_171488_(-1.4697F, -2.5303F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)).m_171555_(false), PartPose.m_171423_(-1.8F, -0.875F, -2.5F, 1.5708F, 0.7854F, 1.5708F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171480_().m_171488_(-2.5303F, -1.4697F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)).m_171555_(false), PartPose.m_171423_(-1.8F, -0.875F, -2.75F, 1.5708F, 0.7854F, 1.5708F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171480_().m_171488_(-2.5303F, -1.4697F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)).m_171555_(false), PartPose.m_171423_(-1.8F, -0.875F, -1.5F, 1.5708F, 0.7854F, 1.5708F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(14, 27).m_171480_().m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-1.55F, -0.875F, -1.5F, 1.5708F, 0.0F, 0.7854F));
      head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(14, 27).m_171488_(-0.5F, -2.5F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.55F, -0.875F, -1.5F, 1.5708F, 0.0F, -0.7854F));
      head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-2.5303F, -2.5303F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)), PartPose.m_171423_(1.8F, -0.875F, -2.5F, 1.5708F, -0.7854F, -1.5708F));
      head.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-1.4697F, -1.4697F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)), PartPose.m_171423_(1.8F, -0.875F, -1.5F, 1.5708F, -0.7854F, -1.5708F));
      head.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-1.4697F, -1.4697F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)), PartPose.m_171423_(1.8F, -0.875F, -2.75F, 1.5708F, -0.7854F, -1.5708F));
      head.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)), PartPose.m_171423_(1.3F, 0.625F, -4.75F, 1.5708F, -0.7854F, -1.5708F));
      head.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-1.25F)), PartPose.m_171423_(1.3F, 0.625F, -6.25F, 1.5708F, -0.7854F, -1.5708F));
      head.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0F, 0.7F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.95F, -6.1F, -1.5708F, 0.0F, -3.1416F));
      head.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171488_(-1.5F, -3.2F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.95F, -6.2F, -1.5708F, 0.0F, -3.1416F));
      head.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171488_(0.0F, -4.0F, 1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(-1.5F, -1.15F, -7.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(-2.0F, -1.15F, -9.9F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -6.0F, 1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.5F, 1.1F, -6.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -5.0F, 1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, 1.0F, -9.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -4.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5F, -2.9F, -4.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -2.75F, -7.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -3.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -1.9F, -3.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5F, -1.75F, -7.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -3.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, -1.75F, -10.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.0F, 0.0F, -10.0F, -1.5708F, 0.0F, 0.0F));
      head.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -3.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5F, 0.0F, -7.0F, -1.5708F, 0.0F, 0.0F));
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 21.0F, 2.75F));
      bone.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171480_().m_171488_(0.6102F, -5.1594F, -0.8058F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1146F, 0.2222F, 48.7317F, -1.9907F, 0.147F, 1.2053F));
      bone.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171480_().m_171488_(0.2963F, -5.6072F, -2.4317F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1146F, 0.2222F, 48.7317F, -1.6257F, 0.0451F, 1.4824F));
      bone.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171480_().m_171488_(-0.9332F, -4.3418F, -2.6362F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1146F, 0.2222F, 48.7317F, -1.5985F, -0.2456F, 1.216F));
      bone.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171488_(-0.6102F, -5.1594F, -0.8058F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1146F, 0.2222F, 48.7317F, -1.9907F, -0.147F, -1.2053F));
      bone.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171488_(-0.2963F, -5.6072F, -2.4317F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1146F, 0.2222F, 48.7317F, -1.6257F, -0.0451F, -1.4824F));
      bone.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171488_(0.9332F, -4.3418F, -2.6362F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1146F, 0.2222F, 48.7317F, -1.5985F, 0.2456F, -1.216F));
      bone.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -9.0F, 1.0F, 1.0F, 10.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-1.5F, -2.5F, 37.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -9.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-1.0F, -3.0F, 38.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -9.0F, 2.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.0F, -3.0F, 37.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -9.0F, 1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.4F)).m_171514_(0, 0).m_171488_(0.5F, -9.0F, 0.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(-1.5F, -2.5F, 28.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -9.0F, 1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.15F)).m_171514_(0, 0).m_171488_(0.5F, -9.0F, 0.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-1.5F, -2.5F, 19.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0F, -9.0F, 0.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(0.5F, -9.0F, 1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-2.0F, -2.5F, 10.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -9.0F, -1.0F, 3.0F, 10.0F, 6.0F, new CubeDeformation(-0.25F)).m_171514_(0, 0).m_171488_(-0.5F, -9.0F, 0.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-1.5F, -2.0F, 1.0F, -1.5708F, 0.0F, 0.0F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(1.7654F, 21.1522F, 4.5F));
      left_arm.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171488_(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1925F, 0.3579F, 3.7133F, -2.0167F, -0.0079F, -1.4719F));
      left_arm.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171488_(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.6985F, -0.8602F, 2.3334F, -1.9923F, 0.3614F, -1.3353F));
      left_arm.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171488_(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(3.0F, 1.0F, 2.25F, -2.3562F, 0.0F, -1.1781F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-1.7654F, 21.1522F, 4.5F));
      right_arm.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171480_().m_171488_(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-2.1925F, 0.3579F, 3.7133F, -2.0167F, 0.0079F, 1.4719F));
      right_arm.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171480_().m_171488_(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-1.6985F, -0.8602F, 2.3334F, -1.9923F, -0.3614F, 1.3353F));
      right_arm.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(18, 2).m_171480_().m_171488_(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(-3.0F, 1.0F, 2.25F, -2.3562F, 0.0F, 1.1781F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.right_arm.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F) * 0.6F;
      this.left_arm.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F + 3.0F) * 0.6F;
   }
}
