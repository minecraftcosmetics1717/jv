package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.NightOfFireArtItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NightOfFireArtItemModel extends GeoModel<NightOfFireArtItem> {
   public ResourceLocation getAnimationResource(NightOfFireArtItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/night_of_fire_art.animation.json");
   }

   public ResourceLocation getModelResource(NightOfFireArtItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/night_of_fire_art.geo.json");
   }

   public ResourceLocation getTextureResource(NightOfFireArtItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/night_of_fire_art.png");
   }
}
