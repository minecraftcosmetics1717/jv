package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraftv.world.inventory.CursePowerColorChangerGuiMenu;
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

public class CursePowerColorChangerUseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) != (double)-1.0F) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer _ent = (ServerPlayer)entity;
               final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
               NetworkHooks.openScreen(_ent, new MenuProvider() {
                  public Component m_5446_() {
                     return Component.m_237113_("CursePowerColorChangerGui");
                  }

                  public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                     return new CursePowerColorChangerGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
                  }
               }, _bpos);
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
            }
         }

      }
   }
}
