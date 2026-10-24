package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.HsMahitoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HsMahitoModel extends GeoModel<HsMahitoEntity> {
   public ResourceLocation getAnimationResource(HsMahitoEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(HsMahitoEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(HsMahitoEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
