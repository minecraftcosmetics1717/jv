package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.NunobeNishikiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NunobeNishikiModel extends GeoModel<NunobeNishikiEntity> {
   public ResourceLocation getAnimationResource(NunobeNishikiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(NunobeNishikiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(NunobeNishikiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
