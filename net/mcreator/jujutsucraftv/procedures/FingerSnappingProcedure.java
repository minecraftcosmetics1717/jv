package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class FingerSnappingProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rad = (double)0.0F;
         double skillnum = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F && entity.getPersistentData().m_128471_("PRESS_Z")) {
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (!_livEnt.m_21220_().isEmpty()) {
                  int cooldownTicks = entity.getPersistentData().m_128451_("COOLDOWN_TICKS");
                  if (cooldownTicks > 0) {
                     _livEnt.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), cooldownTicks, 0, false, false));
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123808_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, x, y + (double)entity.m_20206_() * (double)0.5F, z, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
            }

            if (entity.getPersistentData().m_128459_("cnt6") < (double)5.0F) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - (double)1.0F;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }

               if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123808_, x, y + (double)entity.m_20206_() * (double)0.5F, z, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:finger_snap2")), SoundSource.NEUTRAL, 5.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:finger_snap2")), SoundSource.NEUTRAL, 5.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:finger_snap")), SoundSource.NEUTRAL, 3.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:finger_snap")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
               }
            }

            for(int index0 = 0; index0 < (int)(entity.getPersistentData().m_128459_("cnt6") * (double)5.0F); ++index0) {
               DisplayParticleGeneratorProcedure.execute(world, (double)0.0F, (double)3.0F, (double)0.0F, (double)2.0F, x, x + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F * entity.getPersistentData().m_128459_("cnt6") * (double)5.0F, entity.getPersistentData().m_128459_("cnt6") * (double)5.0F), y + (double)entity.m_20206_() * (double)0.5F, y + Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, entity.getPersistentData().m_128459_("cnt6") * (double)5.0F), z, z + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F * entity.getPersistentData().m_128459_("cnt6") * (double)5.0F, entity.getPersistentData().m_128459_("cnt6") * (double)5.0F), "jujutsucraftv:particle_note");
            }

            entity.getPersistentData().m_128347_("Range", (double)6.0F + entity.getPersistentData().m_128459_("cnt6"));
            entity.getPersistentData().m_128347_("knockback", (double)0.5F);
            entity.getPersistentData().m_128347_("Damage", (double)13.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
            RangeAttackVProcedure.execute(world, x, y, z, entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)3.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt_x_play", (double)0.0F);
         }

      }
   }
}
