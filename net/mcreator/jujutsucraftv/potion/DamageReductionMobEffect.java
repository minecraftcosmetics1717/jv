package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

public class DamageReductionMobEffect extends MobEffect {
   public DamageReductionMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -7344408);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
