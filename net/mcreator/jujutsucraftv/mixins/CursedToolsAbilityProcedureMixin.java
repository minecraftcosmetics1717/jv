package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.CursedToolsAbilityProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({CursedToolsAbilityProcedure.class})
public abstract class CursedToolsAbilityProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(Entity entity, Entity entityIterator, CallbackInfo info) {
      if (entity.getPersistentData().m_128471_("attack") && entity instanceof LivingEntity livingEntity) {
         ItemStack mainHandItem = livingEntity.m_21205_();
         if (mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool"))) && isInvertedSpearOrBlackRope(mainHandItem)) {
            applyCursedEffects(entityIterator);
            if (entityIterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && entityIterator instanceof LivingEntity) {
               LivingEntity target = (LivingEntity)entityIterator;
               applyRangedAmmoEffects(target);
            }
         }
      }

   }

   private static boolean isInvertedSpearOrBlackRope(ItemStack itemStack) {
      return itemStack.m_41720_() == JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get();
   }

   private static void applyCursedEffects(Entity entityIterator) {
      if (entityIterator instanceof LivingEntity target) {
         if (!target.m_21023_((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get())) {
            target.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 200, 0));
         }

         if (!target.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
            target.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 200, 0));
         }

         target.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
      }

   }

   private static void applyRangedAmmoEffects(LivingEntity target) {
      if (!target.m_21023_(MobEffects.f_19613_)) {
         int amplifier = 0;
         if (target.m_21023_(MobEffects.f_19600_)) {
            amplifier = target.m_21124_(MobEffects.f_19600_).m_19564_();
         }

         target.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 200, amplifier, false, false));
      }

   }
}
