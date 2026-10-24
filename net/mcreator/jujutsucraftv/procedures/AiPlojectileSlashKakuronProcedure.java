package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AiPlojectileSlashKakuronProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_power = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         if (entity.getPersistentData().m_128459_("cnt_1") == (double)0.0F && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.MOTION.get(), 60, 1, false, false));
            }
         }

         entity.f_19789_ = 0.0F;
         if (!((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         entity.getPersistentData().m_128347_("cnt_1", entity.getPersistentData().m_128459_("cnt_1") + (double)1.0F);
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt_1") > (double)1.0F) {
            if (entity.getPersistentData().m_128471_("osuki")) {
               x_power = entity.getPersistentData().m_128459_("x_power") * (double)3.0F;
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)3.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)3.0F;
            } else {
               x_power = entity.getPersistentData().m_128459_("x_power") * (double)3.0F * Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F);
               y_power = entity.getPersistentData().m_128459_("y_power") * (double)3.0F;
               z_power = entity.getPersistentData().m_128459_("z_power") * (double)3.0F * Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, (double)1.5F);
            }

            entity.m_20256_(new Vec3(x_power, y_power, z_power));
            Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)3.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (!LogicAttackProcedure.execute(world, entity, entityiterator) && !LogicBetrayalProcedure.execute(world, entity, entityiterator)) {
                  if (GetEntityStoppedProcedure.execute(entity)) {
                     if (entity.getPersistentData().m_128471_("osuki")) {
                        entity.getPersistentData().m_128347_("Damage", (double)22.0F);
                        entity.getPersistentData().m_128347_("Range", (double)6.0F);
                     } else {
                        entity.getPersistentData().m_128347_("Damage", (double)10.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                        entity.getPersistentData().m_128347_("Range", (double)4.0F);
                     }

                     RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     entity.getPersistentData().m_128347_("BlockDamage", (double)3.0F);
                     entity.getPersistentData().m_128347_("BlockRange", (double)3.0F);
                     BlockDestroyAllDirectionVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     entity.getPersistentData().m_128379_("hitted", true);
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt51 = (LivingEntity)entity;
                        if (_livEnt51.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
                           continue;
                        }
                     }

                     if (entity.getPersistentData().m_128471_("osuki")) {
                        entity.getPersistentData().m_128347_("Damage", (double)22.0F);
                        entity.getPersistentData().m_128347_("Range", (double)6.0F);
                     } else {
                        entity.getPersistentData().m_128347_("Damage", (double)10.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                        entity.getPersistentData().m_128347_("Range", (double)4.0F);
                     }

                     RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                     entity.getPersistentData().m_128379_("hitted", true);
                  }
               } else {
                  if (entity.getPersistentData().m_128471_("osuki")) {
                     entity.getPersistentData().m_128347_("Damage", (double)20.0F);
                     entity.getPersistentData().m_128347_("Range", (double)6.0F);
                  } else {
                     entity.getPersistentData().m_128347_("Damage", (double)15.0F * ((double)1.0F + 0.1 * entity.getPersistentData().m_128459_("cnt6")));
                     entity.getPersistentData().m_128347_("Range", (double)4.0F);
                  }

                  RangeAttackVProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
                  entity.getPersistentData().m_128379_("hitted", true);
               }
            }

            if (entity.getPersistentData().m_128471_("hitted")) {
               if (entity.getPersistentData().m_128471_("osuki")) {
                  for(int index0 = 0; index0 < 5; ++index0) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y + (double)1.0F, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_explode_dust_transition 0 0.5 0 0.5 0.6 1 0.6 ~ ~ ~ 0.1 0.1 0.1 0.1 7 force");
                     }
                  }
               } else {
                  for(int index1 = 0; index1 < 5; ++index1) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y + (double)1.0F, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_blood_red ~ ~ ~ 0.1 0.1 0.1 1 3 force");
                     }
                  }
               }

               if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_1") >= (double)300.0F && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
