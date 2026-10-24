package net.mcreator.jujutsucraftv.init;

import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.network.JujutsuCuriosSlot1ActionMessage;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftvModKeyMappings {
   public static final KeyMapping JUJUTSU_CURIOS_SLOT_1_ACTION = new KeyMapping("key.jujutsucraftv.jujutsu_curios_slot_1_action", 72, "key.categories.jujutsu_craft") {
      private boolean isDownOld = false;

      public void m_7249_(boolean isDown) {
         super.m_7249_(isDown);
         if (this.isDownOld != isDown && isDown) {
            JujutsucraftvMod.PACKET_HANDLER.sendToServer(new JujutsuCuriosSlot1ActionMessage(0, 0));
            JujutsuCuriosSlot1ActionMessage.pressAction(Minecraft.m_91087_().f_91074_, 0, 0);
         }

         this.isDownOld = isDown;
      }
   };

   @SubscribeEvent
   public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
      event.register(JUJUTSU_CURIOS_SLOT_1_ACTION);
   }

   @EventBusSubscriber({Dist.CLIENT})
   public static class KeyEventListener {
      @SubscribeEvent
      public static void onClientTick(TickEvent.ClientTickEvent event) {
         if (Minecraft.m_91087_().f_91080_ == null) {
            JujutsucraftvModKeyMappings.JUJUTSU_CURIOS_SLOT_1_ACTION.m_90859_();
         }

      }
   }
}
