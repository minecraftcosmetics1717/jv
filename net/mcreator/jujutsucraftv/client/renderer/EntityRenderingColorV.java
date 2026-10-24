package net.mcreator.jujutsucraftv.client.renderer;

public final class EntityRenderingColorV {
   private EntityRenderingColorV() {
   }

   public static float[] getColor(int amplifier) {
      float[] var10000;
      switch (amplifier) {
         case 0 -> var10000 = new float[]{1.0F, 1.0F, 1.0F};
         case 1 -> var10000 = new float[]{0.02F, 0.02F, 0.02F};
         case 2 -> var10000 = new float[]{1.0F, 0.0F, 0.0F};
         case 3 -> var10000 = new float[]{1.0F, 0.35F, 0.0F};
         case 4 -> var10000 = new float[]{1.0F, 0.9F, 0.0F};
         case 5 -> var10000 = new float[]{0.0F, 1.0F, 0.0F};
         case 6 -> var10000 = new float[]{0.0F, 0.2F, 1.0F};
         case 7 -> var10000 = new float[]{0.65F, 0.0F, 1.0F};
         default -> var10000 = new float[]{1.0F, 1.0F, 1.0F};
      }

      return var10000;
   }
}
