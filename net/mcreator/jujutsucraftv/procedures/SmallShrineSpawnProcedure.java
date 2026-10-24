package net.mcreator.jujutsucraftv.procedures;

public class SmallShrineSpawnProcedure {
   public static boolean execute() {
      double random = (double)0.0F;
      random = Math.random() * (double)1000.0F;
      return random < (double)5.0F;
   }
}
