package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesOsukiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesOsukiModel extends GeoModel<ClothesOsukiItem> {
   public ResourceLocation getAnimationResource(ClothesOsukiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_osuki.animation.json");
   }

   public ResourceLocation getModelResource(ClothesOsukiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_osuki.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesOsukiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_osuki.png");
   }
}
