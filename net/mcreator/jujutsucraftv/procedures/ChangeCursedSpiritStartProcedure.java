package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class ChangeCursedSpiritStartProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (!entity.getPersistentData().m_128471_("CursedSpirit")) {
            entity.getPersistentData().m_128379_("CursedSpirit", true);
            entity.getPersistentData().m_128347_("check_side", (double)1.0F);
         }

      }
   }
}
