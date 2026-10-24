package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemUseDebugStickProcedure {
   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         ItemStack var10000;
         if (sourceentity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)sourceentity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.DEBUG_STICK_V.get() && sourceentity instanceof Player) {
            Player _player = (Player)sourceentity;
            if (!_player.m_9236_().m_5776_()) {
               String entityName = ForgeRegistries.ENTITY_TYPES.getKey(entity.m_6095_()).toString();
               double atkBase = (double)0.0F;
               double defBase = (double)0.0F;
               int strLevel = -1;
               int resLevel = -1;
               if (entity instanceof LivingEntity) {
                  LivingEntity _target = (LivingEntity)entity;
                  if (_target.m_21204_().m_22171_(Attributes.f_22281_)) {
                     atkBase = _target.m_21051_(Attributes.f_22281_).m_22115_();
                  }

                  if (_target.m_21204_().m_22171_(Attributes.f_22284_)) {
                     defBase = _target.m_21051_(Attributes.f_22284_).m_22115_();
                  }

                  if (_target.m_21023_(MobEffects.f_19600_)) {
                     strLevel = _target.m_21124_(MobEffects.f_19600_).m_19564_();
                  }

                  if (_target.m_21023_(MobEffects.f_19606_)) {
                     resLevel = _target.m_21124_(MobEffects.f_19606_).m_19564_();
                  }
               }

               _player.m_5661_(Component.m_237113_(entityName), false);
               _player.m_5661_(Component.m_237113_("ATK: " + atkBase), false);
               _player.m_5661_(Component.m_237113_("STR Level: " + strLevel), false);
               _player.m_5661_(Component.m_237113_("DEF: " + defBase), false);
               _player.m_5661_(Component.m_237113_("RES Level: " + resLevel), false);
            }
         }

      }
   }
}
