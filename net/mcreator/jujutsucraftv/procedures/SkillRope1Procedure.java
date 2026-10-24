package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraftv.entity.EntityHangingRopeEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillRope1Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double y_after = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double dis = (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 4, 255, false, false));
            }
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               double var50 = Math.pow(((Entity)var10000).m_20185_() - entity.m_20185_(), (double)2.0F);
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               var50 += Math.pow(((Entity)var10001).m_20186_() - entity.m_20186_(), (double)2.0F);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               dis = Math.sqrt(var50 + Math.pow(((Entity)var10001).m_20189_() - entity.m_20189_(), (double)2.0F));
               if (dis <= (double)30.0F) {
                  CompoundTag var52 = entity.getPersistentData();
                  LivingEntity var10002;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.m_5448_();
                  } else {
                     var10002 = null;
                  }

                  var52.m_128347_("x_pos", ((Entity)var10002).m_20185_());
                  var52 = entity.getPersistentData();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.m_5448_();
                  } else {
                     var10002 = null;
                  }

                  double var60 = ((Entity)var10002).m_20186_();
                  LivingEntity var10003;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10003 = _mobEnt.m_5448_();
                  } else {
                     var10003 = null;
                  }

                  var52.m_128347_("y_pos", var60 + (double)((Entity)var10003).m_20206_() * (double)0.75F);
                  var52 = entity.getPersistentData();
                  LivingEntity var61;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var61 = _mobEnt.m_5448_();
                  } else {
                     var61 = null;
                  }

                  var52.m_128347_("z_pos", ((Entity)var61).m_20189_());
               } else {
                  entity.getPersistentData().m_128347_("skill", (double)0.0F);
               }
            } else {
               entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_());
               entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_());
               entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)30.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_());
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F) {
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");

            for(int index0 = 0; index0 < 50 && world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_(); ++index0) {
               ++y_pos;
            }

            for(int index1 = 0; index1 < 50; ++index1) {
               if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                  y_pos -= 0.1;
                  break;
               }

               y_pos -= (double)0.5F;
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos + (double)0.25F, z_pos, 5, (double)1.0F, (double)0.25F, (double)1.0F, 0.05);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos + (double)0.25F, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:rope_strangulation")), SoundSource.NEUTRAL, 1.0F, 1.3F);
               } else {
                  _level.m_7785_(x_pos, y_pos + (double)0.25F, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:rope_strangulation")), SoundSource.NEUTRAL, 1.0F, 1.3F, false);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)15.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator)) {
                     x_pos = entityiterator.m_20185_();
                     y_pos = entityiterator.m_20186_();
                     z_pos = entityiterator.m_20189_();
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos + (double)0.25F, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:rope_strangulation")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos + (double)0.25F, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:rope_strangulation")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos + (double)0.25F, z_pos, 18, (double)0.0F, (double)0.0F, (double)0.0F, 0.15);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ENTITY_HANGING_ROPE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           if (entity instanceof CursedSpiritGrade13Entity && entityinstance instanceof EntityHangingRopeEntity) {
                              EntityHangingRopeEntity animatable = (EntityHangingRopeEntity)entityinstance;
                              animatable.setTexture("hunging_rope2");
                           }

                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(((LivingEntity)entityiterator).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22115_() < (double)1.0F ? (double)1.0F : ((LivingEntity)entityiterator).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22115_());
                           SetRangedAmmoProcedure.execute(entity, entityinstance);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity59 = (LivingEntity)entityinstance;
                              if (_livingEntity59.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 AttributeInstance var55;
                                 int var10004;
                                 label160: {
                                    var55 = _livingEntity59.m_21051_(Attributes.f_22276_);
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10004 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label160;
                                       }
                                    }

                                    var10004 = 0;
                                 }

                                 var55.m_22100_((double)Math.round((double)50.0F * ((double)1.0F + 0.1 * (double)var10004)));
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              float var57;
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityinstance;
                                 var57 = _livEnt.m_21233_();
                              } else {
                                 var57 = -1.0F;
                              }

                              _entity.m_21153_(var57);
                           }

                           entityinstance.m_20242_(true);
                           entityinstance.getPersistentData().m_128359_("TARGET_UUID", entityiterator.m_20149_());
                           if (entityinstance instanceof EntityHangingRopeEntity) {
                              ((EntityHangingRopeEntity)entityinstance).setAnimation("act");
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var58;
                                 MobEffect var62;
                                 int var10005;
                                 label146: {
                                    var58 = new MobEffectInstance;
                                    var62 = MobEffects.f_19600_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label146;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var58.<init>(var62, Integer.MAX_VALUE, var10005, false, false);
                                 _entity.m_7292_(var58);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 300, 1, false, false));
                              }
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                     break;
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)15.0F) {
            entity.getPersistentData().m_128347_("x_pos", (double)0.0F);
            entity.getPersistentData().m_128347_("y_pos", (double)0.0F);
            entity.getPersistentData().m_128347_("z_pos", (double)0.0F);
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
