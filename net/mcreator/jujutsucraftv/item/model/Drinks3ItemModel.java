package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.Drinks3Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Drinks3ItemModel extends GeoModel<Drinks3Item> {
   public ResourceLocation getAnimationResource(Drinks3Item animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/plastic_bottle.animation.json");
   }

   public ResourceLocation getModelResource(Drinks3Item animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/plastic_bottle.geo.json");
   }

   public ResourceLocation getTextureResource(Drinks3Item animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/plastic_bottle_water_cola.png");
   }
}
