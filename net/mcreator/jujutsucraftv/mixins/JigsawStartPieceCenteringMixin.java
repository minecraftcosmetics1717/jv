package net.mcreator.jujutsucraftv.mixins;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({JigsawPlacement.class})
public abstract class JigsawStartPieceCenteringMixin {
   @Unique
   private static final ThreadLocal<Boolean> ADVANCED_WORLDGEN_CENTER_START = ThreadLocal.withInitial(() -> false);

   @Inject(
      method = {"addPieces(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;Lnet/minecraft/core/Holder;Ljava/util/Optional;ILnet/minecraft/core/BlockPos;ZLjava/util/Optional;I)Ljava/util/Optional;", "m_227238_(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;Lnet/minecraft/core/Holder;Ljava/util/Optional;ILnet/minecraft/core/BlockPos;ZLjava/util/Optional;I)Ljava/util/Optional;"},
      at = {@At("HEAD")},
      remap = false
   )
   private static void advancedworldgen$beginCentering(Structure.GenerationContext context, Holder<StructureTemplatePool> startPool, Optional<ResourceLocation> startJigsawName, int maxDepth, BlockPos startPos, boolean useExpansionHack, Optional<Heightmap.Types> projectStartToHeightmap, int maxDistanceFromCenter, CallbackInfoReturnable<Optional<Structure.GenerationStub>> cir) {
      ADVANCED_WORLDGEN_CENTER_START.set(startJigsawName.isEmpty() && maxDistanceFromCenter > 128);
   }

   @Redirect(
      method = {"addPieces(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;Lnet/minecraft/core/Holder;Ljava/util/Optional;ILnet/minecraft/core/BlockPos;ZLjava/util/Optional;I)Ljava/util/Optional;", "m_227238_(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;Lnet/minecraft/core/Holder;Ljava/util/Optional;ILnet/minecraft/core/BlockPos;ZLjava/util/Optional;I)Ljava/util/Optional;"},
      at = @At(
   value = "NEW",
   target = "net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece",
   remap = false
),
      remap = false,
      require = 1
   )
   private static PoolElementStructurePiece advancedworldgen$centerStartPiece(StructureTemplateManager templateManager, StructurePoolElement element, BlockPos originalPosition, int groundLevelDelta, Rotation rotation, BoundingBox originalBox) {
      if (!(Boolean)ADVANCED_WORLDGEN_CENTER_START.get()) {
         return new PoolElementStructurePiece(templateManager, element, originalPosition, groundLevelDelta, rotation, originalBox);
      } else {
         int centerX = originalBox.m_162395_() + (originalBox.m_162399_() - originalBox.m_162395_()) / 2;
         int centerZ = originalBox.m_162398_() + (originalBox.m_162401_() - originalBox.m_162398_()) / 2;
         BlockPos centeredPosition = originalPosition.m_7918_(originalPosition.m_123341_() - centerX, 0, originalPosition.m_123343_() - centerZ);
         BoundingBox centeredBox = element.m_214015_(templateManager, centeredPosition, rotation);
         return new PoolElementStructurePiece(templateManager, element, centeredPosition, groundLevelDelta, rotation, centeredBox);
      }
   }

   @Inject(
      method = {"addPieces(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;Lnet/minecraft/core/Holder;Ljava/util/Optional;ILnet/minecraft/core/BlockPos;ZLjava/util/Optional;I)Ljava/util/Optional;", "m_227238_(Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;Lnet/minecraft/core/Holder;Ljava/util/Optional;ILnet/minecraft/core/BlockPos;ZLjava/util/Optional;I)Ljava/util/Optional;"},
      at = {@At("RETURN")},
      remap = false
   )
   private static void advancedworldgen$endCentering(Structure.GenerationContext context, Holder<StructureTemplatePool> startPool, Optional<ResourceLocation> startJigsawName, int maxDepth, BlockPos startPos, boolean useExpansionHack, Optional<Heightmap.Types> projectStartToHeightmap, int maxDistanceFromCenter, CallbackInfoReturnable<Optional<Structure.GenerationStub>> cir) {
      ADVANCED_WORLDGEN_CENTER_START.remove();
   }
}
