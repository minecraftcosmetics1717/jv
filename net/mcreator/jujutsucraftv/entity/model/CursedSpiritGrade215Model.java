package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade215Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade215Model extends GeoModel<CursedSpiritGrade215Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade215Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_monkey.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade215Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_monkey.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade215Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
