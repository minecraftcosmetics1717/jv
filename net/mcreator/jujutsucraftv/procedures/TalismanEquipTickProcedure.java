package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class TalismanEquipTickProcedure {
   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.m_41720_() == JujutsucraftvModItems.REGENERATION_ROSARY.get() && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance current = _entity.m_21124_(MobEffects.f_19605_);
               if (current == null || current.m_19557_() <= 20) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19605_, 220, 0, false, false));
               }
            }
         }

         if (itemstack.m_41720_() == JujutsucraftvModItems.NIGHT_VISION_ROSARY.get() && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance current = _entity.m_21124_(MobEffects.f_19611_);
               if (current == null || current.m_19564_() != 0 || current.m_19557_() <= 220) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 400, 0, false, false));
               }
            }
         }

         if (itemstack.m_41720_() == JujutsucraftvModItems.DEEP_SEA_ROSARY.get() && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               MobEffectInstance conduit = _entity.m_21124_(MobEffects.f_19592_);
               MobEffectInstance dolphinsGrace = _entity.m_21124_(MobEffects.f_19593_);
               if (conduit == null || conduit.m_19557_() <= 20) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19592_, 220, 0, false, false));
               }

               if (dolphinsGrace == null || dolphinsGrace.m_19557_() <= 20) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19593_, 220, 0, false, false));
               }
            }
         }

      }
   }
}
