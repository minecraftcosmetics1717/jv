package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade13Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade13Model extends GeoModel<CursedSpiritGrade13Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/strangulation_cursed_spilit.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/strangulation_cursed_spilit.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
