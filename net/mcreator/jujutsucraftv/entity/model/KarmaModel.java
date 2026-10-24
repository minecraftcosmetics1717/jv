package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.KarmaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KarmaModel extends GeoModel<KarmaEntity> {
   public ResourceLocation getAnimationResource(KarmaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KarmaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KarmaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
