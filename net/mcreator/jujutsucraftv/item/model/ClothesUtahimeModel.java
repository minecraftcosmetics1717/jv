package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesUtahimeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesUtahimeModel extends GeoModel<ClothesUtahimeItem> {
   public ResourceLocation getAnimationResource(ClothesUtahimeItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_utahime.animation.json");
   }

   public ResourceLocation getModelResource(ClothesUtahimeItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_utahime.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesUtahimeItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_utahime.png");
   }
}
