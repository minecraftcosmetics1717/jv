package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.ReturnEnergyColorProcedure;
import net.minecraft.world.entity.Entity;

public class ReturnEnergyColorVProcedure {
   public static double execute(Entity entity) {
      return entity == null ? (double)0.0F : ReturnEnergyColorProcedure.execute(entity);
   }
}
