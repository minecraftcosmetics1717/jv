package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesOkkotsuTsurugi2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesOkkotsuTsurugi2Model extends GeoModel<ClothesOkkotsuTsurugi2Item> {
   public ResourceLocation getAnimationResource(ClothesOkkotsuTsurugi2Item object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_okkotsu_tsurugi.animation.json");
   }

   public ResourceLocation getModelResource(ClothesOkkotsuTsurugi2Item object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_okkotsu_tsurugi.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesOkkotsuTsurugi2Item object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_okkotsu_tsurugi.png");
   }
}
