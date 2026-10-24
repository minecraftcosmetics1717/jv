package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.KugisakiGrandMotherEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KugisakiGrandMotherModel extends GeoModel<KugisakiGrandMotherEntity> {
   public ResourceLocation getAnimationResource(KugisakiGrandMotherEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KugisakiGrandMotherEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KugisakiGrandMotherEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
