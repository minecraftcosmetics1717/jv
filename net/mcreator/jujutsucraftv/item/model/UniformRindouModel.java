package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.UniformRindouItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UniformRindouModel extends GeoModel<UniformRindouItem> {
   public ResourceLocation getAnimationResource(UniformRindouItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_rindou.animation.json");
   }

   public ResourceLocation getModelResource(UniformRindouItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_rindou.geo.json");
   }

   public ResourceLocation getTextureResource(UniformRindouItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_rindou.png");
   }
}
