package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ArmorCursedSpiritWhiteItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorCursedSpiritWhiteModel extends GeoModel<ArmorCursedSpiritWhiteItem> {
   public ResourceLocation getAnimationResource(ArmorCursedSpiritWhiteItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/armor_cursedspirit_white.animation.json");
   }

   public ResourceLocation getModelResource(ArmorCursedSpiritWhiteItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/armor_cursedspirit_white.geo.json");
   }

   public ResourceLocation getTextureResource(ArmorCursedSpiritWhiteItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/cursedspirit_white.png");
   }
}
