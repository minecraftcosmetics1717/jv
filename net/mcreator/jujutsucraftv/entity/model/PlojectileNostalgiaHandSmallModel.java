package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileNostalgiaHandSmallEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileNostalgiaHandSmallModel extends GeoModel<PlojectileNostalgiaHandSmallEntity> {
   public ResourceLocation getAnimationResource(PlojectileNostalgiaHandSmallEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/nosttalgia_hand.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileNostalgiaHandSmallEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/nosttalgia_hand.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileNostalgiaHandSmallEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
