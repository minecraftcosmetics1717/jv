package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.ArmorCursedSpiritWhackAMoleItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ArmorCursedSpiritWhackAMoleModel extends GeoModel<ArmorCursedSpiritWhackAMoleItem> {
   public ResourceLocation getAnimationResource(ArmorCursedSpiritWhackAMoleItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/armor_whack_a_mole.animation.json");
   }

   public ResourceLocation getModelResource(ArmorCursedSpiritWhackAMoleItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/armor_whack_a_mole.geo.json");
   }

   public ResourceLocation getTextureResource(ArmorCursedSpiritWhackAMoleItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/whack_a_mole.png");
   }
}
