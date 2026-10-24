package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesMaruru2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesMaruru2Model extends GeoModel<ClothesMaruru2Item> {
   public ResourceLocation getAnimationResource(ClothesMaruru2Item object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_maruru.animation.json");
   }

   public ResourceLocation getModelResource(ClothesMaruru2Item object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_maruru.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesMaruru2Item object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/cloothes_maruru.png");
   }
}
