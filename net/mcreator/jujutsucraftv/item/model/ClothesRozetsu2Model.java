package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesRozetsu2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesRozetsu2Model extends GeoModel<ClothesRozetsu2Item> {
   public ResourceLocation getAnimationResource(ClothesRozetsu2Item object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_rozetsu.animation.json");
   }

   public ResourceLocation getModelResource(ClothesRozetsu2Item object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_rozetsu.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesRozetsu2Item object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/rouzetsu_armor.png");
   }
}
