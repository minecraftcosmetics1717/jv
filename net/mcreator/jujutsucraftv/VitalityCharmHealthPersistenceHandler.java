package net.mcreator.jujutsucraftv;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class VitalityCharmHealthPersistenceHandler {
   private static final String SAVED_HEALTH_TAG = "jjcv_vitality_charm_saved_health";
   private static final String HAS_SAVED_HEALTH_TAG = "jjcv_vitality_charm_has_saved_health";

   @SubscribeEvent
   public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
      Player var2 = event.getEntity();
      if (var2 instanceof ServerPlayer player) {
         if (player.m_6084_()) {
            CompoundTag data = player.getPersistentData();
            data.m_128350_("jjcv_vitality_charm_saved_health", player.m_21223_());
            data.m_128379_("jjcv_vitality_charm_has_saved_health", true);
         }
      }
   }

   @SubscribeEvent
   public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
      Player var2 = event.getEntity();
      if (var2 instanceof ServerPlayer player) {
         CompoundTag data = player.getPersistentData();
         if (data.m_128471_("jjcv_vitality_charm_has_saved_health")) {
            float savedHealth = data.m_128457_("jjcv_vitality_charm_saved_health");
            restoreHealthWhenReady(player, savedHealth, 6);
         }
      }
   }

   private static void restoreHealthWhenReady(ServerPlayer player, float savedHealth, int attemptsLeft) {
      JujutsucraftvMod.queueServerWork(5, () -> {
         if (!player.m_213877_()) {
            if (player.m_6084_()) {
               float currentHealth = player.m_21223_();
               float maxHealth = player.m_21233_();
               if (!(savedHealth <= maxHealth) && attemptsLeft > 0) {
                  restoreHealthWhenReady(player, savedHealth, attemptsLeft - 1);
               } else {
                  float restoreHealth = Math.min(savedHealth, maxHealth);
                  if (currentHealth < restoreHealth) {
                     player.m_21153_(restoreHealth);
                  }

                  CompoundTag data = player.getPersistentData();
                  data.m_128350_("jjcv_vitality_charm_saved_health", player.m_21223_());
                  data.m_128379_("jjcv_vitality_charm_has_saved_health", true);
               }
            }
         }
      });
   }

   @SubscribeEvent
   public static void onPlayerDeath(LivingDeathEvent event) {
      LivingEntity var2 = event.getEntity();
      if (var2 instanceof Player player) {
         if (!player.m_9236_().m_5776_()) {
            CompoundTag data = player.getPersistentData();
            data.m_128473_("jjcv_vitality_charm_saved_health");
            data.m_128473_("jjcv_vitality_charm_has_saved_health");
         }
      }
   }
}
