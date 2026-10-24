package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade110Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade110Model extends GeoModel<CursedSpiritGrade110Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade110Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_vagrant_samurai.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade110Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_vagrant_samurai.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade110Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
