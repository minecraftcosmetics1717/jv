package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetEntityGroundDistanceProcedure {
   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

         while(pos.m_123342_() > world.m_141937_() && !world.m_8055_(pos).m_60815_()) {
            pos.m_122184_(0, -1, 0);
         }

         return entity.m_20186_() - (double)pos.m_123342_();
      }
   }
}
