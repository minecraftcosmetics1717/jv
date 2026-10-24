package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.UiuiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UiuiModel extends GeoModel<UiuiEntity> {
   public ResourceLocation getAnimationResource(UiuiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(UiuiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(UiuiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
