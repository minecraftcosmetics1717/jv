package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundCursePowerProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rad = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double skillnum = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         skillnum = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = XLookPositionProcedure.execute(entity, (double)3.0F);
         y_pos = YLookPositionProcedure.execute(entity, (double)3.0F);
         z_pos = ZLookPositionProcedure.execute(entity, (double)3.0F);
         double var10000 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
         if (entity.getPersistentData().m_128459_("cnt1") <= (double)1.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
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
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.75F, false);
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

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            entity.getPersistentData().m_128347_("x_pos", x);
            entity.getPersistentData().m_128347_("y_pos", y);
            entity.getPersistentData().m_128347_("z_pos", z);
            if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
               entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)(entity.m_146908_() + 70.0F)));
            } else {
               entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)(entity.m_146908_() + 90.0F)));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            entity.getPersistentData().m_128347_("sound", (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 2));
            if (entity.getPersistentData().m_128459_("sound") == (double)2.0F) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:guitar1")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:guitar1")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            } else if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:guitar3")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:guitar3")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            entity.getPersistentData().m_128347_("sound", (double)0.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)3.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)30.0F) {
            for(int index0 = 0; index0 < (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F ? 4 : 3); ++index0) {
               rad = entity.getPersistentData().m_128459_("start_r");

               for(int index1 = 0; index1 < (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F ? 3 : 1); ++index1) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * entity.getPersistentData().m_128459_("cnt_x_play") + Mth.m_216263_(RandomSource.m_216327_(), (double)-2.0F, (double)2.0F);
                  y_pos = entity.getPersistentData().m_128459_("y_pos") + Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)3.0F);
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * entity.getPersistentData().m_128459_("cnt_x_play") + Mth.m_216263_(RandomSource.m_216327_(), (double)-2.0F, (double)2.0F);

                  for(int index2 = 0; index2 < 50 && world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index2) {
                     ++y_pos;
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                     rad += Math.toRadians((double)20.0F);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, (double)0.0F);
                  }

                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)1.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     entity.getPersistentData().m_128347_("Range", (double)2.5F);
                     entity.getPersistentData().m_128347_("knockback", 0.2);
                     entity.getPersistentData().m_128347_("Damage", (double)17.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }

               entity.getPersistentData().m_128347_("cnt_x_play", entity.getPersistentData().m_128459_("cnt_x_play") + (double)0.5F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)30.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt_x_play", (double)0.0F);
            entity.getPersistentData().m_128347_("start_r", (double)0.0F);
         }

      }
   }
}
