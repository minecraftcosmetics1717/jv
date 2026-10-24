package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActOtsurugiProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 61900;
         switch (skill) {
            case 3:
               AttackSpeedVProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 5:
               SkillWipProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
