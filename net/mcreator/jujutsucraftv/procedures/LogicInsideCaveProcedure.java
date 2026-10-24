package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;

public class LogicInsideCaveProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         LevelAccessor world = entity.m_9236_();
         BlockPos pos = entity.m_20183_();
         if (!world.m_6042_().f_223549_()) {
            return false;
         } else {
            int surfaceY = world.m_6924_(Types.MOTION_BLOCKING_NO_LEAVES, pos.m_123341_(), pos.m_123343_());
            if (world.m_45527_(pos)) {
               return false;
            } else {
               return pos.m_123342_() < surfaceY - 2;
            }
         }
      }
   }
}
