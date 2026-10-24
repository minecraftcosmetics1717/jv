package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillRouzetsuDismantleAroundProcedure {
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
         x_pos = XLookPositionProcedure.execute(entity, (double)3.0F);
         y_pos = YLookPositionProcedure.execute(entity, (double)3.0F);
         z_pos = ZLookPositionProcedure.execute(entity, (double)3.0F);
         double var10000 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
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

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            entity.getPersistentData().m_128347_("x_pos", x);
            entity.getPersistentData().m_128347_("y_pos", y);
            entity.getPersistentData().m_128347_("z_pos", z);
            entity.getPersistentData().m_128347_("particle_size", 0.3);
            entity.getPersistentData().m_128347_("start_r", Math.toRadians((double)(entity.m_146908_() + 90.0F)));
            entity.getPersistentData().m_128347_("break_count", (double)0.0F);
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)4.0F);
            PlayAnimationProcedure.execute(world, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:slash2")), SoundSource.NEUTRAL, 1.0F, 0.7F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:slash2")), SoundSource.NEUTRAL, 1.0F, 0.7F, false);
               }
            }
         }

         if ((entity.getPersistentData().m_128459_("cnt1") == (double)10.0F || entity.getPersistentData().m_128459_("cnt1") == (double)20.0F || entity.getPersistentData().m_128459_("cnt1") == (double)30.0F) && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos")), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:stone_crash")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, 1.2));
            } else {
               _level.m_7785_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:stone_crash")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.8, 1.2), false);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)3.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)15.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            for(int index0 = 0; index0 < 15; ++index0) {
               rad = entity.getPersistentData().m_128459_("start_r");

               for(int index1 = 0; index1 < 8; ++index1) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * entity.getPersistentData().m_128459_("cnt_x_play");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * entity.getPersistentData().m_128459_("cnt_x_play");

                  for(int index2 = 0; index2 < 50; ++index2) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        ++y_pos;
                     } else {
                        if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - (double)1.0F, z_pos)).m_60815_()) {
                           y_pos = Math.floor(y_pos);
                           break;
                        }

                        --y_pos;
                     }
                  }

                  rad += Math.toRadians((double)45.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var48 = _level.m_7654_().m_129892_();
                     CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     CompoundTag var10002 = entity.getPersistentData();
                     var48.m_230957_(var10001, "particle jujutsucraftv:particle_vertical_impact_dust 1 1 1 " + var10002.m_128459_("particle_size") + " ~ ~ ~ 0.3 0 0.3 0 3 force");
                  }

                  if (entity.getPersistentData().m_128459_("break_count") > (double)10.0F) {
                     entity.getPersistentData().m_128347_("BlockDamage", (double)4.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                     entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
                     BlockDestroyAllDirectionVProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)1.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     entity.getPersistentData().m_128347_("Range", (double)4.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                     entity.getPersistentData().m_128347_("knockback", 0.8);
                     entity.getPersistentData().m_128347_("Damage", (double)23.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }

               if (entity.getPersistentData().m_128459_("break_count") > (double)10.0F) {
                  entity.getPersistentData().m_128347_("break_count", (double)0.0F);
               } else {
                  entity.getPersistentData().m_128347_("break_count", entity.getPersistentData().m_128459_("break_count") + (double)1.0F);
               }

               entity.getPersistentData().m_128347_("particle_size", entity.getPersistentData().m_128459_("particle_size") + 0.01);
               entity.getPersistentData().m_128347_("cnt_x_play", entity.getPersistentData().m_128459_("cnt_x_play") + 0.175);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)60.0F) {
            entity.getPersistentData().m_128347_("cnt1", (double)0.0F);
            entity.getPersistentData().m_128347_("cnt_x_play", (double)0.0F);
            entity.getPersistentData().m_128347_("start_r", (double)0.0F);
            entity.getPersistentData().m_128347_("particle_size", (double)0.0F);
            entity.getPersistentData().m_128347_("break_count", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
