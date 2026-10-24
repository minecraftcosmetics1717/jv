package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesMaruruItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesMaruruModel extends GeoModel<ClothesMaruruItem> {
   public ResourceLocation getAnimationResource(ClothesMaruruItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_maruru.animation.json");
   }

   public ResourceLocation getModelResource(ClothesMaruruItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_maruru.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesMaruruItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/cloothes_maruru.png");
   }
}
