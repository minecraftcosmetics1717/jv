package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade12Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade12Model extends GeoModel<CursedSpiritGrade12Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade12Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/red_cursed_spilit.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade12Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/red_cursed_spilit.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade12Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
