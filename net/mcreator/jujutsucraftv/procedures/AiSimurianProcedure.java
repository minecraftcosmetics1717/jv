package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.CrossEntity;
import net.mcreator.jujutsucraftv.entity.MaruruEntity;
import net.mcreator.jujutsucraftv.entity.OsukiEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AiSimurianProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         if (entity.m_6084_()) {
            AiActiveVProcedure.execute(world, x, y, z, entity);
            if (entity instanceof OsukiEntity) {
               label132: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity2 = (LivingEntity)entity;
                     if (_livingEntity2.m_21204_().m_22171_(Attributes.f_22278_)) {
                        _livingEntity2.m_21051_(Attributes.f_22278_).m_22100_((double)-0.5F);
                     }
                  }

                  label119: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt3 = (LivingEntity)entity;
                        if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                           break label119;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 10, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entity;
                     if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                        break label132;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                     }
                  }
               }
            }

            if (entity instanceof MaruruEntity || entity instanceof CrossEntity) {
               label134: {
                  label106: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.m_21023_(MobEffects.f_19600_)) {
                           break label106;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.m_21023_(MobEffects.f_19606_)) {
                        break label134;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                     }
                  }
               }
            }

            if (entity instanceof MaruruEntity) {
               float var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21223_();
               } else {
                  var10000 = -1.0F;
               }

               double var29 = (double)var10000;
               float var10001;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21233_();
               } else {
                  var10001 = -1.0F;
               }

               if (var29 <= (double)var10001 * 0.9) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MARURU_2_HELMET.get()));
                     _player.m_150109_().m_6596_();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MARURU_2_HELMET.get()));
                  }
               }

               float var30;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var30 = _livEnt.m_21223_();
               } else {
                  var30 = -1.0F;
               }

               double var31 = (double)var30;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21233_();
               } else {
                  var10001 = -1.0F;
               }

               if (var31 <= (double)var10001 * 0.7 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_MARURU.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }
            }

            LivingEntity var32;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var32 = _mobEnt.m_5448_();
            } else {
               var32 = null;
            }

            if (var32 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                  ResetCounterVProcedure.execute(entity);
                  GetDistanceVProcedure.execute(world, entity);
                  CalculateAttackVProcedure.execute(world, entity);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
