package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ActWhackamoleProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, int skill) {
      if (entity == null) {
         return false;
      } else {
         boolean found = false;
         CompoundTag ForgeData = entity.getPersistentData();
         skill %= 61300;
         switch (skill) {
            case 5:
               SpineProcedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 6:
               Spine2Procedure.execute(world, x, y, z, entity);
               found = true;
               break;
            case 20:
               WhackamoleDomainProcedure.execute(world, x, y, z, entity);
               found = true;
         }

         return found;
      }
   }
}
