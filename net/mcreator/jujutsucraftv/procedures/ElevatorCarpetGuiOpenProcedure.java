package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import java.text.DecimalFormat;
import net.mcreator.jujutsucraftv.world.inventory.ElevatorCarpetSettingGuiMenu;
import net.minecraft.client.Minecraft;
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

public class ElevatorCarpetGuiOpenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer _serverPlayer) {
                  return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            if (entity.m_6144_()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     DecimalFormat var10001 = new DecimalFormat("##.##");
                     double var10002 = ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : (double)-1.0F;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "up_num");
                     _player.m_5661_(Component.m_237113_("UP:" + var10001.format(var10002)), false);
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     DecimalFormat var12 = new DecimalFormat("##.##");
                     double var13 = ((<undefinedtype>)(new Object() {
                        public double getValue(LevelAccessor world, BlockPos pos, String tag) {
                           BlockEntity blockEntity = world.m_7702_(pos);
                           return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : (double)-1.0F;
                        }
                     })).getValue(world, BlockPos.m_274561_(x, y, z), "down_num");
                     _player.m_5661_(Component.m_237113_("DOWN:" + var12.format(var13)), false);
                  }
               }
            } else if (entity instanceof ServerPlayer) {
               ServerPlayer _ent = (ServerPlayer)entity;
               final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
               NetworkHooks.openScreen(_ent, new MenuProvider() {
                  public Component m_5446_() {
                     return Component.m_237113_("ElevatorCarpetSettingGui");
                  }

                  public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                     return new ElevatorCarpetSettingGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
                  }
               }, _bpos);
            }
         }

      }
   }
}
