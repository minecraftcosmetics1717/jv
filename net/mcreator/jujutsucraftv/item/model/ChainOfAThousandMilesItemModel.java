package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ChainOfAThousandMilesItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChainOfAThousandMilesItemModel extends GeoModel<ChainOfAThousandMilesItem> {
   public ResourceLocation getAnimationResource(ChainOfAThousandMilesItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/chain_of_a_thousand_miles.animation.json");
   }

   public ResourceLocation getModelResource(ChainOfAThousandMilesItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/chain_of_a_thousand_miles.geo.json");
   }

   public ResourceLocation getTextureResource(ChainOfAThousandMilesItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/chain_of_a_thousand_miles.png");
   }
}
