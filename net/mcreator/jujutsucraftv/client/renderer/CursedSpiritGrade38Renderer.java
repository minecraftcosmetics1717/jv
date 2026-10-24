package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcurusedspirit_mouth;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade38Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade38Renderer extends MobRenderer<CursedSpiritGrade38Entity, Modelcurusedspirit_mouth<CursedSpiritGrade38Entity>> {
   public CursedSpiritGrade38Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcurusedspirit_mouth(context.m_174023_(Modelcurusedspirit_mouth.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade38Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/curusedspirit_mouth.png");
   }
}
