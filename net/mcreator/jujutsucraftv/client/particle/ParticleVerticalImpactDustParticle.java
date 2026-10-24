package net.mcreator.jujutsucraftv.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftv.procedures.ReturnNumber1To3Procedure;
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
public class ParticleVerticalImpactDustParticle extends TextureSheetParticle {
   private static final float BASE_SIZE = 1.0F;
   private static final float COLOR_BOOST = 1.25F;
   private static final float START_ALPHA = 0.65F;
   private final SpriteSet spriteSet;
   private final float baseQuadHeight;
   private final float baseHalfWidth;
   private final float startAlpha;
   private final int frameOffset;

   public static ParticleVerticalImpactDustParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleVerticalImpactDustParticleProvider(spriteSet);
   }

   protected ParticleVerticalImpactDustParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet, float commandScale) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      float randomSize = (float)ReturnNumber1To3Procedure.execute();
      float widthScale = 0.6F + this.f_107223_.m_188501_() * 0.8F;
      this.baseQuadHeight = 1.0F * randomSize * commandScale;
      this.baseHalfWidth = 1.0F * randomSize * widthScale;
      this.startAlpha = 0.65F;
      this.frameOffset = this.f_107223_.m_188503_(3);
      this.m_107250_(0.2F, 0.5F * commandScale);
      this.f_107663_ = this.baseQuadHeight;
      this.f_107225_ = Math.max(1, 10 + this.f_107223_.m_188503_(4) - 2);
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.f_107230_ = this.startAlpha;
      this.m_108339_(spriteSet);
   }

   public int m_6355_(float partialTick) {
      return 10485920;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public float m_5902_(float partialTick) {
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
         float yaw = camera.m_90590_() * ((float)Math.PI / 180F);
         rightX = Mth.m_14089_(yaw);
         rightZ = Mth.m_14031_(yaw);
      } else {
         rightX = (float)(directionZ / horizontalLength);
         rightZ = (float)(-directionX / horizontalLength);
      }

      float progress = this.f_107225_ <= 0 ? 1.0F : Math.min(1.0F, Math.max(0.0F, ((float)this.f_107224_ + partialTick) / (float)this.f_107225_));
      float halfWidth = this.baseHalfWidth * (1.0F + progress * 0.15F);
      float halfHeight = this.m_5902_(partialTick);
      float leftX = renderX - rightX * halfWidth;
      float rightSideX = renderX + rightX * halfWidth;
      float topY = renderY + halfHeight * 2.0F;
      float leftZ = renderZ - rightZ * halfWidth;
      float rightSideZ = renderZ + rightZ * halfWidth;
      float minU = this.m_5970_();
      float maxU = this.m_5952_();
      float minV = this.m_5951_();
      float maxV = this.m_5950_();
      int light = this.m_6355_(partialTick);
      vertexConsumer.m_5483_((double)leftX, (double)renderY, (double)leftZ).m_7421_(maxU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)leftX, (double)topY, (double)leftZ).m_7421_(maxU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)rightSideX, (double)topY, (double)rightSideZ).m_7421_(minU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)rightSideX, (double)renderY, (double)rightSideZ).m_7421_(minU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)rightSideX, (double)renderY, (double)rightSideZ).m_7421_(minU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)rightSideX, (double)topY, (double)rightSideZ).m_7421_(minU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)leftX, (double)topY, (double)leftZ).m_7421_(maxU, minV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
      vertexConsumer.m_5483_((double)leftX, (double)renderY, (double)leftZ).m_7421_(maxU, maxV).m_85950_(this.f_107227_, this.f_107228_, this.f_107229_, this.f_107230_).m_85969_(light).m_5752_();
   }

   public void m_5989_() {
      super.m_5989_();
      float progress = this.f_107225_ <= 0 ? 1.0F : Math.min(1.0F, Math.max(0.0F, (float)this.f_107224_ / (float)this.f_107225_));
      this.f_107230_ = Math.max(0.0F, this.startAlpha * (1.0F - progress * 0.45F));
      this.f_107663_ = this.baseQuadHeight * (1.0F + progress * 0.15F);
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_((this.f_107224_ + this.frameOffset) % 6 + 1, 6));
      }

   }

   public static class ParticleVerticalImpactDustParticleProvider implements ParticleProvider<ParticleDustColorOptions> {
      private final SpriteSet spriteSet;

      public ParticleVerticalImpactDustParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustColorOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleVerticalImpactDustParticle particle = new ParticleVerticalImpactDustParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet, typeIn.getScale());
         Vector3f dustColor = typeIn.getColor();
         particle.f_107227_ = Math.min(1.0F, dustColor.x() * 1.25F);
         particle.f_107228_ = Math.min(1.0F, dustColor.y() * 1.25F);
         particle.f_107229_ = Math.min(1.0F, dustColor.z() * 1.25F);
         particle.f_107230_ = particle.startAlpha;
         return particle;
      }
   }
}
