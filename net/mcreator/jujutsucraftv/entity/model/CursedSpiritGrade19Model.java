package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade19Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade19Model extends GeoModel<CursedSpiritGrade19Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_butterfly.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_butterfly.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
