package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class ZLookPositionPenetrationProcedure {
   public static double execute(Entity entity, double num) {
      return entity == null ? (double)0.0F : entity.m_20189_() + entity.m_20154_().f_82481_ * num;
   }
}
