package net.mcreator.jujutsucraftv.mixins;

import java.util.concurrent.Executor;
import net.minecraft.Util;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(
   value = {ChunkGeneratorStructureState.class},
   priority = 1100
)
public abstract class ModernFixStrongholdExecutorMixin {
   @ModifyArg(
      method = {"generateRingPositions", "m_255294_"},
      at = @At(
   value = "INVOKE",
   target = "Ljava/util/concurrent/CompletableFuture;supplyAsync(Ljava/util/function/Supplier;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;"
),
      index = 1,
      remap = false,
      require = 1
   )
   private Executor jujutsucraftv$replaceNullStrongholdExecutor(Executor executor) {
      return (Executor)(executor != null ? executor : Util.m_183991_());
   }
}
