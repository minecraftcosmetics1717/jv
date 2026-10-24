package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesMahitoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesMahitoModel extends GeoModel<ClothesMahitoItem> {
   public ResourceLocation getAnimationResource(ClothesMahitoItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_mahito.animation.json");
   }

   public ResourceLocation getModelResource(ClothesMahitoItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_mahito.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesMahitoItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_mahito.png");
   }
}
