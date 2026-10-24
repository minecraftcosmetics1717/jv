package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ClothesRozetsuShikigamiVesselItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesRozetsuShikigamiVesselModel extends GeoModel<ClothesRozetsuShikigamiVesselItem> {
   public ResourceLocation getAnimationResource(ClothesRozetsuShikigamiVesselItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/clothes_rouzetsu_shikigami.animation.json");
   }

   public ResourceLocation getModelResource(ClothesRozetsuShikigamiVesselItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/clothes_rouzetsu_shikigami.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesRozetsuShikigamiVesselItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/clothes_rozetsu_shikigami_vessel.png");
   }
}
