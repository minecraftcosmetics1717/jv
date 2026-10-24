package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesMahito2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesMahito2Model extends GeoModel<ClothesMahito2Item> {
   public ResourceLocation getAnimationResource(ClothesMahito2Item object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_mahito.animation.json");
   }

   public ResourceLocation getModelResource(ClothesMahito2Item object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_mahito.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesMahito2Item object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_mahito.png");
   }
}
