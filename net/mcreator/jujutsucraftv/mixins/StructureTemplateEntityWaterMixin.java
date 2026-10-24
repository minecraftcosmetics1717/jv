package net.mcreator.jujutsucraftv.mixins;

import java.util.List;
import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeStructureRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({StructureTemplate.class})
public abstract class StructureTemplateEntityWaterMixin {
   @Shadow
   @Final
   private List<StructureTemplate.Palette> f_74482_;
   private static final ThreadLocal<PlacementTransform> ADVANCED_WORLDGEN_TRANSFORM = new ThreadLocal();

   @Inject(
      method = {"placeInWorld(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;Lnet/minecraft/util/RandomSource;I)Z", "m_230328_(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;Lnet/minecraft/util/RandomSource;I)Z"},
      at = {@At("HEAD")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$rememberSavedWater(ServerLevelAccessor level, BlockPos origin, BlockPos pivot, StructurePlaceSettings settings, RandomSource random, int flags, CallbackInfoReturnable<Boolean> cir) {
      if (!this.f_74482_.isEmpty()) {
         BoundingBox box = settings.m_74409_();

         for(StructureTemplate.StructureBlockInfo info : settings.m_74387_(this.f_74482_, origin).m_74652_()) {
            if (info.f_74676_().m_60819_().m_205070_(FluidTags.f_13131_)) {
               BlockPos transformed = StructureTemplate.m_74563_(settings, info.f_74675_()).m_121955_(origin);
               if (box == null || box.m_71051_(transformed)) {
                  AdvancedBiomeStructureRegistry.markIntentionalStructureWater(level, transformed);
               }
            }
         }

      }
   }

   @Inject(
      method = {"addEntitiesToWorld(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;)V", "m_74523_(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;)V"},
      at = {@At("HEAD")},
      remap = false,
      require = 0
   )
   private void advancedworldgen$beginEntityTransform(ServerLevelAccessor level, BlockPos origin, StructurePlaceSettings settings, CallbackInfo ci) {
      ADVANCED_WORLDGEN_TRANSFORM.set(new PlacementTransform(origin, settings.m_74401_(), settings.m_74404_(), settings.m_74407_()));
   }

   @Inject(
      method = {"addEntitiesToWorld(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;)V", "m_74523_(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructurePlaceSettings;)V"},
      at = {@At("RETURN")},
      remap = false,
      require = 0
   )
   private void advancedworldgen$endEntityTransform(ServerLevelAccessor level, BlockPos origin, StructurePlaceSettings settings, CallbackInfo ci) {
      ADVANCED_WORLDGEN_TRANSFORM.remove();
   }

   @Inject(
      method = {"placeEntities(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Mirror;Lnet/minecraft/world/level/block/Rotation;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Z)V", "m_74523_(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Mirror;Lnet/minecraft/world/level/block/Rotation;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Z)V"},
      at = {@At("HEAD")},
      remap = false,
      require = 0
   )
   private void advancedworldgen$beginLegacyEntityTransform(ServerLevelAccessor level, BlockPos origin, Mirror mirror, Rotation rotation, BlockPos pivot, BoundingBox box, boolean finalizeEntities, CallbackInfo ci) {
      ADVANCED_WORLDGEN_TRANSFORM.set(new PlacementTransform(origin, mirror, rotation, pivot));
   }

   @Inject(
      method = {"placeEntities(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Mirror;Lnet/minecraft/world/level/block/Rotation;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Z)V", "m_74523_(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Mirror;Lnet/minecraft/world/level/block/Rotation;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Z)V"},
      at = {@At("RETURN")},
      remap = false,
      require = 0
   )
   private void advancedworldgen$endLegacyEntityTransform(ServerLevelAccessor level, BlockPos origin, Mirror mirror, Rotation rotation, BlockPos pivot, BoundingBox box, boolean finalizeEntities, CallbackInfo ci) {
      ADVANCED_WORLDGEN_TRANSFORM.remove();
   }

   @Inject(
      method = {"createEntityIgnoreException(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/nbt/CompoundTag;)Ljava/util/Optional;", "m_74543_(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/nbt/CompoundTag;)Ljava/util/Optional;"},
      at = {@At("HEAD")},
      remap = false,
      require = 1
   )
   private static void advancedworldgen$fixHangingEntityAnchor(ServerLevelAccessor level, CompoundTag nbt, CallbackInfoReturnable<?> cir) {
      PlacementTransform transform = (PlacementTransform)ADVANCED_WORLDGEN_TRANSFORM.get();
      if (transform != null && nbt.m_128441_("TileX") && nbt.m_128441_("TileY") && nbt.m_128441_("TileZ")) {
         String id = nbt.m_128461_("id");
         if ("minecraft:painting".equals(id) || "minecraft:item_frame".equals(id) || "minecraft:glow_item_frame".equals(id)) {
            BlockPos oldAnchor = new BlockPos(nbt.m_128451_("TileX"), nbt.m_128451_("TileY"), nbt.m_128451_("TileZ"));
            BlockPos fixedAnchor = StructureTemplate.m_74593_(oldAnchor, transform.mirror(), transform.rotation(), transform.pivot()).m_121955_(transform.origin());
            nbt.m_128405_("TileX", fixedAnchor.m_123341_());
            nbt.m_128405_("TileY", fixedAnchor.m_123342_());
            nbt.m_128405_("TileZ", fixedAnchor.m_123343_());
         }
      }
   }

   private static record PlacementTransform(BlockPos origin, Mirror mirror, Rotation rotation, BlockPos pivot) {
   }
}
