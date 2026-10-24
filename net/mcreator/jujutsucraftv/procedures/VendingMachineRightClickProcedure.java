package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineSetGuiMenu;
import net.mcreator.jujutsucraftv.world.inventory.VendingMachineShopGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkHooks;

public class VendingMachineRightClickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!world.m_5776_()) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer serverPlayer = (ServerPlayer)entity;
               final BlockPos pos = BlockPos.m_274561_(x, y, z);
               boolean creative = serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
               if (creative && entity.m_6144_()) {
                  NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                     public Component m_5446_() {
                        return Component.m_237113_("VendingMachineSetGui");
                     }

                     public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                        return new VendingMachineSetGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(pos));
                     }
                  }, pos);
               } else {
                  if (getBoolean(world, pos, "SET0") || getBoolean(world, pos, "SET1") || getBoolean(world, pos, "SET2")) {
                     NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                        public Component m_5446_() {
                           return Component.m_237113_("VendingMachineShopGui");
                        }

                        public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                           return new VendingMachineShopGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(pos));
                        }
                     }, pos);
                  }

               }
            }
         }
      }
   }

   private static boolean getBoolean(LevelAccessor world, BlockPos pos, String tag) {
      BlockEntity blockEntity = world.m_7702_(pos);
      return blockEntity != null && blockEntity.getPersistentData().m_128471_(tag);
   }
}
