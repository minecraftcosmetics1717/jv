package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.YakumaruEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YakumaruModel extends GeoModel<YakumaruEntity> {
   public ResourceLocation getAnimationResource(YakumaruEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(YakumaruEntity.DATA_entity_form) == 0 ? new ResourceLocation("jujutsucraftv", "animations/human.animation.json") : new ResourceLocation("jujutsucraftv", "animations/yakumaru_dying.animation.json");
   }

   public ResourceLocation getModelResource(YakumaruEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(YakumaruEntity.DATA_entity_form) == 0 ? new ResourceLocation("jujutsucraftv", "geo/human.geo.json") : new ResourceLocation("jujutsucraftv", "geo/yakumaru_dying.geo.json");
   }

   public ResourceLocation getTextureResource(YakumaruEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(YakumaruEntity.DATA_entity_form) == 0 ? new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png") : new ResourceLocation("jujutsucraftv", "textures/entities/yakumaru2.png");
   }
}
