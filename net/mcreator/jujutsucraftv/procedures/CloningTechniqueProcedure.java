package net.mcreator.jujutsucraftv.procedures;

import java.util.Locale;
import java.util.function.Consumer;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftv.entity.CloneEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class CloningTechniqueProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack right_hand = ItemStack.f_41583_;
         ItemStack left_hand = ItemStack.f_41583_;
         ItemStack armor0 = ItemStack.f_41583_;
         ItemStack armor1 = ItemStack.f_41583_;
         ItemStack armor2 = ItemStack.f_41583_;
         ItemStack armor3 = ItemStack.f_41583_;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos_2 = (double)0.0F;
         double count = (double)0.0F;
         double tec_count = (double)0.0F;
         if (GetFlagShiftProcedure.execute(entity)) {
            tec_count = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax - ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount;
         } else {
            tec_count = (double)1.0F;
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);

         for(int index0 = 0; index0 < (int)tec_count; ++index0) {
            x_pos = XLookPositionProcedure.execute(entity, (double)1.0F);
            y_pos = YLookPositionProcedure.execute(entity, (double)1.0F);
            z_pos = ZLookPositionProcedure.execute(entity, (double)1.0F);
            double var10000 = entity.m_20186_() + (double)entity.m_20206_() * (double)0.75F + Math.sin(pitch) * (double)-1.0F * (double)(1.0F + entity.m_20205_());
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 4, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
               if (!(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax <= (double)0.0F)) {
                  double _setval = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount + (double)1.0F;
                  entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.CloneCount = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount <= ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax && ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount > (double)0.0F) {
                     x_pos += (double)Mth.m_216271_(RandomSource.m_216327_(), -2, 2);
                     z_pos += (double)Mth.m_216271_(RandomSource.m_216327_(), -2, 2);
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftvModEntities.CLONE.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 20, 0.8, (double)2.0F, 0.8, 0.3);
                           }

                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                              } else {
                                 _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bubble_column.upwards_inside")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                              }
                           }

                           entityinstance.m_6593_(Component.m_237113_(entity.m_5446_().getString()));
                           entityinstance.m_20340_(false);
                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var10001;
                                 MobEffect var10003;
                                 float var10005;
                                 label281: {
                                    var10001 = new MobEffectInstance;
                                    var10003 = MobEffects.f_19600_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10005 = (float)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label281;
                                       }
                                    }

                                    var10005 = 0.0F;
                                 }

                                 int var108;
                                 if (Math.round(var10005) < 0) {
                                    var108 = 1;
                                 } else {
                                    label274: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                             var109 = (float)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                             break label274;
                                          }
                                       }

                                       var109 = 0.0F;
                                    }

                                    var108 = Math.round(var109);
                                 }

                                 var10001.<init>(var10003, Integer.MAX_VALUE, var108, false, false);
                                 _entity.m_7292_(var10001);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var98;
                                 MobEffect var104;
                                 int var110;
                                 label263: {
                                    var98 = new MobEffectInstance;
                                    var104 = MobEffects.f_19606_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                          var110 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                          break label263;
                                       }
                                    }

                                    var110 = 0;
                                 }

                                 var98.<init>(var104, Integer.MAX_VALUE, var110, false, false);
                                 _entity.m_7292_(var98);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, Integer.MAX_VALUE, 0, false, false));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt28 = (LivingEntity)entity;
                              if (_livEnt28.m_21023_(MobEffects.f_19616_)) {
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityinstance;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       MobEffectInstance var99;
                                       MobEffect var105;
                                       int var111;
                                       label248: {
                                          var99 = new MobEffectInstance;
                                          var105 = MobEffects.f_19616_;
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_(MobEffects.f_19616_)) {
                                                var111 = _livEnt.m_21124_(MobEffects.f_19616_).m_19564_();
                                                break label248;
                                             }
                                          }

                                          var111 = 0;
                                       }

                                       var99.<init>(var105, Integer.MAX_VALUE, var111, false, false);
                                       _entity.m_7292_(var99);
                                    }
                                 }

                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityinstance;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance(MobEffects.f_19601_, 10, 200, false, false));
                                    }
                                 }
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              float var100;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var100 = _livEnt.m_21223_();
                              } else {
                                 var100 = -1.0F;
                              }

                              _entity.m_21153_(var100);
                           }

                           if (entityinstance instanceof TamableAnimal) {
                              TamableAnimal _toTame = (TamableAnimal)entityinstance;
                              if (entity instanceof Player) {
                                 Player _owner = (Player)entity;
                                 _toTame.m_21828_(_owner);
                              }
                           }

                           ((LivingEntity)entityinstance).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.0F);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity43 = (LivingEntity)entityinstance;
                              if (_livingEntity43.m_21204_().m_22171_(Attributes.f_22284_)) {
                                 double var101;
                                 label234: {
                                    var90 = _livingEntity43.m_21051_(Attributes.f_22284_);
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity41 = (LivingEntity)entity;
                                       if (_livingEntity41.m_21204_().m_22171_(Attributes.f_22284_)) {
                                          var101 = _livingEntity41.m_21051_(Attributes.f_22284_).m_22115_();
                                          break label234;
                                       }
                                    }

                                    var101 = (double)0.0F;
                                 }

                                 var90.m_22100_(var101 + (double)5.0F);
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity46 = (LivingEntity)entityinstance;
                              if (_livingEntity46.m_21204_().m_22171_(Attributes.f_22285_)) {
                                 double var102;
                                 label223: {
                                    var91 = _livingEntity46.m_21051_(Attributes.f_22285_);
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity44 = (LivingEntity)entity;
                                       if (_livingEntity44.m_21204_().m_22171_(Attributes.f_22285_)) {
                                          var102 = _livingEntity44.m_21051_(Attributes.f_22285_).m_22115_();
                                          break label223;
                                       }
                                    }

                                    var102 = (double)0.0F;
                                 }

                                 var91.m_22100_(var102);
                              }
                           }

                           if (entityinstance instanceof CloneEntity) {
                              CloneEntity _datEntSetL = (CloneEntity)entityinstance;
                              _datEntSetL.m_20088_().m_135381_(CloneEntity.DATA_follow, true);
                           }

                           entityinstance.getPersistentData().m_128379_("jjkChara", true);
                           entityinstance.getPersistentData().m_128379_("Shikigami", true);
                           entityinstance.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                           entityinstance.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                           entityinstance.getPersistentData().m_128379_("CursedSpirit", entity.getPersistentData().m_128471_("CursedSpirit"));
                           entityinstance.getPersistentData().m_128379_("Player", entity instanceof Player);
                           if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
                              entityinstance.getPersistentData().m_128379_("EntityParticleSet", true);
                              entityinstance.getPersistentData().m_128347_("EntitySetParticle", ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor);
                           }

                           if (GetCanUseReverseCursedTechniqueProcedure.execute(entity)) {
                              entityinstance.getPersistentData().m_128379_("entity_can_use_rct", true);
                           }

                           ItemStack var92 = new ItemStack;
                           IForgeRegistry var10002 = ForgeRegistries.ITEMS;
                           ResourceLocation var106 = new ResourceLocation;
                           IForgeRegistry var112 = ForgeRegistries.ITEMS;
                           ItemStack var10006;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10006 = _livEnt.m_21205_();
                           } else {
                              var10006 = ItemStack.f_41583_;
                           }

                           var106.<init>(var112.getKey(var10006.m_41720_()).toString().toLowerCase(Locale.ENGLISH));
                           var92.<init>((ItemLike)var10002.getValue(var106));
                           right_hand = var92.m_41777_();
                           var92 = new ItemStack;
                           var10002 = ForgeRegistries.ITEMS;
                           var106 = new ResourceLocation;
                           var112 = ForgeRegistries.ITEMS;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10006 = _livEnt.m_21206_();
                           } else {
                              var10006 = ItemStack.f_41583_;
                           }

                           var106.<init>(var112.getKey(var10006.m_41720_()).toString().toLowerCase(Locale.ENGLISH));
                           var92.<init>((ItemLike)var10002.getValue(var106));
                           left_hand = var92.m_41777_();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              ItemStack _setstack = right_hand.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              ItemStack _setstack = left_hand.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var92 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var92 = ItemStack.f_41583_;
                           }

                           armor3 = var92.m_41777_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var92 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                           } else {
                              var92 = ItemStack.f_41583_;
                           }

                           armor2 = var92.m_41777_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var92 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                           } else {
                              var92 = ItemStack.f_41583_;
                           }

                           armor1 = var92.m_41777_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var92 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                           } else {
                              var92 = ItemStack.f_41583_;
                           }

                           armor0 = var92.m_41777_();
                           if (entityinstance instanceof Player) {
                              Player _player = (Player)entityinstance;
                              _player.m_150109_().f_35975_.set(3, armor3);
                              _player.m_150109_().m_6596_();
                           } else if (entityinstance instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entityinstance;
                              _living.m_8061_(EquipmentSlot.HEAD, armor3);
                           }

                           if (entityinstance instanceof Player) {
                              Player _player = (Player)entityinstance;
                              _player.m_150109_().f_35975_.set(2, armor2);
                              _player.m_150109_().m_6596_();
                           } else if (entityinstance instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entityinstance;
                              _living.m_8061_(EquipmentSlot.CHEST, armor2);
                           }

                           if (entityinstance instanceof Player) {
                              Player _player = (Player)entityinstance;
                              _player.m_150109_().f_35975_.set(1, armor1);
                              _player.m_150109_().m_6596_();
                           } else if (entityinstance instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entityinstance;
                              _living.m_8061_(EquipmentSlot.LEGS, armor1);
                           }

                           if (entityinstance instanceof Player) {
                              Player _player = (Player)entityinstance;
                              _player.m_150109_().f_35975_.set(0, armor0);
                              _player.m_150109_().m_6596_();
                           } else if (entityinstance instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entityinstance;
                              _living.m_8061_(EquipmentSlot.FEET, armor0);
                           }

                           _serverLevel.m_7967_(entityinstance);
                        }
                     }
                  } else {
                     _setval = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount - (double)1.0F;
                     entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.CloneCount = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_summon").getString()), true);
                        }
                     }
                  }
               } else if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_summon").getString()), true);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)5.0F) {
            if (!(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount < ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneMax) && !(((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).CloneCount > (double)0.0F)) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
               }

               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }
}
