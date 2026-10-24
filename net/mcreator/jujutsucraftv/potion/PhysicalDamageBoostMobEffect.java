package net.mcreator.jujutsucraftv.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class PhysicalDamageBoostMobEffect extends MobEffect {
   public PhysicalDamageBoostMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
