package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class SetTagCurseUserProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("CurseUser", true);
         entity.getPersistentData().m_128379_("jjkChara", true);
      }
   }
}
