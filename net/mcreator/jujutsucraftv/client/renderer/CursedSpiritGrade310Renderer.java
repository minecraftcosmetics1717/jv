package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_dissatisfaction;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade310Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade310Renderer extends MobRenderer<CursedSpiritGrade310Entity, Modelcursedspirit_dissatisfaction<CursedSpiritGrade310Entity>> {
   public CursedSpiritGrade310Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_dissatisfaction(context.m_174023_(Modelcursedspirit_dissatisfaction.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade310Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_dissatisfaction.png");
   }
}
