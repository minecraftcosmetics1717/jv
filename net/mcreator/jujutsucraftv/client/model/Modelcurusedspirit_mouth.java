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

public class Modelcurusedspirit_mouth<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcurusedspirit_mouth"), "main");
   public final ModelPart bone;

   public Modelcurusedspirit_mouth(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(1, 1).m_171488_(-6.0F, -12.75F, -5.0F, 12.0F, 4.0F, 11.0F, new CubeDeformation(0.1F)).m_171514_(6, 4).m_171488_(-4.0F, -13.75F, -3.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.1F)).m_171514_(0, 0).m_171488_(-6.0F, -3.5F, -5.25F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 10.0F, -1.2262F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(2, 20).m_171488_(-6.0F, -1.0F, -5.0F, 12.0F, 4.0F, 10.0F, new CubeDeformation(-0.5F)), PartPose.m_171423_(0.0F, -4.4651F, -1.6892F, -0.3927F, 0.0F, -3.1416F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(2, 36).m_171488_(-6.0F, -3.0F, -6.0F, 12.0F, 2.0F, 10.0F, new CubeDeformation(-0.1F)).m_171514_(1, 1).m_171488_(-6.0F, -2.0F, -6.0F, 12.0F, 3.0F, 11.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -3.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 18).m_171488_(-6.0F, 1.5F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(-0.4F)).m_171514_(2, 36).m_171488_(-6.0F, 1.0F, -6.0F, 12.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(2, 2).m_171488_(-6.0F, -1.0F, -6.0F, 12.0F, 3.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -9.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(1, 49).m_171480_().m_171488_(0.5127F, -2.1882F, -6.5599F, 2.0F, 7.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, -3.4849F, -4.0136F, 1.4549F, -0.4402F, 1.919F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(0.578F, 2.5357F, -3.5387F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, -3.4849F, -4.0136F, -0.0775F, -0.3606F, 1.8977F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-0.597F, -0.1523F, -3.2875F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, -3.4849F, -4.0136F, -0.0255F, -0.3942F, 1.5236F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171480_().m_171488_(-0.5F, -3.75F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(0.0F, -5.3798F, -3.1798F, -0.9671F, 0.3286F, 0.219F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171488_(-2.5F, -3.75F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -5.3798F, -3.1798F, -0.9671F, -0.3286F, -0.219F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 49).m_171488_(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -5.3798F, -3.1798F, -1.0036F, 0.0F, 0.0F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-1.403F, -0.1523F, -3.2875F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -3.4849F, -4.0136F, -0.0255F, 0.3942F, -1.5236F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-2.578F, 2.5357F, -3.5387F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -3.4849F, -4.0136F, -0.0775F, 0.3606F, -1.8977F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(1, 49).m_171488_(-2.5127F, -2.1882F, -6.5599F, 2.0F, 7.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -3.4849F, -4.0136F, 1.4549F, 0.4402F, -1.919F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-0.2159F, 0.1637F, -1.7841F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-0.3644F, -8.6901F, -5.5402F, -0.0255F, -0.3942F, -1.618F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(1, 49).m_171488_(-1.8F, -0.45F, -4.8F, 2.0F, 9.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-1.9549F, -9.336F, -5.4561F, 1.4549F, 0.4402F, 1.2226F));
      bone.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(1, 49).m_171480_().m_171488_(-0.2F, -0.45F, -4.8F, 2.0F, 9.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(1.9549F, -9.336F, -5.4561F, 1.4549F, -0.4402F, -1.2226F));
      bone.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171480_().m_171488_(-0.2F, -0.2F, -1.8F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(2.9096F, -8.9919F, -5.5593F, -0.0775F, -0.3606F, -1.2439F));
      bone.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-1.8F, -0.2F, -1.8F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(-2.9096F, -8.9919F, -5.5593F, -0.0775F, 0.3606F, 1.2439F));
      bone.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 48).m_171488_(-1.8F, -0.2F, -1.8F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -8.6901F, -5.5402F, -0.0255F, 0.3942F, 1.618F));
      bone.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(9, 9).m_171488_(-6.0F, -2.0F, 1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -3.7678F, 3.6538F, -0.7854F, 0.0F, 0.0F));
      bone.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(9, 9).m_171488_(-6.0F, -2.0F, 1.5F, 12.0F, 4.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -12.7678F, 3.6538F, -0.7854F, 0.0F, 0.0F));
      bone.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(3, 3).m_171488_(-6.0F, -4.0F, -0.5F, 12.0F, 4.0F, 9.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -10.5F, 4.25F, -1.5708F, 0.0F, 0.0F));
      bone.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171488_(-5.6953F, -4.2074F, 2.2074F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, -6.3334F, 8.2926F, 2.3562F, -0.7854F, -2.7489F));
      bone.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(13, 10).m_171488_(-4.5206F, 0.905F, -0.1363F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.7779F, -8.7747F, 6.7706F, 0.0F, -1.5708F, -0.3927F));
      bone.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(1.0547F, -2.0718F, 0.0718F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.8539F, -7.8059F, 5.0769F, -1.2899F, -0.3175F, 0.6992F));
      bone.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(13, 10).m_171480_().m_171488_(-8.0547F, -2.0718F, 0.0718F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.8539F, -7.8059F, 5.0769F, -1.2899F, 0.3175F, -0.6992F));
      bone.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(13, 10).m_171480_().m_171488_(-0.4794F, 0.905F, -0.1363F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.7779F, -8.7747F, 6.7706F, 0.0F, 1.5708F, 0.3927F));
      bone.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171480_().m_171488_(2.6953F, -4.2074F, 2.2074F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.0F, -6.3334F, 8.2926F, 2.3562F, 0.7854F, 2.7489F));
      bone.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171480_().m_171488_(-11.0547F, -2.0718F, 0.0718F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.9612F, -10.4673F, 2.4243F, -1.0638F, 0.653F, -0.5426F));
      bone.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171480_().m_171488_(1.3571F, -4.1631F, 1.9381F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.3315F, -2.8843F, 4.1895F, 2.3562F, 0.7854F, -2.7489F));
      bone.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171480_().m_171488_(-3.0605F, -2.3189F, 0.0939F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(5.3315F, -2.8843F, 4.1895F, 0.0F, 1.5708F, 1.1781F));
      bone.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(13, 10).m_171480_().m_171488_(-6.4396F, -3.6598F, 0.3659F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.1961F, -4.3508F, 5.6138F, -2.4483F, 0.4212F, -0.9572F));
      bone.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171488_(-4.3571F, -4.1631F, 1.9381F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-5.3315F, -2.8843F, 4.1895F, 2.3562F, -0.7854F, 2.7489F));
      bone.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-4.9395F, -2.3189F, 0.0939F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-5.3315F, -2.8843F, 4.1895F, 0.0F, -1.5708F, -1.1781F));
      bone.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-0.5604F, -3.6598F, 0.3659F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.1961F, -4.3508F, 5.6138F, -2.4483F, -0.4212F, 0.9572F));
      bone.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(1.0547F, -2.0718F, 0.0718F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.9612F, -10.4673F, 2.4243F, -1.0638F, -0.653F, 0.5426F));
      bone.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-6.0426F, -1.6482F, -0.3518F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, -9.3334F, 3.2925F, 0.0F, -1.5708F, -0.3927F));
      bone.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171488_(-5.6953F, -4.2074F, 2.2074F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-6.0F, -9.3334F, 3.2925F, 2.3562F, -0.7854F, -2.7489F));
      bone.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171480_().m_171488_(-1.9574F, -1.6482F, -0.3518F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.0F, -9.3334F, 3.2925F, 0.0F, 1.5708F, 0.3927F));
      bone.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171480_().m_171488_(2.6953F, -4.2074F, 2.2074F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(6.0F, -9.3334F, 3.2925F, 2.3562F, 0.7854F, 2.7489F));
      bone.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171480_().m_171488_(-11.0547F, -2.0718F, 0.0718F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.0F, -13.2946F, 2.5751F, -0.9975F, 0.8013F, -1.3587F));
      bone.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171480_().m_171488_(-1.9575F, -1.6482F, -0.3518F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.0F, -12.3334F, 3.2925F, 0.0F, 1.5708F, -0.3927F));
      bone.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171480_().m_171488_(2.6953F, -4.2074F, 2.2074F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(4.0F, -12.3334F, 3.2925F, 2.3562F, 0.7854F, 1.9635F));
      bone.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(1.0547F, -2.0718F, 0.0718F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.0F, -13.2946F, 2.5751F, -0.9975F, -0.8013F, 1.3587F));
      bone.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-6.0426F, -1.6482F, -0.3518F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.0F, -12.3334F, 3.2925F, 0.0F, -1.5708F, 0.3927F));
      bone.m_171599_("cube_r45", CubeListBuilder.m_171558_().m_171514_(19, 10).m_171488_(-5.6953F, -4.2074F, 2.2074F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(-4.0F, -12.3334F, 3.2925F, 2.3562F, -0.7854F, -1.9635F));
      bone.m_171599_("cube_r46", CubeListBuilder.m_171558_().m_171514_(18, 10).m_171488_(2.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -10.3923F, -5.3133F, 2.3562F, -0.7854F, -1.5708F));
      bone.m_171599_("cube_r47", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-6.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -10.3923F, 9.3133F, -0.7854F, -0.7854F, 1.5708F));
      bone.m_171599_("cube_r48", CubeListBuilder.m_171558_().m_171514_(10, 10).m_171488_(-6.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(0.0F, -14.25F, 4.0F, 0.0F, -1.5708F, 0.7854F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
