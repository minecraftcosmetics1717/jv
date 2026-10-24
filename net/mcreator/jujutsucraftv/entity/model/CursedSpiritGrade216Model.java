package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade216Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade216Model extends GeoModel<CursedSpiritGrade216Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade216Entity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/cursedspirit_dog.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade216Entity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/cursedspirit_dog.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade216Entity entity) {
      return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade216Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * ((float)Math.PI / 180F));
         head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180F));
      }

   }
}
