package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade213Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade213Model extends GeoModel<CursedSpiritGrade213Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade213Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_white.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade213Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_white.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade213Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
