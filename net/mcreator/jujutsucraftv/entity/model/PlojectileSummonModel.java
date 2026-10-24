package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileSummonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileSummonModel extends GeoModel<PlojectileSummonEntity> {
   public ResourceLocation getAnimationResource(PlojectileSummonEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_scaffold.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileSummonEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_scaffold.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileSummonEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
