package net.mcreator.jujutsucraftv.block.model;

import net.mcreator.jujutsucraftv.block.display.NostalgistHandDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NostalgistHandDisplayModel extends GeoModel<NostalgistHandDisplayItem> {
   public ResourceLocation getAnimationResource(NostalgistHandDisplayItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/nostalgist_hand.animation.json");
   }

   public ResourceLocation getModelResource(NostalgistHandDisplayItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/nostalgist_hand.geo.json");
   }

   public ResourceLocation getTextureResource(NostalgistHandDisplayItem entity) {
      return new ResourceLocation("jujutsucraftv", "textures/block/cursedspirit_nostalgy.png");
   }
}
