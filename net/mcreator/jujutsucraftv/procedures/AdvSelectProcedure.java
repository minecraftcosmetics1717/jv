package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class AdvSelectProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) == (double)620.0F || GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) == (double)620.0F) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_0");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_1");
            }

            AdvYukiProcedure.execute(entity);
         }

         if (GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) == (double)630.0F || GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) == (double)630.0F) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_dabura_0");
            }

            AdvDaburaProcedure.execute(entity);
         }

         if (GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) == (double)43.0F || GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) == (double)43.0F) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_rozetsu_0");
            }

            AdvJjcProcedure.execute(entity);
         }

      }
   }
}
