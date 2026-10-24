package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.BlackKnifeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlackKnifeItemModel extends GeoModel<BlackKnifeItem> {
   public ResourceLocation getAnimationResource(BlackKnifeItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/black_knife.animation.json");
   }

   public ResourceLocation getModelResource(BlackKnifeItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/black_knife.geo.json");
   }

   public ResourceLocation getTextureResource(BlackKnifeItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/black_knife.png");
   }
}
