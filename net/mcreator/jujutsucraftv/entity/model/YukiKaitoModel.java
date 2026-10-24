package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.YukiKaitoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YukiKaitoModel extends GeoModel<YukiKaitoEntity> {
   public ResourceLocation getAnimationResource(YukiKaitoEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(YukiKaitoEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(YukiKaitoEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }
}
