package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileBarrier3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlojectileBarrier3Model extends GeoModel<PlojectileBarrier3Entity> {
   public ResourceLocation getAnimationResource(PlojectileBarrier3Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_barrier3.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileBarrier3Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_barrier3.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileBarrier3Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
