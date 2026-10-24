package net.mcreator.jujutsucraftv.procedures;

import java.util.Comparator;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.LogicBetrayalProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class EffectSoloForbiddenAreaTickProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double pos_x = (double)0.0F;
         double pos_y = (double)0.0F;
         double pos_z = (double)0.0F;
         if (!GetCanUseTechnique2Procedure.execute(entity)) {
            pos_x = entity.m_20185_();
            pos_y = entity.m_20186_();
            pos_z = entity.m_20189_();
            DisplayParticleCircleProcedure.execute(world, pos_x, pos_y, pos_z, (double)15.0F, (double)20.0F, "/particle jujutsucraftv:particle_vermilion_ash ~ ~ ~ 0.1 0.01 0.1 0.05 1");
            String var10006 = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet && entity instanceof Player ? ReturnEnergyColor3Procedure.execute(entity) : "jujutsucraft:particle_curse_power_blue";
            DisplayParticleCircleProcedure.execute(world, pos_x, pos_y, pos_z, (double)10.0F, (double)20.0F, "/particle " + var10006 + " ~ ~ ~ 0.1 0.1 0.1 0.1 1");
            Vec3 _center = new Vec3(pos_x, pos_y, pos_z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)10.0F), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (!LogicAttackProcedure.execute(world, entity, entityiterator) || LogicBetrayalProcedure.execute(world, entity, entityiterator) || LogicEntityTeamProcedure.execute(entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var10001;
                        MobEffect var10003;
                        int var10005;
                        label55: {
                           var10001 = new MobEffectInstance;
                           var10003 = (MobEffect)JujutsucraftvModMobEffects.CURSE_ENERGY_BOOST.get();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get())) {
                                 var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get()).m_19564_();
                                 break label55;
                              }
                           }

                           var10005 = 0;
                        }

                        var10001.<init>(var10003, 5, var10005, true, true);
                        _entity.m_7292_(var10001);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var20;
                        MobEffect var21;
                        int var22;
                        label49: {
                           var20 = new MobEffectInstance;
                           var21 = (MobEffect)JujutsucraftvModMobEffects.MAX_CURSE_POWER_BOOST.get();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get())) {
                                 var22 = _livEnt.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get()).m_19564_();
                                 break label49;
                              }
                           }

                           var22 = 0;
                        }

                        var20.<init>(var21, 5, var22, true, true);
                        _entity.m_7292_(var20);
                     }
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_SOLO_FORBIDDEN_AREA.get());
         }

      }
   }
}
