package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class HoldFoundationStoneProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double hold_type = (double)0.0F;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.FOUNDATION_STONE.get()) {
            hold_type = (double)1.0F;
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftvModItems.FOUNDATION_STONE.get()) {
               hold_type = (double)2.0F;
            } else {
               hold_type = (double)0.0F;
            }
         }

         return hold_type;
      }
   }
}
