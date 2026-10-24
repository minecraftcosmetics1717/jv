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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillTest1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6 + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.m_20205_());
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }

            if (!(entity instanceof Player) && entity.getPersistentData().m_128459_("cnt6_rnd") == (double)0.0F) {
               if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 1) {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)5.0F);
               } else {
                  entity.getPersistentData().m_128347_("cnt6_rnd", (double)1.0F);
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && !(entity.getPersistentData().m_128459_("cnt6") >= entity.getPersistentData().m_128459_("cnt6_rnd")) && !(entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F)) {
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
                     _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().m_128459_("cnt6") + (double)1.0F), (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
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
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123808_, x_pos, y_pos, z_pos, 20, (double)0.5F, (double)0.5F, (double)0.5F, 0.1);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)60.0F) {
            entity.getPersistentData().m_128347_("count", entity.getPersistentData().m_128459_("count") + (double)1.0F);
            if (entity.getPersistentData().m_128459_("count") >= (double)5.0F) {
               entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)5.0F);
               entity.getPersistentData().m_128379_("noParticle", true);
               entity.getPersistentData().m_128347_("Range", (double)2.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("Damage", (double)10.0F);
               DisplayBeamGenerator2Procedure.execute(world, entity, true, true, false, true, true, (double)5.0F, 0.2, (double)0.5F, 0.1, (double)5.0F, 0.1, x_pos, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_(), y_pos, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_(), z_pos, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_(), (double)2.0F, "jujutsucraftv:particle_flame_dust_transition 1.000 0.624 0.129 1 0.286 0.259 1.000");
               entity.getPersistentData().m_128347_("count", (double)0.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)70.0F) {
            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt6_rnd", (double)0.0F);
            }

            entity.getPersistentData().m_128347_("count", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
