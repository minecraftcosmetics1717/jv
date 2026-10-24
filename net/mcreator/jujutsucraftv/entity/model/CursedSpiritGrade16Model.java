package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade16Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade16Model extends GeoModel<CursedSpiritGrade16Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_humanoidshadow.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_humanoidshadow.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade16Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
