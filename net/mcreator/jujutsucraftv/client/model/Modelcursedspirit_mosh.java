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

public class Modelcursedspirit_mosh<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_mosh"), "main");
   public final ModelPart bone;
   public final ModelPart bone2;
   public final ModelPart left_leg;
   public final ModelPart right_leg;
   public final ModelPart right_arm;
   public final ModelPart left_arm;

   public Modelcursedspirit_mosh(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.bone2 = this.bone.m_171324_("bone2");
      this.left_leg = root.m_171324_("left_leg");
      this.right_leg = root.m_171324_("right_leg");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 18.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -3.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5858F, -1.0F, -0.4142F, 0.0F, 2.3562F, 0.0F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -3.0F, 3.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1213F, -1.0F, 0.1213F, 0.0F, 1.5708F, 0.0F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(3.0F, -3.0F, -3.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5858F, -1.0F, -0.4142F, 0.0F, -2.3562F, 0.0F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(3.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5858F, -1.0F, 0.6569F, 0.0F, 2.3562F, 0.0F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(1.5858F, -1.0F, 0.6569F, 0.0F, -2.3562F, 0.0F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -3.0F, 3.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.1213F, -1.0F, 0.1213F, 0.0F, -1.5708F, 0.0F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -3.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.0F, 0.2426F, 0.0F, 1.5708F, 0.0F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.5F, 4.75F, -4.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(0, 50).m_171488_(-5.0F, -3.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
      PartDefinition bone2 = bone.m_171599_("bone2", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-6.0F, -10.75F, -8.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(-0.01F)).m_171514_(0, 28).m_171488_(-6.0F, -10.75F, -4.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(-0.01F)).m_171514_(0, 14).m_171488_(-3.0F, -15.75F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 6.0F, 0.0F));
      bone2.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-6.0F, -1.0F, -8.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(-0.001F)).m_171514_(0, 28).m_171488_(8.0F, -1.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(36, 37).m_171488_(-4.0F, -1.0F, 8.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 28).m_171488_(-6.0F, -1.0F, -4.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -9.75F, 0.0F, 0.0F, 1.5708F, 0.0F));
      bone2.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(8.0F, -1.25F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(36, 37).m_171488_(-4.0F, -1.25F, 8.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -9.5F, 0.0F, 0.0F, -1.5708F, 0.0F));
      bone2.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(4.4042F, -11.9257F, 0.0F, 0.0F, 0.0F, 0.7854F));
      bone2.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(-4.4042F, -11.9257F, 0.0F, 0.0F, 0.0F, -0.7854F));
      bone2.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -11.9257F, 4.4042F, -0.7854F, 0.0F, 0.0F));
      bone2.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.m_171423_(0.0F, -11.9257F, -4.4042F, 0.7854F, 0.0F, 0.0F));
      bone2.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1602F, -10.4598F, 2.1602F, 0.3927F, 0.7854F, 0.0F));
      bone2.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-1.5F, -1.6F, -2.9F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1602F, -10.4598F, 2.1602F, 0.7854F, 0.7854F, 0.0F));
      bone2.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.1602F, -10.4598F, 2.1602F, 0.3927F, -0.7854F, 0.0F));
      bone2.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-1.5F, -1.6F, -2.9F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.1602F, -10.4598F, 2.1602F, 0.7854F, -0.7854F, 0.0F));
      bone2.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.1602F, -10.4598F, -2.1602F, -0.3927F, 0.7854F, 0.0F));
      bone2.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-1.5F, -1.6F, -3.1F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.1602F, -10.4598F, -2.1602F, -0.7854F, 0.7854F, 0.0F));
      bone2.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-1.5F, -1.6F, -3.1F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1602F, -10.4598F, -2.1602F, -0.7854F, -0.7854F, 0.0F));
      bone2.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171488_(-2.0F, -0.85F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.1602F, -10.4598F, -2.1602F, -0.3927F, -0.7854F, 0.0F));
      partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171488_(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(4.0F, 22.0F, 0.0F));
      partdefinition.m_171599_("right_leg", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171488_(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-4.0F, 22.0F, 0.0F));
      partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-6.0F, 19.0F, 0.0F));
      partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(56, 0).m_171488_(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(6.0F, 19.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.right_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
