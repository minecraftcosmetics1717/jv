package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class LoadDimentionTombOfTheStarProcedure {
   @SubscribeEvent
   public static void onWorldLoad(LevelEvent.Load event) {
      execute(event);
   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
   }
}
