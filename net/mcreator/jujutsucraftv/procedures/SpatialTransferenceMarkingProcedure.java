package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SpatialTransferenceMarkingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (GetFlagShiftProcedure.execute(entity)) {
            entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
         } else {
            entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)3.0F) {
            if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:strike_wood")), SoundSource.NEUTRAL, 1.0F, 2.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:strike_wood")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
                  }
               }

               ShowSlotPosProcedure.execute(entity, (double)GetPlayerSelectSlotProcedure.execute(entity));
            } else {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:strike_wood")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:strike_wood")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               SetSlotPosProcedure.execute(entity, (double)GetPlayerSelectSlotProcedure.execute(entity));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            entity.getPersistentData().m_128359_("pos", "");
         }

      }
   }
}
