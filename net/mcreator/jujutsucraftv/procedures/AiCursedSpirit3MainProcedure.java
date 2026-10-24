package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.AICursedSpirit3Procedure;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade311Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade315Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade316Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade317Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade318Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade319Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade31Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade320Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade32Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade33Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade34Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade35Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade37Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade39Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

public class AiCursedSpirit3MainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double distance = (double)0.0F;
         double skill = (double)0.0F;
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         if (entity.m_6084_()) {
            if (!(entity instanceof CursedSpiritGrade35Entity) && !(entity instanceof CursedSpiritGrade315Entity) && !(entity instanceof CursedSpiritGrade37Entity) && !(entity instanceof CursedSpiritGrade311Entity) && !(entity instanceof CursedSpiritGrade318Entity)) {
               if (!(entity instanceof CursedSpiritGrade32Entity) && !(entity instanceof CursedSpiritGrade33Entity) && !(entity instanceof CursedSpiritGrade34Entity) && !(entity instanceof CursedSpiritGrade39Entity) && !(entity instanceof CursedSpiritGrade316Entity) && !(entity instanceof CursedSpiritGrade320Entity)) {
                  if (entity instanceof CursedSpiritGrade319Entity) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 3, false, false));
                        }
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 0, false, false));
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 1, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 2, false, false));
               }
            }

            if (!(entity instanceof CursedSpiritGrade32Entity) && !(entity instanceof CursedSpiritGrade315Entity)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 0, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
               }
            }

            if (entity instanceof CursedSpiritGrade317Entity && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 2, false, false));
               }
            }

            if (entity instanceof CursedSpiritGrade318Entity && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 4, false, false));
               }
            }

            if (entity instanceof CursedSpiritGrade319Entity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 14, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity29 = (LivingEntity)entity;
                  if (_livingEntity29.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                     _livingEntity29.m_21051_((Attribute)ForgeMod.SWIM_SPEED.get()).m_22100_((double)3.0F);
                  }
               }
            }

            if (entity instanceof CursedSpiritGrade31Entity) {
               float var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21223_();
               } else {
                  var10000 = -1.0F;
               }

               float var10001;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21233_();
               } else {
                  var10001 = -1.0F;
               }

               if (var10000 < var10001 / 2.0F && entity instanceof Mob) {
                  Mob _mobEnt33 = (Mob)entity;
                  if (_mobEnt33.m_5912_() && Mth.m_216271_(RandomSource.m_216327_(), 1, 50) <= 30) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)1.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        LivingEntity var42;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var42 = _mobEnt.m_5448_();
                        } else {
                           var42 = null;
                        }

                        if (var42 == entityiterator) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_254877_(entity, new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), (ExplosionDamageCalculator)null, x, y, z, 2.0F, false, ExplosionInteraction.MOB);
                              }
                           }

                           if (!entity.m_9236_().m_5776_()) {
                              entity.m_146870_();
                           }
                        }
                     }
                  }
               }
            } else if (entity instanceof CursedSpiritGrade320Entity) {
               LivingEntity var43;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var43 = _mobEnt.m_5448_();
               } else {
                  var43 = null;
               }

               if (var43 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + (double)1.0F);
                  if (entity.getPersistentData().m_128459_("cnt_x") > (double)10.0F && entity.getPersistentData().m_128459_("skill") == (double)0.0F) {
                     entity.getPersistentData().m_128347_("cnt_x", (double)-10.0F);
                     ResetCounterVProcedure.execute(entity);
                     distance = GetDistanceVProcedure.execute(world, entity);
                     if (!GetCoolDownProcedure.execute(entity) && entity instanceof CursedSpiritGrade320Entity && distance > (double)5.0F) {
                        EntityAnchorArgument.Anchor var44 = Anchor.EYES;
                        Vec3 var10002 = new Vec3;
                        LivingEntity var10004;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        double var45 = ((Entity)var10004).m_20185_();
                        LivingEntity var10005;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        double var46 = ((Entity)var10005).m_20186_();
                        LivingEntity var10006;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10006 = _mobEnt.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        var46 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10006 = _mobEnt.m_5448_();
                        } else {
                           var10006 = null;
                        }

                        var10002.<init>(var45, var46, ((Entity)var10006).m_20189_());
                        entity.m_7618_(var44, var10002);
                        skill = (double)4705.0F;
                        tick = (double)15.0F;
                     }

                     if (skill > (double)0.0F) {
                        entity.getPersistentData().m_128347_("skill", skill);
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cooldown_time " + Math.round(tick) + " 0 true");
                        }

                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/effect give @s jujutsucraft:cursed_technique infinite 0 true");
                        }
                     } else {
                        AICursedSpirit3Procedure.execute(world, x, y, z, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", (double)0.0F);
               }
            } else {
               AICursedSpirit3Procedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
