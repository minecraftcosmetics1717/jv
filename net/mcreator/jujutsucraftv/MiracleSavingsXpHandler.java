package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class MiracleSavingsXpHandler {
   private static final int EXPERIENCE_LEVELS_PER_EFFECT_LEVEL = 5;
   private static final String CREATIVE_TAG = "miracle_life_creative";
   private static final String CHARGE_EXP_TAG = "miracle_charge_exp";
   private static final String CREATIVE_USED_UNITS_KEY = "jjcv_miracle_life_creative_used_units";

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         Player player = event.player;
         if (!player.m_9236_().m_5776_()) {
            CompoundTag data = player.getPersistentData();
            if (!player.m_21023_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get())) {
               data.m_128473_("jjcv_miracle_life_creative_used_units");
            } else if (!data.m_128471_("miracle_charge_exp")) {
               data.m_128473_("jjcv_miracle_life_creative_used_units");
            } else {
               boolean noXpCost = data.m_128471_("miracle_life_creative");
               int currentUnits = player.f_36078_ / 5;
               if (currentUnits > 0) {
                  int levelUpCount;
                  if (noXpCost) {
                     int usedUnits = data.m_128451_("jjcv_miracle_life_creative_used_units");
                     if (currentUnits <= usedUnits) {
                        return;
                     }

                     levelUpCount = currentUnits - usedUnits;
                     data.m_128405_("jjcv_miracle_life_creative_used_units", currentUnits);
                  } else {
                     data.m_128473_("jjcv_miracle_life_creative_used_units");
                     levelUpCount = currentUnits;
                  }

                  if (levelUpCount > 0) {
                     addMiracleSavingsLevel(player, levelUpCount);
                     if (!noXpCost) {
                        removePlayerExperienceLevels(player, levelUpCount * 5);
                     }

                     playMiracleSavingsLevelUpSound(player);
                  }
               }
            }
         }
      }
   }

   private static void addMiracleSavingsLevel(Player player, int amount) {
      MobEffectInstance effect = player.m_21124_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
      if (effect != null) {
         int duration = effect.m_19557_();
         int amplifier = effect.m_19564_();
         boolean ambient = effect.m_19571_();
         boolean visible = effect.m_19572_();
         boolean showIcon = effect.m_19575_();
         player.m_21195_((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get());
         player.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), duration, amplifier + amount, ambient, visible, showIcon));
      }
   }

   private static void removePlayerExperienceLevels(Player player, int levels) {
      if (levels > 0) {
         player.m_6749_(-levels);
      }
   }

   private static void playMiracleSavingsLevelUpSound(Player player) {
      if (!player.m_9236_().m_5776_()) {
         player.m_9236_().m_6263_((Player)null, player.m_20185_(), player.m_20186_(), player.m_20189_(), SoundEvents.f_11887_, SoundSource.MASTER, 1.0F, 1.0F);
      }
   }
}
