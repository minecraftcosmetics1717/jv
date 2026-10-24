package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PlojectileScaffoldTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double y_minus = (double)0.0F;
         if (((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) == null || !((new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID")) instanceof LivingEntity) || !entity.m_20159_()) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.MOTION.get());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entity;
            if (_livEnt8.m_21023_((MobEffect)JujutsucraftvModMobEffects.MOTION.get())) {
               return;
            }
         }

         JujutsucraftvMod.queueServerWork(10, () -> {
            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }

         });
      }
   }
}
