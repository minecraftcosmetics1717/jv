package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.EyePatchLeftItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EyePatchLeftModel extends GeoModel<EyePatchLeftItem> {
   public ResourceLocation getAnimationResource(EyePatchLeftItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/eye_patch.animation.json");
   }

   public ResourceLocation getModelResource(EyePatchLeftItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/eye_patch.geo.json");
   }

   public ResourceLocation getTextureResource(EyePatchLeftItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/eye_patch.png");
   }
}
