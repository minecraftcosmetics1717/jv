package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CurseEnergyRegenerationTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Player && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            Commands var10000;
            CommandSourceStack var10001;
            int var10002;
            label23: {
               var10000 = entity.m_20194_().m_129892_();
               var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_REGENERATION.get())) {
                     var10002 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_REGENERATION.get()).m_19564_();
                     break label23;
                  }
               }

               var10002 = 0;
            }

            var10000.m_230957_(var10001, "/jjc_cursepower " + var10002 * 1 + " @s");
         }

      }
   }
}
