package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.LogicAttackTargetProcedure;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade37Entity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class TargetEntityLogicAttackProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_entity = false;
         if (entity instanceof CursedSpiritGrade37Entity) {
            if (entity instanceof Mob) {
               Mob _mobEnt1 = (Mob)entity;
               if (_mobEnt1.m_5912_()) {
                  logic_entity = false;
                  return LogicAttackTargetProcedure.execute(entity);
               }
            }

            logic_entity = LogicAttackTargetProcedure.execute(entity);
         }

         return LogicAttackTargetProcedure.execute(entity);
      }
   }
}
