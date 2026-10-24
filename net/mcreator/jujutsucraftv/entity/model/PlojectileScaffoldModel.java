package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileScaffoldEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileScaffoldModel extends GeoModel<PlojectileScaffoldEntity> {
   public ResourceLocation getAnimationResource(PlojectileScaffoldEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_scaffold.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileScaffoldEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_scaffold.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileScaffoldEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
