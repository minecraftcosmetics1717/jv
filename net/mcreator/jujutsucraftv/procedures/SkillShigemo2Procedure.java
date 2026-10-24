package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.MiracleSavingsPhaseHandler;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillShigemo2Procedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)5.0F && entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (!livingEntity.m_9236_().m_5776_()) {
               livingEntity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 60, 199, false, false));
            }

            Attribute animationAttribute = (Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:animation_1"));
            if (animationAttribute != null && livingEntity.m_21051_(animationAttribute) != null) {
               livingEntity.m_21051_(animationAttribute).m_22100_((double)-8.0F);
            }

            PlayAnimationProcedure.execute(world, entity);
            MiracleSavingsPhaseHandler.start(entity, 60);
            playDodgeSound(livingEntity);
            MobEffectInstance effect = livingEntity.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
            if (effect != null && effect.m_19564_() > 0) {
               int duration = effect.m_19557_();
               int amplifier = effect.m_19564_();
               boolean ambient = effect.m_19571_();
               boolean visible = effect.m_19572_();
               boolean showIcon = effect.m_19575_();
               livingEntity.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
               livingEntity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), duration, amplifier - 1, ambient, visible, showIcon));
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)80.0F) {
            entity.getPersistentData().m_128347_("skill", (double)0.0F);
         }

      }
   }

   private static void playDodgeSound(LivingEntity entity) {
      if (!entity.m_9236_().m_5776_()) {
         entity.m_9236_().m_6263_((Player)null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), SoundEvents.f_12516_, SoundSource.MASTER, 1.0F, 0.5F);
      }
   }
}
