package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiShrineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuShikigamiShrineModel extends GeoModel<RozetsuShikigamiShrineEntity> {
   public ResourceLocation getAnimationResource(RozetsuShikigamiShrineEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/rozetsu_shikigami_shrine.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuShikigamiShrineEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/rozetsu_shikigami_shrine.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuShikigamiShrineEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
