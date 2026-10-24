package net.mcreator.jujutsucraftv.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSetDataProcedure;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineSetGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
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
public class VendingMachineSetGuiSlotMessage {
   private final int slotID;
   private final int x;
   private final int y;
   private final int z;
   private final int changeType;
   private final int meta;
   private HashMap<String, String> textstate;

   public VendingMachineSetGuiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta, HashMap<String, String> textstate) {
      this.slotID = slotID;
      this.x = x;
      this.y = y;
      this.z = z;
      this.changeType = changeType;
      this.meta = meta;
      this.textstate = textstate;
   }

   public VendingMachineSetGuiSlotMessage(FriendlyByteBuf buffer) {
      this.slotID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.changeType = buffer.readInt();
      this.meta = buffer.readInt();
      this.textstate = readTextState(buffer);
   }

   public static void buffer(VendingMachineSetGuiSlotMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.slotID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      buffer.writeInt(message.changeType);
      buffer.writeInt(message.meta);
      writeTextState(message.textstate, buffer);
   }

   public static void handler(VendingMachineSetGuiSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         int slotID = message.slotID;
         int changeType = message.changeType;
         int meta = message.meta;
         int x = message.x;
         int y = message.y;
         int z = message.z;
         HashMap<String, String> textstate = message.textstate;
         handleSlotAction(entity, slotID, changeType, meta, x, y, z, textstate);
      });
      context.setPacketHandled(true);
   }

   public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z, HashMap<String, String> textstate) {
      Level world = entity.m_9236_();
      HashMap guistate = VendingMachineSetGuiMenu.guistate;

      for(Map.Entry<String, String> entry : textstate.entrySet()) {
         String key = (String)entry.getKey();
         String value = (String)entry.getValue();
         guistate.put(key, value);
      }

      if (world.m_46805_(new BlockPos(x, y, z))) {
         if (slot == 0 && changeType == 0) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 0 && changeType == 1) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 0 && changeType == 2) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 1 && changeType == 0) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 2 && changeType == 0) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 2 && changeType == 1) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 2 && changeType == 2) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 3 && changeType == 0) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 3 && changeType == 1) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 3 && changeType == 2) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 4 && changeType == 0) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 4 && changeType == 1) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 4 && changeType == 2) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 5 && changeType == 0) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 5 && changeType == 1) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (slot == 5 && changeType == 2) {
            VendingMachineSetDataProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(VendingMachineSetGuiSlotMessage.class, VendingMachineSetGuiSlotMessage::buffer, VendingMachineSetGuiSlotMessage::new, VendingMachineSetGuiSlotMessage::handler);
   }

   public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
      buffer.writeInt(map.size());

      for(Map.Entry<String, String> entry : map.entrySet()) {
         buffer.m_130083_(Component.m_237113_((String)entry.getKey()));
         buffer.m_130083_(Component.m_237113_((String)entry.getValue()));
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
