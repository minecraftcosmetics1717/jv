package net.mcreator.jujutsucraftv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_brownwarm;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade321Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade321Renderer extends MobRenderer<CursedSpiritGrade321Entity, Modelcursedspirit_brownwarm<CursedSpiritGrade321Entity>> {
   public CursedSpiritGrade321Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_brownwarm(context.m_174023_(Modelcursedspirit_brownwarm.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade321Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.5F, 1.5F, 1.5F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade321Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_brownwarm.png");
   }
}
