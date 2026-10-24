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

public class Modelcursedspirit_eel<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_eel"), "main");
   public final ModelPart head;
   public final ModelPart bone;

   public Modelcursedspirit_eel(ModelPart root) {
      this.head = root.m_171324_("head");
      this.bone = root.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition head = partdefinition.m_171599_("head", CubeListBuilder.m_171558_(), PartPose.m_171419_(0.0F, 22.2929F, 0.7071F));
      head.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.0F, -1.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.m_171423_(0.0F, -20.2708F, 4.0353F, -1.5708F, 0.0F, -1.5708F));
      head.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-2.75F, -0.75F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.m_171423_(0.0F, -20.8596F, 2.4749F, -1.5708F, 0.3927F, -1.5708F));
      head.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(11.0F, -15.0F, -1.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(0, 10).m_171488_(12.0F, -6.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).m_171514_(16, 0).m_171488_(11.0F, -12.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, 0.0F, 0.0F, -1.5708F, 0.7854F, -1.5708F));
      head.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(7.0F, -12.0F, -1.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, 0.3536F, 0.3535F, -1.5708F, 0.7854F, -1.5708F));
      head.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 10).m_171488_(-1.5F, -1.5F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(0.0F, -12.3744F, -6.0104F, -1.5708F, 0.7854F, 1.5708F));
      head.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(14, 10).m_171488_(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-1.25F, -15.5563F, -3.5355F, 1.5708F, -0.3927F, 1.5708F));
      head.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(14, 10).m_171480_().m_171488_(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171423_(1.25F, -15.5563F, -3.5355F, 1.5708F, 0.3927F, -1.5708F));
      head.m_171599_("cube_r8", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171488_(-2.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -9.8995F, -2.8284F, -1.5708F, 0.7854F, 1.5708F));
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 9.9185F, 1.0607F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r9", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.4526F, -0.1363F, -0.4767F, 3.0F, 8.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(4.3549F, -8.966F, 29.4562F, 1.9635F, -0.6109F, 1.5708F));
      bone.m_171599_("cube_r10", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.9526F, -7.1577F, -0.6171F, 4.0F, 8.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(4.3549F, -8.966F, 29.4562F, 2.3562F, -0.6109F, 1.5708F));
      bone.m_171599_("cube_r11", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(1.0337F, -10.8209F, -2.4221F, 5.0F, 8.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.m_171423_(2.3929F, -11.7554F, 25.7119F, 1.9635F, -0.2182F, 1.5708F));
      bone.m_171599_("cube_r12", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.6453F, -11.2168F, -8.1332F, 5.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(2.3929F, -7.5325F, 25.1647F, 1.1781F, -0.6109F, 1.5708F));
      bone.m_171599_("cube_r13", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.0F, -2.5F, -1.0F, 5.0F, 8.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.m_171423_(0.0F, 2.6037F, 9.8397F, 1.5708F, -0.3927F, 1.5708F));
      bone.m_171599_("cube_r14", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-6.0F, -2.0F, -1.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, 3.0F, 1.0F, 1.5708F, 0.0F, 1.5708F));
      return LayerDefinition.m_171565_(meshdefinition, 32, 32);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.head.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
