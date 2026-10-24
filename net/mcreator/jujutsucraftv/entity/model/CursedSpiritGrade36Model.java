package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade36Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade36Model extends GeoModel<CursedSpiritGrade36Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade36Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_sorry.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade36Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_sorry.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade36Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
