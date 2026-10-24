package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.VibraslapItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VibraslapItemModel extends GeoModel<VibraslapItem> {
   public ResourceLocation getAnimationResource(VibraslapItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/vibraslap.animation.json");
   }

   public ResourceLocation getModelResource(VibraslapItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/vibraslap.geo.json");
   }

   public ResourceLocation getTextureResource(VibraslapItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/vibraslap.png");
   }
}
