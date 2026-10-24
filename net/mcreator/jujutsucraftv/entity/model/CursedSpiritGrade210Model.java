package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade210Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade210Model extends GeoModel<CursedSpiritGrade210Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade210Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_bulldog.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade210Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_bulldog.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade210Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
