package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritNetherGrade22Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritNetherGrade22Model extends GeoModel<CursedSpiritNetherGrade22Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritNetherGrade22Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_birch.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritNetherGrade22Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_birch.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritNetherGrade22Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
