package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_bard;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade33Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade33Renderer extends MobRenderer<CursedSpiritGrade33Entity, Modelcursedspirit_bard<CursedSpiritGrade33Entity>> {
   public CursedSpiritGrade33Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_bard(context.m_174023_(Modelcursedspirit_bard.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade33Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_bard.png");
   }
}
