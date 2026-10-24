package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_maggot;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade313Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade313Renderer extends MobRenderer<CursedSpiritGrade313Entity, Modelcursedspirit_maggot<CursedSpiritGrade313Entity>> {
   public CursedSpiritGrade313Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_maggot(context.m_174023_(Modelcursedspirit_maggot.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade313Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_maggot.png");
   }

   protected boolean isShaking(CursedSpiritGrade313Entity entity) {
      return true;
   }
}
