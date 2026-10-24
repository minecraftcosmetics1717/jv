package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.UniformYukiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UniformYukiModel extends GeoModel<UniformYukiItem> {
   public ResourceLocation getAnimationResource(UniformYukiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_yuki.animation.json");
   }

   public ResourceLocation getModelResource(UniformYukiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_yuki.geo.json");
   }

   public ResourceLocation getTextureResource(UniformYukiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_yuki.png");
   }
}
