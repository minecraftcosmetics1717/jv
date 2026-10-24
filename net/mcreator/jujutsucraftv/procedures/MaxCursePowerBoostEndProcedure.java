package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.LazyOptional;

public class MaxCursePowerBoostEndProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            Commands var10000 = entity.m_20194_().m_129892_();
            CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
            LazyOptional var10002 = entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null);
            JujutsucraftvModVariables.PlayerVariables var10003 = new JujutsucraftvModVariables.PlayerVariables();
            var10000.m_230957_(var10001, "/jjcv entity_data set_player_curse_power_former @s " + ((JujutsucraftvModVariables.PlayerVariables)var10002.orElse(var10003)).CursePowerFormerBackup);
         }

      }
   }
}
