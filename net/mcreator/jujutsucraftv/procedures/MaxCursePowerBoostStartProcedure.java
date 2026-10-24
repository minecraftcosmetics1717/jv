package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class MaxCursePowerBoostStartProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         double _setval = GetPlayerCursePowerFormerProcedure.execute(entity);
         entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.CursePowerFormerBackup = _setval;
            capability.syncPlayerVariables(entity);
         });
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            Commands var10000;
            CommandSourceStack var10001;
            double var10002;
            int var10004;
            label22: {
               var10000 = entity.m_20194_().m_129892_();
               var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               var10002 = GetPlayerCursePowerFormerProcedure.execute(entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.MAX_CURSE_POWER_BOOST.get())) {
                     var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.MAX_CURSE_POWER_BOOST.get()).m_19564_();
                     break label22;
                  }
               }

               var10004 = 0;
            }

            var10000.m_230957_(var10001, "jjcv entity_data set_player_curse_power_former @s " + (var10002 + (double)(5 * var10004)));
         }

      }
   }
}
