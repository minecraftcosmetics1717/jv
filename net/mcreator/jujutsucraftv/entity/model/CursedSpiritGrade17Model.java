package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade17Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade17Model extends GeoModel<CursedSpiritGrade17Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_scissors.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_scissors.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
