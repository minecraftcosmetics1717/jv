package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesKakuronItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesKakuronModel extends GeoModel<ClothesKakuronItem> {
   public ResourceLocation getAnimationResource(ClothesKakuronItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/kakuron_cloth.animation.json");
   }

   public ResourceLocation getModelResource(ClothesKakuronItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/kakuron_cloth.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesKakuronItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/kakuron_cloth.png");
   }
}
