package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModGameRules;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenVanillaMobSpawnProcedure {
   private static final TagKey<EntityType<?>> VANILLA_MOBS;
   private static final TagKey<EntityType<?>> ORIGINAL_MOBS;
   private static final TagKey<EntityType<?>> SUKUNA_MOBS;

   @SubscribeEvent
   public static void onFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
      Mob entity = event.getEntity();
      if (entity != null) {
         LevelAccessor world = event.getLevel();
         if (shouldBlock(world, entity)) {
            event.setSpawnCancelled(true);
         }

      }
   }

   @SubscribeEvent
   public static void onEntityJoin(EntityJoinLevelEvent event) {
      if (!event.getLevel().m_5776_()) {
         Entity entity = event.getEntity();
         if (entity != null) {
            if (!(entity instanceof Player)) {
               if (entity instanceof LivingEntity) {
                  if (shouldBlock(event.getLevel(), entity)) {
                     event.setCanceled(true);
                     if (!entity.m_213877_()) {
                        entity.m_146870_();
                     }
                  }

               }
            }
         }
      }
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!(entity instanceof Player)) {
            if (entity instanceof LivingEntity) {
               if (shouldBlock(world, entity) && !entity.m_9236_().m_5776_() && !entity.m_213877_()) {
                  entity.m_146870_();
               }

            }
         }
      }
   }

   private static boolean shouldBlock(LevelAccessor world, Entity entity) {
      if (entity.m_6095_().m_204039_(VANILLA_MOBS) && !world.m_6106_().m_5470_().m_46207_(JujutsucraftvModGameRules.JJCV_VANILLA_MOB_SPAWN)) {
         return true;
      } else if (entity.m_6095_().m_204039_(ORIGINAL_MOBS) && !world.m_6106_().m_5470_().m_46207_(JujutsucraftvModGameRules.JJCV_ORIGINAL_MOB_SPAWN)) {
         return true;
      } else {
         return entity.m_6095_().m_204039_(SUKUNA_MOBS) && !world.m_6106_().m_5470_().m_46207_(JujutsucraftvModGameRules.JJCV_SUKUNA_UNDER_GROUND_SPAWN) && LogicInsideCaveProcedure.execute(entity);
      }
   }

   static {
      VANILLA_MOBS = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "vanilla_mobs"));
      ORIGINAL_MOBS = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraftv", "original_mob"));
      SUKUNA_MOBS = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "sukuna_mob"));
   }
}
