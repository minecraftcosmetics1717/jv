package net.mcreator.jujutsucraftv.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.procedures.ButtonDaburaProcedure;
import net.mcreator.jujutsucraftv.procedures.ButtonNonSorcererProcedure;
import net.mcreator.jujutsucraftv.procedures.ButtonOTsurugiProcedure;
import net.mcreator.jujutsucraftv.procedures.ButtonRandomProcedure;
import net.mcreator.jujutsucraftv.procedures.ButtonWithoutCursedTechniqueProcedure;
import net.mcreator.jujutsucraftv.procedures.CursedTechniqueChangerVGui3OpenProcedure;
import net.mcreator.jujutsucraftv.procedures.CursedTechniqueChangerVGui4OpenProcedure;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGui2Menu;
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
public class CursedTechniqueChangerVGui2ButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;
   private HashMap<String, String> textstate;

   public CursedTechniqueChangerVGui2ButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.textstate = readTextState(buffer);
   }

   public CursedTechniqueChangerVGui2ButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
      this.textstate = textstate;
   }

   public static void buffer(CursedTechniqueChangerVGui2ButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      writeTextState(message.textstate, buffer);
   }

   public static void handler(CursedTechniqueChangerVGui2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         int buttonID = message.buttonID;
         int x = message.x;
         int y = message.y;
         int z = message.z;
         HashMap<String, String> textstate = message.textstate;
         handleButtonAction(entity, buttonID, x, y, z, textstate);
      });
      context.setPacketHandled(true);
   }

   public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      Level world = entity.m_9236_();
      HashMap guistate = CursedTechniqueChangerVGui2Menu.guistate;

      for(Map.Entry<String, String> entry : textstate.entrySet()) {
         String key = (String)entry.getKey();
         String value = (String)entry.getValue();
         guistate.put(key, value);
      }

      if (world.m_46805_(new BlockPos(x, y, z))) {
         if (buttonID == 0) {
            ButtonOTsurugiProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 1) {
            ButtonRandomProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 2) {
            ButtonNonSorcererProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 3) {
            ButtonWithoutCursedTechniqueProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 4) {
            ButtonDaburaProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 5) {
            CursedTechniqueChangerVGui3OpenProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 6) {
            CursedTechniqueChangerVGui4OpenProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(CursedTechniqueChangerVGui2ButtonMessage.class, CursedTechniqueChangerVGui2ButtonMessage::buffer, CursedTechniqueChangerVGui2ButtonMessage::new, CursedTechniqueChangerVGui2ButtonMessage::handler);
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
