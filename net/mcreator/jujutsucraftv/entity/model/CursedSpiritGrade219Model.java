package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade219Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade219Model extends GeoModel<CursedSpiritGrade219Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade219Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_wild_dog.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade219Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_wild_dog.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade219Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
