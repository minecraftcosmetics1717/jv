package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.Drinks4Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Drinks4ItemModel extends GeoModel<Drinks4Item> {
   public ResourceLocation getAnimationResource(Drinks4Item animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/plastic_bottle.animation.json");
   }

   public ResourceLocation getModelResource(Drinks4Item animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/plastic_bottle.geo.json");
   }

   public ResourceLocation getTextureResource(Drinks4Item animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/plastic_bottle_water_special_grade_tea.png");
   }
}
