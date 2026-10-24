package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.client.utils.CurseColorHelper;
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
public class ParticleThunderRainbowParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleThunderRainbowParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleThunderRainbowParticleProvider(spriteSet);
   }

   protected ParticleThunderRainbowParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, float r, float g, float b, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = 10;
      this.f_107226_ = 0.0F;
      this.f_107219_ = true;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.f_107227_ = r;
      this.f_107228_ = g;
      this.f_107229_ = b;
      this.f_107230_ = 1.0F;
      this.f_107663_ *= (float)ReturnNumber6To7Procedure.execute();
      this.m_108335_(spriteSet);
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
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 12 + 1, 12));
      }

   }

   public static class ParticleThunderRainbowParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleThunderRainbowParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         float[] colors = CurseColorHelper.getRGB(typeIn);
         return new ParticleThunderRainbowParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, colors[0], colors[1], colors[2], this.spriteSet);
      }
   }
}
