package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesRemiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesRemiModel extends GeoModel<ClothesRemiItem> {
   public ResourceLocation getAnimationResource(ClothesRemiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/head_scorpion.animation.json");
   }

   public ResourceLocation getModelResource(ClothesRemiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/head_scorpion.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesRemiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/head_scorpion.png");
   }
}
