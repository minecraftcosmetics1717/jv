package net.mcreator.jujutsucraftv.worldgen.biome;

import it.unimi.dsi.fastutil.longs.LongIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public final class AdvancedBiomeStructureRegistry {
   private static final Map<Object, Set<Long>> INTENTIONAL_STRUCTURE_WATER = Collections.synchronizedMap(new WeakHashMap());
   private static final Map<Object, Map<Long, List<BoundingBox>>> REPLACEMENT_BOX_CACHE = Collections.synchronizedMap(new WeakHashMap());

   private AdvancedBiomeStructureRegistry() {
   }

   public static Boolean fixedCenterResult(int salt, long seed, int chunkX, int chunkZ) {
      if (salt == 26298795) {
         return !AdvancedFixedBiomeRegistry.isRegionCenter("jujutsucraftv:jujutsu_plain", seed, chunkX, chunkZ) ? false : chance(seed, salt, chunkX, chunkZ, 0.6);
      } else {
         return null;
      }
   }

   public static boolean tooCloseToOtherStructure(int currentSalt, long seed, int chunkX, int chunkZ) {
      return false;
   }

   private static boolean hasNearbyCandidate(long seed, int chunkX, int chunkZ, int spacing, int separation, int salt, int requiredDistance, boolean samePlacement) {
      if (requiredDistance > 0 && spacing > separation) {
         RandomSpreadStructurePlacement placement = new RandomSpreadStructurePlacement(spacing, separation, RandomSpreadType.LINEAR, salt);
         int minCellX = Math.floorDiv(chunkX - requiredDistance, spacing) - 1;
         int maxCellX = Math.floorDiv(chunkX + requiredDistance, spacing) + 1;
         int minCellZ = Math.floorDiv(chunkZ - requiredDistance, spacing) - 1;
         int maxCellZ = Math.floorDiv(chunkZ + requiredDistance, spacing) + 1;

         for(int cellX = minCellX; cellX <= maxCellX; ++cellX) {
            for(int cellZ = minCellZ; cellZ <= maxCellZ; ++cellZ) {
               ChunkPos candidate = placement.m_227008_(seed, cellX * spacing, cellZ * spacing);
               if (candidate.f_45578_ != chunkX || candidate.f_45579_ != chunkZ) {
                  int distance = Math.max(Math.abs(candidate.f_45578_ - chunkX), Math.abs(candidate.f_45579_ - chunkZ));
                  if (distance < requiredDistance && (!samePlacement || candidate.f_45578_ < chunkX || candidate.f_45578_ == chunkX && candidate.f_45579_ < chunkZ)) {
                     return true;
                  }
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean blocksVegetation(WorldGenLevel level, BlockPos pos) {
      Registry<Structure> structures = level.m_9598_().m_175515_(Registries.f_256944_);
      StructureManager manager = level.m_6018_().m_215010_();
      if (level instanceof WorldGenRegion region) {
         manager = manager.m_220468_(region);
      }

      Structure structure_2 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:derelict_building_1"));
      if (structure_2 != null && containsStructureSafely(level, pos, manager, structure_2, true)) {
         return true;
      } else {
         Structure structure_3 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:tokyo_jujutsu_high_school"));
         if (structure_3 != null && containsStructureSafely(level, pos, manager, structure_3, true)) {
            return true;
         } else {
            Structure structure_5 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:closed_high_school"));
            if (structure_5 != null && containsStructureSafely(level, pos, manager, structure_5, true)) {
               return true;
            } else {
               Structure structure_6 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:curse_user_log_cabin"));
               if (structure_6 != null && containsStructureSafely(level, pos, manager, structure_6, true)) {
                  return true;
               } else {
                  Structure structure_9 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:ruins_house_1"));
                  return structure_9 != null && containsStructureSafely(level, pos, manager, structure_9, true);
               }
            }
         }
      }
   }

   public static boolean blocksFeatureReplacement(WorldGenLevel level, BlockPos pos) {
      long chunkKey = ChunkPos.m_45589_(SectionPos.m_123171_(pos.m_123341_()), SectionPos.m_123171_(pos.m_123343_()));
      Map<Long, List<BoundingBox>> byChunk = (Map)REPLACEMENT_BOX_CACHE.computeIfAbsent(level, (ignored) -> new ConcurrentHashMap());

      for(BoundingBox box : (List)byChunk.computeIfAbsent(chunkKey, (ignored) -> replacementBoxes(level, pos))) {
         if (box.m_71051_(pos)) {
            return true;
         }
      }

      return false;
   }

   private static List<BoundingBox> replacementBoxes(WorldGenLevel level, BlockPos pos) {
      Registry<Structure> structures = level.m_9598_().m_175515_(Registries.f_256944_);
      StructureManager manager = level.m_6018_().m_215010_();
      if (level instanceof WorldGenRegion region) {
         manager = manager.m_220468_(region);
      }

      List<BoundingBox> boxes = new ArrayList();
      Structure structure_3 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:tokyo_jujutsu_high_school"));
      if (structure_3 != null) {
         collectStructureBoxesSafely(level, pos, manager, structure_3, boxes);
      }

      Structure structure_5 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:closed_high_school"));
      if (structure_5 != null) {
         collectStructureBoxesSafely(level, pos, manager, structure_5, boxes);
      }

      Structure structure_9 = (Structure)structures.m_7745_(new ResourceLocation("jujutsucraftv:ruins_house_1"));
      if (structure_9 != null) {
         collectStructureBoxesSafely(level, pos, manager, structure_9, boxes);
      }

      return List.copyOf(boxes);
   }

   public static void markIntentionalStructureWater(ServerLevelAccessor level, BlockPos pos) {
      ((Set)INTENTIONAL_STRUCTURE_WATER.computeIfAbsent(level, (ignored) -> Collections.newSetFromMap(new ConcurrentHashMap()))).add(pos.m_121878_());
   }

   private static boolean consumeIntentionalStructureWater(WorldGenLevel level, BlockPos pos) {
      Set<Long> positions = (Set)INTENTIONAL_STRUCTURE_WATER.get(level);
      return positions != null && positions.remove(pos.m_121878_());
   }

   public static void removeWaterInside(WorldGenLevel level, StructureStart start, BoundingBox generationBox, ChunkPos chunkPos) {
      if (start != null && start.m_73603_()) {
         Registry<Structure> structures = level.m_9598_().m_175515_(Registries.f_256944_);
         Structure generated = start.m_226861_();
         boolean enabled = false;
         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:derelict_building_1"))) {
            enabled = true;
         }

         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:tokyo_jujutsu_high_school"))) {
            enabled = true;
         }

         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:closed_high_school"))) {
            enabled = true;
         }

         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:curse_user_log_cabin"))) {
            enabled = true;
         }

         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:ruins_house_1"))) {
            enabled = true;
         }

         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:ruins_house_2"))) {
            enabled = true;
         }

         if (generated == structures.m_7745_(new ResourceLocation("jujutsucraftv:truck"))) {
            enabled = true;
         }

         if (enabled) {
            BoundingBox structureBox = start.m_73601_();
            int minX = Math.max(structureBox.m_162395_(), generationBox.m_162395_());
            int maxX = Math.min(structureBox.m_162399_(), generationBox.m_162399_());
            int minY = Math.max(Math.max(structureBox.m_162396_(), generationBox.m_162396_()), level.m_141937_());
            int maxY = Math.min(Math.min(structureBox.m_162400_(), generationBox.m_162400_()), level.m_151558_() - 1);
            int minZ = Math.max(structureBox.m_162398_(), generationBox.m_162398_());
            int maxZ = Math.min(structureBox.m_162401_(), generationBox.m_162401_());
            if (minX <= maxX && minY <= maxY && minZ <= maxZ) {
               ChunkAccess chunk = level.m_6325_(chunkPos.f_45578_, chunkPos.f_45579_);
               BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
               int firstSection = chunk.m_151564_(minY);
               int lastSection = chunk.m_151564_(maxY);

               for(int sectionIndex = firstSection; sectionIndex <= lastSection; ++sectionIndex) {
                  LevelChunkSection section = chunk.m_183278_(sectionIndex);
                  if (section.m_63002_((statex) -> statex.m_60819_().m_205070_(FluidTags.f_13131_))) {
                     int sectionMinY = SectionPos.m_123223_(chunk.m_151568_(sectionIndex));
                     int sectionMaxY = sectionMinY + 15;
                     int fromY = Math.max(minY, sectionMinY);
                     int toY = Math.min(maxY, sectionMaxY);

                     for(int y = fromY; y <= toY; ++y) {
                        for(int x = minX; x <= maxX; ++x) {
                           for(int z = minZ; z <= maxZ; ++z) {
                              BlockState state = section.m_62982_(x & 15, y & 15, z & 15);
                              if (state.m_60819_().m_205070_(FluidTags.f_13131_)) {
                                 pos.m_122178_(x, y, z);
                                 if (!consumeIntentionalStructureWater(level, pos)) {
                                    if (state.m_61138_(BlockStateProperties.f_61362_) && (Boolean)state.m_61143_(BlockStateProperties.f_61362_)) {
                                       chunk.m_6978_(pos.m_122178_(x, y, z), (BlockState)state.m_61124_(BlockStateProperties.f_61362_, false), false);
                                    } else if (isVerticallyEnclosed(chunk, pos, x, y, z, minY, maxY)) {
                                       chunk.m_6978_(pos.m_122178_(x, y, z), Blocks.f_50016_.m_49966_(), false);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }

            }
         }
      }
   }

   private static boolean isVerticallyEnclosed(ChunkAccess chunk, BlockPos.MutableBlockPos pos, int x, int y, int z, int minY, int maxY) {
      boolean floor = false;

      for(int checkY = y - 1; checkY >= Math.max(minY, y - 32); --checkY) {
         BlockState state = chunk.m_8055_(pos.m_122178_(x, checkY, z));
         if (!state.m_60795_() && state.m_60819_().m_76178_()) {
            floor = true;
            break;
         }
      }

      if (!floor) {
         return false;
      } else {
         for(int checkY = y + 1; checkY <= Math.min(maxY, y + 32); ++checkY) {
            BlockState state = chunk.m_8055_(pos.m_122178_(x, checkY, z));
            if (!state.m_60795_() && state.m_60819_().m_76178_()) {
               return true;
            }
         }

         return false;
      }
   }

   private static boolean containsStructureSafely(WorldGenLevel level, BlockPos pos, StructureManager manager, Structure structure, boolean xzOnly) {
      if (level instanceof WorldGenRegion region) {
         int chunkX = SectionPos.m_123171_(pos.m_123341_());
         int chunkZ = SectionPos.m_123171_(pos.m_123343_());
         if (!region.m_7232_(chunkX, chunkZ)) {
            return false;
         } else {
            ChunkAccess referenceChunk = region.m_6522_(chunkX, chunkZ, ChunkStatus.f_62316_, false);
            if (referenceChunk == null) {
               return false;
            } else {
               LongIterator var9 = referenceChunk.m_213649_(structure).iterator();

               while(var9.hasNext()) {
                  long packedStart = (Long)var9.next();
                  ChunkPos startPos = new ChunkPos(packedStart);
                  if (region.m_7232_(startPos.f_45578_, startPos.f_45579_)) {
                     ChunkAccess startChunk = region.m_6522_(startPos.f_45578_, startPos.f_45579_, ChunkStatus.f_62315_, false);
                     if (startChunk != null) {
                        StructureStart start = manager.m_220512_(SectionPos.m_123196_(startPos, region.m_151560_()), structure, startChunk);
                        if (isInside(start, pos, xzOnly)) {
                           return true;
                        }
                     }
                  }
               }

               return false;
            }
         }
      } else {
         for(StructureStart start : manager.m_220504_(SectionPos.m_123199_(pos), structure)) {
            if (isInside(start, pos, xzOnly)) {
               return true;
            }
         }

         return false;
      }
   }

   private static void collectStructureBoxesSafely(WorldGenLevel level, BlockPos pos, StructureManager manager, Structure structure, List<BoundingBox> output) {
      if (level instanceof WorldGenRegion region) {
         int chunkX = SectionPos.m_123171_(pos.m_123341_());
         int chunkZ = SectionPos.m_123171_(pos.m_123343_());
         if (region.m_7232_(chunkX, chunkZ)) {
            ChunkAccess referenceChunk = region.m_6522_(chunkX, chunkZ, ChunkStatus.f_62316_, false);
            if (referenceChunk != null) {
               LongIterator var9 = referenceChunk.m_213649_(structure).iterator();

               while(var9.hasNext()) {
                  long packedStart = (Long)var9.next();
                  ChunkPos startPos = new ChunkPos(packedStart);
                  if (region.m_7232_(startPos.f_45578_, startPos.f_45579_)) {
                     ChunkAccess startChunk = region.m_6522_(startPos.f_45578_, startPos.f_45579_, ChunkStatus.f_62315_, false);
                     if (startChunk != null) {
                        StructureStart start = manager.m_220512_(SectionPos.m_123196_(startPos, region.m_151560_()), structure, startChunk);
                        if (start != null && start.m_73603_()) {
                           output.add(start.m_73601_());
                        }
                     }
                  }
               }

            }
         }
      } else {
         for(StructureStart start : manager.m_220504_(SectionPos.m_123199_(pos), structure)) {
            if (start != null && start.m_73603_()) {
               output.add(start.m_73601_());
            }
         }

      }
   }

   private static boolean isInside(StructureStart start, BlockPos pos, boolean xzOnly) {
      if (start != null && start.m_73603_()) {
         BoundingBox box = start.m_73601_();
         return pos.m_123341_() >= box.m_162395_() && pos.m_123341_() <= box.m_162399_() && pos.m_123343_() >= box.m_162398_() && pos.m_123343_() <= box.m_162401_() && (xzOnly || pos.m_123342_() >= box.m_162396_() && pos.m_123342_() <= box.m_162400_());
      } else {
         return false;
      }
   }

   private static boolean limited(long seed, int salt, int chunkX, int chunkZ, int configuredLimit, int normalSpacing, boolean nearSpawn, int spawnRadius) {
      long limit = configuredLimit > 0 ? (long)configuredLimit : 1L;
      int pitch;
      if (nearSpawn) {
         int width = (int)Math.ceil(Math.sqrt((double)limit * (double)2.0F)) + 1;
         pitch = Math.max(1, spawnRadius / width);
      } else {
         pitch = Math.max(1, normalSpacing);
      }

      long mixed = mix(seed ^ (long)salt << 32);
      int offsetX = Math.floorMod(mixed, pitch) - pitch / 2;
      int offsetZ = Math.floorMod(mixed >>> 21, pitch) - pitch / 2;
      int relativeX = chunkX - offsetX;
      int relativeZ = chunkZ - offsetZ;
      if (Math.floorMod(relativeX, pitch) == 0 && Math.floorMod(relativeZ, pitch) == 0) {
         long gridX = (long)Math.floorDiv(relativeX, pitch);
         long gridZ = (long)Math.floorDiv(relativeZ, pitch);
         long index = cantor(zigzag(gridX), zigzag(gridZ));
         if (index >= 0L && index < limit) {
            return !nearSpawn || (long)chunkX * (long)chunkX + (long)chunkZ * (long)chunkZ <= (long)spawnRadius * (long)spawnRadius;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean chance(long seed, int salt, int chunkX, int chunkZ, double frequency) {
      long value = mix(seed ^ (long)salt << 32 ^ (long)chunkX * 341873128712L ^ (long)chunkZ * 132897987541L);
      return Math.floorMod(value, 1000000L) < Math.round(frequency * (double)1000000.0F);
   }

   private static long zigzag(long value) {
      return value >= 0L ? value * 2L : -value * 2L - 1L;
   }

   private static long cantor(long a, long b) {
      long sum = a + b;
      return sum >= 0L && sum <= 3037000498L ? sum * (sum + 1L) / 2L + b : Long.MAX_VALUE;
   }

   private static long mix(long value) {
      value ^= value >>> 33;
      value *= -49064778989728563L;
      value ^= value >>> 33;
      value *= -4265267296055464877L;
      return value ^ value >>> 33;
   }
}
