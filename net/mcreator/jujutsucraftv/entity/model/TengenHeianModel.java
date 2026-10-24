package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.TengenHeianEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TengenHeianModel extends GeoModel<TengenHeianEntity> {
   public ResourceLocation getAnimationResource(TengenHeianEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(TengenHeianEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(TengenHeianEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
