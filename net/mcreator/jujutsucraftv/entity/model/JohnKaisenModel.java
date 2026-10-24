package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.JohnKaisenEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JohnKaisenModel extends GeoModel<JohnKaisenEntity> {
   public ResourceLocation getAnimationResource(JohnKaisenEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(JohnKaisenEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(JohnKaisenEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
