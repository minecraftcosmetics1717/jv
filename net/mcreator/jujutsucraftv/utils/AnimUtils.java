package net.mcreator.jujutsucraftv.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import software.bernie.geckolib.cache.object.GeoBone;

public class AnimUtils {
   public static void renderPartOverBone(ModelPart model, GeoBone bone, PoseStack stack, VertexConsumer buffer, int packedLightIn, int packedOverlayIn, float alpha) {
      renderPartOverBone(model, bone, stack, buffer, packedLightIn, packedOverlayIn, 1.0F, 1.0F, 1.0F, alpha);
   }

   public static void renderPartOverBone(ModelPart model, GeoBone bone, PoseStack stack, VertexConsumer buffer, int packedLightIn, int packedOverlayIn, float r, float g, float b, float a) {
      setupModelFromBone(model, bone);
      model.m_104306_(stack, buffer, packedLightIn, packedOverlayIn, r, g, b, a);
   }

   public static void setupModelFromBone(ModelPart model, GeoBone bone) {
      model.m_104227_(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());
      model.f_104203_ = 0.0F;
      model.f_104204_ = 0.0F;
      model.f_104205_ = 0.0F;
   }
}
