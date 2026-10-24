package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.entity.PlojectileLightTowerEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PlojectileLightTowerTickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double y_minus = (double)0.0F;
         if (((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) == null || !((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity)) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.MOTION.get());
         }

         if (!entity.getPersistentData().m_128471_("set_data")) {
            y_minus = entity.m_20186_();
            entity.m_6021_(entity.m_20185_(), y_minus, entity.m_20189_());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), y_minus, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
            }

            entity.getPersistentData().m_128379_("set_data", true);
         } else {
            if (entity.getPersistentData().m_128459_("attack1") == (double)1.0F) {
               entity.getPersistentData().m_128347_("cntx", entity.getPersistentData().m_128459_("cntx") + (double)1.0F);
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator != entity && entity instanceof LivingEntity && !(entity instanceof ItemEntity) && entityiterator.m_20149_().equals(entity.getPersistentData().m_128461_("TARGET_UUID")) && !(entityiterator instanceof PlojectileLightTowerEntity) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                     entityiterator.m_6021_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_());
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), entityiterator.m_146908_(), entityiterator.m_146909_());
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.IMMOBILIZED.get(), 60, 1, false, false, true));
                        }
                     }

                     if (entity.getPersistentData().m_128459_("cntx") == (double)5.0F) {
                        entity.getPersistentData().m_128347_("Damage", (double)5.0F);
                        entity.getPersistentData().m_128347_("Range", (double)1.0F);
                        RangeAttackVProcedure.execute(world, entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), entity);
                        entity.getPersistentData().m_128347_("cntx", (double)0.0F);
                     }
                  }
               }
            }

            label62: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt35 = (LivingEntity)entity;
                  if (_livEnt35.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                     break label62;
                  }
               }

               JujutsucraftvMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED.get(), x, y, z, 150, (double)2.0F, (double)(2.0F + entity.m_20206_()), (double)2.0F, 0.3);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), x, y, z, 100, (double)1.0F, (double)(2.0F + entity.m_20206_()), (double)1.0F, 0.3);
                  }

                  for(int index0 = 0; index0 < Mth.m_216271_(RandomSource.m_216327_(), 5, 7); ++index0) {
                     if (world instanceof Level _level) {
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7, 1.3));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7, 1.3), false);
                        }
                     }
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

               });
            }

            float var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21223_();
            } else {
               var10000 = -1.0F;
            }

            if (var10000 == 0.0F) {
               JujutsucraftvMod.queueServerWork(10, () -> {
                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED.get(), x, y, z, 150, (double)2.0F, (double)(2.0F + entity.m_20206_()), (double)2.0F, 0.3);
                  }

                  if (world instanceof ServerLevel _level) {
                     _level.m_8767_((SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), x, y, z, 100, (double)1.0F, (double)(2.0F + entity.m_20206_()), (double)1.0F, 0.3);
                  }

                  for(int index1 = 0; index1 < Mth.m_216271_(RandomSource.m_216327_(), 5, 7); ++index1) {
                     if (world instanceof Level _level) {
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7, 1.3));
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 0.7, 1.3), false);
                        }
                     }
                  }

                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

               });
            }
         }

      }
   }
}
