package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade12Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade14Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade16Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade18Entity;
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

public class AiCursedSpirit1MainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double skill = (double)0.0F;
         if (entity.m_6084_()) {
            label151: {
               AiActiveVProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label151;
                  }
               }

               if ((entity instanceof CursedSpiritGrade14Entity || entity instanceof CursedSpiritGrade16Entity || entity instanceof CursedSpiritGrade18Entity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 8, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 9, false, false));
                  }
               }
            }

            label124: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19606_)) {
                     break label124;
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

               double var33 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var36 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var36 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var33, var36, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
               if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                  if (entity instanceof CursedSpiritGrade12Entity) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)-5.0F);
                  } else {
                     entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                  }

                  ResetCounterVProcedure.execute(entity);
                  distance = GetDistanceVProcedure.execute(world, entity);
                  if (!GetCoolDownProcedure.execute(entity) && entity instanceof CursedSpiritGrade14Entity && distance > (double)5.0F) {
                     var10001 = Anchor.EYES;
                     var10002 = new Vec3;
                     LivingEntity var34;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var34 = _mobEnt.m_5448_();
                     } else {
                        var34 = null;
                     }

                     double var35 = ((Entity)var34).m_20185_();
                     LivingEntity var38;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var38 = _mobEnt.m_5448_();
                     } else {
                        var38 = null;
                     }

                     double var39 = ((Entity)var38).m_20186_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var39 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10006 = _mobEnt.m_5448_();
                     } else {
                        var10006 = null;
                     }

                     var10002.<init>(var35, var39, ((Entity)var10006).m_20189_());
                     entity.m_7618_(var10001, var10002);
                     skill = (double)69900.0F;
                     rnd = (double)50.0F;
                     tick = (double)10.0F;
                  }

                  if (rnd > (double)0.0F) {
                     entity.getPersistentData().m_128347_("skill", skill + rnd);
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
