package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade217Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade217Model extends GeoModel<CursedSpiritGrade217Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_purple.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_purple.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
