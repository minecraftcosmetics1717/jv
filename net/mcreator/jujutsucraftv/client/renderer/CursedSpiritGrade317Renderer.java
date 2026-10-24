package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_argonauta_hians;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade317Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade317Renderer extends MobRenderer<CursedSpiritGrade317Entity, Modelcursedspirit_argonauta_hians<CursedSpiritGrade317Entity>> {
   public CursedSpiritGrade317Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_argonauta_hians(context.m_174023_(Modelcursedspirit_argonauta_hians.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade317Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_argonauta_hians.png");
   }
}
