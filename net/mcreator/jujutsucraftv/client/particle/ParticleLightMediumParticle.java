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
public class ParticleLightMediumParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleLightMediumParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleLightMediumParticleProvider(spriteSet);
   }

   protected ParticleLightMediumParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = 10;
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx * (double)1.0F;
      this.f_107216_ = vy * (double)1.0F;
      this.f_107217_ = vz * (double)1.0F;
      this.f_107230_ = 0.8F;
      this.m_108335_(spriteSet);
      this.f_107663_ *= (float)ReturnNumber6To7Procedure.execute();
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public void m_5989_() {
      super.m_5989_();
   }

   public static class ParticleLightMediumParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleLightMediumParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleLightMediumParticle particle = new ParticleLightMediumParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         return particle;
      }
   }
}
