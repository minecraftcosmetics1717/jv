package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade220Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade220Model extends GeoModel<CursedSpiritGrade220Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade220Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_birch.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade220Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_birch.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade220Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
