package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade23Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade23Model extends GeoModel<CursedSpiritGrade23Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_salamander.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_salamander.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
