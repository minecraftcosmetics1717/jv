package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class JjcvGiveLootTableChestProcedure {
   public static void execute(final CommandContext<CommandSourceStack> arguments) {
      String txt = "";
      if (BoolArgumentType.getBool(arguments, "barrel")) {
         txt = "/give @p minecraft:barrel{BlockEntityTag:{LootTable:\"jujutsucraft:entities/stevenson_screen\"}} 1";
      } else {
         txt = "/give @p minecraft:chest{BlockEntityTag:{LootTable:\"jujutsucraft:entities/stevenson_screen\"}} 1";
      }

      Entity _ent = ((<undefinedtype>)(new Object() {
         public Entity getEntity() {
            try {
               return EntityArgument.m_91452_(arguments, "entity");
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return null;
            }
         }
      })).getEntity();
      if (!_ent.m_9236_().m_5776_() && _ent.m_20194_() != null) {
         _ent.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent), txt);
      }

   }
}
