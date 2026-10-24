package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesDaburaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesDaburaModel extends GeoModel<ClothesDaburaItem> {
   public ResourceLocation getAnimationResource(ClothesDaburaItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_dabura.animation.json");
   }

   public ResourceLocation getModelResource(ClothesDaburaItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_dabura.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesDaburaItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_dabura.png");
   }
}
