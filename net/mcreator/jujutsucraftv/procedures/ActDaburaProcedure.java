package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActDaburaProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 63000;
         switch (skill) {
            case 5:
               SkillDabura1Procedure.execute(world, entity);
               found = true;
               break;
            case 6:
               SkillDabura2Procedure.execute(world, entity);
               found = true;
               break;
            case 7:
               SkillDabura3Procedure.execute(world, entity);
               found = true;
               break;
            case 8:
               SkillDabura6Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 9:
               if (CheckSublightSpeedProcedure.execute(entity)) {
                  SkillDabura4Procedure.execute(world, x, y, z, entity);
               } else {
                  SkillDabura4CancelProcedure.execute(world, x, y, z, entity);
               }

               found = true;
               break;
            case 10:
               SkillDabura5Procedure.execute(world, x, y, z, entity);
               found = true;
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
            case 20:
               DaburaDomainProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
