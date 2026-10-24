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
public class ParticleNoteParticle extends TextureSheetParticle {
   public static ParticleNoteParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleNoteParticleProvider(spriteSet);
   }

   protected ParticleNoteParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z, vx, vy, vz);
      this.m_107250_(0.2F, 0.2F);
      this.f_107225_ = 7;
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.m_108337_(spriteSet.m_213979_(this.f_107223_));
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107430_;
   }

   public void m_5989_() {
      super.m_5989_();
   }

   public static class ParticleNoteParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleNoteParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new ParticleNoteParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}
