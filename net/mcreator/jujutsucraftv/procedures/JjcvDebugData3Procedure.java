package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class JjcvDebugData3Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         int var10000 = entity.getPersistentData().m_128471_("JujutsuSorcerer") ? 1 : 0;
         return "JS:" + var10000 + " CU:" + (entity.getPersistentData().m_128471_("CurseUser") ? 1 : 0) + " CS:" + (entity.getPersistentData().m_128471_("CursedSpirit") ? 1 : 0);
      }
   }
}
