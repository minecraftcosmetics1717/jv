package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

public class SizeChangeMobEffect extends MobEffect {
   public SizeChangeMobEffect() {
      super(MobEffectCategory.NEUTRAL, -3407668);
   }

   public static float getScale(int amplifier) {
      int clampedAmplifier = Math.max(0, Math.min(99, amplifier));
      return (float)(clampedAmplifier + 1) * 0.1F;
   }

   public List<ItemStack> getCurativeItems() {
      return new ArrayList();
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
