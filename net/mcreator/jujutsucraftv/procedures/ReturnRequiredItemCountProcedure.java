package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ReturnRequiredItemCountProcedure {
   public static double execute(Entity entity, ItemStack item) {
      if (entity != null && item != null && !item.m_41619_()) {
         int count = 0;
         if (entity instanceof Player) {
            Player player = (Player)entity;

            for(ItemStack stack : player.m_150109_().f_35974_) {
               if (!stack.m_41619_() && stack.m_150930_(item.m_41720_())) {
                  count += stack.m_41613_();
               }
            }

            for(ItemStack stack : player.m_150109_().f_35975_) {
               if (!stack.m_41619_() && stack.m_150930_(item.m_41720_())) {
                  count += stack.m_41613_();
               }
            }

            for(ItemStack stack : player.m_150109_().f_35976_) {
               if (!stack.m_41619_() && stack.m_150930_(item.m_41720_())) {
                  count += stack.m_41613_();
               }
            }

            return (double)count;
         } else {
            if (entity instanceof Container) {
               Container container = (Container)entity;

               for(int i = 0; i < container.m_6643_(); ++i) {
                  ItemStack stack = container.m_8020_(i);
                  if (!stack.m_41619_() && stack.m_150930_(item.m_41720_())) {
                     count += stack.m_41613_();
                  }
               }
            }

            return (double)count;
         }
      } else {
         return (double)0.0F;
      }
   }
}
