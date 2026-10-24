package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class JjcvSetTechnique2Procedure {
   public static void execute(CommandContext<CommandSourceStack> arguments) {
      try {
         Entity targetEntity = EntityArgument.m_91452_(arguments, "entity");
         if (targetEntity == null || !(targetEntity instanceof Player)) {
            return;
         }

         double tecNumber = DoubleArgumentType.getDouble(arguments, "technique_number");
         targetEntity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique2 = tecNumber;
            capability.syncPlayerVariables(targetEntity);
         });
         if (!targetEntity.m_9236_().m_5776_() && targetEntity.m_20194_() != null) {
            targetEntity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, targetEntity.m_20182_(), targetEntity.m_20155_(), targetEntity.m_9236_() instanceof ServerLevel ? (ServerLevel)targetEntity.m_9236_() : null, 4, targetEntity.m_7755_().getString(), targetEntity.m_5446_(), targetEntity.m_9236_().m_7654_(), targetEntity), "advancement revoke @s only jujutsucraft:update");
         }
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

   }
}
