package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class VendingMachineButton2Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      VendingMachinePurchaseHelper.execute(world, x, y, z, entity, 2, 5);
   }
}
