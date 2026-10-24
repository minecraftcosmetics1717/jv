package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class LogicInsideNetherProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.m_9236_().m_46472_() == Level.f_46429_;
      }
   }
}
