package net.mcreator.jujutsucraftv.entity.model;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade15Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade15Model extends GeoModel<CursedSpiritGrade15Entity> {
   public ResourceLocation getAnimationResource(CursedSpiritGrade15Entity entity) {
      return (Integer)entity.m_20088_().m_135370_(CursedSpiritGrade15Entity.DATA_entity_form) == 0 ? new ResourceLocation("jujutsucraftv", "animations/whack_a_mole.animation.json") : new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade15Entity entity) {
      return (Integer)entity.m_20088_().m_135370_(CursedSpiritGrade15Entity.DATA_entity_form) == 0 ? new ResourceLocation("jujutsucraftv", "geo/whack_a_mole.geo.json") : new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade15Entity entity) {
      return (Integer)entity.m_20088_().m_135370_(CursedSpiritGrade15Entity.DATA_entity_form) == 0 ? new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png") : new ResourceLocation("jujutsucraft", "textures/entities/cursedspirit0_1.png");
   }
}
