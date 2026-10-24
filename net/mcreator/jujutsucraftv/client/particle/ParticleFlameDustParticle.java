package net.mcreator.jujutsucraftv.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public class ParticleFlameDustParticle extends TextureSheetParticle {
   private static final float COLOR_BOOST = 1.6F;
   private static final float START_ALPHA = 0.9F;
   private final SpriteSet spriteSet;
   private float startAlpha = 0.9F;
   private float baseQuadSize = 1.0F;

   public static ParticleFlameDustParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleFlameDustParticleProvider(spriteSet);
   }

   protected ParticleFlameDustParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.3F, 0.3F);
      this.f_107663_ *= 3.0F;
      this.baseQuadSize = this.f_107663_;
      this.f_107225_ = Math.max(1, 12 + (this.f_107223_.m_188503_(4) - 2));
      this.f_107226_ = 0.0F;
      this.f_107219_ = true;
      this.f_107215_ = vx * 0.3;
      this.f_107216_ = vy * 0.3;
      this.f_107217_ = vz * 0.3;
      this.f_107230_ = this.startAlpha;
      this.m_108339_(spriteSet);
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public void m_5989_() {
      super.m_5989_();
      float progress = this.f_107225_ <= 0 ? 1.0F : Math.min(1.0F, Math.max(0.0F, (float)this.f_107224_ / (float)this.f_107225_));
      this.f_107230_ = Math.max(0.0F, this.startAlpha * (1.0F - progress * 0.35F));
      this.f_107663_ = this.baseQuadSize * (1.0F + progress * 0.25F);
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 11 + 1, 11));
      }

   }

   public static class ParticleFlameDustParticleProvider implements ParticleProvider<ParticleDustColorOptions> {
      private final SpriteSet spriteSet;

      public ParticleFlameDustParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustColorOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleFlameDustParticle particle = new ParticleFlameDustParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         Vector3f dustColor = typeIn.getColor();
         particle.f_107227_ = Math.min(1.0F, dustColor.x() * 1.6F);
         particle.f_107228_ = Math.min(1.0F, dustColor.y() * 1.6F);
         particle.f_107229_ = Math.min(1.0F, dustColor.z() * 1.6F);
         particle.f_107230_ = 0.9F;
         particle.startAlpha = 0.9F;
         particle.f_107663_ = typeIn.getScale();
         particle.baseQuadSize = particle.f_107663_;
         return particle;
      }
   }
}
