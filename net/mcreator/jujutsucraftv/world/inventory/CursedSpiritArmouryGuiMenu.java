package net.mcreator.jujutsucraftv.world.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMenus;
import net.mcreator.jujutsucraftv.procedures.CsaTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.network.NetworkEvent;

public class CursedSpiritArmouryGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
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

   public CursedSpiritArmouryGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
      super((MenuType)JujutsucraftvModMenus.CURSED_SPIRIT_ARMOURY_GUI.get(), id);
      this.access = ContainerLevelAccess.f_39287_;
      this.customSlots = new HashMap();
      this.bound = false;
      this.boundItemMatcher = null;
      this.boundEntity = null;
      this.boundBlockEntity = null;
      this.entity = inv.f_35978_;
      this.world = inv.f_35978_.m_9236_();
      this.internal = new ItemStackHandler(9);
      BlockPos pos = null;
      if (extraData != null) {
         pos = extraData.m_130135_();
         this.x = pos.m_123341_();
         this.y = pos.m_123342_();
         this.z = pos.m_123343_();
         this.access = ContainerLevelAccess.m_39289_(this.world, pos);
      }

      if (pos != null) {
         if (extraData.readableBytes() == 1) {
            byte hand = extraData.readByte();
            ItemStack itemstack = hand == 0 ? this.entity.m_21205_() : this.entity.m_21206_();
            this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.m_21205_() : this.entity.m_21206_());
            itemstack.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
               this.internal = capability;
               this.bound = true;
            });
         } else if (extraData.readableBytes() > 1) {
            extraData.readByte();
            this.boundEntity = this.world.m_6815_(extraData.m_130242_());
            if (this.boundEntity != null) {
               this.boundEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  this.internal = capability;
                  this.bound = true;
               });
            }
         } else {
            this.boundBlockEntity = this.world.m_7702_(pos);
            if (this.boundBlockEntity != null) {
               this.boundBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                  this.internal = capability;
                  this.bound = true;
               });
            }
         }
      }

      this.customSlots.put(0, this.m_38897_(new SlotItemHandler(this.internal, 0, 7, 23) {
         private final int slot = 0;
      }));
      this.customSlots.put(1, this.m_38897_(new SlotItemHandler(this.internal, 1, 25, 50) {
         private final int slot = 1;
      }));
      this.customSlots.put(2, this.m_38897_(new SlotItemHandler(this.internal, 2, 43, 23) {
         private final int slot = 2;
      }));
      this.customSlots.put(3, this.m_38897_(new SlotItemHandler(this.internal, 3, 61, 50) {
         private final int slot = 3;
      }));
      this.customSlots.put(4, this.m_38897_(new SlotItemHandler(this.internal, 4, 79, 23) {
         private final int slot = 4;
      }));
      this.customSlots.put(5, this.m_38897_(new SlotItemHandler(this.internal, 5, 97, 50) {
         private final int slot = 5;
      }));
      this.customSlots.put(6, this.m_38897_(new SlotItemHandler(this.internal, 6, 115, 23) {
         private final int slot = 6;
      }));
      this.customSlots.put(7, this.m_38897_(new SlotItemHandler(this.internal, 7, 133, 50) {
         private final int slot = 7;
      }));
      this.customSlots.put(8, this.m_38897_(new SlotItemHandler(this.internal, 8, 151, 23) {
         private final int slot = 8;
      }));

      for(int si = 0; si < 3; ++si) {
         for(int sj = 0; sj < 9; ++sj) {
            this.m_38897_(new Slot(inv, sj + (si + 1) * 9, 8 + sj * 18, 81 + si * 18));
         }
      }

      for(int si = 0; si < 9; ++si) {
         this.m_38897_(new Slot(inv, si, 8 + si * 18, 139));
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
      ItemStack itemstack = ItemStack.f_41583_;
      Slot slot = (Slot)this.f_38839_.get(index);
      if (slot != null && slot.m_6657_()) {
         ItemStack itemstack1 = slot.m_7993_();
         itemstack = itemstack1.m_41777_();
         if (index < 9) {
            if (!this.m_38903_(itemstack1, 9, this.f_38839_.size(), true)) {
               return ItemStack.f_41583_;
            }

            slot.m_40234_(itemstack1, itemstack);
         } else if (!this.m_38903_(itemstack1, 0, 9, false)) {
            if (index < 36) {
               if (!this.m_38903_(itemstack1, 36, this.f_38839_.size(), true)) {
                  return ItemStack.f_41583_;
               }
            } else if (!this.m_38903_(itemstack1, 9, 36, false)) {
               return ItemStack.f_41583_;
            }

            return ItemStack.f_41583_;
         }

         if (itemstack1.m_41613_() == 0) {
            slot.m_5852_(ItemStack.f_41583_);
         } else {
            slot.m_6654_();
         }

         if (itemstack1.m_41613_() == itemstack.m_41613_()) {
            return ItemStack.f_41583_;
         }

         slot.m_142406_(playerIn, itemstack1);
      }

      return itemstack;
   }

   protected boolean m_38903_(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
      boolean flag = false;
      int i = p_38905_;
      if (p_38907_) {
         i = p_38906_ - 1;
      }

      if (p_38904_.m_41753_()) {
         while(!p_38904_.m_41619_()) {
            if (p_38907_) {
               if (i < p_38905_) {
                  break;
               }
            } else if (i >= p_38906_) {
               break;
            }

            Slot slot = (Slot)this.f_38839_.get(i);
            ItemStack itemstack = slot.m_7993_();
            if (slot.m_5857_(itemstack) && !itemstack.m_41619_() && ItemStack.m_150942_(p_38904_, itemstack)) {
               int j = itemstack.m_41613_() + p_38904_.m_41613_();
               int maxSize = Math.min(slot.m_6641_(), p_38904_.m_41741_());
               if (j <= maxSize) {
                  p_38904_.m_41764_(0);
                  itemstack.m_41764_(j);
                  slot.m_5852_(itemstack);
                  flag = true;
               } else if (itemstack.m_41613_() < maxSize) {
                  p_38904_.m_41774_(maxSize - itemstack.m_41613_());
                  itemstack.m_41764_(maxSize);
                  slot.m_5852_(itemstack);
                  flag = true;
               }
            }

            if (p_38907_) {
               --i;
            } else {
               ++i;
            }
         }
      }

      if (!p_38904_.m_41619_()) {
         if (p_38907_) {
            i = p_38906_ - 1;
         } else {
            i = p_38905_;
         }

         while(true) {
            if (p_38907_) {
               if (i < p_38905_) {
                  break;
               }
            } else if (i >= p_38906_) {
               break;
            }

            Slot slot1 = (Slot)this.f_38839_.get(i);
            ItemStack itemstack1 = slot1.m_7993_();
            if (itemstack1.m_41619_() && slot1.m_5857_(p_38904_)) {
               if (p_38904_.m_41613_() > slot1.m_6641_()) {
                  slot1.m_269060_(p_38904_.m_41620_(slot1.m_6641_()));
               } else {
                  slot1.m_269060_(p_38904_.m_41620_(p_38904_.m_41613_()));
               }

               slot1.m_6654_();
               flag = true;
               break;
            }

            if (p_38907_) {
               --i;
            } else {
               ++i;
            }
         }
      }

      return flag;
   }

   public void m_6877_(Player playerIn) {
      super.m_6877_(playerIn);
      if (!this.bound && playerIn instanceof ServerPlayer serverPlayer) {
         if (serverPlayer.m_6084_() && !serverPlayer.m_9232_()) {
            for(int i = 0; i < this.internal.getSlots(); ++i) {
               if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 7 && i != 8) {
                  playerIn.m_150109_().m_150079_(this.internal.extractItem(i, this.internal.getStackInSlot(i).m_41613_(), false));
               }
            }
         } else {
            for(int j = 0; j < this.internal.getSlots(); ++j) {
               if (j != 0 && j != 1 && j != 2 && j != 3 && j != 4 && j != 5 && j != 6 && j != 7 && j != 8) {
                  playerIn.m_36176_(this.internal.extractItem(j, this.internal.getStackInSlot(j).m_41613_(), false), false);
               }
            }
         }
      }

   }

   public Map<Integer, Slot> get() {
      return this.customSlots;
   }

   @EventBusSubscriber(
      bus = Bus.MOD
   )
   public static class CursedSpiritArmouryGuiOtherMessage {
      private final int mode;
      private final int x;
      private final int y;
      private final int z;
      private HashMap<String, String> textstate;

      public CursedSpiritArmouryGuiOtherMessage(FriendlyByteBuf buffer) {
         this.mode = buffer.readInt();
         this.x = buffer.readInt();
         this.y = buffer.readInt();
         this.z = buffer.readInt();
         this.textstate = readTextState(buffer);
      }

      public CursedSpiritArmouryGuiOtherMessage(int mode, int x, int y, int z, HashMap<String, String> textstate) {
         this.mode = mode;
         this.x = x;
         this.y = y;
         this.z = z;
         this.textstate = textstate;
      }

      public static void buffer(CursedSpiritArmouryGuiOtherMessage message, FriendlyByteBuf buffer) {
         buffer.writeInt(message.mode);
         buffer.writeInt(message.x);
         buffer.writeInt(message.y);
         buffer.writeInt(message.z);
         writeTextState(message.textstate, buffer);
      }

      public static void handler(CursedSpiritArmouryGuiOtherMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
         HashMap guistate = CursedSpiritArmouryGuiMenu.guistate;

         for(Map.Entry<String, String> entry : textstate.entrySet()) {
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            guistate.put(key, value);
         }

         if (world.m_46805_(new BlockPos(x, y, z))) {
            if (mode == 0) {
               CsaTickProcedure.execute(world, entity);
            }

         }
      }

      @SubscribeEvent
      public static void registerMessage(FMLCommonSetupEvent event) {
         JujutsucraftvMod.addNetworkMessage(CursedSpiritArmouryGuiOtherMessage.class, CursedSpiritArmouryGuiOtherMessage::buffer, CursedSpiritArmouryGuiOtherMessage::new, CursedSpiritArmouryGuiOtherMessage::handler);
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
