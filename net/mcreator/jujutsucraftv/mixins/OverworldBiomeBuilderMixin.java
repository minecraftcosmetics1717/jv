package net.mcreator.jujutsucraftv.mixins;

import com.mojang.datafixers.util.Pair;
import java.util.function.Consumer;
import net.mcreator.jujutsucraftv.worldgen.biome.AdvancedBiomeClimateRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({OverworldBiomeBuilder.class})
public abstract class OverworldBiomeBuilderMixin {
   @Inject(
      method = {"addBiomes(Ljava/util/function/Consumer;)V", "m_187175_(Ljava/util/function/Consumer;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 1
   )
   private void advancedworldgen$addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
      AdvancedBiomeClimateRegistry.addParameterPoints(consumer);
   }
}
