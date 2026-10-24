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
public class ParticleCursePowerDustTransitionParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private Vector3f dustTransitionFromColor;
   private Vector3f dustTransitionToColor;
   private float startAlpha = 0.8F;
   private float baseQuadSize = 1.0F;

   public static ParticleCursePowerDustTransitionParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleCursePowerDustTransitionParticleProvider(spriteSet);
   }

   protected ParticleCursePowerDustTransitionParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.5F, 0.5F);
      this.f_107663_ *= 3.0F;
      this.baseQuadSize = this.f_107663_;
      this.f_107225_ = Math.max(1, 15 + (this.f_107223_.m_188503_(4) - 2));
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
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
      if (this.dustTransitionFromColor != null && this.dustTransitionToColor != null) {
         this.f_107227_ = this.dustTransitionFromColor.x() + (this.dustTransitionToColor.x() - this.dustTransitionFromColor.x()) * progress;
         this.f_107228_ = this.dustTransitionFromColor.y() + (this.dustTransitionToColor.y() - this.dustTransitionFromColor.y()) * progress;
         this.f_107229_ = this.dustTransitionFromColor.z() + (this.dustTransitionToColor.z() - this.dustTransitionFromColor.z()) * progress;
      }

      float fade = 1.0F - progress;
      this.f_107230_ = Math.max(0.0F, this.startAlpha * fade);
      this.f_107663_ = this.baseQuadSize * (1.0F + progress * 0.35F);
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 15 + 1, 15));
      }

   }

   public static class ParticleCursePowerDustTransitionParticleProvider implements ParticleProvider<ParticleDustTransitionOptions> {
      private final SpriteSet spriteSet;

      public ParticleCursePowerDustTransitionParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustTransitionOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleCursePowerDustTransitionParticle particle = new ParticleCursePowerDustTransitionParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         Vector3f fromColor = typeIn.getFromColor();
         Vector3f toColor = typeIn.getToColor();
         particle.dustTransitionFromColor = new Vector3f(fromColor);
         particle.dustTransitionToColor = new Vector3f(toColor);
         particle.f_107227_ = fromColor.x();
         particle.f_107228_ = fromColor.y();
         particle.f_107229_ = fromColor.z();
         particle.startAlpha = 0.8F;
         particle.f_107230_ = particle.startAlpha;
         particle.f_107663_ = typeIn.getScale();
         particle.baseQuadSize = particle.f_107663_;
         return particle;
      }
   }
}
