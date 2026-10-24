package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.ShiraseSatsukiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShiraseSatsukiModel extends GeoModel<ShiraseSatsukiEntity> {
   public ResourceLocation getAnimationResource(ShiraseSatsukiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ShiraseSatsukiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ShiraseSatsukiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
