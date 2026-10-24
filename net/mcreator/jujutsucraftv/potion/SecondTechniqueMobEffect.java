package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.SecondTechniqueEndProcedure;
import net.mcreator.jujutsucraftv.procedures.SecondTechniqueStartProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class SecondTechniqueMobEffect extends MobEffect {
   public SecondTechniqueMobEffect() {
      super(MobEffectCategory.NEUTRAL, -13382401);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      SecondTechniqueStartProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      SecondTechniqueEndProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
