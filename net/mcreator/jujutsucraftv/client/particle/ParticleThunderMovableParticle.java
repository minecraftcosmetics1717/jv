package net.mcreator.jujutsucraftv.client.particle;

import net.mcreator.jujutsucraftv.procedures.ReturnNumber1To05Procedure;
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
public class ParticleThunderMovableParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;
   private final float baseQuadSize;
   private int movableMode;
   private double movableCenterX;
   private double movableCenterY;
   private double movableCenterZ;

   public static ParticleThunderMovableParticleProvider provider(SpriteSet spriteSet) {
      return new ParticleThunderMovableParticleProvider(spriteSet);
   }

   protected ParticleThunderMovableParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet, float commandScale) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      float randomSize = (float)ReturnNumber1To05Procedure.execute();
      float finalSize = commandScale * randomSize;
      this.baseQuadSize = finalSize;
      this.f_107663_ = finalSize;
      this.m_107250_(2.0F * commandScale, 2.0F * commandScale);
      this.f_107225_ = 23;
      this.f_107226_ = 0.0F;
      this.f_107219_ = false;
      this.f_107215_ = vx;
      this.f_107216_ = vy;
      this.f_107217_ = vz;
      this.m_108339_(spriteSet);
   }

   private void applyMovableMode(int mode, double vx, double vy, double vz) {
      this.movableMode = mode;
      if (mode > 0) {
         this.f_107219_ = false;
         this.movableCenterX = this.f_107212_;
         this.movableCenterY = this.f_107213_;
         this.movableCenterZ = this.f_107214_;
         double dirX = vx;
         double dirY = vy;
         double dirZ = vz;
         double length = Math.sqrt(vx * vx + vy * vy + vz * vz);
         if (length < 1.0E-5) {
            dirX = this.f_107223_.m_188500_() * (double)2.0F - (double)1.0F;
            dirY = this.f_107223_.m_188500_() * (double)2.0F - (double)1.0F;
            dirZ = this.f_107223_.m_188500_() * (double)2.0F - (double)1.0F;
            length = Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);
            if (length < 1.0E-5) {
               dirX = (double)0.0F;
               dirY = (double)1.0F;
               dirZ = (double)0.0F;
               length = (double)1.0F;
            }
         }

         dirX /= length;
         dirY /= length;
         dirZ /= length;
         if (mode == 1) {
            double speed = 0.04 + this.f_107223_.m_188500_() * 0.08;
            this.f_107215_ = dirX * speed;
            this.f_107216_ = dirY * speed;
            this.f_107217_ = dirZ * speed;
         } else if (mode == 2) {
            double distance = 0.6 + this.f_107223_.m_188500_() * 1.4;
            this.f_107212_ += dirX * distance;
            this.f_107213_ += dirY * distance;
            this.f_107214_ += dirZ * distance;
            this.f_107209_ = this.f_107212_;
            this.f_107210_ = this.f_107213_;
            this.f_107211_ = this.f_107214_;
            double speed = 0.08 + this.f_107223_.m_188500_() * 0.05;
            this.f_107215_ = -dirX * speed;
            this.f_107216_ = -dirY * speed;
            this.f_107217_ = -dirZ * speed;
         }

      }
   }

   public int m_6355_(float partialTick) {
      return 15728880;
   }

   public ParticleRenderType m_7556_() {
      return ParticleRenderType.f_107431_;
   }

   public float m_5902_(float scale) {
      return this.f_107663_;
   }

   public void m_5989_() {
      super.m_5989_();
      this.f_107663_ = this.baseQuadSize;
      if (this.movableMode == 2) {
         double targetX = this.movableCenterX - this.f_107212_;
         double targetY = this.movableCenterY - this.f_107213_;
         double targetZ = this.movableCenterZ - this.f_107214_;
         this.f_107215_ += targetX * 0.04;
         this.f_107216_ += targetY * 0.04;
         this.f_107217_ += targetZ * 0.04;
         this.f_107215_ *= 0.82;
         this.f_107216_ *= 0.82;
         this.f_107217_ *= 0.82;
      }

      if (!this.f_107220_) {
         this.m_108337_(this.spriteSet.m_5819_(this.f_107224_ / 1 % 22 + 1, 22));
      }

   }

   public static class ParticleThunderMovableParticleProvider implements ParticleProvider<ParticleMovableOptions> {
      private final SpriteSet spriteSet;

      public ParticleThunderMovableParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(ParticleMovableOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         ParticleThunderMovableParticle particle = new ParticleThunderMovableParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet, typeIn.getScale());
         Vector3f movableColor = typeIn.getColor();
         particle.f_107227_ = movableColor.x();
         particle.f_107228_ = movableColor.y();
         particle.f_107229_ = movableColor.z();
         particle.f_107230_ = 0.7F;
         particle.applyMovableMode(typeIn.getMode(), xSpeed, ySpeed, zSpeed);
         return particle;
      }
   }
}
