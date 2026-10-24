package net.mcreator.jujutsucraftv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class RegisterConfigPacketProcedure {
   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> CloseJjcvConfigGuiProcedure.registerPackets());
   }
}
