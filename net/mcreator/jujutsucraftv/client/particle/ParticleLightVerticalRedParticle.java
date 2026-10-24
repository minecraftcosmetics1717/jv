package net.mcreator.jujutsucraftv.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.procedures.ReturnNumber50To60Procedure;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ParticleLightVerticalRedParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private final float baseQuadSize;

   public static ParticleLightVerticalRedParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleLightVerticalRedParticleProvider(spriteSet);
   }

   protected ParticleLightVerticalRedParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(1.0F, 1.0F);
      this.f_107225_ = Math.max(1, 30 + this.f_107223_.m_188503_(20) - 10);
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.f_107230_ = 0.3F;
      this.m_108339_(spriteSet);
      this.f_107663_ *= (float)ReturnNumber50To60Procedure.execute();
      this.baseQuadSize = this.f_107663_;
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107432_;
   }

   public float m_5902_(float partialTick) {
      return this.baseQuadSize;
   }

   public void m_5744_(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
      Vec3 cameraPosition = camera.m_90583_();
      double particleX = Mth.m_14139_((double)partialTick, this.f_107209_, this.f_107212_);
      double particleY = Mth.m_14139_((double)partialTick, this.f_107210_, this.f_107213_);
      double particleZ = Mth.m_14139_((double)partialTick, this.f_107211_, this.f_107214_);
      float renderX = (float)(particleX - cameraPosition.m_7096_());
      float renderY = (float)(particleY - cameraPosition.m_7098_());
      float renderZ = (float)(particleZ - cameraPosition.m_7094_());
      double directionX = cameraPosition.m_7096_() - particleX;
      double directionZ = cameraPosition.m_7094_() - particleZ;
      double horizontalLength = Math.sqrt(directionX * directionX + directionZ * directionZ);
      float rightX;
      float rightZ;
      if (horizontalLength < 1.0E-4) {
         float yaw = (float)Math.toRadians((double)camera.m_90590_());
         rightX = Mth.m_14089_(yaw);
         rightZ = Mth.m_14031_(yaw);
      } else {
         rightX = (float)(directionZ / horizontalLength);
         rightZ = (float)(-directionX / horizontalLength);
      }

      float size = this.m_5902_(partialTick);
      float x0 = renderX - rightX * size;
      float x1 = renderX + rightX * size;
      float y0 = renderY - size;
      float y1 = renderY + size;
      float z0 = renderZ - rightZ * size;
      float z1 = renderZ + rightZ * size;
      float minU = this.m_5970_();
      float maxU = this.m_5952_();
      float minV = this.m_5951_();
      float maxV = this.m_5950_();
      int light = this.m_6355_(partialTick);
      vertexConsumer.m_5483_((double)x0, (double)y0, (double)z0).m_7421_(maxU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x0, (double)y1, (double)z0).m_7421_(maxU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x1, (double)y1, (double)z1).m_7421_(minU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x1, (double)y0, (double)z1).m_7421_(minU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x1, (double)y0, (double)z1).m_7421_(minU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x1, (double)y1, (double)z1).m_7421_(minU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x0, (double)y1, (double)z0).m_7421_(maxU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)x0, (double)y0, (double)z0).m_7421_(maxU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
   }

   public void m_5989_() {
      super.m_5989_();
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ % 5 + 1, 5));
      }

   }

   public static class ParticleLightVerticalRedParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleLightVerticalRedParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new ParticleLightVerticalRedParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}
