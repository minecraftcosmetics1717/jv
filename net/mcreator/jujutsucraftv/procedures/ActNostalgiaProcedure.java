package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActNostalgiaProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 63200;
         switch (skill) {
            case 3:
               AttackSpeedVProcedure.execute(world, x, y, z, entity);
               found = true;
            case 4:
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
            default:
               break;
            case 5:
               SkillNostalgia1Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               SkillNostalgia2Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               SkillNostalgia3Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 8:
               SkillNostalgia4Procedure.execute(world, entity);
               found = true;
               break;
            case 20:
               OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
