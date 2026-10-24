package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.EbinaNijiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EbinaNijiModel extends GeoModel<EbinaNijiEntity> {
   public ResourceLocation getAnimationResource(EbinaNijiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(EbinaNijiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(EbinaNijiEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
