package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade214Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade214Model extends GeoModel<CursedSpiritGrade214Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade214Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_giantsquid.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade214Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_giantsquid.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade214Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
