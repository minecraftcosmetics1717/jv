package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileSlashEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileSlashModel extends GeoModel<PlojectileSlashEntity> {
   public ResourceLocation getAnimationResource(PlojectileSlashEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/projectile_slash.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileSlashEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/projectile_slash.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileSlashEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
