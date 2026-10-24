package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.KakuronEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KakuronModel extends GeoModel<KakuronEntity> {
   public ResourceLocation getAnimationResource(KakuronEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KakuronEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KakuronEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
