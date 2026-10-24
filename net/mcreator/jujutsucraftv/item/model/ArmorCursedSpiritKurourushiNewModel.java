package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ArmorCursedSpiritKurourushiNewItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorCursedSpiritKurourushiNewModel extends GeoModel<ArmorCursedSpiritKurourushiNewItem> {
   public ResourceLocation getAnimationResource(ArmorCursedSpiritKurourushiNewItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/kurourushi_new_armor.animation.json");
   }

   public ResourceLocation getModelResource(ArmorCursedSpiritKurourushiNewItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/kurourushi_new_armor.geo.json");
   }

   public ResourceLocation getTextureResource(ArmorCursedSpiritKurourushiNewItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/kurourushi_new_armor.png");
   }
}
