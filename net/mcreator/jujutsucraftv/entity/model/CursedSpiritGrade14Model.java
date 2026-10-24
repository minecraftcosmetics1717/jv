package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade14Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade14Model extends GeoModel<CursedSpiritGrade14Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade14Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_wing.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade14Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_wing.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade14Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
