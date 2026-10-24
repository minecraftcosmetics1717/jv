package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.CursePowerSaberItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursePowerSaberItemModel extends GeoModel<CursePowerSaberItem> {
   public ResourceLocation getAnimationResource(CursePowerSaberItem animatable) {
      return new ResourceLocation("jujutsucraftv", "animations/curse_power_saber.animation.json");
   }

   public ResourceLocation getModelResource(CursePowerSaberItem animatable) {
      return new ResourceLocation("jujutsucraftv", "geo/curse_power_saber.geo.json");
   }

   public ResourceLocation getTextureResource(CursePowerSaberItem animatable) {
      return new ResourceLocation("jujutsucraftv", "textures/item/curse_power_saber1.png");
   }
}
