package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.DomainObjectDaburaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DomainObjectDaburaModel extends GeoModel<DomainObjectDaburaEntity> {
   public ResourceLocation getAnimationResource(DomainObjectDaburaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/dabura_domain.animation.json");
   }

   public ResourceLocation getModelResource(DomainObjectDaburaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/dabura_domain.geo.json");
   }

   public ResourceLocation getTextureResource(DomainObjectDaburaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
