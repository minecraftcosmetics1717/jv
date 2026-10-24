package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.BlindnessDomainObjectEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlindnessDomainObjectModel extends GeoModel<BlindnessDomainObjectEntity> {
   public ResourceLocation getAnimationResource(BlindnessDomainObjectEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/blindness_domain.animation.json");
   }

   public ResourceLocation getModelResource(BlindnessDomainObjectEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/blindness_domain.geo.json");
   }

   public ResourceLocation getTextureResource(BlindnessDomainObjectEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
