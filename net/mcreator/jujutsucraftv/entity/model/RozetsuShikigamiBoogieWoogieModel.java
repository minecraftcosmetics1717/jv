package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiBoogieWoogieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuShikigamiBoogieWoogieModel extends GeoModel<RozetsuShikigamiBoogieWoogieEntity> {
   public ResourceLocation getAnimationResource(RozetsuShikigamiBoogieWoogieEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/rouzetsu_shikigami_boogiewoogie.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuShikigamiBoogieWoogieEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/rouzetsu_shikigami_boogiewoogie.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuShikigamiBoogieWoogieEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
