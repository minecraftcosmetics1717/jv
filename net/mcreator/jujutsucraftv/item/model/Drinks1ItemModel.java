package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.Drinks1Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Drinks1ItemModel extends GeoModel<Drinks1Item> {
   public ResourceLocation getAnimationResource(Drinks1Item animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/plastic_bottle.animation.json");
   }

   public ResourceLocation getModelResource(Drinks1Item animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/plastic_bottle.geo.json");
   }

   public ResourceLocation getTextureResource(Drinks1Item animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/plastic_bottle_water.png");
   }
}
