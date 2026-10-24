package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class DisplayParticleCircleProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, double radius, double interval, String particle) {
      if (particle != null && !(radius <= (double)0.0F) && !(interval <= (double)0.0F)) {
         double rad0 = radius;
         double int0 = interval;
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;

            for(double i = (double)0.0F; i < (double)360.0F; i += rad0 * Math.random() * (double)2.0F) {
               double angle = Math.toRadians(i);
               double offsetX = int0 * Math.cos(angle);
               double offsetZ = int0 * Math.sin(angle);
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x + offsetX, y, z + offsetZ), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), particle);
            }
         }

      }
   }
}
