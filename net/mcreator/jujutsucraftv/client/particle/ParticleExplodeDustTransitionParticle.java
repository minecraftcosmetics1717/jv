package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.procedures.ReturnNumber1To3Procedure;
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
public class ParticleExplodeDustTransitionParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private final float randomQuadScale;
   private Vector3f dustTransitionFromColor;
   private Vector3f dustTransitionToColor;

   public static ParticleExplodeDustTransitionParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleExplodeDustTransitionParticleProvider(spriteSet);
   }

   protected ParticleExplodeDustTransitionParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.randomQuadScale = (float)ReturnNumber1To3Procedure.execute();
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = Math.max(1, 16 + (this.f_107223_.m_188503_(4) - 2));
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx * (double)1.0F;
      this.f_107216_ = vy * (double)1.0F;
      this.f_107217_ = vz * (double)1.0F;
      this.m_107271_(0.6F);
      this.m_108339_(spriteSet);
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public float m_5902_(float scale) {
      return super.m_5902_(scale) * this.randomQuadScale;
   }

   public void m_5989_() {
      super.m_5989_();
      if (this.dustTransitionFromColor != null && this.dustTransitionToColor != null) {
         float progress = this.f_107225_ <= 0 ? 1.0F : Math.min(1.0F, Math.max(0.0F, (float)this.f_107224_ / (float)this.f_107225_));
         this.f_107227_ = this.dustTransitionFromColor.x() + (this.dustTransitionToColor.x() - this.dustTransitionFromColor.x()) * progress;
         this.f_107228_ = this.dustTransitionFromColor.y() + (this.dustTransitionToColor.y() - this.dustTransitionFromColor.y()) * progress;
         this.f_107229_ = this.dustTransitionFromColor.z() + (this.dustTransitionToColor.z() - this.dustTransitionFromColor.z()) * progress;
      }

      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 16 + 1, 16));
      }

   }

   public static class ParticleExplodeDustTransitionParticleProvider implements ParticleProvider<ParticleDustTransitionOptions> {
      private final SpriteSet spriteSet;

      public ParticleExplodeDustTransitionParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustTransitionOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleExplodeDustTransitionParticle particle = new ParticleExplodeDustTransitionParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         Vector3f fromColor = typeIn.getFromColor();
         Vector3f toColor = typeIn.getToColor();
         particle.dustTransitionFromColor = new Vector3f(fromColor);
         particle.dustTransitionToColor = new Vector3f(toColor);
         particle.f_107227_ = fromColor.x();
         particle.f_107228_ = fromColor.y();
         particle.f_107229_ = fromColor.z();
         particle.f_107663_ = typeIn.getScale();
         return particle;
      }
   }
}
