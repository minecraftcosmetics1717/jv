package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.Attack4ConsecutiveAttacksProcedure;
import net.mcreator.jujutsucraft.procedures.AttackJumpProcedure;
import net.mcreator.jujutsucraft.procedures.GaragaraProcedure;
import net.mcreator.jujutsucraft.procedures.NanamiDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.WeaponNanamiRightClickedInAirProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActNanamiProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 1300;
         switch (skill) {
            case 5:
               WeaponNanamiRightClickedInAirProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
               found = true;
               break;
            case 6:
               AttackJumpProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               Attack4ConsecutiveAttacksProcedure.execute(world, entity);
               found = true;
            case 8:
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
               break;
            case 10:
               GaragaraProcedure.execute(world, entity);
               found = true;
               break;
            case 11:
               SkillOvertimeProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 20:
               NanamiDomainExpansionProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
