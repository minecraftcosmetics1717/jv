package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileCrystalEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileCrystalModel extends GeoModel<PlojectileCrystalEntity> {
   public ResourceLocation getAnimationResource(PlojectileCrystalEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_crystal_ore.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileCrystalEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_crystal_ore.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileCrystalEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
