package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.OtherDomainExpansionProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActYukiProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 62000;
         switch (skill) {
            case 5:
               SkillGetFoundationStoneProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               SkillYuki4Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 7:
               SkillYuki1Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 8:
               SkillYuki2Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 9:
               SkillYuki3Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 10:
               SkillYuki5Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 11:
               SkillYuki6Procedure.execute(world, x, y, z, entity);
               found = true;
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
               OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
