package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.DomainObjectRockyAreaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DomainObjectRockyAreaModel extends GeoModel<DomainObjectRockyAreaEntity> {
   public ResourceLocation getAnimationResource(DomainObjectRockyAreaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/whack_a_mole_domain2.animation.json");
   }

   public ResourceLocation getModelResource(DomainObjectRockyAreaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/whack_a_mole_domain2.geo.json");
   }

   public ResourceLocation getTextureResource(DomainObjectRockyAreaEntity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(DomainObjectRockyAreaEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
