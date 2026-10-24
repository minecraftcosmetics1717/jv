package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesRozetsuItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesRozetsuModel extends GeoModel<ClothesRozetsuItem> {
   public ResourceLocation getAnimationResource(ClothesRozetsuItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_rozetsu.animation.json");
   }

   public ResourceLocation getModelResource(ClothesRozetsuItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_rozetsu.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesRozetsuItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/rouzetsu_armor.png");
   }
}
