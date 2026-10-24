package net.mcreator.jujutsucraftv.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ParticleRiceParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private float angularVelocity;
   private float angularAcceleration;

   public static ParticleRiceParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleRiceParticleProvider(spriteSet);
   }

   protected ParticleRiceParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.5F, 0.5F);
      this.f_107663_ *= 2.0F;
      this.f_107225_ = Math.max(1, 15 + (this.f_107223_.m_188503_(4) - 2));
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx * (double)1.0F;
      this.f_107216_ = vy * (double)1.0F;
      this.f_107217_ = vz * (double)1.0F;
      this.angularVelocity = 0.314F;
      this.angularAcceleration = 0.0F;
      this.f_107231_ = this.f_107223_.m_188501_() * (float)Math.PI * 2.0F;
      this.f_107204_ = this.f_107231_;
      this.m_108335_(spriteSet);
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107430_;
   }

   public void m_5989_() {
      super.m_5989_();
      this.f_107204_ = this.f_107231_;
      this.f_107231_ += this.angularVelocity;
      this.angularVelocity += this.angularAcceleration;
   }

   public static class ParticleRiceParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleRiceParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleRiceParticle particle = new ParticleRiceParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         return particle;
      }
   }
}
