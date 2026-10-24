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

public class Modelcursedspirit_brownwarm<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_brownwarm"), "main");
   public final ModelPart head;
   public final ModelPart leg;
   public final ModelPart leg2;
   public final ModelPart leg3;

   public Modelcursedspirit_brownwarm(ModelPart root) {
      this.head = root.m_171324_("head");
      this.leg = this.head.m_171324_("leg");
      this.leg2 = this.leg.m_171324_("leg2");
      this.leg3 = this.leg2.m_171324_("leg3");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171480_().m_171488_(-1.5F, -1.4587F, -4.4619F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.3F)).m_171555_(false), PartPose.m_171419_(0.0F, 22.0F, -4.0F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-1.0F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(-0.5F, -1.4856F, -1.5042F, -0.3655F, 0.147F, 0.3655F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(0.0F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.5F, -1.4856F, -1.5042F, -0.3655F, -0.147F, -0.3655F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(1, 0).m_171488_(0.0F, 0.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-1.0F, -3.1594F, -1.3716F, -0.3927F, 0.0F, 0.0F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(22, 5).m_171480_().m_171488_(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.4413F, -3.9619F, 0.0F, 0.7854F, -1.5708F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.019F, -0.9043F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.7786F, -0.3814F, -4.516F, 0.3927F, 0.0F, -1.9635F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.4979F, -0.9025F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.7786F, -0.3814F, -4.516F, 0.3843F, -0.0829F, -1.7615F));
      head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5021F, -0.9025F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-0.7786F, -0.3814F, -4.516F, 0.3843F, 0.0829F, 1.7615F));
      head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.981F, -0.9043F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-0.7786F, -0.3814F, -4.516F, 0.3927F, 0.0F, 1.9635F));
      head.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(0.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-0.867F, 0.6376F, -4.4794F, 0.3655F, 0.147F, 1.2053F));
      head.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-0.867F, 0.6376F, -4.4794F, 0.3843F, 0.0829F, 1.3688F));
      head.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171480_().m_171488_(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)).m_171555_(false), PartPose.m_171423_(-1.329F, 0.1376F, -4.2881F, 0.3927F, 0.0F, 1.5708F));
      head.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.867F, 0.6376F, -4.4794F, 0.3655F, -0.147F, -1.2053F));
      head.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(0.867F, 0.6376F, -4.4794F, 0.3843F, -0.0829F, -1.3688F));
      head.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.m_171423_(1.329F, 0.1376F, -4.2881F, 0.3927F, 0.0F, -1.5708F));
      head.m_171599_("cube_r15", CubeListBuilder.m_171558_().m_171514_(17, 6).m_171488_(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(1.579F, 0.1376F, -3.7881F, 0.0F, -0.3927F, 3.1416F));
      head.m_171599_("cube_r16", CubeListBuilder.m_171558_().m_171514_(17, 6).m_171480_().m_171488_(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(-1.579F, 0.1376F, -3.7881F, 0.0F, 0.3927F, -3.1416F));
      head.m_171599_("cube_r17", CubeListBuilder.m_171558_().m_171514_(17, 6).m_171480_().m_171488_(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.0F, 1.7166F, -3.7881F, 0.0F, 0.3927F, 1.5708F));
      head.m_171599_("cube_r18", CubeListBuilder.m_171558_().m_171514_(17, 6).m_171480_().m_171488_(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).m_171555_(false), PartPose.m_171423_(0.5F, -1.25F, -4.25F, 0.0F, 0.3927F, -1.5708F));
      head.m_171599_("cube_r19", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(0.0F, 0.0F, -2.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition leg = head.m_171599_("leg", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      leg.m_171599_("cube_r20", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 0.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
      PartDefinition leg2 = leg.m_171599_("leg2", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.1F, 6.5F));
      leg2.m_171599_("cube_r21", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -0.1F, -1.9F, 4.0F, 16.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, 0.0F, 5.4F, 1.5708F, 0.0F, 0.0F));
      PartDefinition leg3 = leg2.m_171599_("leg3", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 0.1F, 21.0F));
      leg3.m_171599_("cube_r22", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -0.2F, 1.5F, 1.5708F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.leg2.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F + 3.0F) * 0.6F;
      this.leg3.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F) * 0.6F;
      this.leg.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F) * 0.6F;
   }
}
