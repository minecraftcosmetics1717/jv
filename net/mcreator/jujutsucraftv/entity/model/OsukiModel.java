package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.OsukiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OsukiModel extends GeoModel<OsukiEntity> {
   public ResourceLocation getAnimationResource(OsukiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(OsukiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(OsukiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
