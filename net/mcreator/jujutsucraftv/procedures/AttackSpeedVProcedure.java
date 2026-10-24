package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade217Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.item.SwordOptionItem;
import net.mcreator.jujutsucraft.procedures.AttackWeakPunchProcedure;
import net.mcreator.jujutsucraft.procedures.AttackWeakSwordProcedure;
import net.mcreator.jujutsucraft.procedures.ChargeParticleProcedure;
import net.mcreator.jujutsucraft.procedures.EntityVectorProcedure;
import net.mcreator.jujutsucraft.procedures.GetDistanceIteratorProcedure;
import net.mcreator.jujutsucraft.procedures.InsideSolidCalculateProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicSwordProcedure;
import net.mcreator.jujutsucraft.procedures.OnGroundProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationEntity2Procedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraft.procedures.StepBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackSpeedVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double CNT6 = (double)0.0F;
         double rad_now = (double)0.0F;
         double range = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         double dis = (double)0.0F;
         double distance = (double)0.0F;
         double strength = (double)0.0F;
         double old_cnt1 = (double)0.0F;
         double old_cnt2 = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + (double)1.0F);
         if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
            entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)2.5F));
         }

         ItemStack itemstack = ItemStack.f_41583_;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            itemstack = _livEnt.m_21205_();
         }

         label320: {
            if (itemstack.m_41720_() != JujutsucraftModItems.SWORD_OPTION.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  itemstack = _livEnt.m_21206_();
               }

               if (itemstack.m_41720_() != JujutsucraftModItems.SWORD_OPTION.get()) {
                  break label320;
               }
            }

            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)-1.0F * (double)entity.m_20205_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)-1.0F * (double)entity.m_20205_();
            z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)-1.0F * (double)entity.m_20205_();
            if (itemstack.m_41720_() instanceof SwordOptionItem) {
               itemstack.m_41784_().m_128359_("geckoAnim", "attack");
            }

            entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), (double)2.5F));
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 1, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.25F);
               _level.m_8767_(ParticleTypes.f_123797_, x_pos, y_pos, z_pos, 2, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.25F);
               _level.m_8767_(ParticleTypes.f_123815_, x_pos, y_pos, z_pos, 2, (double)0.25F, (double)0.25F, (double)0.25F, (double)0.25F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 0.5F, false);
               }
            }
         }

         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.m_21573_().m_26573_();
         }

         int amp = 0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_(MobEffects.f_19600_)) {
               amp = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
            }
         }

         strength = (double)Math.min(amp, 50);
         range = ReturnEntitySizeProcedure.execute(entity) * ((double)1.0F + strength * 0.025);
         CNT6 = (double)1.0F + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F;
         z_pos = entity.m_20189_();
         entity.f_19789_ = 0.0F;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         LivingEntity target = var10000;
         if (target instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt7") > (double)1.0F) {
            entity.m_146922_((float)entity.getPersistentData().m_128459_("yaw"));
            entity.m_146926_((float)entity.getPersistentData().m_128459_("pitch"));
            entity.m_5616_(entity.m_146908_());
            entity.m_5618_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity = (LivingEntity)entity;
               _livingEntity.f_20886_ = _livingEntity.m_146908_();
               _livingEntity.f_20884_ = _livingEntity.m_146908_();
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt7", entity.getPersistentData().m_128459_("cnt7") + (double)1.0F);
            if (target instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt7") % (double)20.0F == (double)1.0F) {
               net.mcreator.jujutsucraft.procedures.RotateEntityProcedure.execute(target.m_20185_(), target.m_20186_() + (double)target.m_20206_() * (double)0.5F, target.m_20189_(), entity);
               entity.getPersistentData().m_128347_("yaw", (double)entity.m_146908_());
               entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            }

            if (entity.getPersistentData().m_128459_("cnt3") == (double)0.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
                  }
               }

               if (target instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

               if (entity.getPersistentData().m_128459_("cnt2") >= (double)9.0F && entity.getPersistentData().m_128459_("cnt2") <= (double)10.0F) {
                  if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                     entity.getPersistentData().m_128347_("cnt2", Math.min(entity.getPersistentData().m_128459_("cnt2"), (double)9.0F));
                  }

                  if (entity.getPersistentData().m_128459_("cnt6") > (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_254849_((Entity)null, x, y + (double)entity.m_20206_() * (double)0.5F, z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  } else if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                     entity.getPersistentData().m_128347_("cnt6", (double)5.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)0.125F);
                     if (entity.getPersistentData().m_128459_("cnt6") == (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
                     }
                  }
               }

               ChargeParticleProcedure.execute(world, entity, entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F ? (double)10.0F : (double)0.0F);
               if (entity.getPersistentData().m_128459_("cnt2") >= (double)10.0F && !entity.getPersistentData().m_128471_("PRESS_Z") && OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
                  entity.getPersistentData().m_128347_("cnt3", (double)1.0F);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_(MobEffects.f_19597_);
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * (double)3.0F);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * (double)3.0F);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123815_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)10.0F * range), range * (double)0.25F, 0.1, range * (double)0.25F, (double)0.25F);
                  }

                  if (entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "form_attack_speed2");
                  } else if (entity instanceof Player) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity107 = (LivingEntity)entity;
                        if (_livingEntity107.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity107.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-21.0F);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity108 = (LivingEntity)entity;
                        if (_livingEntity108.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity108.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }
               }
            } else {
               if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19592_, 2, 1, false, false));
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
                  }
               }

               x_power = entity.getPersistentData().m_128459_("x_power") * (double)2.0F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)2.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)2.0F;
               if (entity.getPersistentData().m_128459_("cnt2") == (double)1.0F) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != (double)0.0F) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_();
               z_pos = entity.m_20189_();

               for(int index0 = 0; index0 < (int)Math.max(dis, (double)1.0F); ++index0) {
                  entity.getPersistentData().m_128347_("Range", (double)4.0F * range);
                  if (!logic_a) {
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.m_20206_() * (double)0.5F, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / (double)2.0F), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           distance = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().m_128379_("attack", true);
               if (logic_a) {
                  if (Math.round(distance) >= 1L) {
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();

                     for(int index1 = 0; index1 < (int)Math.round(distance); ++index1) {
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           x_pos += x_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           y_pos += y_power;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                           logic_a = false;
                           z_pos += z_power;
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     entity.m_6021_(x_pos, y_pos, z_pos);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  logic_a = true;
               }

               if (logic_a || entity.getPersistentData().m_128459_("cnt2") > (double)6.0F) {
                  entity.m_20256_(new Vec3((double)0.0F, (double)0.0F, (double)0.0F));
                  entity.getPersistentData().m_128347_("cnt1", (double)(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity ? 9 : 8));
                  entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + (double)1.0F);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123815_, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (int)((double)5.0F * range), range * (double)0.25F, 0.1, range * (double)0.25F, 0.1);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity152 = (LivingEntity)entity;
                     if (_livingEntity152.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity152.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-49.0F);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity153 = (LivingEntity)entity;
                     if (_livingEntity153.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity153.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_((double)0.0F);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") != (double)0.0F) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
               }
            }

            old_cnt1 = entity.getPersistentData().m_128459_("cnt1");
            old_cnt2 = entity.getPersistentData().m_128459_("cnt2");
            entity.getPersistentData().m_128347_("cnt2", (double)0.0F);
            if (old_cnt1 == (double)10.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if ((entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity || entity instanceof CursedSpiritGrade217Entity) && entity instanceof LivingEntity) {
                  LivingEntity _livingEntity164 = (LivingEntity)entity;
                  if (_livingEntity164.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity164.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)1.0F);
                  }
               }

               if (entity instanceof CursedSpiritGrade217Entity) {
                  PlayAnimationEntity2Procedure.execute(entity, "punch_right_backup");
               }

               if (LogicSwordProcedure.execute(entity)) {
                  AttackWeakSwordProcedure.execute(world, x, y, z, entity);
               } else {
                  AttackWeakPunchProcedure.execute(world, x, y, z, entity);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity167 = (LivingEntity)entity;
                  if (_livingEntity167.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity167.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)0.0F);
                  }
               }
            }

            entity.getPersistentData().m_128347_("cnt1", old_cnt1);
            entity.getPersistentData().m_128347_("cnt2", old_cnt2);
            if (entity.getPersistentData().m_128459_("cnt1") > (double)20.0F) {
               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
