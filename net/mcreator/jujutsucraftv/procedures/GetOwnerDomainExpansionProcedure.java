package net.mcreator.jujutsucraftv.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class GetOwnerDomainExpansionProcedure {
   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         if (!entity.getPersistentData().m_128461_("OWNER_UUID").equals("")) {
            Entity var3 = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (var3 instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)var3;
               if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = true;
                  return var10000;
               }
            }
         }

         var10000 = false;
         return var10000;
      }
   }
}
