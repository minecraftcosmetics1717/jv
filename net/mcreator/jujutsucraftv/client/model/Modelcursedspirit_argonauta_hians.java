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

public class Modelcursedspirit_argonauta_hians<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_argonauta_hians"), "main");
   public final ModelPart bone;

   public Modelcursedspirit_argonauta_hians(ModelPart root) {
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 10).m_171488_(-1.5F, -0.0149F, -6.1841F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-1.0F, -2.2014F, -0.6374F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171514_(0, 0).m_171488_(-1.0F, -2.2014F, -1.6374F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(-0.5F, 19.2649F, 3.4341F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171488_(-1.5F, -1.75F, -1.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(-0.05F)), PartPose.m_171423_(0.5F, 0.2014F, 1.1374F, -0.7854F, 0.0F, 0.0F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -2.0F, -0.25F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.05F)).m_171514_(0, 5).m_171488_(-2.5F, -2.0F, -1.25F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(1.0F, -0.3162F, -1.5343F, 0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 5).m_171488_(-2.0F, -2.0F, 0.25F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.05F)).m_171514_(0, 5).m_171488_(-2.0F, -2.0F, -0.75F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.5F, 0.7351F, -3.0199F, 0.7854F, 0.0F, 0.0F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(3, 13).m_171488_(-1.75F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).m_171514_(3, 13).m_171480_().m_171488_(0.75F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false), PartPose.m_171423_(-2.5F, 3.8705F, -4.4144F, 0.0F, 1.5708F, 0.7854F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(3, 13).m_171480_().m_171488_(0.75F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(3, 13).m_171488_(-1.75F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(3.5F, 3.8705F, -4.4144F, 0.0F, -1.5708F, -0.7854F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(3, 13).m_171480_().m_171488_(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)).m_171555_(false).m_171514_(3, 13).m_171488_(-3.0F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(1.75F, 3.3705F, -7.1644F, -0.7854F, 0.0F, 0.0F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 10).m_171488_(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.5F, 2.3706F, -4.6644F, -0.2182F, 0.0F, 0.0F));
      bone.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -2.2492F, -0.3721F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.15F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
