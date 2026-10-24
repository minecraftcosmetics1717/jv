package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.NoisSeverScissorsItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NoisSeverScissorsItemModel extends GeoModel<NoisSeverScissorsItem> {
   public ResourceLocation getAnimationResource(NoisSeverScissorsItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/nihiladmirari.animation.json");
   }

   public ResourceLocation getModelResource(NoisSeverScissorsItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/nihiladmirari.geo.json");
   }

   public ResourceLocation getTextureResource(NoisSeverScissorsItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/nihiladmiari.png");
   }
}
