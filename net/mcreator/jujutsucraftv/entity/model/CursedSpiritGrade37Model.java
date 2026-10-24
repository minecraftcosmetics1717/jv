package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade37Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade37Model extends GeoModel<CursedSpiritGrade37Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade37Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/armor_stand_curse.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade37Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/armor_stand_curse.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade37Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
