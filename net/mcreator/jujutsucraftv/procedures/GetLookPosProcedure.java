package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class GetLookPosProcedure {
   public static void execute(LevelAccessor world, Entity entity, boolean stop, double distance) {
      if (entity != null) {
         Vec3 start = entity.m_20299_(1.0F);
         Vec3 look = entity.m_20154_();
         Vec3 end = start.m_82549_(look.m_82490_(distance));
         HitResult hit = world.m_45547_(new ClipContext(start, end, Block.COLLIDER, Fluid.NONE, entity));
         double targetX;
         double targetY;
         double targetZ;
         if (stop && hit.m_6662_() == Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult)hit;
            BlockPos pos = blockHit.m_82425_();
            targetX = (double)pos.m_123341_();
            targetY = (double)pos.m_123342_();
            targetZ = (double)pos.m_123343_();
         } else {
            targetX = end.f_82479_;
            targetY = end.f_82480_;
            targetZ = end.f_82481_;
         }

         entity.getPersistentData().m_128347_("x_pos", targetX);
         entity.getPersistentData().m_128347_("y_pos", targetY);
         entity.getPersistentData().m_128347_("z_pos", targetZ);
         if (!world.m_5776_() && entity instanceof Mob) {
            Mob mob = (Mob)entity;
            mob.getPersistentData().m_128405_("data_updated", 1);
         }

      }
   }
}
