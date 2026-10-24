package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.JinJiroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JinJiroModel extends GeoModel<JinJiroEntity> {
   public ResourceLocation getAnimationResource(JinJiroEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human_huge.animation.json");
   }

   public ResourceLocation getModelResource(JinJiroEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human_huge.geo.json");
   }

   public ResourceLocation getTextureResource(JinJiroEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
