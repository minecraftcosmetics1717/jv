package net.mcreator.jujutsucraftv.worldgen.biome;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;

public final class AdvancedBiomeSpawnRegistry {
   private AdvancedBiomeSpawnRegistry() {
   }

   public static boolean treatsMonsterSpawnAsNight(ServerLevelAccessor level, BlockPos pos) {
      return level != null && pos != null ? false : false;
   }

   public static WeightedRandomList<MobSpawnSettings.SpawnerData> modify(ServerLevel level, Holder<Biome> biome, MobCategory category, WeightedRandomList<MobSpawnSettings.SpawnerData> original) {
      if (level != null && biome != null && category != null && original != null) {
         if (biome.m_203565_(ResourceKey.m_135785_(Registries.f_256952_, new ResourceLocation("jujutsucraftv:grand_barrier_forest")))) {
            List<MobSpawnSettings.SpawnerData> result = new ArrayList(((Biome)biome.m_203334_()).m_47518_().m_151798_(category).m_146338_());
            if (category == MobCategory.CREATURE) {
               addEntity(level, result, "jujutsucraft:rozetsu_shikigami", 5, 2, 6);
            }

            return WeightedRandomList.m_146328_(result);
         } else {
            return original;
         }
      } else {
         return original;
      }
   }

   private static void addTag(ServerLevel level, List<MobSpawnSettings.SpawnerData> result, MobCategory category, String tagId, int weight, int min, int max) {
      Registry<EntityType<?>> registry = level.m_9598_().m_175515_(Registries.f_256939_);
      TagKey<EntityType<?>> tag = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation(tagId));

      for(Holder<EntityType<?>> holder : registry.m_206058_(tag)) {
         EntityType<?> type = (EntityType)holder.m_203334_();
         if (type.m_20674_() == category) {
            result.removeIf((entry) -> entry.f_48404_ == type);
            result.add(new MobSpawnSettings.SpawnerData(type, weight, min, max));
         }
      }

   }

   private static void addEntity(ServerLevel level, List<MobSpawnSettings.SpawnerData> result, String entityId, int weight, int min, int max) {
      Registry<EntityType<?>> registry = level.m_9598_().m_175515_(Registries.f_256939_);
      EntityType<?> type = (EntityType)registry.m_7745_(new ResourceLocation(entityId));
      if (type != null) {
         result.removeIf((entry) -> entry.f_48404_ == type);
         result.add(new MobSpawnSettings.SpawnerData(type, weight, min, max));
      }
   }
}
