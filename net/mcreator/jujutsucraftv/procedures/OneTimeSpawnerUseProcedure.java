package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraftv.world.inventory.OneTimeSpawnerGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkHooks;

public class OneTimeSpawnerUseProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         final BlockPos _pos = BlockPos.m_274561_(x, y, z);
         BlockEntity _be = world.m_7702_(_pos);
         if (_be != null) {
            CompoundTag nbt = _be.getPersistentData();
            if (nbt.m_128471_("selected")) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     String entityId = nbt.m_128461_("entity_id");
                     double count = nbt.m_128459_("entity_count");
                     _player.m_5661_(Component.m_237113_("Entity: " + entityId + " x" + (int)count), false);
                  }
               }
            } else if (entity instanceof ServerPlayer) {
               ServerPlayer _ent = (ServerPlayer)entity;
               NetworkHooks.openScreen(_ent, new MenuProvider() {
                  public Component m_5446_() {
                     return Component.m_237113_("OneTimeSpawnerGui");
                  }

                  public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                     return new OneTimeSpawnerGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_pos));
                  }
               }, _pos);
            }

         }
      }
   }
}
