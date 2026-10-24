package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class ZLookPositionProcedure {
   public static double execute(Entity entity, double distance) {
      return entity == null ? (double)0.0F : entity.m_20189_() + entity.m_20184_().m_7094_() * distance;
   }
}
