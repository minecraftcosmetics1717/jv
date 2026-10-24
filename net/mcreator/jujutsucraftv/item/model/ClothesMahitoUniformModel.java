package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesMahitoUniformItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesMahitoUniformModel extends GeoModel<ClothesMahitoUniformItem> {
   public ResourceLocation getAnimationResource(ClothesMahitoUniformItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_mahito_uniform.animation.json");
   }

   public ResourceLocation getModelResource(ClothesMahitoUniformItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_mahito_uniform.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesMahitoUniformItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_mahito_uniform.png");
   }
}
