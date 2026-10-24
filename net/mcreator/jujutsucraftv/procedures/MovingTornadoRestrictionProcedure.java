package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.GetHeightFromGroundProcedure;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class MovingTornadoRestrictionProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null && entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
         double x_pos = entity.m_20185_();
         double y_pos = entity.m_20186_();
         double z_pos = entity.m_20189_();
         new Vec3(x_pos, y_pos, z_pos);
         double y_velocity = entity.m_20184_().f_82480_;
         double heightFromGround = GetHeightFromGroundProcedure.execute(world, entity);
         if (heightFromGround < (double)6.0F) {
            y_velocity = Math.min(y_velocity + 0.1, (double)0.5F);
         } else if (heightFromGround > (double)8.0F) {
            y_velocity = Math.max(y_velocity - 0.1, (double)-0.5F);
         } else {
            y_velocity = (double)0.0F;
         }

         double playerCurseTechnique = (Double)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).map((capability) -> capability.PlayerCurseTechnique).orElse((double)0.0F);
         if (playerCurseTechnique == (double)602.0F) {
            entity.m_20256_(new Vec3(entity.m_20184_().f_82479_, y_velocity, entity.m_20184_().f_82481_));
         }

      }
   }
}
