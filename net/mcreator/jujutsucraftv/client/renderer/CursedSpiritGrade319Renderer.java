package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_suture;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade319Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade319Renderer extends MobRenderer<CursedSpiritGrade319Entity, Modelcursedspirit_suture<CursedSpiritGrade319Entity>> {
   public CursedSpiritGrade319Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_suture(context.m_174023_(Modelcursedspirit_suture.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade319Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_suture.png");
   }
}
