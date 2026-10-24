package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_fatigue;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade314Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade314Renderer extends MobRenderer<CursedSpiritGrade314Entity, Modelcursedspirit_fatigue<CursedSpiritGrade314Entity>> {
   public CursedSpiritGrade314Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_fatigue(context.m_174023_(Modelcursedspirit_fatigue.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade314Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_fatigue.png");
   }
}
