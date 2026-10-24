package net.mcreator.jujutsucraftv.procedures;

import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class VendingMachineSetOpenProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         BlockEntity blockEntity = world.m_7702_(BlockPos.m_274561_(x, y, z));
         if (blockEntity != null) {
            for(int i = 0; i < 6; ++i) {
               loadSlotFromBlock(blockEntity, entity, i, i);
            }

            if (entity instanceof Player) {
               Player player = (Player)entity;
               player.f_36096_.m_38946_();
            }

         }
      }
   }

   private static void loadSlotFromBlock(BlockEntity blockEntity, Entity entity, int blockSlot, int guiSlot) {
      if (entity instanceof Player player) {
         AbstractContainerMenu var6 = player.f_36096_;
         if (var6 instanceof Supplier supplier) {
            Object var7 = supplier.get();
            if (var7 instanceof Map slots) {
               if (slots.containsKey(guiSlot)) {
                  Object var8 = slots.get(guiSlot);
                  if (var8 instanceof Slot) {
                     Slot slot = (Slot)var8;
                     blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (blockSlot >= 0 && blockSlot < capability.getSlots()) {
                           ItemStack stack = capability.getStackInSlot(blockSlot).m_41777_();
                           slot.m_5852_(stack);
                        }

                     });
                  }
               }
            }
         }
      }
   }
}
