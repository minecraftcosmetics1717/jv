package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables.MapVariables;
import net.minecraft.world.level.LevelAccessor;

public class GetDomainRadiusProcedure {
   public static double execute(LevelAccessor world) {
      return MapVariables.get(world).DomainExpansionRadius;
   }
}
