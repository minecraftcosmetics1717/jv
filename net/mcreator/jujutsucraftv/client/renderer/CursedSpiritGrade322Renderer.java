package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_greenwarm;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade322Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade322Renderer extends MobRenderer<CursedSpiritGrade322Entity, Modelcursedspirit_greenwarm<CursedSpiritGrade322Entity>> {
   public CursedSpiritGrade322Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_greenwarm(context.m_174023_(Modelcursedspirit_greenwarm.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade322Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_greenwarm.png");
   }
}
