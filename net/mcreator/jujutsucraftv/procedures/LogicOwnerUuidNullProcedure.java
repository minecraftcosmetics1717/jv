package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;

public class LogicOwnerUuidNullProcedure {
   public static boolean execute(Entity entity, String uuid) {
      return entity != null && uuid != null ? entity.getPersistentData().m_128461_(uuid).isEmpty() : false;
   }
}
