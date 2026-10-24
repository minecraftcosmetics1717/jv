package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class HoldWeponTickProcedure {
   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event);
      }

   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
      double set_num = (double)0.0F;
   }
}
