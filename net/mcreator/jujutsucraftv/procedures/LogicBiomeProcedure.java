package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;

public class LogicBiomeProcedure {
   public static boolean execute(Entity entity, String id) {
      if (entity != null && id != null && !id.isEmpty()) {
         ResourceLocation biomeId = ResourceLocation.m_135820_(id);
         if (biomeId == null) {
            return false;
         } else {
            ResourceKey<Biome> biomeKey = ResourceKey.m_135785_(Registries.f_256952_, biomeId);
            return entity.m_9236_().m_204166_(entity.m_20183_()).m_203565_(biomeKey);
         }
      } else {
         return false;
      }
   }
}
