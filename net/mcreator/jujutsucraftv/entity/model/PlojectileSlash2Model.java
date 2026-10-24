package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileSlash2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlojectileSlash2Model extends GeoModel<PlojectileSlash2Entity> {
   public ResourceLocation getAnimationResource(PlojectileSlash2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/projectile_slash2.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileSlash2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/projectile_slash2.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileSlash2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PlojectileSlash2Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
