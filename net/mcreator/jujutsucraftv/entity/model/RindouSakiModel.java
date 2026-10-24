package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.RindouSakiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RindouSakiModel extends GeoModel<RindouSakiEntity> {
   public ResourceLocation getAnimationResource(RindouSakiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(RindouSakiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(RindouSakiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
