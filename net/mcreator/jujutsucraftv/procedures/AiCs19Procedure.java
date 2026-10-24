package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AiCs19Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         if (entity.m_6084_()) {
            label89: {
               AiActiveVProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label89;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label84: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label84;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 2, false, false));
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
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var23 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var24 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var23, var24, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  entity.getPersistentData().m_128347_("cnt_x", (double)-15.0F);
                  ResetCounterVProcedure.execute(entity);
                  distance = GetDistanceVProcedure.execute(world, entity);
                  if (!GetCoolDownProcedure.execute(entity) && distance > (double)5.0F) {
                     rnd = (double)5.0F;
                     tick = (double)10.0F;
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", (double)63300.0F + rnd);
                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + Math.round(tick) + " 0 true");
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
