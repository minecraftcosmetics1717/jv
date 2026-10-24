package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.EntityWeaponEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityWeaponModel extends GeoModel<EntityWeaponEntity> {
   public ResourceLocation getAnimationResource(EntityWeaponEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/weapon_entity.animation.json");
   }

   public ResourceLocation getModelResource(EntityWeaponEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/weapon_entity.geo.json");
   }

   public ResourceLocation getTextureResource(EntityWeaponEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityWeaponEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("Body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
