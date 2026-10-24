package net.mcreator.jujutsucraftv.network;

import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.procedures.CloseJjcvConfigGuiProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.network.NetworkEvent;

public class JjcvConfigSyncMessage {
   private final int id;
   private final boolean value;

   public JjcvConfigSyncMessage(int id, boolean value) {
      this.id = id;
      this.value = value;
   }

   public JjcvConfigSyncMessage(FriendlyByteBuf buffer) {
      this.id = buffer.readInt();
      this.value = buffer.readBoolean();
   }

   public static void encoder(JjcvConfigSyncMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.id);
      buffer.writeBoolean(message.value);
   }

   public static void handle(JjcvConfigSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         if (context.getSender() != null) {
            ServerLevel world = context.getSender().m_284548_();
            CloseJjcvConfigGuiProcedure.updateServerVars(world, message.id, message.value);
         }

      });
      context.setPacketHandled(true);
   }
}
