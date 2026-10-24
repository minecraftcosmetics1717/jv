package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesRoninKasaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesRoninKasaModel extends GeoModel<ClothesRoninKasaItem> {
   public ResourceLocation getAnimationResource(ClothesRoninKasaItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_samurai_kasa.animation.json");
   }

   public ResourceLocation getModelResource(ClothesRoninKasaItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_samurai_kasa.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesRoninKasaItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_kasa.png");
   }
}
