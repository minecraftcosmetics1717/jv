package net.mcreator.jujutsucraftv.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.procedures.VendingMachineButton0Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineButton1Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineButton2Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect0Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect1Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect2Procedure;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineShopGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
public class VendingMachineShopGuiButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;
   private HashMap<String, String> textstate;

   public VendingMachineShopGuiButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.textstate = readTextState(buffer);
   }

   public VendingMachineShopGuiButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
      this.textstate = textstate;
   }

   public static void buffer(VendingMachineShopGuiButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      writeTextState(message.textstate, buffer);
   }

   public static void handler(VendingMachineShopGuiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         if (entity != null) {
            handleButtonAction(entity, message.buttonID, message.x, message.y, message.z, message.textstate);
         }
      });
      context.setPacketHandled(true);
   }

   public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      if (entity != null) {
         Level world = entity.m_9236_();
         HashMap<String, Object> guistate = VendingMachineShopGuiMenu.guistate;
         if (textstate != null) {
            for(Map.Entry<String, String> entry : textstate.entrySet()) {
               String key = (String)entry.getKey();
               String value = (String)entry.getValue();
               guistate.put(key, value);
            }
         }

         BlockPos pos = new BlockPos(x, y, z);
         if (world.m_46805_(pos)) {
            if (buttonID == 0 && VendingMachineSelect0Procedure.execute(world, (double)x, (double)y, (double)z)) {
               VendingMachineButton0Procedure.execute(world, (double)x, (double)y, (double)z, entity);
            }

            if (buttonID == 1 && VendingMachineSelect1Procedure.execute(world, (double)x, (double)y, (double)z)) {
               VendingMachineButton1Procedure.execute(world, (double)x, (double)y, (double)z, entity);
            }

            if (buttonID == 2 && VendingMachineSelect2Procedure.execute(world, (double)x, (double)y, (double)z)) {
               VendingMachineButton2Procedure.execute(world, (double)x, (double)y, (double)z, entity);
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer serverPlayer = (ServerPlayer)entity;
               VendingMachineShopGuiSyncMessage.sendTo(serverPlayer, pos);
            }

         }
      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(VendingMachineShopGuiButtonMessage.class, VendingMachineShopGuiButtonMessage::buffer, VendingMachineShopGuiButtonMessage::new, VendingMachineShopGuiButtonMessage::handler);
   }

   public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
      if (map == null) {
         buffer.writeInt(0);
      } else {
         buffer.writeInt(map.size());

         for(Map.Entry<String, String> entry : map.entrySet()) {
            buffer.m_130083_(Component.m_237113_((String)entry.getKey()));
            buffer.m_130083_(Component.m_237113_((String)entry.getValue()));
         }

      }
   }

   public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
      int size = buffer.readInt();
      HashMap<String, String> map = new HashMap();

      for(int i = 0; i < size; ++i) {
         String key = buffer.m_130238_().getString();
         String value = buffer.m_130238_().getString();
         map.put(key, value);
      }

      return map;
   }
}
