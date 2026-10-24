package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.PlojectileBarrier0Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PlojectileBarrier0Model extends GeoModel<PlojectileBarrier0Entity> {
   public ResourceLocation getAnimationResource(PlojectileBarrier0Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/plojectile_barrier0.animation.json");
   }

   public ResourceLocation getModelResource(PlojectileBarrier0Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/plojectile_barrier0.geo.json");
   }

   public ResourceLocation getTextureResource(PlojectileBarrier0Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(PlojectileBarrier0Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("0");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
