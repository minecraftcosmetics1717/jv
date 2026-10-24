package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.Drinks2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Drinks2ItemModel extends GeoModel<Drinks2Item> {
   public ResourceLocation getAnimationResource(Drinks2Item animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/plastic_bottle.animation.json");
   }

   public ResourceLocation getModelResource(Drinks2Item animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/plastic_bottle.geo.json");
   }

   public ResourceLocation getTextureResource(Drinks2Item animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/plastic_bottle_water_green_tea.png");
   }
}
