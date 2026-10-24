package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class ResetSkillProProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128347_("skill", (double)0.0F);
      }
   }
}
