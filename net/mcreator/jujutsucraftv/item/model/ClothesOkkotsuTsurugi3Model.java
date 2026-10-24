package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesOkkotsuTsurugi3Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesOkkotsuTsurugi3Model extends GeoModel<ClothesOkkotsuTsurugi3Item> {
   public ResourceLocation getAnimationResource(ClothesOkkotsuTsurugi3Item object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_okkotsu_tsurugi.animation.json");
   }

   public ResourceLocation getModelResource(ClothesOkkotsuTsurugi3Item object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_okkotsu_tsurugi.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesOkkotsuTsurugi3Item object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_okkotsu_tsurugi.png");
   }
}
