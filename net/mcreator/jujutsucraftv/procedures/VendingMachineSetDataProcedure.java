package net.mcreator.jujutsucraftv.procedures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandlerModifiable;

public class VendingMachineSetDataProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         if (!world.m_5776_()) {
            BlockPos pos = BlockPos.m_274561_(x, y, z);
            BlockEntity blockEntity = world.m_7702_(pos);
            if (blockEntity != null) {
               boolean set0 = isChecked(guistate, "checkboxin:set0");
               boolean set1 = isChecked(guistate, "checkboxin:set1");
               boolean set2 = isChecked(guistate, "checkboxin:set2");
               if (set0) {
                  saveSlotToBlock(blockEntity, entity, 0, 0);
                  saveSlotToBlock(blockEntity, entity, 3, 3);
               }

               if (set1) {
                  saveSlotToBlock(blockEntity, entity, 1, 1);
                  saveSlotToBlock(blockEntity, entity, 4, 4);
               }

               if (set2) {
                  saveSlotToBlock(blockEntity, entity, 2, 2);
                  saveSlotToBlock(blockEntity, entity, 5, 5);
               }

               blockEntity.getPersistentData().m_128379_("SET0", set0);
               blockEntity.getPersistentData().m_128379_("SET1", set1);
               blockEntity.getPersistentData().m_128379_("SET2", set2);
               blockEntity.m_6596_();
               if (world instanceof Level) {
                  Level level = (Level)world;
                  BlockState state = world.m_8055_(pos);
                  level.m_7260_(pos, state, state, 3);
               }

            }
         }
      }
   }

   private static boolean isChecked(HashMap guistate, String key) {
      return guistate.containsKey(key) && "true".equals(String.valueOf(guistate.get(key)));
   }

   private static void saveSlotToBlock(BlockEntity blockEntity, Entity entity, int guiSlot, int blockSlot) {
      if (entity instanceof Player player) {
         AbstractContainerMenu var6 = player.f_36096_;
         if (var6 instanceof Supplier supplier) {
            Object var7 = supplier.get();
            if (var7 instanceof Map slots) {
               if (slots.containsKey(guiSlot)) {
                  Object var8 = slots.get(guiSlot);
                  if (var8 instanceof Slot) {
                     Slot slot = (Slot)var8;
                     ItemStack var11 = slot.m_7993_().m_41777_();
                     blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable modifiable) {
                           if (blockSlot >= 0 && blockSlot < capability.getSlots()) {
                              modifiable.setStackInSlot(blockSlot, var11);
                              blockEntity.m_6596_();
                           }
                        }

                     });
                  }
               }
            }
         }
      }
   }
}
