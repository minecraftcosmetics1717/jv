package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.OkkotsuTsurugiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OkkotsuTsurugiModel extends GeoModel<OkkotsuTsurugiEntity> {
   public ResourceLocation getAnimationResource(OkkotsuTsurugiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(OkkotsuTsurugiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(OkkotsuTsurugiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
