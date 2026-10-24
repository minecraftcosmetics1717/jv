package net.mcreator.jujutsucraftv.handler;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE
)
public class GrandBarrierForestSpawnHandler {
   private static final ResourceKey<Biome> GRAND_BARRIER_FOREST;
   private static final TagKey<EntityType<?>> ROUZETSU_MOBS;

   @SubscribeEvent
   public static void onFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
      if (event.getEntity() != null) {
         MobSpawnType spawnType = event.getSpawnType();
         if (spawnType == MobSpawnType.NATURAL || spawnType == MobSpawnType.CHUNK_GENERATION) {
            BlockPos pos = event.getEntity().m_20183_();
            if (event.getLevel().m_204166_(pos).m_203565_(GRAND_BARRIER_FOREST)) {
               if (!event.getEntity().m_6095_().m_204039_(ROUZETSU_MOBS)) {
                  event.setCanceled(true);
               } else {
                  if (Math.random() < (double)0.5F) {
                     event.setCanceled(true);
                  }

               }
            }
         }
      }
   }

   static {
      GRAND_BARRIER_FOREST = ResourceKey.m_135785_(Registries.f_256952_, new ResourceLocation("jujutsucraftv", "grand_barrier_forest"));
      ROUZETSU_MOBS = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "rouzetsu_mobs"));
   }
}
