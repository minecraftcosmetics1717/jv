package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade24Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade24Model extends GeoModel<CursedSpiritGrade24Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade24Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_crayfish.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade24Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_crayfish.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade24Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
