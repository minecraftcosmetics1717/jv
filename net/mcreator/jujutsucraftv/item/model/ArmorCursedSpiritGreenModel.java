package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ArmorCursedSpiritGreenItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorCursedSpiritGreenModel extends GeoModel<ArmorCursedSpiritGreenItem> {
   public ResourceLocation getAnimationResource(ArmorCursedSpiritGreenItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/armor_pepe.animation.json");
   }

   public ResourceLocation getModelResource(ArmorCursedSpiritGreenItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/armor_pepe.geo.json");
   }

   public ResourceLocation getTextureResource(ArmorCursedSpiritGreenItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/armor_pepe.png");
   }
}
