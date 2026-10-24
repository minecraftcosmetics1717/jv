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

public class Modelclothes_bagmusk<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelclothes_bagmusk"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorRightArm;
   public final ModelPart armorLeftArm;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightBoot;
   public final ModelPart armorLeftBoot;

   public Modelclothes_bagmusk(ModelPart root) {
      this.armorHead = root.m_171324_("armorHead");
      this.armorBody = root.m_171324_("armorBody");
      this.armorRightArm = root.m_171324_("armorRightArm");
      this.armorLeftArm = root.m_171324_("armorLeftArm");
      this.armorRightLeg = root.m_171324_("armorRightLeg");
      this.armorLeftLeg = root.m_171324_("armorLeftLeg");
      this.armorRightBoot = root.m_171324_("armorRightBoot");
      this.armorLeftBoot = root.m_171324_("armorLeftBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      partdefinition.m_171599_("armorHead", CubeListBuilder.m_171558_().m_171514_(32, 32).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)).m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorBody", CubeListBuilder.m_171558_().m_171514_(16, 16).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorRightArm", CubeListBuilder.m_171558_().m_171514_(32, 48).m_171488_(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(-5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("armorLeftArm", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171480_().m_171488_(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.251F)).m_171555_(false), PartPose.m_171419_(5.0F, 2.0F, 0.0F));
      partdefinition.m_171599_("armorRightLeg", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171514_(0, 16).m_171488_(-2.0F, 0.5F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(0, 16).m_171480_().m_171488_(-2.0F, 0.5F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorRightBoot", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171514_(16, 56).m_171488_(-2.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftBoot", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(16, 56).m_171480_().m_171488_(-2.0F, 8.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorBody.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftArm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.armorHead.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.armorHead.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.armorLeftArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F) * limbSwingAmount;
      this.armorRightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.armorRightBoot.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.armorLeftBoot.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.armorRightArm.f_104203_ = Mth.m_14089_(limbSwing * 0.6662F + (float)Math.PI) * limbSwingAmount;
      this.armorLeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
