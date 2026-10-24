package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileBarrier4Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileBarrier4Model extends GeoModel<PlojectileBarrier4Entity> {
   public ResourceLocation getAnimationResource(PlojectileBarrier4Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_barrier4.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileBarrier4Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_barrier4.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileBarrier4Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
