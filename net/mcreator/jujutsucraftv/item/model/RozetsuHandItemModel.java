package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.RozetsuHandItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuHandItemModel extends GeoModel<RozetsuHandItem> {
   public ResourceLocation getAnimationResource(RozetsuHandItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/rozetsu_hand.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuHandItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/rozetsu_hand.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuHandItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/rouzetsu_armor.png");
   }
}
