package net.mcreator.jujutsucraftv.procedures;

import java.util.function.Consumer;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSummonRozetsuShikigamiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double num) {
      if (entity != null) {
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double count = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 10, false, false));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            int _ppvTimes31 = Math.max(0, num == (double)1.0F ? 3 : 1);

            for(int _ppvIndex31 = 0; _ppvIndex31 < _ppvTimes31; ++_ppvIndex31) {
               if (num == (double)1.0F) {
                  ++count;
                  if (count == (double)2.0F) {
                     x_pos = entity.m_20185_() - Math.sin(Math.toRadians((double)(entity.m_146908_() + 45.0F))) * (double)2.0F;
                     z_pos = entity.m_20189_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 45.0F))) * (double)2.0F;
                  } else if (count == (double)3.0F) {
                     x_pos = entity.m_20185_() - Math.sin(Math.toRadians((double)(entity.m_146908_() + -45.0F))) * (double)2.0F;
                     z_pos = entity.m_20189_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + -45.0F))) * (double)2.0F;
                  } else {
                     x_pos = entity.m_20185_() - Math.sin(Math.toRadians((double)(entity.m_146908_() + 0.0F))) * (double)2.0F;
                     z_pos = entity.m_20189_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 0.0F))) * (double)2.0F;
                  }

                  y_pos = entity.m_20186_() + (double)1.0F;
               } else {
                  if (Math.random() < (double)0.5F) {
                     x_pos = entity.m_20185_() - Math.sin(Math.toRadians((double)(entity.m_146908_() + 45.0F))) * (double)2.0F;
                     z_pos = entity.m_20189_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 45.0F))) * (double)2.0F;
                  } else {
                     x_pos = entity.m_20185_() - Math.sin(Math.toRadians((double)(entity.m_146908_() + -45.0F))) * (double)2.0F;
                     z_pos = entity.m_20189_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + -45.0F))) * (double)2.0F;
                  }

                  y_pos = entity.m_20186_() + (double)1.0F;
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               for(int index0 = 0; index0 < 3; ++index0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var10000 = _level.m_7654_().m_129892_();
                     CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     String var10002 = ReturnEnergyColor3Procedure.execute(entity);
                     var10000.m_230957_(var10001, "/particle " + var10002 + " ~ ~ ~ 0.1 " + entity.m_20206_() + " 0.1 0.3 15");
                  }
               }

               if (num == (double)1.0F && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (!(entity instanceof Player)) {
                        entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityinstance.m_20149_());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entityinstance;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22281_)) {
                           AttributeInstance var68;
                           double var73;
                           double var83;
                           label449: {
                              var68 = _livingEntity.m_21051_(Attributes.f_22281_);
                              var73 = _livingEntity.m_21051_(Attributes.f_22281_).m_22115_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _owner = (LivingEntity)entity;
                                 if (_owner.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var83 = _owner.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label449;
                                 }
                              }

                              var83 = (double)0.0F;
                           }

                           int var10003;
                           label444: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label444;
                                 }
                              }

                              var10003 = 0;
                           }

                           var68.m_22100_(var73 + (var83 + (double)(var10003 * 3)) * (double)0.5F);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var74;
                           MobEffect var88;
                           int var10005;
                           label433: {
                              var74 = new MobEffectInstance;
                              var88 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label433;
                                 }
                              }

                              var10005 = 0;
                           }

                           var74.<init>(var88, Integer.MAX_VALUE, Math.max(var10005, 0), false, false);
                           _entity.m_7292_(var74);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                     }

                     if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                        entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (num == (double)2.0F && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (!(entity instanceof Player)) {
                        entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityinstance.m_20149_());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entityinstance;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22281_)) {
                           AttributeInstance var69;
                           double var75;
                           double var84;
                           label410: {
                              var69 = _livingEntity.m_21051_(Attributes.f_22281_);
                              var75 = _livingEntity.m_21051_(Attributes.f_22281_).m_22115_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _owner = (LivingEntity)entity;
                                 if (_owner.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var84 = _owner.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label410;
                                 }
                              }

                              var84 = (double)0.0F;
                           }

                           int var89;
                           label405: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var89 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label405;
                                 }
                              }

                              var89 = 0;
                           }

                           var69.m_22100_(var75 + (var84 + (double)(var89 * 3)) * (double)0.5F);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var76;
                           MobEffect var90;
                           int var97;
                           label394: {
                              var76 = new MobEffectInstance;
                              var90 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var97 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label394;
                                 }
                              }

                              var97 = 0;
                           }

                           var76.<init>(var90, Integer.MAX_VALUE, Math.max(var97, 0), false, false);
                           _entity.m_7292_(var76);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                     }

                     if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                        entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (num == (double)3.0F && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (!(entity instanceof Player)) {
                        entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityinstance.m_20149_());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entityinstance;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22281_)) {
                           AttributeInstance var70;
                           double var77;
                           double var85;
                           label371: {
                              var70 = _livingEntity.m_21051_(Attributes.f_22281_);
                              var77 = _livingEntity.m_21051_(Attributes.f_22281_).m_22115_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _owner = (LivingEntity)entity;
                                 if (_owner.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var85 = _owner.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label371;
                                 }
                              }

                              var85 = (double)0.0F;
                           }

                           int var91;
                           label366: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var91 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label366;
                                 }
                              }

                              var91 = 0;
                           }

                           var70.m_22100_(var77 + (var85 + (double)(var91 * 3)) * (double)0.5F);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var78;
                           MobEffect var92;
                           int var98;
                           label355: {
                              var78 = new MobEffectInstance;
                              var92 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var98 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label355;
                                 }
                              }

                              var98 = 0;
                           }

                           var78.<init>(var92, Integer.MAX_VALUE, Math.max(var98, 0), false, false);
                           _entity.m_7292_(var78);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                     }

                     if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                        entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (num == (double)4.0F && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ROZETSU_SHIKIGAMI_BOOGIE_WOOGIE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (!(entity instanceof Player)) {
                        entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityinstance.m_20149_());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entityinstance;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22281_)) {
                           AttributeInstance var71;
                           double var79;
                           double var86;
                           label332: {
                              var71 = _livingEntity.m_21051_(Attributes.f_22281_);
                              var79 = _livingEntity.m_21051_(Attributes.f_22281_).m_22115_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _owner = (LivingEntity)entity;
                                 if (_owner.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var86 = _owner.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label332;
                                 }
                              }

                              var86 = (double)0.0F;
                           }

                           int var93;
                           label327: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var93 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label327;
                                 }
                              }

                              var93 = 0;
                           }

                           var71.m_22100_(var79 + (var86 + (double)(var93 * 3)) * (double)0.5F);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var80;
                           MobEffect var94;
                           int var99;
                           label316: {
                              var80 = new MobEffectInstance;
                              var94 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var99 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label316;
                                 }
                              }

                              var99 = 0;
                           }

                           var80.<init>(var94, Integer.MAX_VALUE, Math.max(var99, 0), false, false);
                           _entity.m_7292_(var80);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                     }

                     if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                        entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (num == (double)5.0F && world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftvModEntities.ROZETSU_SHIKIGAMI_SHRINE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     entityinstance.m_146922_(entity.m_146908_());
                     entityinstance.m_146926_(entity.m_146909_());
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (!(entity instanceof Player)) {
                        entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityinstance.m_20149_());
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entityinstance;
                        if (_livingEntity.m_21204_().m_22171_(Attributes.f_22281_)) {
                           AttributeInstance var72;
                           double var81;
                           double var87;
                           label293: {
                              var72 = _livingEntity.m_21051_(Attributes.f_22281_);
                              var81 = _livingEntity.m_21051_(Attributes.f_22281_).m_22115_();
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _owner = (LivingEntity)entity;
                                 if (_owner.m_21204_().m_22171_(Attributes.f_22281_)) {
                                    var87 = _owner.m_21051_(Attributes.f_22281_).m_22115_();
                                    break label293;
                                 }
                              }

                              var87 = (double)0.0F;
                           }

                           int var95;
                           label288: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var95 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label288;
                                 }
                              }

                              var95 = 0;
                           }

                           var72.m_22100_(var81 + (var87 + (double)(var95 * 3)) * (double)0.5F);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var82;
                           MobEffect var96;
                           int var100;
                           label277: {
                              var82 = new MobEffectInstance;
                              var96 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var100 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label277;
                                 }
                              }

                              var100 = 0;
                           }

                           var82.<init>(var96, Integer.MAX_VALUE, Math.max(var100, 0), false, false);
                           _entity.m_7292_(var82);
                        }
                     }

                     entityinstance.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                     entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityinstance.getPersistentData().m_128379_("CursedSpirit", true);
                     entityinstance.getPersistentData().m_128379_("Shikigami", true);
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().m_128347_("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                     }

                     if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                        entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                        entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)10.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
