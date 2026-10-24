package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AttackJumpProcedure;
import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.RozetsuDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.SkillRozetsuShikigami1Procedure;
import net.mcreator.jujutsucraft.procedures.SkillRozetsuShikigami2Procedure;
import net.mcreator.jujutsucraft.procedures.SkillRozetsuShikigami3Procedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActRozetsuProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 4300;
         switch (skill) {
            case 3:
               AttackJumpProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 4:
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 5:
               SkillRozetsuShikigami1Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               SkillRozetsuShikigami2Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               SkillRozetsuShikigami3Procedure.execute(world, x, y, z, entity);
               found = true;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 22:
            case 23:
            case 24:
            default:
               break;
            case 20:
               RozetsuDomainExpansionProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 25:
               SkillRouzetsuDismantleProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
