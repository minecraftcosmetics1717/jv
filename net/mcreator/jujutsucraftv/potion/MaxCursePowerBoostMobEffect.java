package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.MaxCursePowerBoostEndProcedure;
import net.mcreator.jujutsucraftv.procedures.MaxCursePowerBoostStartProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class MaxCursePowerBoostMobEffect extends MobEffect {
   public MaxCursePowerBoostMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -10066177);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      MaxCursePowerBoostStartProcedure.execute(entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      MaxCursePowerBoostEndProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
