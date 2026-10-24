package net.mcreator.jujutsucraftv.procedures;

import java.text.DecimalFormat;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DisplayParticleGeneratorProcedure {
   public static void execute(LevelAccessor world, double caliber_radius, double count, double inaccuracy, double speed, double x1, double x2, double y1, double y2, double z1, double z2, String id) {
      if (id != null) {
         boolean logic_vector_set = false;
         double cosTheta = (double)0.0F;
         double distance = (double)0.0F;
         double dot = (double)0.0F;
         double rad_inaccuracy = (double)0.0F;
         double y_power = (double)0.0F;
         double z_power = (double)0.0F;
         double x_power = (double)0.0F;
         double cross2 = (double)0.0F;
         double cross3 = (double)0.0F;
         double cross1 = (double)0.0F;
         double rnd1 = (double)0.0F;
         double sinTheta = (double)0.0F;
         double rnd3 = (double)0.0F;
         double rnd2 = (double)0.0F;
         rad_inaccuracy = Math.toRadians(inaccuracy * (double)0.5F);
         cosTheta = Math.cos(rad_inaccuracy);
         sinTheta = Math.sin(rad_inaccuracy);

         for(int index0 = 0; index0 < (int)count; ++index0) {
            if (!logic_vector_set) {
               logic_vector_set = true;
               x_power = x2 - x1;
               y_power = y2 - y1;
               z_power = z2 - z1;
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance != (double)0.0F) {
                  x_power /= distance;
                  y_power /= distance;
                  z_power /= distance;
               }
            }

            if (inaccuracy != (double)0.0F) {
               logic_vector_set = false;
               rnd1 = Math.random() - (double)0.5F;
               rnd2 = Math.random() - (double)0.5F;
               rnd3 = Math.random() - (double)0.5F;
               distance = Math.sqrt(rnd1 * rnd1 + rnd2 * rnd2 + rnd3 * rnd3);
               if (distance != (double)0.0F) {
                  rnd1 /= distance;
                  rnd2 /= distance;
                  rnd3 /= distance;
               }

               cross1 = rnd2 * z_power - rnd3 * y_power;
               cross2 = rnd3 * x_power - rnd1 * z_power;
               cross3 = rnd1 * y_power - rnd2 * x_power;
               dot = rnd1 * x_power + rnd2 * y_power + rnd3 * z_power;
               x_power = x_power * cosTheta + cross1 * sinTheta + rnd1 * dot * ((double)1.0F - cosTheta);
               y_power = y_power * cosTheta + cross2 * sinTheta + rnd2 * dot * ((double)1.0F - cosTheta);
               z_power = z_power * cosTheta + cross3 * sinTheta + rnd3 * dot * ((double)1.0F - cosTheta);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x1 + caliber_radius * (Math.random() - (double)0.5F), y1 + caliber_radius * (Math.random() - (double)0.5F), z1 + caliber_radius * (Math.random() - (double)0.5F)), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle " + id + " ~ ~ ~ " + (new DecimalFormat("#####.#####")).format(x_power * (double)10000.0F) + " " + (new DecimalFormat("#####.#####")).format(y_power * (double)10000.0F) + " " + (new DecimalFormat("#####.#####")).format(z_power * (double)10000.0F) + " " + (new DecimalFormat("#####.#####")).format(1.0E-4 * speed) + " 0 force");
            }
         }

      }
   }
}
