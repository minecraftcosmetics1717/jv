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

public class Modelcursedspirit_apple<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelcursedspirit_apple"), "main");
   public final ModelPart bone;
   public final ModelPart right_arm;
   public final ModelPart left_arm;

   public Modelcursedspirit_apple(ModelPart root) {
      this.bone = root.m_171324_("bone");
      this.right_arm = root.m_171324_("right_arm");
      this.left_arm = root.m_171324_("left_arm");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition bone = partdefinition.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-5.0F, -13.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).m_171514_(0, 14).m_171488_(-6.0F, -19.0F, -6.0F, 12.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).m_171514_(0, 0).m_171488_(-5.0F, -21.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(0.0F, 21.0F, 0.0F));
      bone.m_171599_("cube_r1", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-1.6693F, -7.0291F, -0.9696F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.25F, -3.3778F, -1.275F, 1.5708F, 0.7854F, -1.5708F));
      bone.m_171599_("cube_r2", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-1.6693F, -7.009F, -0.0376F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.25F, -3.3778F, -1.275F, 1.4399F, 0.7854F, -1.5708F));
      bone.m_171599_("cube_r3", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-1.6693F, -6.9366F, 0.9246F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(0, 34).m_171488_(-2.4194F, -1.2673F, -1.889F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.m_171423_(-0.25F, -3.3778F, -1.275F, 1.3526F, 0.7854F, -1.5708F));
      bone.m_171599_("cube_r4", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-1.6693F, -7.1289F, -1.6909F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(-0.25F, -3.3778F, -1.275F, 1.789F, 0.7854F, -1.5708F));
      bone.m_171599_("cube_r5", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-2.645F, -4.7842F, -1.728F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.m_171423_(-0.25F, -3.3778F, -1.275F, 2.7427F, 0.8669F, -1.3425F));
      bone.m_171599_("cube_r6", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-0.5F, -2.0F, 0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.0F, -23.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
      bone.m_171599_("cube_r7", CubeListBuilder.m_171558_().m_171514_(0, 34).m_171488_(-2.1371F, -6.6222F, 1.275F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.m_171423_(0.1371F, -3.3778F, -1.275F, 0.3927F, 0.0F, 0.0F));
      partdefinition.m_171599_("right_arm", CubeListBuilder.m_171558_().m_171514_(30, 4).m_171480_().m_171488_(-8.0F, -3.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).m_171555_(false), PartPose.m_171419_(-6.0F, 6.0F, 0.0F));
      partdefinition.m_171599_("left_arm", CubeListBuilder.m_171558_().m_171514_(30, 4).m_171488_(0.0F, -3.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.m_171419_(6.0F, 6.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 64, 64);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.bone.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.right_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
      this.left_arm.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.right_arm.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F) * 0.6F;
      this.left_arm.f_104204_ = Mth.m_14031_(ageInTicks * 0.6F + 3.0F) * 0.6F;
   }
}
