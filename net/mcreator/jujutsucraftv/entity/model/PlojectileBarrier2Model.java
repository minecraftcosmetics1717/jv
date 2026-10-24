package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileBarrier2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlojectileBarrier2Model extends GeoModel<PlojectileBarrier2Entity> {
   public ResourceLocation getAnimationResource(PlojectileBarrier2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_barrier2.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileBarrier2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_barrier2.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileBarrier2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PlojectileBarrier2Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("base");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
