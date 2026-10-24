package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class JjcvSetPlayerCursePowerProcedure {
   public static void execute(final CommandContext<CommandSourceStack> arguments, Entity entity) {
      if (entity != null) {
         double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + DoubleArgumentType.getDouble(arguments, "player_curse_power");
         ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity().getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCursePower = _setval;
            capability.syncPlayerVariables(((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity());
         });
      }
   }
}
