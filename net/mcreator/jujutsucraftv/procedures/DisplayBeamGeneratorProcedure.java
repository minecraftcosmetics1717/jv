package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class DisplayBeamGeneratorProcedure {
   public static void execute(LevelAccessor world, boolean penetration, double dis, double height, double width, double x1, double x2, double y1, double y2, double z1, double z2, double zoomsize, String particle) {
      if (particle != null && world instanceof ServerLevel _level) {
         ParticleOptions options = getParticleFromString(particle);
         if (options != null) {
            double finalX2 = x2;
            double finalY2 = y2;
            double finalZ2 = z2;
            if (!penetration) {
               Vec3 startVec = new Vec3(x1, y1, z1);
               Vec3 endVec = new Vec3(x2, y2, z2);
               BlockHitResult result = _level.m_45547_(new ClipContext(startVec, endVec, Block.COLLIDER, Fluid.NONE, (Entity)null));
               if (result.m_6662_() != Type.MISS) {
                  Vec3 hitVec = result.m_82450_();
                  finalX2 = hitVec.f_82479_;
                  finalY2 = hitVec.f_82480_;
                  finalZ2 = hitVec.f_82481_;
               }
            }

            double dx = finalX2 - x1;
            double dy = finalY2 - y1;
            double dz = finalZ2 - z1;
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (!(distance < 0.1)) {
               int count = (int)(distance / dis);
               if (count <= 0) {
                  count = 1;
               }

               double stepX = dx / (double)count;
               double stepY = dy / (double)count;
               double stepZ = dz / (double)count;

               for(int i = 0; i <= count; ++i) {
                  double progress = (double)i / (double)count;
                  double currentWidth = Math.max((double)0.0F, width + progress * zoomsize);
                  double currentHeight = Math.max((double)0.0F, height + progress * zoomsize);
                  int pAmount = (int)Math.max((double)1.0F, (currentWidth + currentHeight) * (double)5.0F);
                  _level.m_8767_(options, x1 + stepX * (double)i, y1 + stepY * (double)i, z1 + stepZ * (double)i, pAmount, currentWidth, currentHeight, currentWidth, (double)0.0F);
               }

            }
         }
      }
   }

   private static ParticleOptions getParticleFromString(String particle) {
      try {
         String id = particle.split(" ")[0];
         ParticleType<?> type = (ParticleType)ForgeRegistries.PARTICLE_TYPES.getValue(new ResourceLocation(id));
         if (type instanceof ParticleOptions options) {
            return options;
         }
      } catch (Exception var4) {
      }

      return null;
   }
}
