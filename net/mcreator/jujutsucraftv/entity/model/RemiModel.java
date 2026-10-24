package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.RemiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RemiModel extends GeoModel<RemiEntity> {
   public ResourceLocation getAnimationResource(RemiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(RemiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(RemiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
