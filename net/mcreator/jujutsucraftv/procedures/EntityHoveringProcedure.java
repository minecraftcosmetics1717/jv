package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class EntityHoveringProcedure {
   private static final double MAX_GROUND_SEARCH = (double)64.0F;
   private static final double MAX_VERTICAL_SPEED = 0.8;
   private static final double MOVE_FACTOR = 0.2;
   private static final double STOP_THRESHOLD = 0.03;

   public static void execute(Entity entity, double num) {
      if (entity != null) {
         if (!entity.getPersistentData().m_128471_("hovering")) {
            if (entity.m_20068_()) {
               entity.m_20242_(false);
            }

         } else {
            entity.m_20242_(true);
            entity.f_19789_ = 0.0F;
            Level var4 = entity.m_9236_();
            if (var4 instanceof ServerLevel) {
               ServerLevel level = (ServerLevel)var4;
               Vec3 var20 = new Vec3(entity.m_20185_(), entity.m_20191_().f_82289_ + 0.05, entity.m_20189_());
               double minimumY = Math.max((double)level.m_141937_(), var20.f_82480_ - (double)64.0F);
               Vec3 end = new Vec3(var20.f_82479_, minimumY, var20.f_82481_);
               BlockHitResult hit = level.m_45547_(new ClipContext(var20, end, Block.COLLIDER, Fluid.NONE, entity));
               if (hit.m_6662_() == Type.BLOCK) {
                  double groundY = hit.m_82450_().f_82480_;
                  double targetY = groundY + num;
                  double currentY = entity.m_20186_();
                  double difference = targetY - currentY;
                  Vec3 motion = entity.m_20184_();
                  double ySpeed;
                  if (Math.abs(difference) <= 0.03) {
                     ySpeed = (double)0.0F;
                  } else {
                     ySpeed = difference * 0.2;
                     ySpeed = Math.max(-0.8, Math.min(0.8, ySpeed));
                  }

                  entity.m_20334_(motion.f_82479_, ySpeed, motion.f_82481_);
                  entity.f_19864_ = true;
               }
            }
         }
      }
   }
}
