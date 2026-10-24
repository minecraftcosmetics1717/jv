package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.MaruruEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MaruruModel extends GeoModel<MaruruEntity> {
   public ResourceLocation getAnimationResource(MaruruEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MaruruEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MaruruEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
