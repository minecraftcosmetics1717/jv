package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.scores.Team;

public class LogicEntityTeamProcedure {
   public static boolean execute(Entity ent1, Entity ent2) {
      if (ent1 != null && ent2 != null) {
         Team team1 = ent1.m_5647_();
         Team team2 = ent2.m_5647_();
         return team1 != null && team2 != null ? team1.equals(team2) : false;
      } else {
         return false;
      }
   }
}
