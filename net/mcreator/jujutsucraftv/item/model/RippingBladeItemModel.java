package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.RippingBladeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RippingBladeItemModel extends GeoModel<RippingBladeItem> {
   public ResourceLocation getAnimationResource(RippingBladeItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/ripping_blade.animation.json");
   }

   public ResourceLocation getModelResource(RippingBladeItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/ripping_blade.geo.json");
   }

   public ResourceLocation getTextureResource(RippingBladeItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/ripping_blade.png");
   }
}
