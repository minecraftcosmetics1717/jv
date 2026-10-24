package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade11Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade11Model extends GeoModel<CursedSpiritGrade11Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/hachishaku_sama.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/hachishaku_sama.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
