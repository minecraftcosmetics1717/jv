package net.mcreator.jujutsucraftv.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.procedures.ReturnNumber6To7Procedure;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public class ParticleLightningHumanoidDustParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private final float baseQuadSize;
   private final float startAlpha;

   public static ParticleLightningHumanoidDustParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleLightningHumanoidDustParticleProvider(spriteSet);
   }

   protected ParticleLightningHumanoidDustParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet, float commandScale) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      float randomSize = (float)ReturnNumber6To7Procedure.execute();
      float finalSize = commandScale * randomSize;
      this.baseQuadSize = finalSize;
      this.f_107663_ = finalSize;
      this.startAlpha = 0.8F;
      this.m_107250_(0.2F * commandScale, 0.2F * commandScale);
      this.f_107225_ = Math.max(1, 30 + this.f_107223_.m_188503_(20) - 10);
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.f_107230_ = this.startAlpha;
      this.m_108335_(spriteSet);
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public float m_5902_(float scale) {
      return this.f_107663_;
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
      float progress = this.f_107225_ <= 0 ? 1.0F : Math.min(1.0F, Math.max(0.0F, (float)this.f_107224_ / (float)this.f_107225_));
      this.f_107230_ = Math.max(0.0F, this.startAlpha * (1.0F - progress * 0.25F));
      this.f_107663_ = this.baseQuadSize;
   }

   public static class ParticleLightningHumanoidDustParticleProvider implements ParticleProvider<ParticleDustColorOptions> {
      private final SpriteSet spriteSet;

      public ParticleLightningHumanoidDustParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustColorOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleLightningHumanoidDustParticle particle = new ParticleLightningHumanoidDustParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet, typeIn.getScale());
         Vector3f dustColor = typeIn.getColor();
         particle.f_107227_ = dustColor.x();
         particle.f_107228_ = dustColor.y();
         particle.f_107229_ = dustColor.z();
         particle.f_107230_ = particle.startAlpha;
         return particle;
      }
   }
}
