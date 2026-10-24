package net.mcreator.jujutsucraftv.client.renderer;

import net.mcreator.jujutsucraftv.client.model.Modelcursedspirit_apple;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade312Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade312Renderer extends MobRenderer<CursedSpiritGrade312Entity, Modelcursedspirit_apple<CursedSpiritGrade312Entity>> {
   public CursedSpiritGrade312Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit_apple(context.m_174023_(Modelcursedspirit_apple.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade312Entity entity) {
      return new ResourceLocation("jujutsucraftv:textures/entities/cursedspirit_apple.png");
   }
}
