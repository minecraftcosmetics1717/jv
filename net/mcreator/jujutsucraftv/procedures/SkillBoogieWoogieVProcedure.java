package net.mcreator.jujutsucraftv.procedures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.GetEntityFromUUIDProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillBoogieWoogieVProcedure {
   private static final Set<UUID> MULTIPLE_TARGET_RUNNING = ConcurrentHashMap.newKeySet();

   public static boolean isMultipleTargetRunning(Entity entity) {
      return entity != null && MULTIPLE_TARGET_RUNNING.contains(entity.m_20148_());
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute(world, x, y, z, entity, false, true, (double)0.0F, (double)32.0F);
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, boolean multiple_target, boolean self_target, double delay, double range) {
      if (entity != null) {
         if (multiple_target) {
            executeMultipleTarget(world, entity, self_target, delay, range);
         } else {
            executeSingleTarget(world, x, y, z, entity);
         }
      }
   }

   private static void executeMultipleTarget(LevelAccessor world, Entity entity, boolean self_target, double delay, double range) {
      if (world instanceof ServerLevel serverLevel) {
         UUID casterUUID = entity.m_20148_();
         if (MULTIPLE_TARGET_RUNNING.add(casterUUID)) {
            entity.getPersistentData().m_128379_("fin_boogie", false);
            double actualRange = Math.max((double)0.0F, range);
            int delayTicks = Math.max(0, (int)Math.floor(delay));
            if (actualRange <= (double)0.0F) {
               finishMultipleTarget(entity, casterUUID);
            } else {
               JujutsucraftvMod.queueServerWork(delayTicks, () -> {
                  Entity caster = serverLevel.m_8791_(casterUUID);

                  try {
                     if (isUsableEntity(caster)) {
                        if (caster.getPersistentData().m_128459_("skill") == (double)0.0F) {
                           return;
                        }

                        Vec3 center = caster.m_20182_();
                        double rangeSqr = actualRange * actualRange;
                        Set<String> ownerUUIDTargets = collectOwnerUUIDTargets(serverLevel, center, actualRange);
                        List<LivingEntity> targets = new ArrayList();

                        for(LivingEntity candidate : serverLevel.m_6443_(LivingEntity.class, (new AABB(center, center)).m_82400_(actualRange), (e) -> true)) {
                           if (candidate != caster && candidate.m_6084_() && !candidate.m_213877_() && !(candidate.m_20280_(caster) > rangeSqr) && !isOwnerUUIDTarget(candidate, ownerUUIDTargets) && isValidMultipleTarget(candidate)) {
                              targets.add(candidate);
                           }
                        }

                        Collections.shuffle(targets);
                        if (self_target) {
                           LivingEntity swapTarget = null;

                           for(LivingEntity target : targets) {
                              if (canSwap(caster, target)) {
                                 swapTarget = target;
                                 break;
                              }
                           }

                           if (swapTarget == null) {
                              return;
                           }

                           playMultipleClap(serverLevel, caster);
                           swapCasterAndTarget(caster, swapTarget);
                           return;
                        }

                        Entity first = null;
                        Entity second = null;

                        for(int i = 0; i < targets.size(); ++i) {
                           LivingEntity firstCandidate = (LivingEntity)targets.get(i);

                           for(int j = i + 1; j < targets.size(); ++j) {
                              LivingEntity secondCandidate = (LivingEntity)targets.get(j);
                              if (canSwap(firstCandidate, secondCandidate)) {
                                 first = firstCandidate;
                                 second = secondCandidate;
                                 break;
                              }

                              if (canSwap(secondCandidate, firstCandidate)) {
                                 first = secondCandidate;
                                 second = firstCandidate;
                                 break;
                              }
                           }

                           if (first != null && second != null) {
                              break;
                           }
                        }

                        if (first != null && second != null) {
                           playMultipleClap(serverLevel, caster);
                           swapTargets(first, second);
                           return;
                        }

                        return;
                     }
                  } finally {
                     finishMultipleTarget(caster != null ? caster : entity, casterUUID);
                  }

               });
            }
         }
      }
   }

   private static void finishMultipleTarget(Entity entity, UUID casterUUID) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("fin_boogie", true);
         entity.getPersistentData().m_128347_("boogie_count", entity.getPersistentData().m_128459_("boogie_count") + (double)1.0F);
      }

      MULTIPLE_TARGET_RUNNING.remove(casterUUID);
   }

   private static boolean isValidMultipleTarget(Entity candidate) {
      if (!(candidate instanceof LivingEntity)) {
         return false;
      } else if (candidate.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
         return false;
      } else if (candidate.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
         return false;
      } else {
         if (candidate instanceof Player) {
            Player player = (Player)candidate;
            double cursePower = ((JujutsucraftModVariables.PlayerVariables)candidate.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower;
            if (cursePower == (double)0.0F) {
               return false;
            }

            if (player.m_7500_() || player.m_5833_()) {
               return false;
            }
         }

         return true;
      }
   }

   private static boolean isUsableEntity(Entity entity) {
      return entity != null && !entity.m_213877_() && entity.m_6084_();
   }

   private static Set<String> collectOwnerUUIDTargets(LevelAccessor world, Vec3 center, double range) {
      if (world != null && center != null && !(range <= (double)0.0F)) {
         Set<String> ownerUUIDTargets = new HashSet();

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(center, center)).m_82400_(range), (e) -> true)) {
            String ownerUUID = entityiterator.getPersistentData().m_128461_("OWNER_UUID");
            if (ownerUUID != null && !ownerUUID.isEmpty()) {
               ownerUUIDTargets.add(ownerUUID);
            }
         }

         return ownerUUIDTargets;
      } else {
         return Collections.emptySet();
      }
   }

   private static boolean isOwnerUUIDTarget(Entity target, Set<String> ownerUUIDTargets) {
      return target != null && ownerUUIDTargets != null && ownerUUIDTargets.contains(target.m_20149_());
   }

   private static boolean canSwap(Entity first, Entity second) {
      if (!(second instanceof LivingEntity target)) {
         return false;
      } else {
         boolean var10000;
         label35: {
            if (first instanceof LivingEntity living) {
               if (living.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = true;
                  break label35;
               }
            }

            var10000 = false;
         }

         boolean firstHasDomain = var10000;
         boolean targetHasDomain = target.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
         int neutralizationAmplifier = target.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()) ? target.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_() : 0;
         if (firstHasDomain && !targetHasDomain && neutralizationAmplifier <= 0) {
            return false;
         } else {
            return firstHasDomain || !targetHasDomain;
         }
      }
   }

   private static void playMultipleClap(ServerLevel world, Entity skillUser) {
      if (skillUser instanceof LivingEntity livingEntity) {
         livingEntity.m_21011_(InteractionHand.MAIN_HAND, true);
         if (livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
            livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-17.0F);
         }
      }

      PlayAnimationProcedure.execute(world, skillUser);
      SoundEvent clapSound = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:clap"));
      if (clapSound != null) {
         world.m_5594_((Player)null, BlockPos.m_274561_(skillUser.m_20185_(), skillUser.m_20186_(), skillUser.m_20189_()), clapSound, SoundSource.NEUTRAL, 1.0F, 1.0F);
      }

      Vec3 particlePos = skillUser.m_9236_().m_45547_(new ClipContext(skillUser.m_20299_(1.0F), skillUser.m_20299_(1.0F).m_82549_(skillUser.m_20252_(1.0F).m_82490_((double)(1.0F + skillUser.m_20205_()))), Block.OUTLINE, Fluid.NONE, skillUser)).m_82450_();
      world.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), particlePos.f_82479_, particlePos.f_82480_, particlePos.f_82481_, 1, 0.1, 0.1, 0.1, 0.2);
      Vec3 center = skillUser.m_20182_();

      for(Entity target : world.m_6443_(Entity.class, (new AABB(center, center)).m_82400_((double)12.0F), (e) -> true)) {
         if (skillUser != target && LogicAttackProcedure.execute(world, skillUser, target)) {
            target.getPersistentData().m_128347_("cnt_target", (double)-5.0F);
            if (target instanceof LivingEntity) {
               LivingEntity living = (LivingEntity)target;
               living.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
            }
         }
      }

   }

   private static void teleportEntity(Entity entity, double x, double y, double z) {
      float yRot = entity.m_146908_();
      float xRot = entity.m_146909_();
      if (entity instanceof ServerPlayer serverPlayer) {
         serverPlayer.f_8906_.m_9774_(x, y, z, yRot, xRot);
      } else {
         entity.m_6021_(x, y, z);
      }

      entity.m_20256_(Vec3.f_82478_);
      entity.f_19789_ = 0.0F;
   }

   private static void swapCasterAndTarget(Entity entity, Entity target) {
      if (entity != null && target != null) {
         if (entity != target) {
            entity.m_8127_();
            target.m_8127_();
            double entityX = entity.m_20185_();
            double entityY = entity.m_20186_();
            double entityZ = entity.m_20189_();
            double targetX = target.m_20185_();
            double targetY = target.m_20186_();
            double targetZ = target.m_20189_();
            target.getPersistentData().m_128379_("betrayal", true);
            target.getPersistentData().m_128347_("cnt_target", (double)-5.0F);
            if (target instanceof LivingEntity) {
               LivingEntity livingTarget = (LivingEntity)target;
               livingTarget.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
            }

            teleportEntity(target, entityX, entityY, entityZ);
            teleportEntity(entity, targetX, targetY, targetZ);
            entity.m_146922_(entity.m_146908_() + 180.0F);
            entity.m_146926_(entity.m_146909_() * -1.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity livingEntity = (LivingEntity)entity;
               livingEntity.f_20884_ = livingEntity.m_146908_();
               livingEntity.f_20886_ = livingEntity.m_146908_();
               if (!livingEntity.m_9236_().m_5776_()) {
                  livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 15, 9, false, false));
               }
            }

            if (!(entity instanceof Player)) {
               entity.getPersistentData().m_128347_("cnt_boogie_woogie", (double)-40.0F);
            }

         }
      }
   }

   private static void swapTargets(Entity first, Entity second) {
      if (first != null && second != null) {
         if (first != second) {
            first.m_8127_();
            second.m_8127_();
            double firstX = first.m_20185_();
            double firstY = first.m_20186_();
            double firstZ = first.m_20189_();
            double secondX = second.m_20185_();
            double secondY = second.m_20186_();
            double secondZ = second.m_20189_();
            first.getPersistentData().m_128379_("betrayal", true);
            second.getPersistentData().m_128379_("betrayal", true);
            first.getPersistentData().m_128347_("cnt_target", (double)-5.0F);
            second.getPersistentData().m_128347_("cnt_target", (double)-5.0F);
            if (first instanceof LivingEntity) {
               LivingEntity livingFirst = (LivingEntity)first;
               livingFirst.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
            }

            if (second instanceof LivingEntity) {
               LivingEntity livingSecond = (LivingEntity)second;
               livingSecond.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
            }

            teleportEntity(first, secondX, secondY, secondZ);
            teleportEntity(second, firstX, firstY, firstZ);
         }
      }
   }

   private static void executeSingleTarget(LevelAccessor world, double x, double y, double z, Entity entity) {
      String targetUUID = "";
      double x_pos = (double)0.0F;
      double y_pos = (double)0.0F;
      double z_pos = (double)0.0F;
      double dis = (double)0.0F;
      boolean SUCCESS = false;
      boolean player = entity instanceof Player;
      Entity entity_a = null;
      Vec3 _center = new Vec3(x, y, z);
      Set<String> ownerUUIDTargets = collectOwnerUUIDTargets(world, _center, (double)16.0F);
      if (!player) {
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         Entity mobTarget = var10000;
         if (mobTarget instanceof LivingEntity && !isOwnerUUIDTarget(mobTarget, ownerUUIDTargets) && entity.getPersistentData().m_128459_("cnt_target") > (double)6.0F && mobTarget.getPersistentData().m_128459_("skill") != (double)0.0F && mobTarget.getPersistentData().m_128459_("Damage") > (double)0.0F && !mobTarget.getPersistentData().m_128471_("attack")) {
            SUCCESS = true;
            targetUUID = mobTarget.m_20149_();
         }
      }

      for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true)) {
         if (entity != entityiterator && !isOwnerUUIDTarget(entityiterator, ownerUUIDTargets)) {
            boolean logic_ = LogicAttackProcedure.execute(world, entity, entityiterator);
            if (logic_ && entityiterator.getPersistentData().m_128459_("skill") != (double)0.0F && entityiterator.getPersistentData().m_128459_("Damage") > (double)0.0F) {
               entityiterator.getPersistentData().m_128379_("betrayal", true);
               if (!player && !SUCCESS && !entityiterator.getPersistentData().m_128471_("attack")) {
                  SUCCESS = true;
                  targetUUID = entityiterator.m_20149_();
               }
            }

            double var74;
            if (entityiterator instanceof Projectile) {
               Projectile _projEnt = (Projectile)entityiterator;
               var74 = _projEnt.m_20184_().m_82553_();
            } else {
               var74 = (double)0.0F;
            }

            double projectileSpeed = var74;
            if (projectileSpeed != (double)0.0F && entityiterator instanceof Projectile) {
               Projectile _projEnt = (Projectile)entityiterator;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity = (LivingEntity)entity;
                  _projEnt.m_5602_(_livingEntity);
               }
            }

            if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || !logic_) {
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var74 = _projEnt.m_20184_().m_82553_();
               } else {
                  var74 = (double)0.0F;
               }

               projectileSpeed = var74;
               if (!(projectileSpeed > (double)0.0F)) {
                  continue;
               }
            }

            String ownerUUID = entityiterator.getPersistentData().m_128461_("OWNER_UUID");
            if (!ownerUUID.equals(entity.m_20149_())) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, ownerUUID);
               if (entity_a instanceof LivingEntity && !isOwnerUUIDTarget(entity_a, ownerUUIDTargets)) {
                  boolean validOwner = false;
                  if (entity_a instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower != (double)0.0F && !((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entity_a) && !((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entity_a)) {
                        validOwner = true;
                     }
                  } else if (!entity_a.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                     validOwner = true;
                  }

                  if (validOwner) {
                     SUCCESS = true;
                     targetUUID = ownerUUID;
                  }
               }

               entityiterator.getPersistentData().m_128359_("OWNER_UUID", "");
               entityiterator.getPersistentData().m_128379_("betrayal", true);
            }
         }
      }

      if (!SUCCESS) {
         _center = new Vec3(x, y, z);
         ownerUUIDTargets = collectOwnerUUIDTargets(world, _center, (double)4.0F);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)4.0F), (e) -> true)) {
            if (entity != entityiterator && !isOwnerUUIDTarget(entityiterator, ownerUUIDTargets) && entityiterator.getPersistentData().m_128459_("skill") != (double)0.0F && entityiterator.getPersistentData().m_128471_("attack") && entityiterator.getPersistentData().m_128471_("PRESS_Z")) {
               if (entityiterator instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == (double)0.0F || ((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(entityiterator) || ((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(entityiterator)) {
                     continue;
                  }
               } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                  continue;
               }

               if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                     entityiterator.getPersistentData().m_128347_("cnt6", (double)0.0F);
                  }

                  SUCCESS = true;
                  targetUUID = entityiterator.m_20149_();
                  break;
               }
            }
         }
      }

      if (player && !SUCCESS) {
         dis = (double)32.0F;

         for(int index0 = 0; index0 < 6; ++index0) {
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
            Vec3 searchCenter = new Vec3(x_pos, y_pos, z_pos);
            ownerUUIDTargets = collectOwnerUUIDTargets(world, searchCenter, (double)6.0F);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(searchCenter, searchCenter)).m_82400_((double)6.0F), (e) -> true)) {
               if (entity != entityiterator && !isOwnerUUIDTarget(entityiterator, ownerUUIDTargets)) {
                  if (entityiterator instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower != (double)0.0F && !((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entityiterator) && !((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entityiterator)) {
                        SUCCESS = true;
                        targetUUID = entityiterator.m_20149_();
                        break;
                     }
                  } else if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                     SUCCESS = true;
                     targetUUID = entityiterator.m_20149_();
                     break;
                  }
               }
            }

            dis -= (double)4.0F;
            if (SUCCESS) {
               break;
            }
         }
      }

      if (player || SUCCESS) {
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity = (LivingEntity)entity;
            if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-17.0F);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(1.0F + entity.m_20205_()))), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(1.0F + entity.m_20205_()))), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)(1.0F + entity.m_20205_()))), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_(), 1, 0.1, 0.1, 0.1, 0.2);
         }

         _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)12.0F), (e) -> true)) {
            if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
               entityiterator.getPersistentData().m_128347_("cnt_target", (double)-5.0F);
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
               }
            }
         }
      }

      if (SUCCESS) {
         entity_a = GetEntityFromUUIDProcedure.execute(world, targetUUID);
         Set<String> finalOwnerUUIDTargets = collectOwnerUUIDTargets(world, new Vec3(x, y, z), (double)32.0F);
         if (isOwnerUUIDTarget(entity_a, finalOwnerUUIDTargets)) {
            return;
         }

         if (entity_a instanceof LivingEntity) {
            boolean var76;
            label208: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var76 = true;
                     break label208;
                  }
               }

               var76 = false;
            }

            boolean entityHasDomain = var76;
            boolean targetHasDomain = ((LivingEntity)entity_a).m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
            int neutralizationAmplifier = ((LivingEntity)entity_a).m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()) ? ((LivingEntity)entity_a).m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_() : 0;
            if (entityHasDomain && !targetHasDomain && neutralizationAmplifier <= 0) {
               return;
            }

            if (!entityHasDomain && targetHasDomain) {
               return;
            }

            entity.m_8127_();
            entity_a.m_8127_();
            entity_a.getPersistentData().m_128379_("betrayal", true);
            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
            }

            entity_a.getPersistentData().m_128347_("cnt_target", (double)-5.0F);
            x_pos = entity_a.m_20185_();
            y_pos = entity_a.m_20186_();
            z_pos = entity_a.m_20189_();
            double entityX = entity.m_20185_();
            double entityY = entity.m_20186_();
            double entityZ = entity.m_20189_();
            teleportEntity(entity_a, entityX, entityY, entityZ);
            teleportEntity(entity, x_pos, y_pos, z_pos);
            entity.m_146922_(entity.m_146908_() + 180.0F);
            entity.m_146926_(entity.m_146909_() * -1.0F);
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 15, 9, false, false));
               }
            }

            if (!player) {
               entity.getPersistentData().m_128347_("cnt_boogie_woogie", (double)-40.0F);
            }
         }
      }

   }
}
