package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class HoldGuitarProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         boolean var4;
         if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:guitar")))) {
            ItemStack var3;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var3 = _livEnt.m_21206_();
            } else {
               var3 = ItemStack.f_41583_;
            }

            if (!var3.m_204117_(ItemTags.create(new ResourceLocation("forge:guitar")))) {
               var4 = false;
               return var4;
            }
         }

         var4 = true;
         return var4;
      }
   }
}
