package net.mcreator.jujutsucraftv.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;

public final class AdvancedFixedBiomeRegistry {
   private static final Map<Climate.Sampler, Long> SAMPLER_SEEDS = Collections.synchronizedMap(new WeakHashMap());
   private static final Map<Climate.Sampler, Map<Long, Boolean>> INLAND_CACHE = Collections.synchronizedMap(new WeakHashMap());
   private static final Map<BiomeSource, Climate.ParameterList<Holder<Biome>>> FALLBACK_CACHE = Collections.synchronizedMap(new WeakHashMap());
   private static final Map<BiomeSource, Map<Long, Optional<Holder<Biome>>>> RESOLVE_CACHE = Collections.synchronizedMap(new WeakHashMap());

   private AdvancedFixedBiomeRegistry() {
   }

   public static void bindSeed(Climate.Sampler sampler, long seed) {
      SAMPLER_SEEDS.put(sampler, seed);
   }

   @Nullable
   public static Holder<Biome> resolve(BiomeSource source, int quartX, int quartY, int quartZ, Climate.Sampler sampler) {
      if (quartY * 4 < 0) {
         return null;
      } else {
         int chunkX = Math.floorDiv(quartX, 4);
         int chunkZ = Math.floorDiv(quartZ, 4);
         long chunkKey = (long)chunkX << 32 ^ (long)chunkZ & 4294967295L;
         Map<Long, Optional<Holder<Biome>>> cache = (Map)RESOLVE_CACHE.computeIfAbsent(source, (ignored) -> new ConcurrentHashMap());
         return (Holder)((Optional)cache.computeIfAbsent(chunkKey, (ignored) -> Optional.ofNullable(resolveUncached(source, chunkX, chunkZ, sampler)))).orElse((Object)null);
      }
   }

   @Nullable
   private static Holder<Biome> resolveUncached(BiomeSource source, int chunkX, int chunkZ, Climate.Sampler sampler) {
      long seed = (Long)SAMPLER_SEEDS.getOrDefault(sampler, 0L);
      if (inside(seed, chunkX, chunkZ, 18, "CIRCLE", 100, 1012818904, true, 32, true, sampler, 64) && !conflicts_2(seed, chunkX, chunkZ, sampler)) {
         Holder<Biome> selected = find(source, ResourceKey.m_135785_(Registries.f_256952_, new ResourceLocation("jujutsucraftv:grand_barrier_forest")));
         if (selected != null) {
            return selected;
         }
      }

      return null;
   }

   public static boolean isRegionCenter(String biomeId, long seed, int chunkX, int chunkZ) {
      return biomeId.equals("jujutsucraftv:grand_barrier_forest") ? isCenter(seed, chunkX, chunkZ, 18, 100, 1012818904, true, 32, 64) : false;
   }

   @Nullable
   private static Holder<Biome> find(BiomeSource source, ResourceKey<Biome> key) {
      for(Holder<Biome> holder : source.m_207840_()) {
         if (holder.m_203565_(key)) {
            return holder;
         }
      }

      return null;
   }

   public static Holder<Biome> replaceFixedOnlyOutside(BiomeSource source, int quartX, int quartY, int quartZ, Climate.Sampler sampler, Holder<Biome> selected) {
      if (isFixedOnly(selected) && source instanceof MultiNoiseBiomeSource multi) {
         if (resolve(source, quartX, quartY, quartZ, sampler) != null) {
            return selected;
         } else {
            Climate.ParameterList<Holder<Biome>> fallback = (Climate.ParameterList)FALLBACK_CACHE.computeIfAbsent(source, (ignored) -> createFallbackParameters(multi));
            return (Holder)fallback.m_204252_(sampler.m_183445_(quartX, quartY, quartZ));
         }
      } else {
         return selected;
      }
   }

   private static Climate.ParameterList<Holder<Biome>> createFallbackParameters(MultiNoiseBiomeSource source) {
      List<Pair<Climate.ParameterPoint, Holder<Biome>>> values = new ArrayList();

      for(Pair<Climate.ParameterPoint, Holder<Biome>> entry : source.m_274409_().m_186850_()) {
         if (!isFixedOnly((Holder)entry.getSecond())) {
            values.add(entry);
         }
      }

      return values.isEmpty() ? source.m_274409_() : new Climate.ParameterList(values);
   }

   private static boolean isFixedOnly(Holder<Biome> biome) {
      return biome.m_203565_(ResourceKey.m_135785_(Registries.f_256952_, new ResourceLocation("jujutsucraftv:grand_barrier_forest")));
   }

   private static boolean conflicts_2(long seed, int chunkX, int chunkZ, Climate.Sampler sampler) {
      return false;
   }

   private static boolean inside(long seed, int chunkX, int chunkZ, int size, String shape, int chance, int salt, boolean avoidSpawn, int spawnDistance, boolean inlandOnly, Climate.Sampler sampler, int minimumGap) {
      return insideWithPadding(seed, chunkX, chunkZ, size, shape, chance, salt, avoidSpawn, spawnDistance, inlandOnly, sampler, minimumGap, 0);
   }

   private static boolean insideWithPadding(long seed, int chunkX, int chunkZ, int size, String shape, int chance, int salt, boolean avoidSpawn, int spawnDistance, boolean inlandOnly, Climate.Sampler sampler, int minimumGap, int padding) {
      Cell cell = cell(seed, chunkX, chunkZ, size, chance, salt, minimumGap);
      if (cell.enabled && !tooCloseToSpawn(cell, size, avoidSpawn, spawnDistance) && (!inlandOnly || isInland(sampler, cell, size))) {
         int safePadding = Math.max(0, padding);
         int paddedSize = size + safePadding * 2;
         int startX = cell.centerX - size / 2 - safePadding;
         int startZ = cell.centerZ - size / 2 - safePadding;
         int localX = chunkX - startX;
         int localZ = chunkZ - startZ;
         if (localX >= 0 && localZ >= 0 && localX < paddedSize && localZ < paddedSize) {
            int dx2 = 2 * localX - (paddedSize - 1);
            int dz2 = 2 * localZ - (paddedSize - 1);
            boolean var10000;
            switch (shape) {
               case "SQUARE" -> var10000 = true;
               case "CROSS" -> var10000 = Math.abs(dx2) <= Math.max(2, paddedSize / 3) || Math.abs(dz2) <= Math.max(2, paddedSize / 3);
               case "DIAMOND" -> var10000 = Math.abs(dx2) + Math.abs(dz2) <= paddedSize;
               default -> var10000 = (long)dx2 * (long)dx2 + (long)dz2 * (long)dz2 <= (long)paddedSize * (long)paddedSize;
            }

            return var10000;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean isInland(Climate.Sampler sampler, Cell cell, int size) {
      long cacheKey = (long)cell.centerX << 32 ^ (long)cell.centerZ & 4294967295L ^ (long)size * -7046029254386353131L;
      Map<Long, Boolean> cache = (Map)INLAND_CACHE.computeIfAbsent(sampler, (ignored) -> new ConcurrentHashMap());
      return (Boolean)cache.computeIfAbsent(cacheKey, (ignored) -> sampleInland(sampler, cell, size));
   }

   private static boolean sampleInland(Climate.Sampler sampler, Cell cell, int size) {
      int radius = Math.max(1, size / 2);
      long minimum = Climate.m_186779_(0.1F);
      int[] offsets = new int[]{-radius, 0, radius};

      for(int dx : offsets) {
         for(int dz : offsets) {
            Climate.TargetPoint point = sampler.m_183445_((cell.centerX + dx) * 4, 16, (cell.centerZ + dz) * 4);
            if (point.f_187005_() < minimum) {
               return false;
            }
         }
      }

      return true;
   }

   private static boolean isCenter(long seed, int chunkX, int chunkZ, int size, int chance, int salt, boolean avoidSpawn, int spawnDistance, int minimumGap) {
      Cell cell = cell(seed, chunkX, chunkZ, size, chance, salt, minimumGap);
      return cell.enabled && !tooCloseToSpawn(cell, size, avoidSpawn, spawnDistance) && chunkX == cell.centerX && chunkZ == cell.centerZ;
   }

   private static boolean tooCloseToSpawn(Cell cell, int size, boolean avoidSpawn, int spawnDistance) {
      if (!avoidSpawn) {
         return false;
      } else {
         long required = (long)spawnDistance + ((long)size + 1L) / 2L;
         return (long)cell.centerX * (long)cell.centerX + (long)cell.centerZ * (long)cell.centerZ < required * required;
      }
   }

   private static Cell cell(long seed, int chunkX, int chunkZ, int size, int chance, int salt, int minimumGap) {
      int safeGap = Math.max(0, minimumGap);
      int jitter = Math.max(4, size / 2);
      int pitch = Math.max(size + 1, size + safeGap + jitter);
      int cellX = Math.floorDiv(chunkX + pitch / 2, pitch);
      int cellZ = Math.floorDiv(chunkZ + pitch / 2, pitch);
      long hash = seed ^ (long)salt * -7046029254386353131L;
      hash ^= (long)cellX * 341873128712L;
      hash ^= (long)cellZ * 132897987541L;
      hash = mix(hash);
      boolean enabled = Math.floorMod(hash, 100L) < (long)chance;
      int offsetX = (int)Math.floorMod(mix(hash ^ 7146057691288625177L), (long)jitter + 1L) - jitter / 2;
      int offsetZ = (int)Math.floorMod(mix(hash ^ -4126379630918251389L), (long)jitter + 1L) - jitter / 2;
      return new Cell(cellX * pitch + offsetX, cellZ * pitch + offsetZ, enabled);
   }

   private static long mix(long value) {
      value ^= value >>> 33;
      value *= -49064778989728563L;
      value ^= value >>> 33;
      value *= -4265267296055464877L;
      return value ^ value >>> 33;
   }

   private static record Cell(int centerX, int centerZ, boolean enabled) {
   }
}
