package net.mcreator.jujutsucraftv.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftvModCuriosProperties {
   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
      });
   }
}
