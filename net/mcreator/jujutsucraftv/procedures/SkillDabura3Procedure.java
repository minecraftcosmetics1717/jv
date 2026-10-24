package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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

public class SkillDabura3Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_pos2 = (double)0.0F;
         double CNT6 = (double)0.0F;
         double distance = (double)0.0F;
         double picth = (double)0.0F;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double y_pos2 = (double)0.0F;
         double z_pos2 = (double)0.0F;
         double yaw = (double)0.0F;
         double pitch = (double)0.0F;
         double dis_ground = (double)0.0F;
         double side_yaw = (double)0.0F;
         double x_look = (double)0.0F;
         double y_look = (double)0.0F;
         double z_look = (double)0.0F;
         double y_look_plus = (double)0.0F;
         double x_pos3 = (double)0.0F;
         double y_pos3 = (double)0.0F;
         double z_pos3 = (double)0.0F;
         boolean tower_spawn = false;
         Entity ride_entity = null;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:attacking 10 1 true");
         }

         if (!(entity instanceof Player)) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var134 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var135 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var135 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var134, var135, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
            } else {
               entity.m_7618_(Anchor.EYES, new Vec3(entity.m_20185_(), entity.m_20186_() - (double)35.0F, entity.m_20189_()));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)2.0F) {
            entity.getPersistentData().m_128379_("hovering", true);
            EntityHoveringProcedure.execute(entity, (double)30.0F);
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)5.0F && entity.getPersistentData().m_128459_("cnt1") <= (double)80.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"))).m_22100_((double)2015.0F);
            PlayAnimationProcedure.execute(world, entity);
            yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            pitch = Math.toRadians((double)entity.m_146909_());
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.6;
            z_pos = entity.m_20189_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }

            x_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
            y_look_plus = y_look;

            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-13.0F, (double)13.0F);
               y_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-1.0F, (double)1.0F);
               z_pos2 = Mth.m_216263_(RandomSource.m_216327_(), (double)-13.0F, (double)13.0F);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.5F));
                  } else {
                     _level.m_7785_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:beam_charge1")), SoundSource.NEUTRAL, 0.5F, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)1.5F), false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos2 + x_pos, y_pos2 + y_pos, z_pos2 + z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)3.0F);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.m_20242_(true);
                     entityinstance.m_20331_(true);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var125;
                           int var137;
                           MobEffect var10003;
                           label372: {
                              var125 = new MobEffectInstance;
                              var10003 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var137 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label372;
                                 }
                              }

                              var137 = 0;
                           }

                           var125.<init>(var10003, Integer.MAX_VALUE, var137, false, false);
                           _entity.m_7292_(var125);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("x_plus", x_pos2);
                     entityinstance.getPersistentData().m_128347_("y_plus", y_pos2);
                     entityinstance.getPersistentData().m_128347_("z_plus", z_pos2);
                     entityinstance.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
                     entityinstance.getPersistentData().m_128347_("x_pos_set", x_pos + entityinstance.getPersistentData().m_128459_("x_plus"));
                     entityinstance.getPersistentData().m_128347_("y_pos_set", y_pos + entityinstance.getPersistentData().m_128459_("y_plus"));
                     entityinstance.getPersistentData().m_128347_("z_pos_set", z_pos + entityinstance.getPersistentData().m_128459_("z_plus"));
                     entityinstance.getPersistentData().m_128347_("x_look", x_look);
                     entityinstance.getPersistentData().m_128347_("y_look", y_look_plus);
                     entityinstance.getPersistentData().m_128347_("z_look", z_look);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.getPersistentData().m_128347_("light_type", (double)3.0F);
                     entityinstance.getPersistentData().m_128347_("Damage", (double)(entity instanceof Player ? Mth.m_216271_(RandomSource.m_216327_(), 10, 15) : Mth.m_216271_(RandomSource.m_216327_(), 8, 10)));
                     entityinstance.getPersistentData().m_128347_("ACT", (double)10.0F);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)81.0F) {
            x_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_look = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_((double)100.0F)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_();
            y_look_plus = y_look;

            while(world.m_8055_(BlockPos.m_274561_(x_look, y_look, z_look)).m_60815_()) {
               ++y_look_plus;
               if (!world.m_8055_(BlockPos.m_274561_(x_look, y_look_plus, z_look)).m_60815_()) {
                  break;
               }
            }

            y_look_plus = y_look;
            if (!world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(x_look, y_look, z_look), (double)10.0F, (double)10.0F, (double)10.0F), (e) -> true).isEmpty()) {
               Vec3 _center = new Vec3(x_look, y_look, z_look);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)5.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (!LogicAttackProcedure.execute(world, entity, entityiterator) && !LogicBetrayalProcedure.execute(world, entity, entityiterator)) {
                     if (!tower_spawn) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT_TOWER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_look_plus, z_look), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                              entity.m_146922_(0.0F);
                              entity.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
                              entity.m_5618_(entity.m_146908_());
                              entity.m_5616_(entity.m_146908_());
                              entity.f_19859_ = entity.m_146908_();
                              entity.f_19860_ = entity.m_146909_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.f_20884_ = _entity.m_146908_();
                                 _entity.f_20886_ = _entity.m_146908_();
                              }

                              if (entityinstance instanceof Mob) {
                                 Mob _mob144 = (Mob)entityinstance;
                                 _mob144.m_21557_(true);
                              }

                              entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                              entityinstance.getPersistentData().m_128347_("attack1", (double)0.0F);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity152 = (LivingEntity)entityinstance;
                                 if (_livingEntity152.m_21204_().m_22171_(Attributes.f_22276_)) {
                                    AttributeInstance var123;
                                    int var132;
                                    label295: {
                                       var123 = _livingEntity152.m_21051_(Attributes.f_22276_);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var132 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label295;
                                          }
                                       }

                                       var132 = 0;
                                    }

                                    var123.m_22100_((double)(100 + 2 * var132));
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 float var128;
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityinstance;
                                    var128 = _livEnt.m_21233_();
                                 } else {
                                    var128 = -1.0F;
                                 }

                                 _entity.m_21153_(var128);
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                 }
                              }

                              ride_entity = entityinstance;
                              _serverLevel.m_7967_(entityinstance);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SCAFFOLD.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_look_plus, z_look), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)5.0F);
                              if (entityinstance instanceof Mob) {
                                 Mob _mob164 = (Mob)entityinstance;
                                 _mob164.m_21557_(true);
                              }

                              entityinstance.m_20331_(true);
                              entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                                 }
                              }

                              entityinstance.m_20329_(ride_entity);
                              _serverLevel.m_7967_(entityinstance);
                           }
                        }

                        tower_spawn = true;
                     }
                  } else if (!tower_spawn) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT_TOWER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_look_plus, z_look), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                           entity.m_146922_(0.0F);
                           entity.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           if (entityinstance instanceof Mob) {
                              Mob _mob101 = (Mob)entityinstance;
                              _mob101.m_21557_(true);
                           }

                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           entityinstance.getPersistentData().m_128359_("TARGET_UUID", entityiterator.m_20149_());
                           entityinstance.getPersistentData().m_128347_("attack1", (double)1.0F);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity112 = (LivingEntity)entityinstance;
                              if (_livingEntity112.m_21204_().m_22171_(Attributes.f_22276_)) {
                                 AttributeInstance var122;
                                 int var130;
                                 label335: {
                                    var122 = _livingEntity112.m_21051_(Attributes.f_22276_);
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var130 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label335;
                                       }
                                    }

                                    var130 = 0;
                                 }

                                 var122.m_22100_((double)(150 + 5 * var130));
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              float var126;
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityinstance;
                                 var126 = _livEnt.m_21233_();
                              } else {
                                 var126 = -1.0F;
                              }

                              _entity.m_21153_(var126);
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var127;
                                 MobEffect var131;
                                 int var138;
                                 label323: {
                                    var127 = new MobEffectInstance;
                                    var131 = MobEffects.f_19600_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var138 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label323;
                                       }
                                    }

                                    var138 = 0;
                                 }

                                 double var139;
                                 if ((double)var138 * (double)0.5F <= (double)0.0F) {
                                    var139 = (double)1.0F;
                                 } else {
                                    label316: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var140 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label316;
                                          }
                                       }

                                       var140 = 0;
                                    }

                                    var139 = (double)var140 * (double)0.5F;
                                 }

                                 var127.<init>(var131, Integer.MAX_VALUE, (int)var139, false, false);
                                 _entity.m_7292_(var127);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                              }
                           }

                           ride_entity = entityinstance;
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SCAFFOLD.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_look_plus, z_look), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)5.0F);
                           if (entityinstance instanceof Mob) {
                              Mob _mob128 = (Mob)entityinstance;
                              _mob128.m_21557_(true);
                           }

                           entityinstance.m_20331_(true);
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                              }
                           }

                           entityinstance.m_20329_(ride_entity);
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     tower_spawn = true;
                  }
               }
            } else if (!tower_spawn) {
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_LIGHT_TOWER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_look, z_look), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
                     entity.m_146922_(0.0F);
                     entity.m_146926_((float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.0F, (double)360.0F));
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityinstance instanceof Mob) {
                        Mob _mob181 = (Mob)entityinstance;
                        _mob181.m_21557_(true);
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     entityinstance.getPersistentData().m_128347_("attack1", (double)0.0F);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity189 = (LivingEntity)entityinstance;
                        if (_livingEntity189.m_21204_().m_22171_(Attributes.f_22276_)) {
                           AttributeInstance var124;
                           int var133;
                           label274: {
                              var124 = _livingEntity189.m_21051_(Attributes.f_22276_);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var133 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label274;
                                 }
                              }

                              var133 = 0;
                           }

                           var124.m_22100_((double)(100 + 2 * var133));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        float var129;
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityinstance;
                           var129 = _livEnt.m_21233_();
                        } else {
                           var129 = -1.0F;
                        }

                        _entity.m_21153_(var129);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                        }
                     }

                     ride_entity = entityinstance;
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.PLOJECTILE_SCAFFOLD.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_look, y_look, z_look), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)5.0F);
                     if (entityinstance instanceof Mob) {
                        Mob _mob201 = (Mob)entityinstance;
                        _mob201.m_21557_(true);
                     }

                     entityinstance.m_20331_(true);
                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 600, 1, false, false));
                        }
                     }

                     entityinstance.m_20329_(ride_entity);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               tower_spawn = true;
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)100.0F) {
            entity.getPersistentData().m_128379_("hovering", false);
            entity.m_20242_(false);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 80, 1, false, false));
               }
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
