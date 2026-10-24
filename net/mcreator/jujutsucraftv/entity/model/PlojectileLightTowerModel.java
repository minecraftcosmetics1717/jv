package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileLightTowerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileLightTowerModel extends GeoModel<PlojectileLightTowerEntity> {
   public ResourceLocation getAnimationResource(PlojectileLightTowerEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_light_beam1.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileLightTowerEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_light_beam1.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileLightTowerEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
