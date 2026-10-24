package net.mcreator.jujutsucraftv.network;

import io.netty.buffer.Unpooled;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class OpenJJCVPacket {
   private final int guiId;

   public OpenJJCVPacket(FriendlyByteBuf buffer) {
      this.guiId = buffer.readInt();
   }

   public OpenJJCVPacket(int guiId) {
      this.guiId = guiId;
   }

   public static void buffer(OpenJJCVPacket message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.guiId);
   }

   public static void handler(OpenJJCVPacket message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         ServerPlayer entity = context.getSender();
         if (entity != null) {
            if (!entity.getPersistentData().m_128471_("used_jjcv_changer")) {
               entity.getPersistentData().m_128379_("used_jjc_changer", true);
            }

            final BlockPos pos = entity.m_20183_();
            NetworkHooks.openScreen(entity, new MenuProvider() {
               public Component m_5446_() {
                  return Component.m_237113_("CursedTechniqueChangerVGui");
               }

               public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player p) {
                  return new CursedTechniqueChangerVGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(pos));
               }
            }, pos);
         }

      });
      context.setPacketHandled(true);
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftvMod.addNetworkMessage(OpenJJCVPacket.class, OpenJJCVPacket::buffer, OpenJJCVPacket::new, OpenJJCVPacket::handler);
   }
}
