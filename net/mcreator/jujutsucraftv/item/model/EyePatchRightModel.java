package net.mcreator.jujutsucraftv.item.model;

import net.mcreator.jujutsucraftv.item.EyePatchRightItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EyePatchRightModel extends GeoModel<EyePatchRightItem> {
   public ResourceLocation getAnimationResource(EyePatchRightItem object) {
      return new ResourceLocation("jujutsucraftv", "animations/eye_patch.animation.json");
   }

   public ResourceLocation getModelResource(EyePatchRightItem object) {
      return new ResourceLocation("jujutsucraftv", "geo/eye_patch.geo.json");
   }

   public ResourceLocation getTextureResource(EyePatchRightItem object) {
      return new ResourceLocation("jujutsucraftv", "textures/item/eye_patch.png");
   }
}
