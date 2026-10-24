package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class LogicTargetONwaterProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         boolean var4;
         if (var10000 instanceof LivingEntity) {
            LivingEntity var3;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var3 = _mobEnt.m_5448_();
            } else {
               var3 = null;
            }

            if (((Entity)var3).m_20072_()) {
               var4 = true;
               return var4;
            }
         }

         var4 = false;
         return var4;
      }
   }
}
