package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.PlojectileDarknessEntity;
import net.mcreator.jujutsucraftv.entity.PlojectileLightEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileLightTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos2 = (double)0.0F;
         double CNT6 = (double)0.0F;
         double x_pos3 = (double)0.0F;
         double x_pos = (double)0.0F;
         double z_pos3 = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos3 = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double yaw = (double)0.0F;
         double Damage = (double)0.0F;
         double size = (double)0.0F;
         double block_size = (double)0.0F;
         double x_look = (double)0.0F;
         double y_look = (double)0.0F;
         double z_look = (double)0.0F;
         if ((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity && (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")).getPersistentData().m_128459_("skill") == (double)0.0F && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         if (!((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         if (entity.getPersistentData().m_128459_("light_type") != (double)4.0F) {
            entity.m_6021_(entity.getPersistentData().m_128459_("x_pos_set"), entity.getPersistentData().m_128459_("y_pos_set"), entity.getPersistentData().m_128459_("z_pos_set"));
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos_set"), entity.getPersistentData().m_128459_("y_pos_set"), entity.getPersistentData().m_128459_("z_pos_set"), entity.m_146908_(), entity.m_146909_());
            }

            entity.m_7618_(Anchor.EYES, new Vec3(entity.getPersistentData().m_128459_("x_look"), entity.getPersistentData().m_128459_("y_look"), entity.getPersistentData().m_128459_("z_look")));
         }

         if (entity.getPersistentData().m_128459_("light_type") == (double)2.0F) {
            if (entity.getPersistentData().m_128459_("ACT") == (double)5.0F) {
               entity.getPersistentData().m_128347_("ACT_RND", Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F));
               entity.getPersistentData().m_128347_("cnt_a", (double)0.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), (int)((double)10.0F + entity.getPersistentData().m_128459_("ACT_RND")), 1, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("ACT", (double)6.0F);
            } else if (entity.getPersistentData().m_128459_("ACT") == (double)6.0F) {
               if (!(entity.getPersistentData().m_128459_("ACT_RND") <= entity.getPersistentData().m_128459_("cnt_a"))) {
                  entity.getPersistentData().m_128347_("cnt_a", entity.getPersistentData().m_128459_("cnt_a") + (double)0.25F);
               } else {
                  entity.getPersistentData().m_128347_("ACT", (double)10.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("ACT") == (double)10.0F) {
            if (entity.getPersistentData().m_128459_("light_type") == (double)1.0F || entity.getPersistentData().m_128459_("light_type") == (double)2.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
               entity.getPersistentData().m_128347_("Range", (double)2.5F + (double)2.0F * entity.getPersistentData().m_128459_("cnt6"));
               entity.getPersistentData().m_128347_("knockback", 0.1);
               entity.getPersistentData().m_128347_("BlockRange", (double)2.0F + (double)1.0F * entity.getPersistentData().m_128459_("cnt6"));
               entity.getPersistentData().m_128347_("BlockDamage", (double)5.0F + (double)1.0F * entity.getPersistentData().m_128459_("cnt6"));
               entity.getPersistentData().m_128379_("noEffect", true);
               entity.getPersistentData().m_128379_("noParticle", true);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F));
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F), false);
                  }
               }

               if (entity.getPersistentData().m_128459_("light_type") == (double)2.0F) {
                  x_look = XLookPositionPenetrationProcedure.execute(entity, (double)100.0F) + entity.getPersistentData().m_128459_("x_plus");
                  y_look = YLookPositionPenetrationProcedure.execute(entity, (double)100.0F) + entity.getPersistentData().m_128459_("y_plus");
                  z_look = ZLookPositionPenetrationProcedure.execute(entity, (double)100.0F) + entity.getPersistentData().m_128459_("z_plus");
               } else {
                  x_look = XLookPositionPenetrationProcedure.execute(entity, (double)100.0F);
                  y_look = YLookPositionPenetrationProcedure.execute(entity, (double)100.0F);
                  z_look = ZLookPositionPenetrationProcedure.execute(entity, (double)100.0F);
               }

               for(int index0 = 0; index0 < 10; ++index0) {
                  DisplayParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F), x_pos, x_look, y_pos, y_look, z_pos, z_look, "jujutsucraftv:particle_light_large_red");
               }

               DisplayBeamGenerator2Procedure.execute(world, entity, true, true, false, true, true, (double)5.0F, 0.2, (double)0.5F, 0.15 * entity.getPersistentData().m_128459_("cnt6"), (double)300.0F, 0.15 * entity.getPersistentData().m_128459_("cnt6"), x_pos, x_look, y_pos, y_look, z_pos, z_look, (double)0.0F, "jujutsucraftv:particle_light_ash_red");
               entity.getPersistentData().m_128347_("ACT", (double)15.0F);
               JujutsucraftvMod.queueServerWork(20, () -> entity.getPersistentData().m_128379_("ACT_OFF", true));
            }

            if (entity.getPersistentData().m_128459_("light_type") == (double)3.0F) {
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
               z_pos = entity.m_20189_();
               entity.getPersistentData().m_128347_("Range", (double)2.0F);
               entity.getPersistentData().m_128347_("knockback", (double)0.0F);
               entity.getPersistentData().m_128347_("BlockRange", (double)2.0F);
               entity.getPersistentData().m_128347_("BlockDamage", (double)5.0F);
               entity.getPersistentData().m_128379_("noEffect", true);
               entity.getPersistentData().m_128379_("noParticle", true);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F));
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.0F), false);
                  }
               }

               x_look = XLookPositionPenetrationProcedure.execute(entity, (double)100.0F) + entity.getPersistentData().m_128459_("x_plus");
               y_look = YLookPositionPenetrationProcedure.execute(entity, (double)100.0F) + entity.getPersistentData().m_128459_("y_plus");
               z_look = ZLookPositionPenetrationProcedure.execute(entity, (double)100.0F) + entity.getPersistentData().m_128459_("z_plus");

               for(int index1 = 0; index1 < 10; ++index1) {
                  DisplayParticleGeneratorProcedure.execute(world, (double)0.0F, (double)1.0F, (double)0.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.8, (double)1.0F), x_pos, x_look, y_pos, y_look, z_pos, z_look, "jujutsucraftv:particle_light_large_red");
               }

               DisplayBeamGenerator2Procedure.execute(world, entity, true, true, false, true, true, (double)10.0F, 0.3, (double)1.0F, 0.1, (double)300.0F, 0.1, x_pos, x_look, y_pos, y_look, z_pos, z_look, (double)0.0F, "jujutsucraftv:particle_light_ash_red");
               entity.getPersistentData().m_128347_("ACT", (double)15.0F);
               JujutsucraftvMod.queueServerWork(20, () -> entity.getPersistentData().m_128379_("ACT_OFF", true));
            }

            if (entity.getPersistentData().m_128459_("light_type") > (double)0.0F) {
               if (entity.getPersistentData().m_128459_("light_type") == (double)4.0F) {
                  entity.getPersistentData().m_128347_("cnt_y", entity.getPersistentData().m_128459_("cnt_y") + (double)1.0F);
                  entity.getPersistentData().m_128347_("cnt_z", entity.getPersistentData().m_128459_("cnt_z") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_y") == (double)1.0F) {
                     entity.getPersistentData().m_128347_("size", (double)3.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam2")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam2")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (entity instanceof PlojectileLightEntity) {
                        ((PlojectileLightEntity)entity).setAnimation("act");
                     }

                     if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt_z_max", (double)5.0F);
                     } else {
                        entity.getPersistentData().m_128347_("cnt_z_max", (double)10.0F);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_y") > (double)1.0F && entity.getPersistentData().m_128459_("cnt_y") < (double)51.0F) {
                     if (entity.getPersistentData().m_128459_("cnt_y") == (double)5.0F) {
                        Damage = (double)35.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.2);
                        entity.getPersistentData().m_128347_("Range", (double)20.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                        entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                        entity.getPersistentData().m_128347_("Damage", Damage);
                        RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     }

                     if (entity.getPersistentData().m_128459_("cnt_y") == (double)15.0F) {
                        Damage = (double)20.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);
                        entity.getPersistentData().m_128347_("Range", (double)40.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                        entity.getPersistentData().m_128347_("knockback", (double)1.0F);
                        entity.getPersistentData().m_128347_("Damage", Damage);
                        RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     }

                     if (entity.getPersistentData().m_128459_("cnt_y") == (double)30.0F) {
                        Damage = (double)15.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1);
                        entity.getPersistentData().m_128347_("Range", (double)40.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                        entity.getPersistentData().m_128347_("knockback", (double)1.5F);
                        entity.getPersistentData().m_128347_("Damage", Damage);
                        RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_LARGE_RED.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 200, (double)50.0F, (double)50.0F, (double)50.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.1, 0.3));
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED.get(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), 200, (double)50.0F, (double)50.0F, (double)50.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.3, (double)0.5F));
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle jujutsucraftv:particle_light_vertical_red ~ ~ ~ 30 5 30 0 10 force");
                     }

                     if (entity.getPersistentData().m_128459_("cnt_z") == entity.getPersistentData().m_128459_("cnt_z_max")) {
                        block_size = entity.getPersistentData().m_128459_("BlockRange");
                        entity.getPersistentData().m_128347_("BlockRange", Math.min(block_size, (double)36.0F));
                        entity.getPersistentData().m_128347_("BlockDamage", (double)24.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                        entity.getPersistentData().m_128379_("noEffect", true);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        BlockDestroyAllDirectionVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                        block_size += (double)5.0F;
                        entity.getPersistentData().m_128347_("BlockRange", block_size);
                        entity.getPersistentData().m_128347_("cnt_z", (double)0.0F);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_y") > (double)100.0F) {
                     entity.getPersistentData().m_128347_("ACT", (double)15.0F);
                     entity.getPersistentData().m_128379_("ACT_OFF", true);
                  }
               }

               if (entity.getPersistentData().m_128459_("light_type") == (double)5.0F) {
                  entity.getPersistentData().m_128347_("cnt_y", entity.getPersistentData().m_128459_("cnt_y") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_y") == (double)1.0F) {
                     if (entity instanceof PlojectileDarknessEntity) {
                        ((PlojectileDarknessEntity)entity).setAnimation("act");
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:suction1")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:suction1")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt_y") > (double)1.0F && entity.getPersistentData().m_128459_("cnt_y") < (double)31.0F) {
                     Damage = (double)15.0F + entity.getPersistentData().m_128459_("DamageAdd");
                     entity.getPersistentData().m_128347_("Range", (double)20.0F * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                     entity.getPersistentData().m_128347_("knockback", (double)0.0F);
                     entity.getPersistentData().m_128347_("Damage", Damage * ((double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1));
                     RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123783_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), 100, (double)5.0F, (double)5.0F, (double)5.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.05, 0.15));
                     }

                     entity.getPersistentData().m_128347_("BlockRange", (double)20.0F);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)15.0F);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     entity.getPersistentData().m_128347_("DamageAdd", entity.getPersistentData().m_128459_("DamageAdd") + (double)0.5F);
                  }

                  if (entity.getPersistentData().m_128459_("cnt_y") > (double)60.0F) {
                     entity.getPersistentData().m_128347_("ACT", (double)15.0F);
                     entity.getPersistentData().m_128379_("ACT_OFF", true);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("ACT", (double)15.0F);
               entity.getPersistentData().m_128379_("ACT_OFF", true);
            }
         }

         if (entity.getPersistentData().m_128471_("ACT_OFF")) {
            JujutsucraftvMod.queueServerWork(20, () -> {
               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }

            });
         }

      }
   }
}
