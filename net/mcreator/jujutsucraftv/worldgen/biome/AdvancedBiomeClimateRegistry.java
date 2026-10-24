package net.mcreator.jujutsucraftv.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import java.util.function.Consumer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.Parameter;

public final class AdvancedBiomeClimateRegistry {
   private AdvancedBiomeClimateRegistry() {
   }

   public static void addParameterPoints(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
      addConfiguredPoint(consumer, biomeKey("jujutsucraftv:jujutsu_plain"), (double)-0.5F, (double)0.5F, (double)-0.5F, (double)0.5F, 0.3, (double)1.0F, -0.1, 0.005, (double)0.0F, 0.2, -0.1, 0.1, (double)0.0F, 0.2, 3, false, false, false, false);
      addRegistrationOnlyPoint(consumer, biomeKey("jujutsucraftv:grand_barrier_forest"));
   }

   private static ResourceKey<Biome> biomeKey(String id) {
      return ResourceKey.m_135785_(Registries.f_256952_, new ResourceLocation(id));
   }

   private static void addRegistrationOnlyPoint(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, ResourceKey<Biome> biomeKey) {
      Climate.Parameter unreachable = Parameter.m_186820_(2.0F);
      consumer.accept(Pair.of(new Climate.ParameterPoint(unreachable, unreachable, unreachable, unreachable, unreachable, unreachable, 1000000L), biomeKey));
   }

   private static void addConfiguredPoint(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, ResourceKey<Biome> biomeKey, double temperatureMin, double temperatureMax, double humidityMin, double humidityMax, double continentalnessMin, double continentalnessMax, double erosionMin, double erosionMax, double depthMin, double depthMax, double weirdnessMin, double weirdnessMax, double offset, double spread, int density, boolean ocean, boolean inlandOnly, boolean peaks, boolean underground) {
      if (inlandOnly) {
         continentalnessMin = Math.max(0.15, continentalnessMin);
         continentalnessMax = Math.max(continentalnessMin, continentalnessMax);
         spread = Math.min(spread, 0.05);
         ocean = false;
      }

      int count = Math.max(1, density);

      for(int index = 0; index < count; ++index) {
         double centeredIndex = (double)index - (double)(count - 1) * (double)0.5F;
         double shift = centeredIndex * 0.08;
         addSinglePoint(consumer, biomeKey, temperatureMin, temperatureMax, humidityMin, humidityMax, continentalnessMin + shift * 0.35, continentalnessMax + shift * 0.35, erosionMin, erosionMax, depthMin, depthMax, weirdnessMin + shift, weirdnessMax + shift, offset, spread);
      }

      if (ocean) {
         addSinglePoint(consumer, biomeKey, temperatureMin, temperatureMax, humidityMin, humidityMax, -1.05, -0.19, erosionMin, erosionMax, (double)0.0F, 0.2, weirdnessMin, weirdnessMax, offset, spread);
      }

      if (peaks) {
         addSinglePoint(consumer, biomeKey, temperatureMin, temperatureMax, humidityMin, humidityMax, 0.3, (double)1.0F, (double)-1.0F, -0.35, 0.15, (double)1.0F, 0.45, (double)1.0F, offset, spread);
      }

      if (underground) {
         addSinglePoint(consumer, biomeKey, temperatureMin, temperatureMax, humidityMin, humidityMax, continentalnessMin, continentalnessMax, erosionMin, erosionMax, 0.2, (double)1.0F, weirdnessMin, weirdnessMax, offset, spread);
      }

   }

   private static void addSinglePoint(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, ResourceKey<Biome> biomeKey, double temperatureMin, double temperatureMax, double humidityMin, double humidityMax, double continentalnessMin, double continentalnessMax, double erosionMin, double erosionMax, double depthMin, double depthMax, double weirdnessMin, double weirdnessMax, double offset, double spread) {
      Climate.ParameterPoint point = new Climate.ParameterPoint(span(temperatureMin, temperatureMax, spread), span(humidityMin, humidityMax, spread), span(continentalnessMin, continentalnessMax, spread), span(erosionMin, erosionMax, spread), span(depthMin, depthMax, spread), span(weirdnessMin, weirdnessMax, spread), (long)(clamp(offset) * (double)10000.0F));
      consumer.accept(Pair.of(point, biomeKey));
   }

   private static Climate.Parameter span(double min, double max, double spread) {
      double center = (min + max) * (double)0.5F;
      double halfRange = (max - min) * (double)0.5F + Math.max((double)0.0F, spread);
      return Parameter.m_186822_((float)clamp(center - halfRange), (float)clamp(center + halfRange));
   }

   private static double clamp(double value) {
      return Math.max((double)-2.0F, Math.min((double)2.0F, value));
   }
}
