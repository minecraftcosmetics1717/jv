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

public class ModelFourth_class_jurei<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "model_fourth_class_jurei"), "main");
   public final ModelPart rigft_leg;
   public final ModelPart left_leg;
   public final ModelPart body;
   public final ModelPart head;
   public final ModelPart left_arm;
   public final ModelPart right_arm;

   public ModelFourth_class_jurei(ModelPart root) {
      this.rigft_leg = root.m_171324_("rigft_leg");
      this.left_leg = root.m_171324_("left_leg");
      this.body = root.m_171324_("body");
      this.head = root.m_171324_("head");
      this.left_arm = root.m_171324_("left_arm");
      this.right_arm = root.m_171324_("right_arm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition rigft_leg = partdefinition.m_171599_("rigft_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, 11.0F, -4.75F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(-1.5F, 12.0F, 1.0F));
      rigft_leg.m_171599_("rigft_leg_r1", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 8.0F, -0.75F, 0.0F, 0.0F, -3.1416F));
      rigft_leg.m_171599_("rigft_leg_r2", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0F, -8.0F, -0.25F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 7.25F, -1.75F, -0.1309F, 0.0873F, 0.0F));
      PartDefinition left_leg = partdefinition.m_171599_("left_leg", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.0F, 11.0F, -4.75F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(1.5F, 12.0F, 1.0F));
      left_leg.m_171599_("rigft_leg_r3", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, 8.0F, -0.75F, 0.0F, 0.0F, -3.1416F));
      left_leg.m_171599_("rigft_leg_r4", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -8.0F, -0.25F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, 7.25F, -1.75F, -0.1309F, -0.0873F, 0.0F));
      PartDefinition body = partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(13, 13).m_171488_(-2.5F, -17.0F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 24.0F, 1.0F));
      body.m_171599_("body_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0F, -1.5F, -2.5F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -19.5F, 0.0F, 0.3927F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171488_(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 4.0F, -1.0F));
      head.m_171599_("head_r1", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171480_().m_171488_(-2.0F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(1.8298F, -1.8827F, -0.4524F, -0.2011F, 0.748F, -0.5033F));
      head.m_171599_("head_r2", CubeListBuilder.m_171558_().m_171514_(1, 9).m_171488_(-1.0F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-1.8298F, -1.8827F, -0.4524F, -0.2011F, -0.748F, 0.5033F));
      PartDefinition left_arm = partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(3.0F, 5.0F, 0.0F));
      left_arm.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171480_().m_171488_(-0.5793F, 3.2759F, -6.621F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -1.5708F, 0.0F, 2.7489F));
      left_arm.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171480_().m_171488_(-0.5793F, 0.9763F, -4.7409F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -1.9635F, 0.0F, 2.7489F));
      left_arm.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171480_().m_171488_(-0.5793F, -2.0528F, -3.9108F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -2.3562F, 0.0F, 2.7489F));
      left_arm.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-1.0793F, -4.6692F, -4.7533F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -2.7489F, 0.0F, 2.7489F));
      left_arm.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-1.0793F, -12.9247F, -6.0251F, 2.0F, 11.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, 3.1416F, 0.0F, 2.7489F));
      left_arm.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171480_().m_171488_(-2.1987F, 2.0964F, -7.3292F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -1.5708F, -0.3927F, 2.3562F));
      left_arm.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171480_().m_171488_(-2.1987F, 0.1576F, -5.8465F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -1.9635F, -0.3927F, 2.3562F));
      left_arm.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171480_().m_171488_(-2.1987F, -2.3861F, -5.2455F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -2.3562F, -0.3927F, 2.3562F));
      left_arm.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-2.6987F, -4.4663F, -6.114F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.35F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -2.7489F, -0.3927F, 2.3562F));
      left_arm.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171480_().m_171488_(-2.6987F, -12.2166F, -7.2046F, 2.0F, 11.0F, 2.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(4.4487F, 11.2166F, -4.7954F, -3.1416F, -0.3927F, 2.3562F));
      PartDefinition right_arm = partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_(), PartPose.m_171419_(-3.0F, 5.0F, 0.0F));
      right_arm.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171488_(-0.4207F, 3.2759F, -6.621F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -1.5708F, 0.0F, -2.7489F));
      right_arm.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171488_(-0.4207F, 0.9763F, -4.7409F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -1.9635F, 0.0F, -2.7489F));
      right_arm.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171488_(-0.4207F, -2.0528F, -3.9108F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -2.3562F, 0.0F, -2.7489F));
      right_arm.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-0.9207F, -4.6692F, -4.7533F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -2.7489F, 0.0F, -2.7489F));
      right_arm.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(-0.9207F, -12.9247F, -6.0251F, 2.0F, 11.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, 3.1416F, 0.0F, -2.7489F));
      right_arm.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171488_(1.1987F, 2.0964F, -7.3292F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -1.5708F, 0.3927F, -2.3562F));
      right_arm.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171488_(1.1987F, 0.1576F, -5.8465F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -1.9635F, 0.3927F, -2.3562F));
      right_arm.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(26, 1).m_171488_(1.1987F, -2.3861F, -5.2455F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -2.3562F, 0.3927F, -2.3562F));
      right_arm.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(0.6987F, -4.4663F, -6.114F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.35F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -2.7489F, 0.3927F, -2.3562F));
      right_arm.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(24, 0).m_171488_(0.6987F, -12.2166F, -7.2046F, 2.0F, 11.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-4.4487F, 11.2166F, -4.7954F, -3.1416F, 0.3927F, -2.3562F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.rigft_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_leg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.left_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.right_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.left_arm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.rigft_leg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
   }
}
