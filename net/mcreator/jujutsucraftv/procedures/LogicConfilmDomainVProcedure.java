package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.LogicConfilmDomainProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LogicConfilmDomainVProcedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      return entity == null ? false : LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
   }
}
