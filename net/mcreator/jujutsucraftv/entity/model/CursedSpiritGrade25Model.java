package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade25Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade25Model extends GeoModel<CursedSpiritGrade25Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade25Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_sparrow.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade25Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_sparrow.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade25Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
