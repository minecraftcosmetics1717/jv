package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade26Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade26Model extends GeoModel<CursedSpiritGrade26Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade26Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/pepe.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade26Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/pepe.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade26Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
