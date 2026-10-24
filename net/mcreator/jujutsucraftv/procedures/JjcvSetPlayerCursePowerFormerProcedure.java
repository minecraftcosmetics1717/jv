package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class JjcvSetPlayerCursePowerFormerProcedure {
   public static void execute(CommandContext<CommandSourceStack> arguments) {
      Entity entity = null;

      try {
         entity = EntityArgument.m_91452_(arguments, "entity");
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
         return;
      }

      double playerFormer = DoubleArgumentType.getDouble(arguments, "player_curse_former");
      entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
         capability.PlayerCursePowerFormer = playerFormer;
         capability.syncPlayerVariables(entity);
      });
      double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer * (double)Math.round(((double)2.0F + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerLevel) / 1.1);
      entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
         capability.PlayerCursePowerMAX = _setval;
         capability.syncPlayerVariables(entity);
      });
   }
}
