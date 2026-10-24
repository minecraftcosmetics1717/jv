package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.UniformKugisaki2Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UniformKugisaki2Model extends GeoModel<UniformKugisaki2Item> {
   public ResourceLocation getAnimationResource(UniformKugisaki2Item object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_kugisaki_uniform.animation.json");
   }

   public ResourceLocation getModelResource(UniformKugisaki2Item object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_kugisaki_uniform.geo.json");
   }

   public ResourceLocation getTextureResource(UniformKugisaki2Item object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_kugisaki_uniform.png");
   }
}
