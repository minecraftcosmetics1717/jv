package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_perikan;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade28Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade28Renderer extends MobRenderer<CursedSpiritGrade28Entity, Modelcursedspirit_perikan<CursedSpiritGrade28Entity>> {
   public CursedSpiritGrade28Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_perikan(context.m_174023_(Modelcursedspirit_perikan.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade28Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(2.0F, 2.0F, 2.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade28Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_perikan.png");
   }
}
