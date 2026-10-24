package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade21Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade21Model extends GeoModel<CursedSpiritGrade21Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade21Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_confused.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade21Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_confused.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade21Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
