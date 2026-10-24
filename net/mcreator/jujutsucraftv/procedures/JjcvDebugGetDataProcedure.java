package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class JjcvDebugGetDataProcedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         CompoundTag var10000 = entity.getPersistentData();
         return "skill:" + var10000.m_128459_("skill");
      }
   }
}
