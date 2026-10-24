package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class GetPlayerSelectSlotProcedure {
   public static int execute(Entity entity) {
      if (entity instanceof Player player) {
         return player.m_150109_().f_35977_;
      } else {
         return 0;
      }
   }
}
