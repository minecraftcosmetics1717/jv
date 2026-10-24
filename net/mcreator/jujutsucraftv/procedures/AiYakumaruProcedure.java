package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraftv.entity.YakumaruEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AiYakumaruProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         String entity_say_set = "";
         if (entity.m_6084_()) {
            float var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21223_();
            } else {
               var10000 = -1.0F;
            }

            double var45 = (double)var10000;
            float var10001;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10001 = _livEnt.m_21233_();
            } else {
               var10001 = -1.0F;
            }

            if (var45 > (double)var10001 * 0.2) {
               int var46;
               if (entity instanceof YakumaruEntity) {
                  YakumaruEntity _datEntI = (YakumaruEntity)entity;
                  var46 = (Integer)_datEntI.m_20088_().m_135370_(YakumaruEntity.DATA_entity_form);
               } else {
                  var46 = 0;
               }

               if (var46 == 0) {
                  label128: {
                     AiActiveVProcedure.execute(world, x, y, z, entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt4 = (LivingEntity)entity;
                        if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                           break label128;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 8, false, false));
                        }
                     }
                  }

                  label123: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                           break label123;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                        }
                     }
                  }

                  LivingEntity var51;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var51 = _mobEnt.m_5448_();
                  } else {
                     var51 = null;
                  }

                  if (var51 instanceof LivingEntity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.YAKUMARU_WEAPON.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                     if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                        entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                        ResetCounterVProcedure.execute(entity);
                        GetDistanceVProcedure.execute(world, entity);
                        CalculateAttackVProcedure.execute(world, entity);
                        return;
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
                  }

                  return;
               }
            }

            if (entity.getPersistentData().m_128459_("form_change") == (double)1.0F) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, Integer.MAX_VALUE, 200, false, false));
                  }
               }

               if (entity.getPersistentData().m_128459_("entity_sayed") != (double)1.0F) {
                  Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)7.5F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     label186: {
                        if ((Entity)world.m_6443_(LivingEntity.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (double)10.0F, (double)10.0F, (double)10.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                           }
                        })).compareDistOf(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).findFirst().orElse((Object)null) == entityiterator && entity != entityiterator && !LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                           LivingEntity var47;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var47 = _mobEnt.m_5448_();
                           } else {
                              var47 = null;
                           }

                           if (var47 != entityiterator) {
                              if (entityiterator instanceof Mob) {
                                 Mob _mobEnt = (Mob)entityiterator;
                                 var47 = _mobEnt.m_5448_();
                              } else {
                                 var47 = null;
                              }

                              if (var47 != entity) {
                                 break label186;
                              }
                           }
                        }

                        if ((Entity)world.m_6443_(Player.class, AABB.m_165882_(new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (double)10.0F, (double)10.0F, (double)10.0F), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                           }
                        })).compareDistOf(entity.m_20185_(), entity.m_20186_(), entity.m_20189_())).findFirst().orElse((Object)null) != entityiterator || entity == entityiterator || LogicAttackProcedure.execute(world, entity, entityiterator) || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
                           continue;
                        }

                        LivingEntity var49;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var49 = _mobEnt.m_5448_();
                        } else {
                           var49 = null;
                        }

                        if (var49 == entityiterator) {
                           continue;
                        }

                        if (entityiterator instanceof Mob) {
                           Mob _mobEnt = (Mob)entityiterator;
                           var49 = _mobEnt.m_5448_();
                        } else {
                           var49 = null;
                        }

                        if (var49 == entity) {
                           continue;
                        }
                     }

                     entity_say_set = entityiterator.m_5446_().getString();
                     entity.getPersistentData().m_128347_("say_set", (double)1.0F);
                  }

                  if (entity.getPersistentData().m_128459_("say_set") == (double)1.0F && !entity_say_set.isEmpty()) {
                     _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)10.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entityiterator instanceof Player) {
                           Player _player = (Player)entityiterator;
                           if (!_player.m_9236_().m_5776_()) {
                              String var52 = entity.m_5446_().getString();
                              _player.m_5661_(Component.m_237113_("<" + var52 + ">" + entity_say_set + Component.m_237115_("jjcv.message.yakumaru_dying").getString()), false);
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("entity_sayed", (double)1.0F);
                  }
               }
            } else {
               if (entity instanceof YakumaruEntity) {
                  YakumaruEntity _datEntSetI = (YakumaruEntity)entity;
                  _datEntSetI.m_20088_().m_135381_(YakumaruEntity.DATA_entity_form, 1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_blood_red ~ ~ ~ 0.01 0.01 0.01 0.3 10");
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "playsound jujutsucraft:crush ambient @s ~ ~ ~ 1 1.8");
               }

               entity.getPersistentData().m_128347_("form_change", (double)1.0F);
            }
         }

      }
   }
}
