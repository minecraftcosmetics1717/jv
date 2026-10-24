package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ArmorTickProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_YELLOW_HELMET.get() && entity instanceof Player && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_GREEN_HELMET.get() && entity instanceof Player && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_WHACK_A_MOLE_HELMET.get() && entity instanceof Player && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_WHITE_HELMET.get() && entity instanceof Player && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_SMALLPOX_DEITY_HELMET.get() && entity instanceof Player && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entGetArmor = (LivingEntity)entity;
            var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.ARMOR_CURSED_SPIRIT_KUROURUSHI_NEW_HELMET.get() && entity instanceof Player && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 5, 0, false, false));
            }
         }

      }
   }
}
