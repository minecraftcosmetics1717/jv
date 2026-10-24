package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ButtonForestProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = (double)604.0F;
            capability.syncPlayerVariables(entity);
         });
         CursedTechniqueSelectedProcedure.execute(world, x, y, z, entity);
      }
   }
}
