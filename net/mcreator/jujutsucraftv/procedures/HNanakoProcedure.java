package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.player.Player;

public class HNanakoProcedure extends SwitchSkillProcedure {
   public static boolean execute(Player player, int selected) {
      boolean found = false;
      switch (selected) {
         default:
            found = switchDefault(player, selected);
            return found;
      }
   }
}
