package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CurseEnergyBoostTickProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("cnt6") == (double)3.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.TECHNIQUE_DAMAGE_BOOST.get(), 20, 14, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.PHYSICAL_DAMAGE_BOOST.get(), 20, 14, false, false));
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt3 = (LivingEntity)entity;
            if (_livEnt3.m_21023_((MobEffect)JujutsucraftvModMobEffects.RAINBOW_EYE.get())) {
               entity.getPersistentData().m_128347_("cnt6", (double)8.0F);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt6") >= (double)5.0F) {
            int var10000;
            label46: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_BOOST.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_BOOST.get()).m_19564_();
                     break label46;
                  }
               }

               var10000 = 0;
            }

            if (var10000 <= 5) {
               entity.getPersistentData().m_128347_("cnt6", (double)6.0F);
            } else {
               double var10002;
               label40: {
                  var6 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_BOOST.get())) {
                        var10002 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_BOOST.get()).m_19564_();
                        break label40;
                     }
                  }

                  var10002 = (double)0.0F;
               }

               var6.m_128347_("cnt6", var10002);
            }
         }

      }
   }
}
