package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.DomainObjectEndressEchoes1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DomainObjectEndressEchoes1Model extends GeoModel<DomainObjectEndressEchoes1Entity> {
   public ResourceLocation getAnimationResource(DomainObjectEndressEchoes1Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/migeru_domain1.animation.json");
   }

   public ResourceLocation getModelResource(DomainObjectEndressEchoes1Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/migeru_domain1.geo.json");
   }

   public ResourceLocation getTextureResource(DomainObjectEndressEchoes1Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(DomainObjectEndressEchoes1Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
