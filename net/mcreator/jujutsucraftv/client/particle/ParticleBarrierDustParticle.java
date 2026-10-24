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
public class ParticleBarrierDustParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleBarrierDustParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleBarrierDustParticleProvider(spriteSet);
   }

   protected ParticleBarrierDustParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = Math.max(1, 20 + (this.f_107223_.m_188503_(10) - 5));
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.m_108335_(spriteSet);
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public void m_5989_() {
      super.m_5989_();
   }

   public static class ParticleBarrierDustParticleProvider implements ParticleProvider<ParticleDustColorOptions> {
      private final SpriteSet spriteSet;

      public ParticleBarrierDustParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustColorOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleBarrierDustParticle particle = new ParticleBarrierDustParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         Vector3f dustColor = typeIn.getColor();
         particle.f_107227_ = dustColor.x();
         particle.f_107228_ = dustColor.y();
         particle.f_107229_ = dustColor.z();
         particle.f_107230_ = 0.7F;
         particle.f_107663_ = typeIn.getScale();
         return particle;
      }
   }
}
