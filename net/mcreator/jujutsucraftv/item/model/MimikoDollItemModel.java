package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.MimikoDollItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MimikoDollItemModel extends GeoModel<MimikoDollItem> {
   public ResourceLocation getAnimationResource(MimikoDollItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/mimiko_doll.animation.json");
   }

   public ResourceLocation getModelResource(MimikoDollItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/mimiko_doll.geo.json");
   }

   public ResourceLocation getTextureResource(MimikoDollItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/mimiko_doll.png");
   }
}
