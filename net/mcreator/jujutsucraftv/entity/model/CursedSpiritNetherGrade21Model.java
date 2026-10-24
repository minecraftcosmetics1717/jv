package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritNetherGrade21Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritNetherGrade21Model extends GeoModel<CursedSpiritNetherGrade21Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritNetherGrade21Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_ore.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritNetherGrade21Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_ore.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritNetherGrade21Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
