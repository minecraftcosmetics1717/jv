package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.SharpenedPlayfulCloudItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SharpenedPlayfulCloudItemModel extends GeoModel<SharpenedPlayfulCloudItem> {
   public ResourceLocation getAnimationResource(SharpenedPlayfulCloudItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/sharpened_playful_cloud.animation.json");
   }

   public ResourceLocation getModelResource(SharpenedPlayfulCloudItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/sharpened_playful_cloud.geo.json");
   }

   public ResourceLocation getTextureResource(SharpenedPlayfulCloudItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/playful_cloud2.png");
   }
}
