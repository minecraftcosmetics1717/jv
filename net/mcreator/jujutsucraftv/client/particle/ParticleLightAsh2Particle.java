package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.procedures.ReturnNumber1To05Procedure;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ParticleLightAsh2Particle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleLightAsh2ParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleLightAsh2ParticleProvider(spriteSet);
   }

   protected ParticleLightAsh2Particle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = Math.max(1, 60 + (this.f_107223_.m_188503_(40) - 20));
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx * (double)1.0F;
      this.f_107216_ = vy * (double)1.0F;
      this.f_107217_ = vz * (double)1.0F;
      this.f_107230_ = 0.8F;
      this.m_108335_(spriteSet);
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107432_;
   }

   public float m_5902_(float scale) {
      Level world = this.f_107208_;
      return super.m_5902_(scale) * (float)ReturnNumber1To05Procedure.execute();
   }

   public void m_5989_() {
      super.m_5989_();
   }

   public static class ParticleLightAsh2ParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleLightAsh2ParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleLightAsh2Particle particle = new ParticleLightAsh2Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         return particle;
      }
   }
}
