package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade29Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade29Model extends GeoModel<CursedSpiritGrade29Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade29Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_ore.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade29Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_ore.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade29Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
