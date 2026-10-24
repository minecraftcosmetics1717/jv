package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade211Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade211Model extends GeoModel<CursedSpiritGrade211Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade211Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedsprit_ripper.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade211Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedsprit_ripper.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade211Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
