package net.mcreator.jujutsucraftv.init;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModCuriosSlots {
   @SubscribeEvent
   public static void enqueueIMC(InterModEnqueueEvent event) {
   }
}
