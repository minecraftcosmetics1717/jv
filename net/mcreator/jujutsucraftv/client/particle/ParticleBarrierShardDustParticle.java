package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.procedures.ReturnNumber1To10Procedure;
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
public class ParticleBarrierShardDustParticle extends TextureSheetParticle {
   private static final float BASE_SIZE = 0.16F;
   private static final float BASE_GRAVITY = 0.025F;
   private static final float GRAVITY_PER_SIZE = 0.14F;
   private final SpriteSet spriteSet;
   private final float spinSpeed;

   public static ParticleBarrierShardDustParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleBarrierShardDustParticleProvider(spriteSet);
   }

   protected ParticleBarrierShardDustParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet, float commandScale) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      float sizeMultiplier = (float)ReturnNumber1To10Procedure.execute();
      float finalSize = 0.16F * sizeMultiplier * commandScale;
      this.m_107250_(0.08F * commandScale, 0.08F * commandScale);
      this.f_107225_ = 18 + this.f_107223_.m_188503_(10);
      this.f_107226_ = getGravityFromSize(finalSize);
      this.f_107219_ = true;
      this.f_172258_ = 0.96F;
      this.f_107663_ = finalSize;
      this.f_107231_ = this.f_107223_.m_188501_() * ((float)Math.PI * 2F);
      this.f_107204_ = this.f_107231_;
      this.spinSpeed = (this.f_107223_.m_188501_() - 0.5F) * 0.22F;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.m_108337_(this.spriteSet.m_5819_(0, 4));
   }

   private static float getGravityFromSize(float size) {
      return 0.025F + size * 0.14F;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public float m_5902_(float scale) {
      return this.f_107663_;
   }

   public void m_5989_() {
      this.f_107204_ = this.f_107231_;
      this.f_107231_ += this.spinSpeed;
      super.m_5989_();
      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 4 % 4 + 1, 4));
      }

   }

   public static class ParticleBarrierShardDustParticleProvider implements ParticleProvider<ParticleDustColorOptions> {
      private final SpriteSet spriteSet;

      public ParticleBarrierShardDustParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleDustColorOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleBarrierShardDustParticle particle = new ParticleBarrierShardDustParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet, typeIn.getScale());
         Vector3f dustColor = typeIn.getColor();
         particle.f_107227_ = dustColor.x();
         particle.f_107228_ = dustColor.y();
         particle.f_107229_ = dustColor.z();
         particle.f_107230_ = 0.7F;
         return particle;
      }
   }
}
