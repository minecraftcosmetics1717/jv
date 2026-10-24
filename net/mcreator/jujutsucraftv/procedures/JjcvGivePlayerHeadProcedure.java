package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class JjcvGivePlayerHeadProcedure {
   public static void execute(final CommandContext<CommandSourceStack> arguments) {
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
         Commands var10000 = _ent.m_20194_().m_129892_();
         CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent);
         Object var10002 = new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "head_entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         };
         var10000.m_230957_(var10001, "/give @s minecraft:player_head{SkullOwner:\"" + ((<undefinedtype>)var10002).getEntity().m_5446_().getString() + "\"}");
      }

   }
}
