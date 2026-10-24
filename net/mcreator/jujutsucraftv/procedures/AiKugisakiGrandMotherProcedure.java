package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.KarmaEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AiKugisakiGrandMotherProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double level = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            AiActiveVProcedure.execute(world, x, y, z, entity);
            if (entity instanceof KarmaEntity) {
               label140: {
                  label124: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt2 = (LivingEntity)entity;
                        if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                           break label124;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 8, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                        break label140;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
                     }
                  }
               }
            } else {
               label144: {
                  label130: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt6 = (LivingEntity)entity;
                        if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                           break label130;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 7, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_(MobEffects.f_19606_)) {
                        break label144;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
                     }
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                  ResetCounterVProcedure.execute(entity);
                  distance = GetDistanceVProcedure.execute(world, entity);
                  if (!GetCoolDownCombatProcedure.execute(entity) && distance > (double)3.0F && distance < (double)24.0F && entity.getPersistentData().m_128459_("cnt_nail") < (double)5.0F && Math.random() < (double)0.5F) {
                     rnd = (double)5.0F;
                     level = (double)1.0F;
                     tick = (double)3.0F;
                  }

                  if (LogicStartVProcedure.execute(entity) && Math.pow((double)0.75F, entity.getPersistentData().m_128459_("cnt_nail")) < Math.random()) {
                     rnd = (double)6.0F;
                     level = (double)0.0F;
                     tick = (double)50.0F;
                  }

                  if (rnd > (double)0.0F) {
                     if (rnd == (double)5.0F) {
                        entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), (double)6.0F));
                        entity.getPersistentData().m_128347_("cnt_nail", entity.getPersistentData().m_128459_("cnt_nail") + (double)1.0F);
                     } else if (rnd == (double)6.0F) {
                        entity.getPersistentData().m_128347_("cnt_nail", Math.max(entity.getPersistentData().m_128459_("cnt_nail") - (double)10.0F, (double)0.0F));
                     }

                     entity.getPersistentData().m_128347_("skill", (double)3400.0F + rnd);
                     if (level > (double)0.0F) {
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time_combat " + tick + " 0 true");
                        }
                     } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + tick + " 0 true");
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique infinite 0 true");
                     }
                  } else {
                     CalculateAttackVProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
            }
         }

      }
   }
}
