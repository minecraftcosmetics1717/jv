package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade32Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade32Model extends GeoModel<CursedSpiritGrade32Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade32Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/giant_ant_spilit.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade32Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/giant_ant_spilit.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade32Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
