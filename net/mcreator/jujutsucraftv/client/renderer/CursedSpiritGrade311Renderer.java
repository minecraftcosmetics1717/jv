package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_renkon;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade311Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade311Renderer extends MobRenderer<CursedSpiritGrade311Entity, Modelcursedspirit_renkon<CursedSpiritGrade311Entity>> {
   public CursedSpiritGrade311Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_renkon(context.m_174023_(Modelcursedspirit_renkon.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade311Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_renkon.png");
   }
}
