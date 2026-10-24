package net.mcreator.jujutsucraftv.procedures;

import java.util.Random;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ButtonRandomProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double randomValue1 = getRandomValue();
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = randomValue1;
            capability.syncPlayerVariables(entity);
         });
         CursedTechniqueSelectedProcedure.execute(world, x, y, z, entity);
      }
   }

   private static double getRandomValue() {
      Random random = new Random();
      int defolt_tec = 45;
      int add_tec = 31;
      int tec_num = defolt_tec + add_tec;

      double result;
      do {
         int rand = random.nextInt(tec_num + 2);
         if (rand == 0) {
            result = (double)-1.0F;
         } else if (rand <= defolt_tec) {
            result = (double)rand;
         } else {
            int offset = 602;
            result = (double)(offset + (rand - defolt_tec - 1));
         }
      } while(result == (double)612.0F || result == (double)622.0F || result == (double)629.0F);

      return result;
   }
}
