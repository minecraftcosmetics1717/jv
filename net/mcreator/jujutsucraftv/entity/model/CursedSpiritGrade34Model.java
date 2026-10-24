package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade34Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade34Model extends GeoModel<CursedSpiritGrade34Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade34Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_cloud.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade34Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_cloud.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade34Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
