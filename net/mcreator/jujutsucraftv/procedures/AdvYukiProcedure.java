package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AdvYukiProcedure {
   @SubscribeEvent
   public static void onAdvancement(AdvancementEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         if (GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) == (double)620.0F || GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) == (double)620.0F) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_0");
            }

            if (LogicGrade3Procedure.execute(entity)) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_2");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_3");
               }
            }

            if (LogicGradeSemi2Procedure.execute(entity)) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_4");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "advancement grant @s only jujutsucraftv:skill_yuki_5");
               }
            }
         }

      }
   }
}
