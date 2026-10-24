package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesKugisakiGrandMotherItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesKugisakiGrandMotherModel extends GeoModel<ClothesKugisakiGrandMotherItem> {
   public ResourceLocation getAnimationResource(ClothesKugisakiGrandMotherItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_grey_coat.animation.json");
   }

   public ResourceLocation getModelResource(ClothesKugisakiGrandMotherItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_grey_coat.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesKugisakiGrandMotherItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_grey_coat.png");
   }
}
