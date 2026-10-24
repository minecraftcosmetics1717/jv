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

public class Modelclothes_ebina<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelclothes_ebina"), "main");
   public final ModelPart armorHead;
   public final ModelPart armorBody;
   public final ModelPart armorLeftLeg;
   public final ModelPart armorRightLeg;
   public final ModelPart armorLeftBoot;
   public final ModelPart armorRightBoot;

   public Modelclothes_ebina(ModelPart root) {
      this.armorHead = root.m_171324_("armorHead");
      this.armorBody = root.m_171324_("armorBody");
      this.armorLeftLeg = root.m_171324_("armorLeftLeg");
      this.armorRightLeg = root.m_171324_("armorRightLeg");
      this.armorLeftBoot = root.m_171324_("armorLeftBoot");
      this.armorRightBoot = root.m_171324_("armorRightBoot");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition armorHead = partdefinition.m_171599_("armorHead", CubeListBuilder.m_171558_().m_171514_(32, 48).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).m_171514_(32, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.45F)).m_171514_(0, 0).m_171488_(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      armorHead.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 35).m_171488_(-4.0F, -4.0F, -0.5F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.45F)), PartPose.m_171423_(0.0F, 4.9974F, 4.2872F, 0.1745F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorBody", CubeListBuilder.m_171558_().m_171514_(40, 48).m_171488_(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.m_171419_(0.0F, 0.0F, 0.0F));
      partdefinition.m_171599_("armorLeftLeg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(48, 25).m_171480_().m_171488_(-1.85F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.23F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorRightLeg", CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171514_(16, 25).m_171488_(-2.15F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.23F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorLeftBoot", CubeListBuilder.m_171558_().m_171514_(48, 48).m_171480_().m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171555_(false).m_171514_(16, 58).m_171480_().m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.19F)).m_171555_(false), PartPose.m_171419_(2.0F, 12.0F, 0.0F));
      partdefinition.m_171599_("armorRightBoot", CubeListBuilder.m_171558_().m_171514_(48, 46).m_171488_(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).m_171514_(16, 58).m_171488_(-2.0F, 10.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.19F)), PartPose.m_171419_(-2.0F, 12.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.armorHead.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorBody.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightLeg.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorLeftBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.armorRightBoot.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.armorHead.f_104204_ = netHeadYaw / (180F / (float)Math.PI);
      this.armorHead.f_104203_ = headPitch / (180F / (float)Math.PI);
      this.armorRightLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.armorRightBoot.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
      this.armorLeftBoot.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
      this.armorLeftLeg.f_104203_ = Mth.m_14089_(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
   }
}
