package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.procedures.ReturnNumber6To7Procedure;
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
public class ParticleSmokePurpleParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleSmokePurpleParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleSmokePurpleParticleProvider(spriteSet);
   }

   protected ParticleSmokePurpleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = Math.max(1, 24 + (this.f_107223_.m_188503_(4) - 2));
      this.f_107226_ = 0.0F;
      this.f_107219_ = true;
      this.f_107215_ = vx * (double)1.0F;
      this.f_107216_ = vy * (double)1.0F;
      this.f_107217_ = vz * (double)1.0F;
      this.m_108339_(spriteSet);
      this.f_107230_ = 0.5F;
      this.f_107663_ *= (float)ReturnNumber6To7Procedure.execute();
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public void m_5989_() {
      super.m_5989_();
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 2 % 12 + 1, 12));
      }

   }

   public static class ParticleSmokePurpleParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleSmokePurpleParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleSmokePurpleParticle particle = new ParticleSmokePurpleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         return particle;
      }
   }
}
