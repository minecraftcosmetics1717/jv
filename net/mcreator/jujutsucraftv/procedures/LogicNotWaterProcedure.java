package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class LogicNotWaterProcedure {
   public static boolean execute(Entity entity) {
      return entity == null ? false : entity.m_20096_();
   }
}
