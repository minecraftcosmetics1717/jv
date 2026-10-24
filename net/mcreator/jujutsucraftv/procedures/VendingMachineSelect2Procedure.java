package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

public class VendingMachineSelect2Procedure {
   public static boolean execute(LevelAccessor world, double x, double y, double z) {
      return ((<undefinedtype>)(new Object() {
         public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128471_(tag) : false;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "SET2");
   }
}
