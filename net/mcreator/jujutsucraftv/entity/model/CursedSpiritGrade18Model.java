package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade18Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade18Model extends GeoModel<CursedSpiritGrade18Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade18Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_ore.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade18Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_ore.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade18Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
