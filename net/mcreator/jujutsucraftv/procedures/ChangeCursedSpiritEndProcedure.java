package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class ChangeCursedSpiritEndProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("check_side") == (double)1.0F) {
            entity.getPersistentData().m_128379_("CursedSpirit", false);
            entity.getPersistentData().m_128347_("check_side", (double)0.0F);
         }

      }
   }
}
