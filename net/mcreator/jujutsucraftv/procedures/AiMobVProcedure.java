package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.AIMobProcedure;
import net.mcreator.jujutsucraftv.entity.EbinaNijiEntity;
import net.mcreator.jujutsucraftv.entity.JohnKaisenEntity;
import net.mcreator.jujutsucraftv.entity.KatsuragiGouseiEntity;
import net.mcreator.jujutsucraftv.entity.RemiEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AiMobVProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (entity instanceof RemiEntity) {
            label134: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_(MobEffects.f_19600_)) {
                     break label134;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 3, false, false));
                  }
               }
            }

            label129: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label129;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 0, false, false));
                  }
               }
            }

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

            if (var29 <= (double)var10001 * (double)0.5F && entity instanceof RemiEntity) {
               RemiEntity animatable = (RemiEntity)entity;
               animatable.setTexture("remi2");
            }
         }

         if (entity instanceof EbinaNijiEntity) {
            label122: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.m_21023_(MobEffects.f_19600_)) {
                     break label122;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 6, false, false));
                  }
               }
            }

            label117: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt12 = (LivingEntity)entity;
                  if (_livEnt12.m_21023_(MobEffects.f_19606_)) {
                     break label117;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
                  }
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt14 = (Mob)entity;
               if (_mobEnt14.m_5912_() && !entity.getPersistentData().m_128471_("summoned")) {
                  SummonOnetTimeProcedure.execute(world, entity);
               }
            }
         }

         if (entity instanceof JohnKaisenEntity) {
            label144: {
               label110: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt17 = (LivingEntity)entity;
                     if (_livEnt17.m_21023_(MobEffects.f_19600_)) {
                        break label110;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 6, false, false));
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt19 = (LivingEntity)entity;
                  if (_livEnt19.m_21023_(MobEffects.f_19606_)) {
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

         if (entity instanceof KatsuragiGouseiEntity) {
            label145: {
               label99: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt22 = (LivingEntity)entity;
                     if (_livEnt22.m_21023_(MobEffects.f_19600_)) {
                        break label99;
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
                  LivingEntity _livEnt24 = (LivingEntity)entity;
                  if (_livEnt24.m_21023_(MobEffects.f_19606_)) {
                     break label145;
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

         AIMobProcedure.execute(world, x, y, z, entity);
      }
   }
}
