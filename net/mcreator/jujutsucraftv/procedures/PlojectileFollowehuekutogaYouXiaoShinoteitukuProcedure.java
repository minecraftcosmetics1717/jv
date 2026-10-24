package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraftv.entity.EntityBindingRopeEntity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class PlojectileFollowehuekutogaYouXiaoShinoteitukuProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label41: {
            Entity entity_aa = null;
            Entity entity_bb = null;
            double y_pos = (double)0.0F;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.PLOJECTILE_FOLLOW.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.PLOJECTILE_FOLLOW.get()).m_19564_();
                  break label41;
               }
            }

            var10000 = 0;
         }

         if (var10000 >= 4) {
            if (!entity.getPersistentData().m_128461_("TARGET_UUID").isEmpty()) {
               Entity var10 = (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("TARGET_UUID"));
               if (entity instanceof EntityBindingRopeEntity) {
                  if (var10 instanceof LivingEntity) {
                     entity.m_6021_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                     }
                  }
               } else if (var10 instanceof LivingEntity) {
                  entity.m_6021_(var10.m_20185_(), var10.m_20186_(), var10.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(var10.m_20185_(), var10.m_20186_(), var10.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }
               }
            }
         } else if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
            Entity var9 = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (var9 instanceof LivingEntity) {
               entity.m_6021_(var9.m_20185_(), var9.m_20186_(), var9.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(var9.m_20185_(), var9.m_20186_(), var9.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }
            }
         }

      }
   }
}
