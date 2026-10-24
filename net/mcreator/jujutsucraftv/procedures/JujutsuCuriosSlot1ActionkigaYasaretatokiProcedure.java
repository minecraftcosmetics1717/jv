package net.mcreator.jujutsucraftv.procedures;

import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.world.inventory.CursedSpiritArmouryGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import top.theillusivec4.curios.api.CuriosApi;

public class JujutsuCuriosSlot1ActionkigaYasaretatokiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity lv = (LivingEntity)entity;
            if (CuriosApi.getCuriosHelper().findEquippedCurio((Item)JujutsucraftvModItems.TRAINED_CURSED_SPIRIT_ARMORY.get(), lv).isPresent()) {
               if (!entity.m_6144_()) {
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _ent = (ServerPlayer)entity;
                     final BlockPos _bpos = BlockPos.m_274561_(x, y, z);
                     NetworkHooks.openScreen(_ent, new MenuProvider() {
                        public Component m_5446_() {
                           return Component.m_237113_("CursedSpiritArmouryGui");
                        }

                        public AbstractContainerMenu m_7208_(int id, Inventory inventory, Player player) {
                           return new CursedSpiritArmouryGuiMenu(id, inventory, (new FriendlyByteBuf(Unpooled.buffer())).m_130064_(_bpos));
                        }
                     }, _bpos);
                  }

                  CsaOpenProcedure.execute(world, entity);
               } else {
                  CsaChangeProcedure.execute(world, x, y, z, entity);
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity lv = (LivingEntity)entity;
            if (CuriosApi.getCuriosHelper().findEquippedCurio((Item)JujutsucraftvModItems.NANAMI_WRISTWATCH.get(), lv).isPresent()) {
               NanamiWristwatchUseProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
