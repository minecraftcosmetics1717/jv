package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraftv.world.inventory.CursedTechniqueChangerVGui2Menu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class CursedTechniqueChangerVGui2OpenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("used_jjc_changer", false);
         if (entity instanceof ServerPlayer) {
            ServerPlayer _ent = (ServerPlayer)entity;
            final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
            NetworkHooks.openScreen(_ent, new MenuProvider() {
               public Component m_5446_() {
                  return Component.m_237113_("CursedTechniqueChangerVGui2");
               }

               public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                  return new CursedTechniqueChangerVGui2Menu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
               }
            }, _bpos);
         }

      }
   }
}
