package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class JjcvSetCloneMaxProcedure {
   public static void execute(final CommandContext<CommandSourceStack> arguments) {
      double _setval = DoubleArgumentType.getDouble(arguments, "clone_max");
      ((<undefinedtype>)(new Object() {
         public Entity getEntity() {
            try {
               return EntityArgument.m_91452_(arguments, "entity");
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return null;
            }
         }
      })).getEntity().getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
         capability.CloneMax = _setval;
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
