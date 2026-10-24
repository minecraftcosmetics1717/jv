package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcuresdspirit_3_20;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade35Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade35Renderer extends MobRenderer<CursedSpiritGrade35Entity, Modelcuresdspirit_3_20<CursedSpiritGrade35Entity>> {
   public CursedSpiritGrade35Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcuresdspirit_3_20(context.m_174023_(Modelcuresdspirit_3_20.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade35Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/curesdspirit_3_20.png");
   }
}
