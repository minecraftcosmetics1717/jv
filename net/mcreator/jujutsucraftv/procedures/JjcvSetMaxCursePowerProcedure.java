package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class JjcvSetMaxCursePowerProcedure {
   public static void execute(CommandContext<CommandSourceStack> arguments) {
      try {
         Entity targetEntity = EntityArgument.m_91452_(arguments, "entity");
         if (targetEntity == null || !(targetEntity instanceof Player)) {
            return;
         }

         double maxcursepowerNumber = DoubleArgumentType.getDouble(arguments, "player_max_curse_power");
         targetEntity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCursePowerMAX = maxcursepowerNumber;
            capability.syncPlayerVariables(targetEntity);
         });
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

   }
}
