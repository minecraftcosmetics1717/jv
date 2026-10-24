package net.mcreator.jujutsucraftv.world.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.client.gui.JjcvConfigGuiScreen;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMenus;
import net.mcreator.jujutsucraftv.procedures.CloseJjcvConfigGuiProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkEvent;

public class JjcvConfigGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
   public static final HashMap<String, Object> guistate = new HashMap();
   public final Level world;
   public final Player entity;
   public int x;
   public int y;
   public int z;
   private ContainerLevelAccess access;
   private IItemHandler internal;
   private final Map<Integer, Slot> customSlots;
   private boolean bound;
   private Supplier<Boolean> boundItemMatcher;
   private Entity boundEntity;
   private BlockEntity boundBlockEntity;

   public JjcvConfigGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
      super((MenuType)JujutsucraftvModMenus.JJCV_CONFIG_GUI.get(), id);
      this.access = ContainerLevelAccess.f_39287_;
      this.customSlots = new HashMap();
      this.bound = false;
      this.boundItemMatcher = null;
      this.boundEntity = null;
      this.boundBlockEntity = null;
      this.entity = inv.f_35978_;
      this.world = inv.f_35978_.m_9236_();
      this.internal = new ItemStackHandler(0);
      BlockPos pos = null;
      if (extraData != null) {
         pos = extraData.m_130135_();
         this.x = pos.m_123341_();
         this.y = pos.m_123342_();
         this.z = pos.m_123343_();
         this.access = ContainerLevelAccess.m_39289_(this.world, pos);
      }

   }

   public boolean m_6875_(Player player) {
      if (this.bound) {
         if (this.boundItemMatcher != null) {
            return (Boolean)this.boundItemMatcher.get();
         }

         if (this.boundBlockEntity != null) {
            return AbstractContainerMenu.m_38889_(this.access, player, this.boundBlockEntity.m_58900_().m_60734_());
         }

         if (this.boundEntity != null) {
            return this.boundEntity.m_6084_();
         }
      }

      return true;
   }

   public ItemStack m_7648_(Player playerIn, int index) {
      return ItemStack.f_41583_;
   }

   public void m_6877_(Player playerIn) {
      super.m_6877_(playerIn);
      if (this.world != null && this.world.f_46443_) {
         this.textBoxStart();
      }

   }

   public void textBoxStart() {
      JujutsucraftvMod.PACKET_HANDLER.sendToServer(new JjcvConfigGuiOtherMessage(1, this.x, this.y, this.z, JjcvConfigGuiScreen.getTextboxValues()));
      JjcvConfigGuiMenu.JjcvConfigGuiOtherMessage.handleOtherAction(this.entity, 1, this.x, this.y, this.z, JjcvConfigGuiScreen.getTextboxValues());
   }

   public Map<Integer, Slot> get() {
      return this.customSlots;
   }

   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class JjcvConfigGuiOtherMessage {
      private final int mode;
      private final int x;
      private final int y;
      private final int z;
      private HashMap<String, String> textstate;

      public JjcvConfigGuiOtherMessage(FriendlyByteBuf buffer) {
         this.mode = buffer.readInt();
         this.x = buffer.readInt();
         this.y = buffer.readInt();
         this.z = buffer.readInt();
         this.textstate = readTextState(buffer);
      }

      public JjcvConfigGuiOtherMessage(int mode, int x, int y, int z, HashMap<String, String> textstate) {
         this.mode = mode;
         this.x = x;
         this.y = y;
         this.z = z;
         this.textstate = textstate;
      }

      public static void buffer(JjcvConfigGuiOtherMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.mode);
         buffer.writeInt(message.x);
         buffer.writeInt(message.y);
         buffer.writeInt(message.z);
         writeTextState(message.textstate, buffer);
      }

      public static void handler(JjcvConfigGuiOtherMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            Player entity = context.getSender();
            int mode = message.mode;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            HashMap<String, String> textstate = message.textstate;
            handleOtherAction(entity, mode, x, y, z, textstate);
         });
         context.setPacketHandled(true);
      }

      public static void handleOtherAction(Player entity, int mode, int x, int y, int z, HashMap<String, String> textstate) {
         Level world = entity.m_9236_();
         HashMap guistate = JjcvConfigGuiMenu.guistate;

         for(Map.Entry<String, String> entry : textstate.entrySet()) {
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            guistate.put(key, value);
         }

         if (world.m_46805_(new BlockPos(x, y, z))) {
            if (mode == 1) {
               CloseJjcvConfigGuiProcedure.execute(world, guistate);
            }

         }
      }

      @SubscribeEvent
      public static void registerMessage(FMLCommonSetupEvent event) {
         JujutsucraftvMod.addNetworkMessage(JjcvConfigGuiOtherMessage.class, JjcvConfigGuiOtherMessage::buffer, JjcvConfigGuiOtherMessage::new, JjcvConfigGuiOtherMessage::handler);
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
}
