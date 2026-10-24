package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class RangeAttackVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         RangeAttackProcedure.execute(world, x, y, z, entity);
      }
   }
}
