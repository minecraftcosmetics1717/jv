package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.EffectFerociousUnitTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EffectFerociousUnitMobEffect extends MobEffect {
   public EffectFerociousUnitMobEffect() {
      super(MobEffectCategory.NEUTRAL, -13627625);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      EffectFerociousUnitTickProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
