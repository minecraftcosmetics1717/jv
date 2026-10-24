package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.CombinedChainOfAThousandMilesAndInvertedSpearOfHeavenItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CombinedChainOfAThousandMilesAndInvertedSpearOfHeavenItemModel extends GeoModel<CombinedChainOfAThousandMilesAndInvertedSpearOfHeavenItem> {
   public ResourceLocation getAnimationResource(CombinedChainOfAThousandMilesAndInvertedSpearOfHeavenItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/combine_chain_of_a_thousand_miles.animation.json");
   }

   public ResourceLocation getModelResource(CombinedChainOfAThousandMilesAndInvertedSpearOfHeavenItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/combine_chain_of_a_thousand_miles.geo.json");
   }

   public ResourceLocation getTextureResource(CombinedChainOfAThousandMilesAndInvertedSpearOfHeavenItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/combine_chain_of_a_thousand_miles.png");
   }
}
