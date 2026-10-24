package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesCrossItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesCrossModel extends GeoModel<ClothesCrossItem> {
   public ResourceLocation getAnimationResource(ClothesCrossItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_maruru.animation.json");
   }

   public ResourceLocation getModelResource(ClothesCrossItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_maruru.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesCrossItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/cloothes_maruru.png");
   }
}
