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

public class Modelcursedspirit_bard<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_bard"), "main");
   public final ModelPart bone;
   public final ModelPart head;
   public final ModelPart left_wing;
   public final ModelPart right_wing;

   public Modelcursedspirit_bard(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.head = root.m_171324_("head");
      this.left_wing = root.m_171324_("left_wing");
      this.right_wing = root.m_171324_("right_wing");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 13.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(-0.5245F, -2.1904F, -0.2238F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false).m_171514_(46, 0).m_171480_().m_171488_(-0.5245F, -4.6904F, -0.2238F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, -0.0272F, 0.147F, 0.0272F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(-0.5245F, -1.5906F, -0.9615F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, -0.8126F, 0.147F, 0.0272F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(0.0326F, -1.4398F, -0.8615F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, -0.8136F, -0.14F, -0.2418F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(-1.154F, -1.8037F, -0.8615F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, -0.729F, 0.4226F, 0.3199F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(-0.5245F, 0.3738F, -2.1144F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, -0.0272F, 0.147F, 0.0272F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(0.0326F, 0.5511F, -2.1503F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, -0.0282F, -0.14F, -0.2418F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171480_().m_171488_(-1.154F, 0.2938F, -1.893F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)).m_171555_(false), PartPose.m_171423_(-2.9536F, 7.2668F, 2.062F, 0.0564F, 0.4226F, 0.3199F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-0.846F, 0.2938F, -1.893F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, 0.0564F, -0.4226F, -0.3199F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-2.0326F, 0.5511F, -2.1503F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, -0.0282F, 0.14F, 0.2418F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-1.4755F, 0.3738F, -2.1144F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, -0.0272F, -0.147F, -0.0272F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-1.4755F, -4.6904F, -0.2238F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.4F)).m_171514_(46, 0).m_171488_(-1.4755F, -2.1904F, -0.2238F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, -0.0272F, -0.147F, -0.0272F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-0.846F, -1.8037F, -0.8615F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, -0.729F, -0.4226F, -0.3199F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-2.0326F, -1.4398F, -0.8615F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, -0.8136F, 0.14F, 0.2418F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(46, 0).m_171488_(-1.4755F, -1.5906F, -0.9615F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.m_171423_(2.9536F, 7.2668F, 2.062F, -0.8126F, -0.147F, -0.0272F));
      bone.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171488_(-4.0F, -5.1822F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 1.1781F, 0.7854F, 1.5708F));
      bone.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -2.8178F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 1.9635F, 0.7854F, 1.5708F));
      bone.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171480_().m_171488_(-4.0F, -5.1822F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 1.1781F, -0.7854F, -1.5708F));
      bone.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-4.0F, -2.8178F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 1.9635F, -0.7854F, -1.5708F));
      bone.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -6.8178F, -5.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)).m_171514_(0, 0).m_171488_(-4.0F, 8.1822F, -5.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.5F)).m_171514_(0, 40).m_171488_(-4.0F, 2.1822F, -5.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(0.0F, -3.8987F, -1.1033F, 2.3562F, 0.0F, 3.1416F));
      bone.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -2.8178F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 2.7489F, 0.0F, 3.1416F));
      bone.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171488_(-4.0F, -5.1822F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 1.9635F, 0.0F, 3.1416F));
      bone.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-4.0F, -2.8178F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 1.1781F, 0.0F, 0.0F));
      bone.m_171599_("cube_r23", CubeListBuilder.m_171558_().m_171514_(0, 40).m_171488_(-4.0F, -5.1822F, -6.4761F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -3.8987F, 0.8967F, 0.3927F, 0.0F, 0.0F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-2.5F, 2.0F, -5.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 24).m_171488_(-2.5F, -1.0F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171488_(-3.5F, -3.5612F, -2.9258F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).m_171514_(0, 28).m_171480_().m_171488_(-4.51F, -1.5612F, -3.9258F, 9.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(34, 8).m_171488_(-2.0F, -0.5612F, -4.0258F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 4.0F, -5.0F));
      head.m_171599_("cube_r24", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, 1.0F, -5.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)).m_171555_(false), PartPose.m_171423_(0.9713F, 1.0F, -0.3149F, 0.0F, 1.1781F, 0.0F));
      head.m_171599_("cube_r25", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, 1.0F, -5.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(-0.9713F, 1.0F, -0.3149F, 0.0F, -1.1781F, 0.0F));
      head.m_171599_("cube_r26", CubeListBuilder.m_171558_().m_171514_(26, 6).m_171488_(-1.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, 0.0F, -4.25F, 0.1745F, 0.0F, 0.0F));
      head.m_171599_("cube_r27", CubeListBuilder.m_171558_().m_171514_(26, 6).m_171488_(-0.5F, -0.25F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.5F, 1.5F, -4.25F, -0.1745F, 0.0F, 0.0F));
      head.m_171599_("cube_r28", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-2.5F, -0.3519F, -3.2716F, 6.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(1.99F, 0.516F, -0.4379F, 0.0F, -1.5708F, -0.5672F));
      head.m_171599_("cube_r29", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.5F, -0.3519F, -3.2716F, 6.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-1.99F, 0.516F, -0.4379F, 0.0F, 1.5708F, 0.5672F));
      head.m_171599_("cube_r30", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.5F, -0.3519F, -3.2716F, 6.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-0.54F, -2.084F, -0.4379F, 0.0F, 1.5708F, 0.3927F));
      head.m_171599_("cube_r31", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.5F, -0.3519F, -3.2716F, 6.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.54F, -2.084F, -0.4379F, 0.0F, -1.5708F, -0.3927F));
      head.m_171599_("cube_r32", CubeListBuilder.m_171558_().m_171514_(0, 28).m_171488_(-3.0F, -4.0F, -6.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(-0.51F, 2.3305F, 1.1867F, -0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r33", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, -4.0F, -3.0F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.51F, -0.7327F, 5.9026F, 0.7854F, 0.0F, 0.0F));
      head.m_171599_("cube_r34", CubeListBuilder.m_171558_().m_171514_(0, 23).m_171488_(-2.0F, 1.0F, -5.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.5F, 3.0657F, 0.3848F, -0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r35", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-3.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-2.2964F, 1.0428F, -3.8393F, 0.0F, 0.7854F, -0.7854F));
      head.m_171599_("cube_r36", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(2.2964F, 1.0428F, -3.8393F, 0.0F, -0.7854F, 0.7854F));
      head.m_171599_("cube_r37", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)).m_171555_(false), PartPose.m_171423_(1.3393F, 0.0857F, -4.4F, 0.0F, 0.0F, 0.7854F));
      head.m_171599_("cube_r38", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-1.0F, 1.0F, -5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.m_171423_(-2.4F, -0.975F, 0.1F, 0.0F, 0.0F, -0.7854F));
      PartDefinition left_wing = partdefinition.m_171599_("left_wing", CubeListBuilder.m_171558_(), PartPose.m_171419_(4.0F, 4.0F, 0.0F));
      left_wing.m_171599_("cube_r39", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171488_(0.2457F, -2.7451F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(12.2017F, 0.3372F, -0.25F, 0.1427F, 0.2875F, 0.2896F));
      left_wing.m_171599_("cube_r40", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171488_(-7.2031F, -2.9594F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(12.2017F, 0.3372F, -0.25F, 0.2128F, 0.2409F, 0.5565F));
      left_wing.m_171599_("cube_r41", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171488_(0.3471F, -3.2072F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(6, 8).m_171488_(-1.4735F, -1.5111F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.2F)), PartPose.m_171423_(4.049F, -0.6352F, 0.0F, 0.1022F, -0.2415F, -0.4051F));
      left_wing.m_171599_("cube_r42", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171488_(-6.0174F, -2.788F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.25F)).m_171514_(26, 0).m_171488_(-6.0174F, -2.988F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(4.049F, -0.6352F, 0.0F, 0.1617F, -0.2068F, -0.6713F));
      left_wing.m_171599_("cube_r43", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171488_(-0.6527F, -2.6198F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.m_171423_(12.2017F, 0.3372F, -0.25F, 0.1794F, 0.2665F, 0.4239F));
      left_wing.m_171599_("cube_r44", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171488_(-6.731F, -1.2054F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(12.2017F, 0.3372F, -0.25F, 0.2128F, 0.2409F, 0.5565F));
      PartDefinition right_wing = partdefinition.m_171599_("right_wing", CubeListBuilder.m_171558_(), PartPose.m_171419_(-4.0F, 4.0F, 0.0F));
      right_wing.m_171599_("cube_r45", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171480_().m_171488_(-8.2457F, -2.7451F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.15F)).m_171555_(false), PartPose.m_171423_(-12.2017F, 0.3372F, -0.25F, 0.1427F, -0.2875F, -0.2896F));
      right_wing.m_171599_("cube_r46", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171480_().m_171488_(-0.7969F, -2.9594F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-12.2017F, 0.3372F, -0.25F, 0.2128F, -0.2409F, -0.5565F));
      right_wing.m_171599_("cube_r47", CubeListBuilder.m_171558_().m_171514_(26, 0).m_171480_().m_171488_(-5.3471F, -3.2072F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(6, 8).m_171480_().m_171488_(-5.5265F, -1.5111F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171423_(-4.049F, -0.6352F, 0.0F, 0.1022F, 0.2415F, 0.4051F));
      right_wing.m_171599_("cube_r48", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171480_().m_171488_(-0.9826F, -2.788F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.25F)).m_171555_(false).m_171514_(26, 0).m_171480_().m_171488_(-0.9826F, -2.988F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)).m_171555_(false), PartPose.m_171423_(-4.049F, -0.6352F, 0.0F, 0.1617F, 0.2068F, 0.6713F));
      right_wing.m_171599_("cube_r49", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171480_().m_171488_(-6.3473F, -2.6198F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.1F)).m_171555_(false), PartPose.m_171423_(-12.2017F, 0.3372F, -0.25F, 0.1794F, -0.2665F, -0.4239F));
      right_wing.m_171599_("cube_r50", CubeListBuilder.m_171558_().m_171514_(6, 8).m_171480_().m_171488_(-0.269F, -1.2054F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.15F)).m_171555_(false), PartPose.m_171423_(-12.2017F, 0.3372F, -0.25F, 0.2128F, -0.2409F, -0.5565F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_wing.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_wing.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.right_wing.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.left_wing.f_104204_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
   }
}
