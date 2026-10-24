package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileDarknessEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileDarknessModel extends GeoModel<PlojectileDarknessEntity> {
   public ResourceLocation getAnimationResource(PlojectileDarknessEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_darkness.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileDarknessEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_darkness.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileDarknessEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
