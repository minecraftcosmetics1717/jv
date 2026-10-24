package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.EntityHangingRopeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityHangingRopeModel extends GeoModel<EntityHangingRopeEntity> {
   public ResourceLocation getAnimationResource(EntityHangingRopeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/hanging_rope.animation.json");
   }

   public ResourceLocation getModelResource(EntityHangingRopeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/hanging_rope.geo.json");
   }

   public ResourceLocation getTextureResource(EntityHangingRopeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
