package net.mcreator.jujutsucraftv.network;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.client.gui.VendingMachineShopGuiSyncClientHandler;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect0Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect1Procedure;
import net.mcreator.jujutsucraftv.procedures.VendingMachineSelect2Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class VendingMachineShopGuiSyncMessage {
   private final int x;
   private final int y;
   private final int z;
   private final ArrayList<ItemStack> stacks;
   private final boolean select0;
   private final boolean select1;
   private final boolean select2;

   public VendingMachineShopGuiSyncMessage(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.stacks = new ArrayList();
      this.select0 = false;
      this.select1 = false;
      this.select2 = false;
   }

   public VendingMachineShopGuiSyncMessage(int x, int y, int z, List<ItemStack> stacks, boolean select0, boolean select1, boolean select2) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.stacks = new ArrayList();

      for(ItemStack stack : stacks) {
         this.stacks.add(stack == null ? ItemStack.f_41583_ : stack.m_41777_());
      }

      this.select0 = select0;
      this.select1 = select1;
      this.select2 = select2;
   }

   public VendingMachineShopGuiSyncMessage(FriendlyByteBuf buffer) {
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.select0 = buffer.readBoolean();
      this.select1 = buffer.readBoolean();
      this.select2 = buffer.readBoolean();
      this.stacks = new ArrayList();
      int size = buffer.readInt();

      for(int i = 0; i < size; ++i) {
         this.stacks.add(buffer.m_130267_());
      }

   }

   public static void buffer(VendingMachineShopGuiSyncMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      buffer.writeBoolean(message.select0);
      buffer.writeBoolean(message.select1);
      buffer.writeBoolean(message.select2);
      buffer.writeInt(message.stacks.size());

      for(ItemStack stack : message.stacks) {
         buffer.m_130055_(stack == null ? ItemStack.f_41583_ : stack.m_41777_());
      }

   }

   public static void handler(VendingMachineShopGuiSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         Player sender = context.getSender();
         if (sender instanceof ServerPlayer serverPlayer) {
            sendTo(serverPlayer, new BlockPos(message.x, message.y, message.z));
         } else {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> VendingMachineShopGuiSyncClientHandler.handle(message));
         }

      });
      context.setPacketHandled(true);
   }

   public static void sendTo(ServerPlayer player, BlockPos pos) {
      if (player != null && pos != null) {
         if (!player.m_9236_().m_5776_()) {
            if (player.m_9236_().m_46805_(pos)) {
               ArrayList<ItemStack> stacks = new ArrayList();

               for(int i = 0; i < 6; ++i) {
                  stacks.add(ItemStack.f_41583_);
               }

               BlockEntity blockEntity = player.m_9236_().m_7702_(pos);
               if (blockEntity != null) {
                  blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                     for(int i = 0; i < 6; ++i) {
                        if (i < capability.getSlots()) {
                           stacks.set(i, capability.getStackInSlot(i).m_41777_());
                        } else {
                           stacks.set(i, ItemStack.f_41583_);
                        }
                     }

                  });
               }

               boolean select0 = VendingMachineSelect0Procedure.execute(player.m_9236_(), (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
               boolean select1 = VendingMachineSelect1Procedure.execute(player.m_9236_(), (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
               boolean select2 = VendingMachineSelect2Procedure.execute(player.m_9236_(), (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_());
               JujutsucraftvMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new VendingMachineShopGuiSyncMessage(pos.m_123341_(), pos.m_123342_(), pos.m_123343_(), stacks, select0, select1, select2));
            }
         }
      }
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getZ() {
      return this.z;
   }

   public List<ItemStack> getStacks() {
      return this.stacks;
   }

   public boolean isSelect0() {
      return this.select0;
   }

   public boolean isSelect1() {
      return this.select1;
   }

   public boolean isSelect2() {
      return this.select2;
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(VendingMachineShopGuiSyncMessage.class, VendingMachineShopGuiSyncMessage::buffer, VendingMachineShopGuiSyncMessage::new, VendingMachineShopGuiSyncMessage::handler);
   }
}
