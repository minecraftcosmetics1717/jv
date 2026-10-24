package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ElectricGuitarItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ElectricGuitarItemModel extends GeoModel<ElectricGuitarItem> {
   public ResourceLocation getAnimationResource(ElectricGuitarItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/electric_guitar.animation.json");
   }

   public ResourceLocation getModelResource(ElectricGuitarItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/electric_guitar.geo.json");
   }

   public ResourceLocation getTextureResource(ElectricGuitarItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/electric_guitar.png");
   }
}
