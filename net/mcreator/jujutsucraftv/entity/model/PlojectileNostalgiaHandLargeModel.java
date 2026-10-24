package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileNostalgiaHandLargeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileNostalgiaHandLargeModel extends GeoModel<PlojectileNostalgiaHandLargeEntity> {
   public ResourceLocation getAnimationResource(PlojectileNostalgiaHandLargeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/nostalgia_hand_2.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileNostalgiaHandLargeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/nostalgia_hand_2.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileNostalgiaHandLargeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
