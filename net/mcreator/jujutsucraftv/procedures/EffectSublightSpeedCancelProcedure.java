package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class EffectSublightSpeedCancelProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("cnt_sublight_speed", (double)0.0F);
      }
   }
}
