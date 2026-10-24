package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade01Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade01Model extends GeoModel<CursedSpiritGrade01Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade01Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_nostalgist.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade01Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_nostalgist.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade01Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
