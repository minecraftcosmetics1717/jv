package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.KatsuragiGouseiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KatsuragiGouseiModel extends GeoModel<KatsuragiGouseiEntity> {
   public ResourceLocation getAnimationResource(KatsuragiGouseiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human_huge.animation.json");
   }

   public ResourceLocation getModelResource(KatsuragiGouseiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human_huge.geo.json");
   }

   public ResourceLocation getTextureResource(KatsuragiGouseiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
