package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.Attack4ConsecutiveAttacksProcedure;
import net.mcreator.jujutsucraft.procedures.TechniquePrayerSongProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActMiguelProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 3000;
         switch (skill) {
            case 4:
               AttackJumpVProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 5:
               TechniquePrayerSongProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               Attack4ConsecutiveAttacksProcedure.execute(world, entity);
               found = true;
               break;
            case 20:
               MiguelDomainProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
