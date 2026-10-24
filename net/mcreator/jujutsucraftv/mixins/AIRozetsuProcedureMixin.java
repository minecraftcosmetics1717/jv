package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.entity.RozetsuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AIActiveProcedure;
import net.mcreator.jujutsucraft.procedures.AIRozetsuProcedure;
import net.mcreator.jujutsucraft.procedures.AnimationResetProcedure;
import net.mcreator.jujutsucraft.procedures.CalculateAttackProcedure;
import net.mcreator.jujutsucraft.procedures.GetDistanceProcedure;
import net.mcreator.jujutsucraft.procedures.GetEntityFromUUIDProcedure;
import net.mcreator.jujutsucraft.procedures.LogicConfilmDomainProcedure;
import net.mcreator.jujutsucraft.procedures.LogicStartProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.ResetCounterProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {AIRozetsuProcedure.class},
   remap = false
)
public abstract class AIRozetsuProcedureMixin {
   @Overwrite
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double health = (double)0.0F;
         boolean domain = false;
         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("transform") > (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("transform", entity.getPersistentData().m_128459_("transform") + (double)1.0F);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity = (LivingEntity)entity;
                  if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)2015.0F);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.getPersistentData().m_128459_("transform") < (double)4.0F) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 100, 9, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  SimpleParticleType _particleType = (SimpleParticleType)ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation("jujutsucraft:particle_curse_power_purple"));
                  if (_particleType != null) {
                     _level.m_8767_(_particleType, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)16.0F * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)1.25F);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  SimpleParticleType _particleType = (SimpleParticleType)ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation("jujutsucraft:particle_curse_power_purple"));
                  if (_particleType != null) {
                     _level.m_8767_(_particleType, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)8.0F * ReturnEntitySizeProcedure.execute(entity)), (double)entity.m_20205_() * (double)0.25F, (double)entity.m_20206_() * (double)0.25F, (double)entity.m_20205_() * (double)0.25F, (double)0.5F);
                  }
               }

               if (entity.getPersistentData().m_128459_("transform") > (double)100.0F) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F, false);
                     }
                  }

                  entity.getPersistentData().m_128347_("transform", (double)0.0F);
                  if (entity instanceof RozetsuEntity) {
                     RozetsuEntity _datEntSetI = (RozetsuEntity)entity;
                     _datEntSetI.m_20088_().m_135381_(RozetsuEntity.DATA_form, 1);
                  }

                  if (entity instanceof RozetsuEntity) {
                     RozetsuEntity animatable = (RozetsuEntity)entity;
                     animatable.setTexture("rozetsu2");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_8061_(EquipmentSlot.OFFHAND, ItemStack.f_41583_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity = (LivingEntity)entity;
                     if (_livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        double var10000;
                        label302: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity2 = (LivingEntity)entity;
                              if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10000 = _livingEntity2.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                                 break label302;
                              }
                           }

                           var10000 = (double)0.0F;
                        }

                        double oldSize = var10000;
                        _livingEntity.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(oldSize + (double)1.0F);
                     }
                  }

                  double var83;
                  label293: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entity;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22276_)) {
                           var83 = _livingEntity.m_21051_(Attributes.f_22276_).m_22115_();
                           break label293;
                        }
                     }

                     var83 = (double)0.0F;
                  }

                  double maxHealth = var83;
                  health = maxHealth * (double)0.5F;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity = (LivingEntity)entity;
                     if (_livingEntity.m_21204_().m_22171_(Attributes.f_22276_)) {
                        label286: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity2 = (LivingEntity)entity;
                              if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 var83 = _livingEntity2.m_21051_(Attributes.f_22276_).m_22115_();
                                 break label286;
                              }
                           }

                           var83 = (double)0.0F;
                        }

                        double oldMaxHealth = var83;
                        _livingEntity.m_21051_(Attributes.f_22276_).m_22100_(oldMaxHealth + health);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21153_((float)((double)_entity.m_21223_() + health));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19600_);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_FEROCIOUS_UNIT.get(), Integer.MAX_VALUE, 0, false, false, true));
                     }
                  }

                  AnimationResetProcedure.execute(entity);
               }
            } else {
               int var85;
               if (entity instanceof RozetsuEntity) {
                  RozetsuEntity _datEntI = (RozetsuEntity)entity;
                  var85 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
               } else {
                  var85 = 0;
               }

               int form = var85;
               if (form == 1) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), Integer.MAX_VALUE, 9, false, false));
                     }
                  }

                  label371: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           break label371;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 14, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_() && !_entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_FEROCIOUS_UNIT.get())) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_FEROCIOUS_UNIT.get(), Integer.MAX_VALUE, 0, false, false, true));
                     }
                  }
               } else {
                  label401: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           break label401;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 10, false, false));
                        }
                     }
                  }
               }

               label362: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                        break label362;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 3, false, false));
                     }
                  }
               }

               AIActiveProcedure.execute(world, x, y, z, entity);
               LivingEntity var86;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var86 = _mobEnt.m_5448_();
               } else {
                  var86 = null;
               }

               LivingEntity target = var86;
               if (target != null) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                     int var87;
                     if (entity instanceof RozetsuEntity) {
                        RozetsuEntity _datEntI = (RozetsuEntity)entity;
                        var87 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
                     } else {
                        var87 = 0;
                     }

                     form = var87;
                     double var88;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var88 = (double)_livEnt.m_21223_();
                     } else {
                        var88 = (double)-1.0F;
                     }

                     double nowHealth = var88;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var88 = (double)_livEnt.m_21233_();
                     } else {
                        var88 = (double)-1.0F;
                     }

                     double maxHealthValue = var88;
                     double healthRate = maxHealthValue > (double)0.0F ? nowHealth / maxHealthValue : (double)1.0F;
                     if (form == 0 && nowHealth < maxHealthValue * 0.3) {
                        entity.getPersistentData().m_128347_("transform", (double)1.0F);
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;

                           for(Entity entityiterator : _serverLevel.m_8583_()) {
                              if (entityiterator != null && entity != entityiterator && entityiterator instanceof Mob && entityiterator.getPersistentData().m_128471_("CursedSpirit") && entityiterator.getPersistentData().m_128461_("OWNER_UUID").equals(entity.m_20149_()) && !entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                                 entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                              }
                           }
                        }
                     }

                     int var90;
                     if (entity instanceof RozetsuEntity) {
                        RozetsuEntity _datEntI = (RozetsuEntity)entity;
                        var90 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
                     } else {
                        var90 = 0;
                     }

                     form = var90;
                     if (form > 0 && nowHealth < maxHealthValue * (double)0.5F) {
                        label337: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var90 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label337;
                              }
                           }

                           var90 = 0;
                        }

                        int selfDamageBoostAmp = var90;
                        int targetDamageBoostAmp = 0;
                        LivingEntity var92;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var92 = _mobEnt.m_5448_();
                        } else {
                           var92 = null;
                        }

                        LivingEntity mobTarget = var92;
                        if (mobTarget != null && mobTarget.m_21023_(MobEffects.f_19600_)) {
                           targetDamageBoostAmp = mobTarget.m_21124_(MobEffects.f_19600_).m_19564_();
                        }

                        if (selfDamageBoostAmp - 10 <= targetDamageBoostAmp) {
                           entity.getPersistentData().m_128379_("flag_domain", true);
                        }
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (domain) {
                        tick = (double)20.0F;
                        rnd = (double)20.0F;
                     } else {
                        if (entity instanceof RozetsuEntity) {
                           RozetsuEntity _datEntI = (RozetsuEntity)entity;
                           var90 = (Integer)_datEntI.m_20088_().m_135370_(RozetsuEntity.DATA_form);
                        } else {
                           var90 = 0;
                        }

                        form = var90;
                        if (form > 0) {
                           label323: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label323;
                                 }
                              }

                              double roll = Math.random();
                              if (roll < 0.3) {
                                 rnd = (double)15.0F;
                                 tick = (double)70.0F;
                                 level = (double)1.0F;
                              } else if (roll < 0.4) {
                                 rnd = (double)16.0F;
                                 tick = (double)140.0F;
                                 level = (double)1.0F;
                              }
                           }
                        } else if (LogicStartProcedure.execute(entity) && Math.random() < (double)0.5F && !(GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().m_128461_("SHIKIGAMI_ROZETSU_UUID")) instanceof LivingEntity)) {
                           double roll = Math.random();
                           if (healthRate < 0.7) {
                              if (roll < 0.1) {
                                 rnd = (double)9.0F;
                              } else if (roll < (double)0.25F) {
                                 rnd = (double)8.0F;
                              } else if (roll < 0.4) {
                                 rnd = (double)7.0F;
                              } else if (roll < 0.6) {
                                 rnd = (double)6.0F;
                              } else {
                                 rnd = (double)5.0F;
                              }
                           } else if (roll < 0.15) {
                              rnd = (double)8.0F;
                           } else if (roll < 0.3) {
                              rnd = (double)7.0F;
                           } else if (roll < (double)0.5F) {
                              rnd = (double)6.0F;
                           } else {
                              rnd = (double)5.0F;
                           }

                           level = (double)0.0F;
                           tick = (double)100.0F;
                        }
                     }

                     if (rnd > (double)0.0F) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().m_128347_("skill", (double)4300.0F + rnd);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                           }
                        }

                        if (level > (double)0.0F) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                              }
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               }
            }

         }
      }
   }
}
