package net.mcreator.jujutsucraftv.client.utils;

import java.awt.Color;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.BuiltInRegistries;

public class CurseColorHelper {
   public static float[] getRGB(ParticleOptions type) {
      String path = BuiltInRegistries.f_257034_.m_7981_(type.m_6012_()).m_135815_();
      if (path.contains("rainbow")) {
         int rgb = Color.HSBtoRGB((float)Math.random(), 1.0F, 1.0F);
         return hexToRGB(rgb & 16777215);
      } else {
         int var10000;
         switch (path) {
            case "particle_curse_power_white" -> var10000 = 16579836;
            case "particle_curse_power_black" -> var10000 = 1644825;
            case "particle_curse_power_yellow" -> var10000 = 15852066;
            case "particle_curse_power_deep_red" -> var10000 = 9306112;
            case "particle_curse_power_deep_blue" -> var10000 = 2399;
            case "particle_curse_power_deep_green" -> var10000 = 24320;
            default -> var10000 = 16777215;
         }

         int color = var10000;
         return hexToRGB(color);
      }
   }

   private static float[] hexToRGB(int hex) {
      float r = (float)(hex >> 16 & 255) / 255.0F;
      float g = (float)(hex >> 8 & 255) / 255.0F;
      float b = (float)(hex & 255) / 255.0F;
      return new float[]{r, g, b};
   }
}
