package net.mcreator.jujutsucraftv;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class MiracleSavingsPhaseHandler {
   private static final String NO_DAMAGE_UNTIL_KEY = "jjcv_miracle_phase_no_damage_until";
   private static final String PHASE_UNTIL_KEY = "jjcv_miracle_phase_until";
   private static final String PHASING_ACTIVE_KEY = "jjcv_miracle_phase_active";
   private static final String PREVIOUS_NO_PHYSICS_KEY = "jjcv_miracle_phase_previous_no_physics";

   public static void start(Entity entity, int ticks) {
      if (entity != null) {
         if (!entity.m_9236_().m_5776_()) {
            CompoundTag data = entity.getPersistentData();
            if (!data.m_128471_("jjcv_miracle_phase_active")) {
               data.m_128379_("jjcv_miracle_phase_previous_no_physics", entity.f_19794_);
            }

            long until = entity.m_9236_().m_46467_() + (long)Math.max(1, ticks);
            data.m_128356_("jjcv_miracle_phase_no_damage_until", until);
            data.m_128356_("jjcv_miracle_phase_until", until);
            data.m_128379_("jjcv_miracle_phase_active", true);
            entity.f_19794_ = true;
            if (entity instanceof LivingEntity) {
               LivingEntity livingEntity = (LivingEntity)entity;
               livingEntity.f_19802_ = Math.max(livingEntity.f_19802_, ticks);
            }

         }
      }
   }

   @SubscribeEvent
   public static void onLivingHurt(LivingHurtEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         if (!event.getSource().m_276093_(DamageTypes.f_286979_)) {
            if (isNoDamageActive(entity)) {
               event.setCanceled(true);
               event.setAmount(0.0F);
            }

         }
      }
   }

   @SubscribeEvent
   public static void onLivingDamage(LivingDamageEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         if (!event.getSource().m_276093_(DamageTypes.f_286979_)) {
            if (isNoDamageActive(entity)) {
               event.setCanceled(true);
               event.setAmount(0.0F);
            }

         }
      }
   }

   @SubscribeEvent
   public static void onLivingTick(LivingEvent.LivingTickEvent event) {
      LivingEntity entity = event.getEntity();
      if (!entity.m_9236_().m_5776_()) {
         CompoundTag data = entity.getPersistentData();
         if (data.m_128471_("jjcv_miracle_phase_active")) {
            long now = entity.m_9236_().m_46467_();
            long phaseUntil = data.m_128454_("jjcv_miracle_phase_until");
            if (now <= phaseUntil) {
               entity.f_19794_ = true;
            } else {
               entity.f_19794_ = data.m_128471_("jjcv_miracle_phase_previous_no_physics");
               data.m_128473_("jjcv_miracle_phase_no_damage_until");
               data.m_128473_("jjcv_miracle_phase_until");
               data.m_128473_("jjcv_miracle_phase_active");
               data.m_128473_("jjcv_miracle_phase_previous_no_physics");
            }
         }
      }
   }

   private static boolean isNoDamageActive(LivingEntity entity) {
      return entity.getPersistentData().m_128454_("jjcv_miracle_phase_no_damage_until") >= entity.m_9236_().m_46467_();
   }
}
