package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonSkeletonCursedSpiritProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double amount = (double)0.0F;
         double strength = (double)0.0F;
         double x_pos = (double)0.0F;
         double pitch = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double yaw = (double)0.0F;
         boolean player = false;
         boolean target = false;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)500.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entityiterator instanceof LivingEntity && (entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") || entityiterator.getPersistentData().m_128459_("friend_num") == (double)0.0F) && !(entityiterator instanceof Player) && entityiterator.getPersistentData().m_128471_("Summon") && entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.soul_sand.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.soul_sand.fall")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123783_, entityiterator.m_20185_(), entityiterator.m_20186_(), entityiterator.m_20189_(), 10, (double)1.0F, (double)1.0F, (double)1.0F, (double)1.0F);
                  }

                  if (!entityiterator.m_9236_().m_5776_()) {
                     entityiterator.m_146870_();
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("friend_num") == (double)0.0F) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 10, false, false));
            }
         }

         if (GetPlayerLevelProcedure.execute(entity) < (double)5.0F) {
            amount = (double)4.0F;
         } else if (GetPlayerLevelProcedure.execute(entity) == (double)20.0F) {
            amount = (double)16.0F;
         } else {
            amount = (double)8.0F;
         }

         if (entity.getPersistentData().m_128459_("cnt1") == (double)2.0F) {
            for(int index0 = 0; index0 < (int)amount; ++index0) {
               x_pos += Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F);
               z_pos += Mth.m_216263_(RandomSource.m_216327_(), (double)-3.0F, (double)3.0F);
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_YELLOW_HELMET.get()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraft:cursed_spirit_grade_24 ~ ~ ~");
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_GREEN_HELMET.get()) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraftv:cursed_spirit_grade_26 ~ ~ ~");
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_WHITE_HELMET.get()) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraftv:cursed_spirit_grade_213 ~ ~ ~");
                        }
                     } else if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "/summon jujutsucraft:cursed_spirit_grade_39 ~ ~ ~");
                     }
                  }
               }

               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)0.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entityiterator instanceof LivingEntity && (entity.getPersistentData().m_128459_("friend_num") == entityiterator.getPersistentData().m_128459_("friend_num") || entityiterator.getPersistentData().m_128459_("friend_num") == (double)0.0F) && !(entityiterator instanceof Player)) {
                     entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var10001;
                           MobEffect var10003;
                           int var10005;
                           label178: {
                              var10001 = new MobEffectInstance;
                              var10003 = MobEffects.f_19600_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label178;
                                 }
                              }

                              var10005 = 0;
                           }

                           var10001.<init>(var10003, Integer.MAX_VALUE, Math.round((float)(var10005 / 2)), false, false);
                           _entity.m_7292_(var10001);
                        }
                     }

                     if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffectInstance var59;
                           MobEffect var61;
                           int var63;
                           label170: {
                              var59 = new MobEffectInstance;
                              var61 = MobEffects.f_19606_;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                    var63 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                    break label170;
                                 }
                              }

                              var63 = 0;
                           }

                           var59.<init>(var61, Integer.MAX_VALUE, Math.round((float)(var63 / 2)), false, false);
                           _entity.m_7292_(var59);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt53 = (LivingEntity)entity;
                        if (_livEnt53.m_21023_(MobEffects.f_19616_)) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var60;
                                 MobEffect var62;
                                 int var64;
                                 label160: {
                                    var60 = new MobEffectInstance;
                                    var62 = MobEffects.f_19616_;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19616_)) {
                                          var64 = _livEnt.m_21124_(MobEffects.f_19616_).m_19564_();
                                          break label160;
                                       }
                                    }

                                    var64 = 0;
                                 }

                                 var60.<init>(var62, Integer.MAX_VALUE, Math.round((float)(var64 / 3)), false, false);
                                 _entity.m_7292_(var60);
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityiterator;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19601_, 10, 200, false, false));
                              }
                           }
                        }
                     }

                     if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                        entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "/effect give @s jujutsucraft:cooldown_time_back_step infinite 0 true");
                     }

                     entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                     entityiterator.getPersistentData().m_128379_("Shikigami", true);
                     entityiterator.getPersistentData().m_128379_("jjkChara", true);
                     entityiterator.getPersistentData().m_128379_("Summon", true);
                     entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                     entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                     entityiterator.getPersistentData().m_128379_("CursedSpirit", entity.getPersistentData().m_128471_("CursedSpirit"));
                     entityiterator.getPersistentData().m_128379_("Player", entity instanceof Player);
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
