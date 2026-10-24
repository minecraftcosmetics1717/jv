package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.CalculateAttackProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class CalculateAttackVProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         CalculateAttackProcedure.execute(world, entity);
      }
   }
}
