package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileBarrier1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileBarrier1Model extends GeoModel<PlojectileBarrier1Entity> {
   public ResourceLocation getAnimationResource(PlojectileBarrier1Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_barrier1.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileBarrier1Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_barrier1.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileBarrier1Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
