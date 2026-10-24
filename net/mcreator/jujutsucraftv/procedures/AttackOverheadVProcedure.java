package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AttackOverheadVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.f_19864_ = true;
         AttackOverheadProcedure.execute(world, x, y, z, entity);
      }
   }
}
