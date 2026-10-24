package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.EffectSublightSpeedCancelProcedure;
import net.mcreator.jujutsucraftv.procedures.EffectSublightSpeedTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class EffectSublightSpeedMobEffect extends MobEffect {
   public EffectSublightSpeedMobEffect() {
      super(MobEffectCategory.NEUTRAL, -39322);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      EffectSublightSpeedTickProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      EffectSublightSpeedCancelProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
