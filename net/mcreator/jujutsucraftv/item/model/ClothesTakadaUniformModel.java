package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesTakadaUniformItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesTakadaUniformModel extends GeoModel<ClothesTakadaUniformItem> {
   public ResourceLocation getAnimationResource(ClothesTakadaUniformItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_takada_uniform.animation.json");
   }

   public ResourceLocation getModelResource(ClothesTakadaUniformItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_takada_uniform.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesTakadaUniformItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_taakda_uniform.png");
   }
}
