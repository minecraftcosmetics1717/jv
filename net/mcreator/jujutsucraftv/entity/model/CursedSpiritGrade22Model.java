package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade22Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade22Model extends GeoModel<CursedSpiritGrade22Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade22Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_special_grade_samurai.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade22Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_special_grade_samurai.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade22Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
