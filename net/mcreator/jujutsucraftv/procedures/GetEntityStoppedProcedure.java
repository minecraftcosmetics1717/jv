package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class GetEntityStoppedProcedure {
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.m_20096_() || entity.f_19862_;
      }
   }
}
