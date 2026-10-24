package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_specimen;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade315Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade315Renderer extends MobRenderer<CursedSpiritGrade315Entity, Modelcursedspirit_specimen<CursedSpiritGrade315Entity>> {
   public CursedSpiritGrade315Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_specimen(context.m_174023_(Modelcursedspirit_specimen.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade315Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_specimen.png");
   }
}
