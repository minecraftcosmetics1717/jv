package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class XLookPositionPenetrationProcedure {
   public static double execute(Entity entity, double num) {
      return entity == null ? (double)0.0F : entity.m_20185_() + entity.m_20154_().f_82479_ * num;
   }
}
