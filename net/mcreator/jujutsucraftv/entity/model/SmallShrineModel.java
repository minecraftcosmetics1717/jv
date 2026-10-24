package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.SmallShrineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SmallShrineModel extends GeoModel<SmallShrineEntity> {
   public ResourceLocation getAnimationResource(SmallShrineEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/small_shrine.animation.json");
   }

   public ResourceLocation getModelResource(SmallShrineEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/small_shrine.geo.json");
   }

   public ResourceLocation getTextureResource(SmallShrineEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
