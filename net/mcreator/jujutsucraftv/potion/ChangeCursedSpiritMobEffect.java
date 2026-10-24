package net.mcreator.jujutsucraftv.potion;

import java.util.ArrayList;
import java.util.List;
import net.mcreator.jujutsucraftv.procedures.ChangeCursedSpiritEndProcedure;
import net.mcreator.jujutsucraftv.procedures.ChangeCursedSpiritStartProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ChangeCursedSpiritMobEffect extends MobEffect {
   public ChangeCursedSpiritMobEffect() {
      super(MobEffectCategory.NEUTRAL, -13434829);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      cures.add(new ItemStack(Items.f_42455_));
      cures.add(new ItemStack(Items.f_42787_));
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      ChangeCursedSpiritStartProcedure.execute(entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      ChangeCursedSpiritEndProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
