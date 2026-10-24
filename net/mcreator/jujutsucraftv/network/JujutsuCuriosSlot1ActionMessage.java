package net.mcreator.jujutsucraftv.network;

import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.procedures.JujutsuCuriosSlot1ActionkigaYasaretatokiProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsuCuriosSlot1ActionMessage {
   int type;
   int pressedms;

   public JujutsuCuriosSlot1ActionMessage(int type, int pressedms) {
      this.type = type;
      this.pressedms = pressedms;
   }

   public JujutsuCuriosSlot1ActionMessage(FriendlyByteBuf buffer) {
      this.type = buffer.readInt();
      this.pressedms = buffer.readInt();
   }

   public static void buffer(JujutsuCuriosSlot1ActionMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.type);
      buffer.writeInt(message.pressedms);
   }

   public static void handler(JujutsuCuriosSlot1ActionMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> pressAction(context.getSender(), message.type, message.pressedms));
      context.setPacketHandled(true);
   }

   public static void pressAction(Player entity, int type, int pressedms) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      if (world.m_46805_(entity.m_20183_())) {
         if (type == 0) {
            JujutsuCuriosSlot1ActionkigaYasaretatokiProcedure.execute(world, x, y, z, entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(JujutsuCuriosSlot1ActionMessage.class, JujutsuCuriosSlot1ActionMessage::buffer, JujutsuCuriosSlot1ActionMessage::new, JujutsuCuriosSlot1ActionMessage::handler);
   }
}
