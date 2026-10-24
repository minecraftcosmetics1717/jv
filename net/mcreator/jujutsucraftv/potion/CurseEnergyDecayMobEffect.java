package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.CurseEnergyDecayTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class CurseEnergyDecayMobEffect extends MobEffect {
   public CurseEnergyDecayMobEffect() {
      super(MobEffectCategory.HARMFUL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      CurseEnergyDecayTickProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
