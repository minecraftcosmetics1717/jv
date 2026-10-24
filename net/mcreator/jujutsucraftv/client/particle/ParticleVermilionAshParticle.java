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
public class ParticleVermilionAshParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleVermilionAshParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleVermilionAshParticleProvider(spriteSet);
   }

   protected ParticleVermilionAshParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = Math.max(1, (40 + (this.f_107223_.m_188503_(20) - 10)) / 2);
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = ((double)this.f_107223_.m_188501_() - (double)0.5F) * 0.1 + vx * 0.1;
      this.f_107216_ = 0.1 + (double)this.f_107223_.m_188501_() * 0.05 + vy * 0.1;
      this.f_107217_ = ((double)this.f_107223_.m_188501_() - (double)0.5F) * 0.1 + vz * 0.1;
      this.m_108339_(spriteSet);
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107432_;
   }

   public void m_5989_() {
      super.m_5989_();
      if (!this.f_107220_) {
         this.f_107215_ += ((double)this.f_107223_.m_188501_() - (double)0.5F) * 0.01;
         this.f_107216_ += ((double)this.f_107223_.m_188501_() - (double)0.5F) * 0.01;
         this.f_107217_ += ((double)this.f_107223_.m_188501_() - (double)0.5F) * 0.01;
         this.f_107230_ = 1.0F - (float)this.f_107224_ / (float)this.f_107225_;
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 2 % 6 + 1, 6));
      }

   }

   public static class ParticleVermilionAshParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleVermilionAshParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new ParticleVermilionAshParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}
