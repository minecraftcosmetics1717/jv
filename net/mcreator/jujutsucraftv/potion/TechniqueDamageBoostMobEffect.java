package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

public class TechniqueDamageBoostMobEffect extends MobEffect {
   public TechniqueDamageBoostMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
