package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillDoodle1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 4, 255, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") > (double)1.0F) {
            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = entity.m_20185_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-7.0F, (double)7.0F);
               y_pos = entity.m_20186_() + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)7.0F);
               z_pos = entity.m_20189_() + Mth.m_216263_(RandomSource.m_216327_(), (double)-7.0F, (double)7.0F);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSED_TEXT_1.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F, entity.m_20189_(), 5, (double)0.25F, (double)0.75F, (double)0.25F, 0.3);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSED_TEXT_2.get(), x_pos, y_pos, z_pos, 0, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 4, (double)0.0F, (double)0.0F, (double)0.0F, 0.1);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.cartography_table.take_result")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.cartography_table.take_result")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.break")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.break")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("Range", (double)5.0F);
               entity.getPersistentData().m_128347_("Damage", (double)10.0F);
               RangeAttackVProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)20.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
