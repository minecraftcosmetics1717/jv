package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class TalismanUnEquipProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.m_41720_() == JujutsucraftvModItems.NIGHT_VISION_ROSARY.get() && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_(MobEffects.f_19611_);
         }

      }
   }
}
