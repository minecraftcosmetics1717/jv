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

public class Modelcursedspirit_maggot<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_maggot"), "main");
   public final ModelPart body;
   public final ModelPart head;

   public Modelcursedspirit_maggot(ModelPart root) {
      this.body = root.m_171324_("body");
      this.head = root.m_171324_("head");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(1, 4).m_171488_(-1.0F, -1.9688F, 10.0313F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(1, 10).m_171488_(-2.0F, -3.7188F, 2.7813F, 4.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(0, 4).m_171488_(-1.5F, -2.9688F, -4.9688F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 4).m_171488_(-1.5F, -2.7188F, -6.7188F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(4, 9).m_171480_().m_171488_(-2.0F, -3.9688F, 0.0313F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(0, 9).m_171488_(-2.0F, -3.9688F, -2.9688F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171488_(-1.5F, -2.9688F, 4.5313F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).m_171514_(0, 16).m_171488_(-1.5F, -2.7188F, 7.2813F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.m_171419_(0.0F, 23.9688F, -1.7813F));
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-1.0F, -1.0F, -0.7065F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).m_171514_(0, 0).m_171488_(-1.0F, -1.0F, -1.4565F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.m_171419_(0.0F, 22.75F, -8.0435F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(2, 0).m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(-0.625F, 0.0F, -0.4565F, -1.5708F, -0.3927F, 0.0F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(4, 0).m_171480_().m_171488_(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).m_171555_(false), PartPose.m_171423_(0.625F, 0.0F, -0.4565F, -1.5708F, 0.3927F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.body.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.head.f_104203_ = headPitch / (180F / (float)Math.PI);
   }
}
