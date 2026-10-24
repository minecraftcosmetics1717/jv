package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class JujutsuEntityTickProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event);
   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
   }
}
