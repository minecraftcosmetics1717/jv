package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class YLookPositionProcedure {
   public static double execute(Entity entity, double distance) {
      return entity == null ? (double)0.0F : entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * distance;
   }
}
