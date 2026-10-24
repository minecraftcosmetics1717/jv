package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesTengenHeianItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesTengenHeianModel extends GeoModel<ClothesTengenHeianItem> {
   public ResourceLocation getAnimationResource(ClothesTengenHeianItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_tengen_heian.animation.json");
   }

   public ResourceLocation getModelResource(ClothesTengenHeianItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_tengen_heian.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesTengenHeianItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_tengen_heian.png");
   }
}
