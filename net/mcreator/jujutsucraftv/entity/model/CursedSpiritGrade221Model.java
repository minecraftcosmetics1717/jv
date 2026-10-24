package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade221Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade221Model extends GeoModel<CursedSpiritGrade221Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade221Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_mermaid.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade221Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_mermaid.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade221Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
