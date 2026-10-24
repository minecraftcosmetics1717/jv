package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BlockDestroyAllDirectionVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
      }
   }
}
