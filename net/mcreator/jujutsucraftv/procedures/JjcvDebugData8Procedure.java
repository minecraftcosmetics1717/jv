package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.LazyOptional;

public class JjcvDebugData8Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "");
         }

         LazyOptional var10000 = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null);
         JujutsucraftModVariables.PlayerVariables var10001 = new JujutsucraftModVariables.PlayerVariables();
         return "fame:" + ((JujutsucraftModVariables.PlayerVariables)var10000.orElse(var10001)).PlayerFame;
      }
   }
}
