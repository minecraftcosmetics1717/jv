package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_eel;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade318Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade318Renderer extends MobRenderer<CursedSpiritGrade318Entity, Modelcursedspirit_eel<CursedSpiritGrade318Entity>> {
   public CursedSpiritGrade318Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_eel(context.m_174023_(Modelcursedspirit_eel.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade318Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_eel.png");
   }
}
