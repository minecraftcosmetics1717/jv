package net.mcreator.jujutsucraftv.worldgen.biome;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap.Types;

public final class AdvancedBiomeTerrainRegistry {
   private static final int BORDER_BLEND_WIDTH = 16;
   private static final int ENCLOSED_WATER_RADIUS = 12;
   private static final int MIN_SURFACE_SUPPORT_DEPTH = 24;
   private static final int MAX_SURFACE_SUPPORT_DEPTH = 96;

   private AdvancedBiomeTerrainRegistry() {
   }

   public static void apply(WorldGenRegion level, ChunkAccess chunk) {
      applyBiome(level, chunk, ResourceKey.m_135785_(Registries.f_256952_, new ResourceLocation("jujutsucraftv:grand_barrier_forest")), true, 64, "PREVENT", 7, 160, ((Block)JujutsucraftvModBlocks.RED_BARRIER_EROSION_DIRT.get()).m_49966_(), ((Block)JujutsucraftvModBlocks.RED_BARRIER_EROSION_DIRT.get()).m_49966_(), ((Block)JujutsucraftvModBlocks.RED_BARRIER_EROSION_DIRT.get()).m_49966_(), Blocks.f_50440_.m_49966_(), 30, Blocks.f_50122_.m_49966_(), 15);
   }

   private static void applyBiome(WorldGenRegion level, ChunkAccess chunk, ResourceKey<Biome> biomeKey, boolean flatten, int flatHeight, String riverMode, int riverWidth, int riverSpacing, BlockState ground, BlockState underground, BlockState underwater, BlockState noiseBlock, int noiseRate, BlockState patchBlock, int patchRate) {
      BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
      int startX = chunk.m_7697_().m_45604_();
      int startZ = chunk.m_7697_().m_45605_();
      int minimumY = chunk.m_141937_();
      int maximumY = chunk.m_151558_() - 1;
      int referenceY = Math.max(minimumY, Math.min(maximumY, level.m_5736_()));
      BiomeMask biomeMask = new BiomeMask(level, biomeKey, referenceY, startX, startZ);
      if (biomeMask.hasAny()) {
         for(int localX = 0; localX < 16; ++localX) {
            for(int localZ = 0; localZ < 16; ++localZ) {
               int x = startX + localX;
               int z = startZ + localZ;
               boolean directBiome = biomeMask.contains(x, z);
               int outsideBlendDistance = directBiome ? 0 : distanceToBiome(biomeMask, x, z);
               boolean flattenTransition = flatten && outsideBlendDistance > 0 && outsideBlendDistance < 16;
               int top = Math.max(minimumY, chunk.m_5885_(Types.WORLD_SURFACE_WG, localX, localZ) - 1);
               chunk.m_5885_(Types.OCEAN_FLOOR_WG, localX, localZ);
               boolean waterAtTop = chunk.m_8055_(pos.m_122178_(x, top, z)).m_60819_().m_205070_(FluidTags.f_13131_);
               if (directBiome || flattenTransition || "PREVENT".equals(riverMode) && waterAtTop && isEnclosedByBiome(biomeMask, x, z)) {
                  int solidTop = findSolidTop(chunk, pos, x, z, top, minimumY);
                  boolean surfaceWater = top > solidTop && hasWater(chunk, pos, x, z, solidTop + 1, top);
                  if (flatten) {
                     int blendedHeight = flatHeight;
                     if (!directBiome) {
                        double naturalBlend = smoothStep((double)outsideBlendDistance / (double)16.0F);
                        int naturalTarget = (int)Math.round((double)flatHeight + (double)(solidTop - flatHeight) * naturalBlend);
                        int supportedRiseLimit = flatHeight + outsideBlendDistance * 4;
                        blendedHeight = solidTop > flatHeight ? Math.min(naturalTarget, supportedRiseLimit) : naturalTarget;
                     }

                     setLandColumn(chunk, pos, x, z, solidTop, blendedHeight, ground, underground, maximumY);
                     clearColumnAbove(chunk, pos, x, z, blendedHeight, maximumY);
                     if (!directBiome && blendedHeight > flatHeight) {
                        fillTransitionFoundation(chunk, pos, x, z, flatHeight, blendedHeight, underground);
                     }

                     solidTop = blendedHeight;
                  }

                  if ("PREVENT".equals(riverMode)) {
                     int dryHeight = flatten ? solidTop : Math.max(solidTop, top);
                     if (surfaceWater) {
                        setLandColumn(chunk, pos, x, z, solidTop, dryHeight, ground, underground, maximumY);
                     }
                  } else if ("GENERATE".equals(riverMode) && isRiver(x, z, level.m_7328_(), riverWidth, riverSpacing)) {
                     carveRiver(chunk, pos, x, z, solidTop, level.m_5736_(), underwater, maximumY);
                  }

                  if (directBiome) {
                     applySurfaceNoise(level, chunk, pos, x, z, localX, localZ, noiseBlock, noiseRate, patchBlock, patchRate, minimumY);
                  }
               }
            }
         }

      }
   }

   private static void applySurfaceNoise(WorldGenRegion level, ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int localX, int localZ, BlockState noiseBlock, int noiseRate, BlockState patchBlock, int patchRate, int minimumY) {
      int top = Math.max(minimumY, chunk.m_5885_(Types.WORLD_SURFACE_WG, localX, localZ) - 1);
      if (chunk.m_8055_(pos.m_122178_(x, top, z)).m_60819_().m_76178_()) {
         int surfaceY = findSolidTop(chunk, pos, x, z, top, minimumY);
         BlockState replacement = null;
         if (matchesNoise(x, z, level.m_7328_(), 7640891576956012809L, patchRate, 18)) {
            replacement = patchBlock;
         } else if (matchesNoise(x, z, level.m_7328_(), -4942790177534073029L, noiseRate, 3)) {
            replacement = noiseBlock;
         }

         if (replacement != null) {
            chunk.m_6978_(pos.m_122178_(x, surfaceY, z), replacement, false);
         }

      }
   }

   private static boolean matchesNoise(int x, int z, long seed, long salt, int rate, int scale) {
      int clamped = Math.max(0, Math.min(100, rate));
      if (clamped <= 0) {
         return false;
      } else if (clamped >= 100) {
         return true;
      } else {
         double value = valueNoise((double)x / (double)scale, (double)z / (double)scale, seed ^ salt);
         double coverage = (double)0.5F + (double)0.5F * Math.sin(Math.PI * value * (double)0.5F);
         return coverage >= (double)1.0F - (double)clamped / (double)100.0F;
      }
   }

   private static double valueNoise(double x, double z, long seed) {
      int x0 = (int)Math.floor(x);
      int z0 = (int)Math.floor(z);
      double tx = smoothStep(x - (double)x0);
      double tz = smoothStep(z - (double)z0);
      double a = randomUnit(seed, x0, z0);
      double b = randomUnit(seed, x0 + 1, z0);
      double c = randomUnit(seed, x0, z0 + 1);
      double d = randomUnit(seed, x0 + 1, z0 + 1);
      return lerp(lerp(a, b, tx), lerp(c, d, tx), tz);
   }

   private static double randomUnit(long seed, int x, int z) {
      long value = seed ^ (long)x * -7046029254386353131L ^ (long)z * -4417276706812531889L;
      value ^= value >>> 30;
      value *= -4658895280553007687L;
      value ^= value >>> 27;
      value *= -7723592293110705685L;
      value ^= value >>> 31;
      return (double)(value >>> 11) * (double)1.110223E-16F * (double)2.0F - (double)1.0F;
   }

   private static double lerp(double a, double b, double value) {
      return a + (b - a) * value;
   }

   private static double smoothStep(double value) {
      double clamped = Math.max((double)0.0F, Math.min((double)1.0F, value));
      return clamped * clamped * ((double)3.0F - (double)2.0F * clamped);
   }

   private static boolean isEnclosedByBiome(BiomeMask biomeMask, int x, int z) {
      int matches = 0;

      for(int dx = -12; dx <= 12; dx += 12) {
         for(int dz = -12; dz <= 12; dz += 12) {
            if ((dx != 0 || dz != 0) && biomeMask.contains(x + dx, z + dz)) {
               ++matches;
            }
         }
      }

      return matches >= 6;
   }

   private static int distanceToBiome(BiomeMask biomeMask, int x, int z) {
      for(int radius = 1; radius < 16; ++radius) {
         if (biomeMask.contains(x + radius, z) || biomeMask.contains(x - radius, z) || biomeMask.contains(x, z + radius) || biomeMask.contains(x, z - radius) || biomeMask.contains(x + radius, z + radius) || biomeMask.contains(x + radius, z - radius) || biomeMask.contains(x - radius, z + radius) || biomeMask.contains(x - radius, z - radius)) {
            return radius;
         }
      }

      return -1;
   }

   private static int findSolidTop(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int top, int minimumY) {
      for(int y = top; y > minimumY; --y) {
         BlockState state = chunk.m_8055_(pos.m_122178_(x, y, z));
         if (!state.m_60795_() && state.m_60819_().m_76178_()) {
            return y;
         }
      }

      return minimumY;
   }

   private static boolean hasWater(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int fromY, int toY) {
      for(int y = Math.max(fromY, chunk.m_141937_()); y <= toY; ++y) {
         if (chunk.m_8055_(pos.m_122178_(x, y, z)).m_60819_().m_205070_(FluidTags.f_13131_)) {
            return true;
         }
      }

      return false;
   }

   private static void setLandColumn(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int oldTop, int target, BlockState ground, BlockState underground, int maximumY) {
      target = Math.max(chunk.m_141937_() + 1, Math.min(maximumY, target));

      for(int y = oldTop + 1; y < target; ++y) {
         chunk.m_6978_(pos.m_122178_(x, y, z), underground, false);
      }

      fillSurfaceSupport(chunk, pos, x, z, target, underground);
      chunk.m_6978_(pos.m_122178_(x, target, z), ground, false);

      for(int y = target + 1; y <= Math.min(maximumY, Math.max(oldTop, target + 16)); ++y) {
         chunk.m_6978_(pos.m_122178_(x, y, z), Blocks.f_50016_.m_49966_(), false);
      }

   }

   private static void fillSurfaceSupport(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int surfaceY, BlockState underground) {
      int minimumY = Math.max(chunk.m_141937_() + 1, surfaceY - 96);
      int solidRun = 0;

      for(int y = surfaceY - 1; y >= minimumY; --y) {
         BlockState state = chunk.m_8055_(pos.m_122178_(x, y, z));
         int depth = surfaceY - y;
         if (!state.m_60795_() && state.m_60819_().m_76178_()) {
            ++solidRun;
            if (depth >= 24 && solidRun >= 4) {
               break;
            }
         } else {
            chunk.m_6978_(pos.m_122178_(x, y, z), underground, false);
            solidRun = 0;
         }
      }

   }

   private static void fillTransitionFoundation(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int flatHeight, int transitionHeight, BlockState underground) {
      int fromY = Math.max(chunk.m_141937_() + 1, Math.min(flatHeight, transitionHeight));
      int toY = Math.min(chunk.m_151558_() - 1, transitionHeight - 1);

      for(int y = fromY; y <= toY; ++y) {
         BlockState state = chunk.m_8055_(pos.m_122178_(x, y, z));
         if (state.m_60795_() || !state.m_60819_().m_76178_()) {
            chunk.m_6978_(pos.m_122178_(x, y, z), underground, false);
         }
      }

   }

   private static void clearColumnAbove(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int surfaceY, int maximumY) {
      for(int y = Math.max(chunk.m_141937_(), surfaceY + 1); y <= maximumY; ++y) {
         BlockState state = chunk.m_8055_(pos.m_122178_(x, y, z));
         if (!state.m_60795_()) {
            chunk.m_6978_(pos.m_122178_(x, y, z), Blocks.f_50016_.m_49966_(), false);
         }
      }

   }

   private static void carveRiver(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int z, int oldTop, int seaLevel, BlockState underwater, int maximumY) {
      int waterTop = Math.min(seaLevel, oldTop - 1);
      int bottom = Math.max(chunk.m_141937_() + 1, waterTop - 3);
      chunk.m_6978_(pos.m_122178_(x, bottom, z), underwater, false);

      for(int y = bottom + 1; y <= waterTop; ++y) {
         chunk.m_6978_(pos.m_122178_(x, y, z), Blocks.f_49990_.m_49966_(), false);
      }

      for(int y = waterTop + 1; y <= Math.min(maximumY, oldTop); ++y) {
         chunk.m_6978_(pos.m_122178_(x, y, z), Blocks.f_50016_.m_49966_(), false);
      }

   }

   private static boolean isRiver(int x, int z, long seed, int width, int spacing) {
      double angle = (double)(seed >>> 24 & 1023L) * 0.006135923151542565;
      double cos = Math.cos(angle);
      double sin = Math.sin(angle);
      double along = (double)x * cos + (double)z * sin;
      double across = (double)(-x) * sin + (double)z * cos;
      double phase = (double)(seed & 65535L) / (double)65535.0F * Math.PI * (double)2.0F;
      double warped = along + Math.sin(across / (double)48.0F + phase) * (double)20.0F + Math.sin(across / (double)19.0F - phase) * (double)6.0F;
      double period = (double)Math.max(48, spacing);
      double distance = Math.abs((double)Math.floorMod((long)Math.floor(warped + period / (double)2.0F), (long)period) - period / (double)2.0F);
      return distance <= Math.max((double)1.0F, (double)width * (double)0.5F);
   }

   private static final class BiomeMask {
      private final int minimumQuartX;
      private final int minimumQuartZ;
      private final int width;
      private final int depth;
      private final boolean[] values;
      private final boolean any;

      private BiomeMask(WorldGenRegion level, ResourceKey<Biome> biomeKey, int referenceY, int chunkStartX, int chunkStartZ) {
         this.minimumQuartX = QuartPos.m_175400_(chunkStartX - 16);
         this.minimumQuartZ = QuartPos.m_175400_(chunkStartZ - 16);
         int maximumQuartX = QuartPos.m_175400_(chunkStartX + 15 + 16);
         int maximumQuartZ = QuartPos.m_175400_(chunkStartZ + 15 + 16);
         this.width = maximumQuartX - this.minimumQuartX + 1;
         this.depth = maximumQuartZ - this.minimumQuartZ + 1;
         this.values = new boolean[this.width * this.depth];
         int quartY = QuartPos.m_175400_(referenceY);
         boolean found = false;

         for(int quartX = this.minimumQuartX; quartX <= maximumQuartX; ++quartX) {
            for(int quartZ = this.minimumQuartZ; quartZ <= maximumQuartZ; ++quartZ) {
               Holder<Biome> biome = level.m_203675_(quartX, quartY, quartZ);
               boolean matches = biome.m_203565_(biomeKey);
               this.values[(quartX - this.minimumQuartX) * this.depth + quartZ - this.minimumQuartZ] = matches;
               found |= matches;
            }
         }

         this.any = found;
      }

      private boolean hasAny() {
         return this.any;
      }

      private boolean contains(int blockX, int blockZ) {
         int localQuartX = QuartPos.m_175400_(blockX) - this.minimumQuartX;
         int localQuartZ = QuartPos.m_175400_(blockZ) - this.minimumQuartZ;
         return localQuartX >= 0 && localQuartX < this.width && localQuartZ >= 0 && localQuartZ < this.depth ? this.values[localQuartX * this.depth + localQuartZ] : false;
      }
   }
}
