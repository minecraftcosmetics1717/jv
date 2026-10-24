package net.mcreator.jujutsucraftv.mixins;

import java.util.UUID;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({DamageFixProcedure.class})
public abstract class DamageFixProcedureMixin {
   @Inject(
      method = {"execute(Lnet/minecraft/world/entity/Entity;)V"},
      at = {@At("TAIL")},
      remap = false
   )
   private static void jujutsucraftv$applyDamageBoosts(Entity entity, CallbackInfo ci) {
      if (entity != null) {
         LivingEntity ownerLiving = jujutsucraftv$getOwnerLivingEntity(entity.m_9236_(), entity.getPersistentData().m_128461_("OWNER_UUID"));
         if (ownerLiving != null) {
            jujutsucraftv$applyBoostFrom(entity, ownerLiving);
         } else if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            jujutsucraftv$applyBoostFrom(entity, livingEntity);
         }

      }
   }

   private static void jujutsucraftv$applyBoostFrom(Entity damageEntity, LivingEntity effectHolder) {
      if (damageEntity.getPersistentData().m_128441_("attack")) {
         jujutsucraftv$applyDamageBoost(damageEntity, effectHolder, (MobEffect)JujutsucraftvModMobEffects.PHYSICAL_DAMAGE_BOOST.get());
      } else {
         jujutsucraftv$applyDamageBoost(damageEntity, effectHolder, (MobEffect)JujutsucraftvModMobEffects.TECHNIQUE_DAMAGE_BOOST.get());
      }

      jujutsucraftv$applyDamageAmplification(damageEntity, effectHolder);
   }

   private static void jujutsucraftv$applyDamageBoost(Entity damageEntity, LivingEntity effectHolder, MobEffect effect) {
      MobEffectInstance instance = effectHolder.m_21124_(effect);
      if (instance != null) {
         double currentDamage = damageEntity.getPersistentData().m_128459_("Damage");
         int amplifier = instance.m_19564_();
         damageEntity.getPersistentData().m_128347_("Damage", currentDamage * ((double)1.0F + (double)amplifier * 0.1));
      }
   }

   private static void jujutsucraftv$applyDamageAmplification(Entity damageEntity, LivingEntity attributeHolder) {
      if (attributeHolder.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.DAMAGE_AMPLIFICATION.get())) {
         double amplification = attributeHolder.m_21051_((Attribute)JujutsucraftvModAttributes.DAMAGE_AMPLIFICATION.get()).m_22135_();
         if (amplification != (double)0.0F) {
            double currentDamage = damageEntity.getPersistentData().m_128459_("Damage");
            damageEntity.getPersistentData().m_128347_("Damage", currentDamage * ((double)1.0F + amplification * 0.01));
         }
      }
   }

   private static LivingEntity jujutsucraftv$getOwnerLivingEntity(LevelAccessor world, String uuid) {
      if (uuid != null && !uuid.isEmpty()) {
         if (world instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)world;

            try {
               Entity owner = serverLevel.m_8791_(UUID.fromString(uuid));
               if (owner instanceof LivingEntity) {
                  LivingEntity livingOwner = (LivingEntity)owner;
                  if (livingOwner.m_6084_()) {
                     return livingOwner;
                  }
               }
            } catch (Exception var5) {
            }
         }

         return null;
      } else {
         return null;
      }
   }
}
