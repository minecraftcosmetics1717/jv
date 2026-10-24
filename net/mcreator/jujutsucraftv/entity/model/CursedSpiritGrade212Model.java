package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade212Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade212Model extends GeoModel<CursedSpiritGrade212Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade212Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_deficit.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade212Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_deficit.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade212Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
