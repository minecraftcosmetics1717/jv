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

public class Modelbullet_bayer_knife<T extends Entity> extends EntityModel<T> {
   public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jujutsucraftv", "modelbullet_bayer_knife"), "main");
   public final ModelPart base;
   public final ModelPart bone;

   public Modelbullet_bayer_knife(ModelPart root) {
      this.base = root.m_171324_("base");
      this.bone = this.base.m_171324_("bone");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.m_171576_();
      PartDefinition base = partdefinition.m_171599_("base", CubeListBuilder.m_171558_(), PartPose.m_171423_(0.0F, 24.0F, 0.0F, -1.5708F, 1.5708F, 0.0F));
      base.m_171599_("bone", CubeListBuilder.m_171558_().m_171514_(10, -2).m_171480_().m_171488_(0.0F, -13.35F, -2.215F, 0.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).m_171555_(false).m_171514_(13, 15).m_171488_(0.0F, 0.9F, -0.915F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).m_171514_(2, 2).m_171488_(-0.5F, 2.5F, -1.215F, 1.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)).m_171514_(2, 12).m_171488_(-0.5F, 6.0F, -1.215F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.05F)).m_171514_(1, 13).m_171480_().m_171488_(-0.5F, 1.5F, -1.215F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.05F)).m_171555_(false), PartPose.m_171423_(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));
      return LayerDefinition.m_171565_(meshdefinition, 16, 16);
   }

   public void m_7695_(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      this.base.m_104306_(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
   }

   public void m_6973_(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }
}
