package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.FoundationStoneItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FoundationStoneItemModel extends GeoModel<FoundationStoneItem> {
   public ResourceLocation getAnimationResource(FoundationStoneItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/foundation_stone.animation.json");
   }

   public ResourceLocation getModelResource(FoundationStoneItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/foundation_stone.geo.json");
   }

   public ResourceLocation getTextureResource(FoundationStoneItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/foundation_stone.png");
   }
}
