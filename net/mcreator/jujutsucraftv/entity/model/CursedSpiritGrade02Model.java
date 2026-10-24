package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade02Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade02Model extends GeoModel<CursedSpiritGrade02Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_beehive.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_beehive.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
