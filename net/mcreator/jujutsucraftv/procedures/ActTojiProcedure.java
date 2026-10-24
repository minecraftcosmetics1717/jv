package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AttackJumpProcedure;
import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.AttackTackleProcedure;
import net.mcreator.jujutsucraft.procedures.AvoidanceProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActTojiProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         skill += 100;
         switch (skill) {
            case 4:
               AttackSpeedVProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 5:
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               AttackJumpProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               AttackTackleProcedure.execute(world, x, y, z, entity);
               found = true;
            case 8:
            case 9:
            default:
               break;
            case 10:
               AvoidanceProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
