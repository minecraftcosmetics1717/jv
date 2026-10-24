package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ArmorCursedSpiritYellowItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorCursedSpiritYellowModel extends GeoModel<ArmorCursedSpiritYellowItem> {
   public ResourceLocation getAnimationResource(ArmorCursedSpiritYellowItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/armor_nanj.animation.json");
   }

   public ResourceLocation getModelResource(ArmorCursedSpiritYellowItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/armor_nanj.geo.json");
   }

   public ResourceLocation getTextureResource(ArmorCursedSpiritYellowItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/armor_nanj.png");
   }
}
