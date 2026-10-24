package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ForestDomainActiveProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double size = (double)0.0F;
         double radius = (double)0.0F;
         if (entity.getPersistentData().m_128471_("Failed")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
            }
         } else {
            DisplayParticleCircleProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma") + 0.1, entity.getPersistentData().m_128459_("z_pos_doma"), (double)15.0F, Mth.m_216263_(RandomSource.m_216327_(), 0.1, GetDomainRadiusProcedure.execute(world) * 0.8), "/particle minecraft:soul_fire_flame ~ ~ ~ 0.1 0.1 0.1 0 5");
         }

      }
   }
}
