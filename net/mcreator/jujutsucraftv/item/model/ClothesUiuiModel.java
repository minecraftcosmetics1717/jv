package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesUiuiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesUiuiModel extends GeoModel<ClothesUiuiItem> {
   public ResourceLocation getAnimationResource(ClothesUiuiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_uiui.animation.json");
   }

   public ResourceLocation getModelResource(ClothesUiuiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_uiui.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesUiuiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_uiui.png");
   }
}
