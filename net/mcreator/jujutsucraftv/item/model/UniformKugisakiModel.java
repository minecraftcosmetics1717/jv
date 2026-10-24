package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.UniformKugisakiItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UniformKugisakiModel extends GeoModel<UniformKugisakiItem> {
   public ResourceLocation getAnimationResource(UniformKugisakiItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_kugisaki_uniform.animation.json");
   }

   public ResourceLocation getModelResource(UniformKugisakiItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_kugisaki_uniform.geo.json");
   }

   public ResourceLocation getTextureResource(UniformKugisakiItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_kugisaki_uniform.png");
   }
}
