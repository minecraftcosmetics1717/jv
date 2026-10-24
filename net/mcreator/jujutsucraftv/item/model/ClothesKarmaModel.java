package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesKarmaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesKarmaModel extends GeoModel<ClothesKarmaItem> {
   public ResourceLocation getAnimationResource(ClothesKarmaItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/karma_mant.animation.json");
   }

   public ResourceLocation getModelResource(ClothesKarmaItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/karma_mant.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesKarmaItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/karma_mant.png");
   }
}
