package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class DadaProcedure {
   @SubscribeEvent
   public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
      if (event.getHand() == event.getEntity().m_7655_()) {
         execute(event);
      }
   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
      String ANIME_NAME = "";
   }
}
