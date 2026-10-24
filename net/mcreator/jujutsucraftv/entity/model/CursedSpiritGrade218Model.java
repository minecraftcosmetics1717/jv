package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade218Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade218Model extends GeoModel<CursedSpiritGrade218Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade218Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_lanthan.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade218Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_lanthan.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade218Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
