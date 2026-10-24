package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.client.utils.CurseColorHelper;
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
public class ParticleCursePowerYellowParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleCursePowerYellowParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleCursePowerYellowParticleProvider(spriteSet);
   }

   protected ParticleCursePowerYellowParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, float r, float g, float b, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.5F, 0.5F);
      this.f_107663_ *= 3.0F;
      this.f_107225_ = Math.max(1, 15 + (this.f_107223_.m_188503_(4) - 2));
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx * 0.3;
      this.f_107216_ = vy * 0.3;
      this.f_107217_ = vz * 0.3;
      this.f_107227_ = r;
      this.f_107228_ = g;
      this.f_107229_ = b;
      this.f_107230_ = 0.8F;
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
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 12 + 1, 12));
      }

   }

   public static class ParticleCursePowerYellowParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleCursePowerYellowParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         float[] colors = CurseColorHelper.getRGB(typeIn);
         return new ParticleCursePowerYellowParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, colors[0], colors[1], colors[2], this.spriteSet);
      }
   }
}
