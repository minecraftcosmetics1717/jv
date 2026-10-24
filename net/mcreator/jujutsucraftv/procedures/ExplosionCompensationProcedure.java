package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class ExplosionCompensationProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double set_damage = (double)0.0F;
         if (entity.getPersistentData().m_128459_("skill") == (double)61705.0F) {
            if (GetZoneProcedure.execute(entity)) {
               set_damage = (double)1.0F;
            } else {
               set_damage = (double)2.0F;
            }
         }

         if (entity.getPersistentData().m_128459_("skill") == (double)61707.0F) {
            if (((<undefinedtype>)(new Object() {
               public boolean checkGamemode(Entity _ent) {
                  if (_ent instanceof ServerPlayer _serverPlayer) {
                     return _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL;
                  } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                     return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SURVIVAL;
                  } else {
                     return false;
                  }
               }
            })).checkGamemode(entity) && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19610_, 40, 0, true, false));
               }
            }

            if (GetZoneProcedure.execute(entity)) {
               set_damage = (double)2.0F;
            } else {
               set_damage = (double)4.0F;
            }
         }

         if (((<undefinedtype>)(new Object() {
            public boolean checkGamemode(Entity _ent) {
               if (_ent instanceof ServerPlayer _serverPlayer) {
                  return _serverPlayer.f_8941_.m_9290_() == GameType.SURVIVAL;
               } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                  return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SURVIVAL;
               } else {
                  return false;
               }
            }
         })).checkGamemode(entity)) {
            entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268724_)), (float)set_damage);
         }

      }
   }
}
