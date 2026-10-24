package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.procedures.ReturnNumber6To7Procedure;
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
public class ParticleThunderBlueParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static ParticleThunderBlueParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleThunderBlueParticleProvider(spriteSet);
   }

   protected ParticleThunderBlueParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.m_107250_(2.0F, 2.0F);
      this.f_107225_ = Math.max(1, 23 + (this.f_107223_.m_188503_(16) - 8));
      this.f_107226_ = 0.0F;
      this.f_107219_ = true;
      this.f_107215_ = vx * 0.3;
      this.f_107216_ = vy * 0.3;
      this.f_107217_ = vz * 0.3;
      this.m_108339_(spriteSet);
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107432_;
   }

   public float m_5902_(float scale) {
      Level world = this.f_107208_;
      return super.m_5902_(scale) * (float)ReturnNumber6To7Procedure.execute();
   }

   public void m_5989_() {
      super.m_5989_();
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 22 + 1, 22));
      }

   }

   public static class ParticleThunderBlueParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public ParticleThunderBlueParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleThunderBlueParticle particle = new ParticleThunderBlueParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
         return particle;
      }
   }
}
