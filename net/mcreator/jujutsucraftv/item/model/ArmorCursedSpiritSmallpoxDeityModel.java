package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ArmorCursedSpiritSmallpoxDeityItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorCursedSpiritSmallpoxDeityModel extends GeoModel<ArmorCursedSpiritSmallpoxDeityItem> {
   public ResourceLocation getAnimationResource(ArmorCursedSpiritSmallpoxDeityItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/smallpox_deity_armor.animation.json");
   }

   public ResourceLocation getModelResource(ArmorCursedSpiritSmallpoxDeityItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/smallpox_deity_armor.geo.json");
   }

   public ResourceLocation getTextureResource(ArmorCursedSpiritSmallpoxDeityItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/smallpox_deity_armor.png");
   }
}
