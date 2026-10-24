package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class SetPosGoProcedure {
   public static void execute(double x_pos, double y_pos, double z_pos, Entity entity, boolean loop, double speed) {
      if (entity != null) {
         Vec3 currentPos = entity.m_20182_();
         Vec3 targetPos = new Vec3(x_pos, y_pos, z_pos);
         Vec3 direction = targetPos.m_82546_(currentPos);
         double distanceSq = direction.m_82556_();
         if (distanceSq < 1.0E-7) {
            if (!loop) {
               entity.m_20256_(Vec3.f_82478_);
            }

         } else {
            if (!loop && distanceSq <= speed * speed) {
               entity.m_6034_(x_pos, y_pos, z_pos);
               entity.m_20256_(Vec3.f_82478_);
            } else {
               Vec3 velocity = direction.m_82541_().m_82490_(speed);
               entity.m_20256_(velocity);
            }

            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9829_(new ClientboundSetEntityMotionPacket(_serverPlayer));
            }

         }
      }
   }
}
