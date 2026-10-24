package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;

public class OpenJJCCursedTechniqueGuiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().m_128471_("used_jjc_changer")) {
            entity.getPersistentData().m_128379_("used_jjcv_changer", true);
            if (CheckHaveItemProcedure.execute(world, entity, new ItemStack((ItemLike)JujutsucraftModItems.CURSED_TECHNIQUE_CHANGER.get()))) {
               entity.getPersistentData().m_128379_("have_jjc_changer", true);
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_6915_();
         }

         if (entity instanceof ServerPlayer) {
            ServerPlayer _ent = (ServerPlayer)entity;
            final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
            NetworkHooks.openScreen(_ent, new MenuProvider() {
               public Component m_5446_() {
                  return Component.m_237113_("SelectTechnique");
               }

               public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                  return new SelectTechniqueMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
               }
            }, _bpos);
         }

      }
   }
}
