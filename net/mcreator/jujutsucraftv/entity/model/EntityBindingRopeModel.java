package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.EntityBindingRopeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityBindingRopeModel extends GeoModel<EntityBindingRopeEntity> {
   public ResourceLocation getAnimationResource(EntityBindingRopeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_binding_rope.animation.json");
   }

   public ResourceLocation getModelResource(EntityBindingRopeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_binding_rope.geo.json");
   }

   public ResourceLocation getTextureResource(EntityBindingRopeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
