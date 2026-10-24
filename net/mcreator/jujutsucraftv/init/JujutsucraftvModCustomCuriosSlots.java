package net.mcreator.jujutsucraftv.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModCustomCuriosSlots {
   @SubscribeEvent
   public static void enqueueIMC(InterModEnqueueEvent event) {
      InterModComms.sendTo("curios", "register_type", () -> (new SlotTypeMessage.Builder("jujutsu_slot")).icon(new ResourceLocation("curios:slot/curios_slot_curse1")).size(1).build());
      InterModComms.sendTo("curios", "register_type", () -> (new SlotTypeMessage.Builder("jujutsu_talisman")).icon(new ResourceLocation("curios:slot/curios_slot_talisman")).size(4).build());
   }
}
