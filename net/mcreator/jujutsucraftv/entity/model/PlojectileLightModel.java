package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileLightEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlojectileLightModel extends GeoModel<PlojectileLightEntity> {
   public ResourceLocation getAnimationResource(PlojectileLightEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_light.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileLightEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_light.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileLightEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PlojectileLightEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body2");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
