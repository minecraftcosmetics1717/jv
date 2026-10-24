package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SummonBlockMainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
      if (blockstate.m_60734_() == JujutsucraftvModBlocks.NOSTALGIST_HAND.get()) {
         world.m_7731_(BlockPos.m_274561_(x, y, z), Blocks.f_50016_.m_49966_(), 3);
         JujutsucraftvMod.queueServerWork(1, () -> {
            if (world instanceof ServerLevel _serverLevel) {
               Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SUMMON.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                  entityinstance.getPersistentData().m_128347_("summon", (double)1.0F);
                  entityinstance.getPersistentData().m_128379_("data_set", true);
                  _serverLevel.m_7967_(entityinstance);
               }
            }

         });
      }

   }
}
