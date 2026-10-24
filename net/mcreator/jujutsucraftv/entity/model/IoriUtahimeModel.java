package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.IoriUtahimeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IoriUtahimeModel extends GeoModel<IoriUtahimeEntity> {
   public ResourceLocation getAnimationResource(IoriUtahimeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(IoriUtahimeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(IoriUtahimeEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
