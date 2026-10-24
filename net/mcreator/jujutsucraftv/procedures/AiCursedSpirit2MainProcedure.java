package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade211Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade212Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade213Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade215Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade217Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade218Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade219Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade21Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade220Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade221Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade222Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade22Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade26Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade27Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade28Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade29Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

public class AiCursedSpirit2MainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         double tick = (double)0.0F;
         double distance = (double)0.0F;
         double level = (double)0.0F;
         if (entity.m_6084_()) {
            label150: {
               AiActiveVProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label150;
                  }
               }

               if ((entity instanceof CursedSpiritGrade21Entity || entity instanceof CursedSpiritGrade26Entity || entity instanceof CursedSpiritGrade27Entity || entity instanceof CursedSpiritGrade28Entity || entity instanceof CursedSpiritGrade29Entity || entity instanceof CursedSpiritGrade211Entity || entity instanceof CursedSpiritGrade213Entity || entity instanceof CursedSpiritGrade215Entity || entity instanceof CursedSpiritGrade217Entity || entity instanceof CursedSpiritGrade218Entity || entity instanceof CursedSpiritGrade219Entity || entity instanceof CursedSpiritGrade220Entity || entity instanceof CursedSpiritGrade221Entity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 6, false, false));
                  }
               }

               if ((entity instanceof CursedSpiritGrade22Entity || entity instanceof CursedSpiritGrade212Entity || entity instanceof CursedSpiritGrade222Entity) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 7, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, Integer.MAX_VALUE, 5, false, false));
                  }
               }
            }

            if (entity instanceof CursedSpiritGrade221Entity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity23 = (LivingEntity)entity;
                  if (_livingEntity23.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                     _livingEntity23.m_21051_((Attribute)ForgeMod.SWIM_SPEED.get()).m_22100_((double)5.0F);
                  }
               }
            }

            if (entity instanceof CursedSpiritGrade222Entity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, Integer.MAX_VALUE, 4, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity26 = (LivingEntity)entity;
                  if (_livingEntity26.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                     _livingEntity26.m_21051_((Attribute)ForgeMod.SWIM_SPEED.get()).m_22100_((double)2.0F);
                  }
               }
            }

            label110: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt27 = (LivingEntity)entity;
                  if (_livEnt27.m_21023_(MobEffects.f_19606_)) {
                     break label110;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, Integer.MAX_VALUE, 1, false, false));
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

               double var31 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var32 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var32 += (double)((Entity)var10006).m_20206_() * (double)0.5F;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var31, var32, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
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
