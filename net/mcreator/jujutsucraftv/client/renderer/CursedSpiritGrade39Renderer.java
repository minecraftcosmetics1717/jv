package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_mosh;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade39Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade39Renderer extends MobRenderer<CursedSpiritGrade39Entity, Modelcursedspirit_mosh<CursedSpiritGrade39Entity>> {
   public CursedSpiritGrade39Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_mosh(context.m_174023_(Modelcursedspirit_mosh.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade39Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(3.0F, 3.0F, 3.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade39Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_mosh2.png");
   }
}
