package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesOkkotsuTsurugiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesOkkotsuTsurugiModel extends GeoModel<ClothesOkkotsuTsurugiItem> {
   public ResourceLocation getAnimationResource(ClothesOkkotsuTsurugiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_okkotsu_tsurugi.animation.json");
   }

   public ResourceLocation getModelResource(ClothesOkkotsuTsurugiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_okkotsu_tsurugi.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesOkkotsuTsurugiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_okkotsu_tsurugi.png");
   }
}
