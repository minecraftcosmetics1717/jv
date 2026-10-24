package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade31Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade31Model extends GeoModel<CursedSpiritGrade31Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade31Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cicada_cursed_spilit.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade31Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cicada_cursed_spilit.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade31Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
