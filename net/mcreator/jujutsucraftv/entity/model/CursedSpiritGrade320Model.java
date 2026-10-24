package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade320Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade320Model extends GeoModel<CursedSpiritGrade320Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade320Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_ball.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade320Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_ball.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade320Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
