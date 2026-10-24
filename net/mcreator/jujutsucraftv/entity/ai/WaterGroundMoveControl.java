package net.mcreator.jujutsucraftv.entity.ai;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.MoveControl.Operation;

public class WaterGroundMoveControl extends MoveControl {
   public WaterGroundMoveControl(Mob mob) {
      super(mob);
   }

   public void m_8126_() {
      if (!this.f_24974_.m_20072_()) {
         super.m_8126_();
      } else {
         this.f_24974_.m_20256_(this.f_24974_.m_20184_().m_82520_((double)0.0F, 0.005, (double)0.0F));
         if (this.f_24981_ == Operation.MOVE_TO && !this.f_24974_.m_21573_().m_26571_()) {
            double dx = this.f_24975_ - this.f_24974_.m_20185_();
            double dy = this.f_24976_ - this.f_24974_.m_20186_();
            double dz = this.f_24977_ - this.f_24974_.m_20189_();
            double horizontalDistance = Math.sqrt(dx * dx + dz * dz);
            float targetYRot = (float)(Mth.m_14136_(dz, dx) * (180D / Math.PI)) - 90.0F;
            float movementSpeed = (float)(this.f_24978_ * this.f_24974_.m_21133_(Attributes.f_22279_));
            this.f_24974_.m_146922_(this.m_24991_(this.f_24974_.m_146908_(), targetYRot, 10.0F));
            this.f_24974_.m_5618_(this.f_24974_.m_146908_());
            this.f_24974_.m_5616_(this.f_24974_.m_146908_());
            this.f_24974_.m_7910_(movementSpeed);
            float targetXRot = -((float)(Mth.m_14136_(dy, horizontalDistance) * (180D / Math.PI)));
            targetXRot = Mth.m_14036_(Mth.m_14177_(targetXRot), -85.0F, 85.0F);
            this.f_24974_.m_146926_(this.m_24991_(this.f_24974_.m_146909_(), targetXRot, 5.0F));
            float pitchCos = Mth.m_14089_(this.f_24974_.m_146909_() * ((float)Math.PI / 180F));
            float pitchSin = Mth.m_14031_(this.f_24974_.m_146909_() * ((float)Math.PI / 180F));
            this.f_24974_.m_21564_(pitchCos * movementSpeed);
            this.f_24974_.m_21567_(-pitchSin * movementSpeed);
         } else {
            this.f_24974_.m_7910_(0.0F);
            this.f_24974_.m_21570_(0.0F);
            this.f_24974_.m_21567_(0.0F);
            this.f_24974_.m_21564_(0.0F);
         }

      }
   }
}
