package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesGakuganjiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesGakuganjiModel extends GeoModel<ClothesGakuganjiItem> {
   public ResourceLocation getAnimationResource(ClothesGakuganjiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_utahime.animation.json");
   }

   public ResourceLocation getModelResource(ClothesGakuganjiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_utahime.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesGakuganjiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_gakuganji.png");
   }
}
