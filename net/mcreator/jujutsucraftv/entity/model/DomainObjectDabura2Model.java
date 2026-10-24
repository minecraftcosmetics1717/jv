package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.DomainObjectDabura2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DomainObjectDabura2Model extends GeoModel<DomainObjectDabura2Entity> {
   public ResourceLocation getAnimationResource(DomainObjectDabura2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/dabura_domain2.animation.json");
   }

   public ResourceLocation getModelResource(DomainObjectDabura2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/dabura_domain2.geo.json");
   }

   public ResourceLocation getTextureResource(DomainObjectDabura2Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(DomainObjectDabura2Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
