package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade222Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade222Model extends GeoModel<CursedSpiritGrade222Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade222Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_bigfish.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade222Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_bigfish.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade222Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
