package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade27Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade27Model extends GeoModel<CursedSpiritGrade27Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade27Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_jizo.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade27Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_jizo.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade27Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
