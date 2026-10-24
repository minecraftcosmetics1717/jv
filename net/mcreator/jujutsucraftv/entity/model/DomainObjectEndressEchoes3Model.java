package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.DomainObjectEndressEchoes3Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DomainObjectEndressEchoes3Model extends GeoModel<DomainObjectEndressEchoes3Entity> {
   public ResourceLocation getAnimationResource(DomainObjectEndressEchoes3Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/migeru_domain3.animation.json");
   }

   public ResourceLocation getModelResource(DomainObjectEndressEchoes3Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/migeru_domain3.geo.json");
   }

   public ResourceLocation getTextureResource(DomainObjectEndressEchoes3Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
