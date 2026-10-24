package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileExplosionEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileExplosionModel extends GeoModel<PlojectileExplosionEntity> {
   public ResourceLocation getAnimationResource(PlojectileExplosionEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_explosion.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileExplosionEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_explosion.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileExplosionEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
