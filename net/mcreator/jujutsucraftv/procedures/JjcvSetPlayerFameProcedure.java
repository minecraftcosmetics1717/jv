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

public class JjcvSetPlayerFameProcedure {
   public static void execute(CommandContext<CommandSourceStack> arguments) {
      try {
         Entity targetEntity = EntityArgument.m_91452_(arguments, "entity");
         if (targetEntity == null || !(targetEntity instanceof Player)) {
            return;
         }

         double fameNumber = DoubleArgumentType.getDouble(arguments, "player_fame");
         targetEntity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerFame = fameNumber;
            capability.syncPlayerVariables(targetEntity);
         });
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

   }
}
