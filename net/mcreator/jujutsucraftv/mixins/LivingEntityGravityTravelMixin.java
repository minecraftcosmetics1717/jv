package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.handler.VariableGravityHandler;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LivingEntity.class})
public abstract class LivingEntityGravityTravelMixin {
   @Shadow
   protected boolean f_20899_;
   @Unique
   private int jjcv$variableGravityJumpCooldown;

   @Inject(
      method = {"travel"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jjcv$variableGravityTravel(Vec3 travelVector, CallbackInfo ci) {
      LivingEntity entity = (LivingEntity)this;
      if (VariableGravityHandler.hasVariableGravity(entity)) {
         Direction gravityDirection = VariableGravityHandler.getGravityDirection(entity);
         if (gravityDirection != Direction.DOWN) {
            if (entity.m_6084_() && !entity.m_20159_() && !entity.m_21255_() && !entity.m_20069_() && !entity.m_20077_()) {
               if (this.jjcv$variableGravityJumpCooldown > 0) {
                  --this.jjcv$variableGravityJumpCooldown;
               }

               boolean grounded = VariableGravityHandler.isOnGravityGround(entity, gravityDirection);
               entity.m_6853_(grounded);
               Vec3 motion = entity.m_20184_();
               Vec3 input = VariableGravityHandler.getTravelSurfaceInput(entity, travelVector, gravityDirection);
               motion = VariableGravityHandler.applyTravelAcceleration(entity, motion, input, grounded);
               if (grounded && this.f_20899_ && this.jjcv$variableGravityJumpCooldown <= 0) {
                  float jumpPower = 0.42F + entity.m_285755_();
                  motion = VariableGravityHandler.removeGravityComponent(motion, gravityDirection);
                  motion = motion.m_82549_(VariableGravityHandler.directionVec(gravityDirection).m_82490_(-VariableGravityHandler.getGravityJumpPower(entity, jumpPower)));
                  this.jjcv$variableGravityJumpCooldown = 8;
                  entity.f_19789_ = 0.0F;
                  entity.m_6853_(false);
               }

               motion = VariableGravityHandler.applyGravity(entity, gravityDirection, motion, grounded);
               if (grounded) {
                  motion = VariableGravityHandler.applyGroundFriction(motion, gravityDirection, 0.82);
               }

               motion = VariableGravityHandler.clampSurfaceSpeed(motion, gravityDirection, Math.max(0.28, (double)entity.m_6113_() * 2.6));
               double oldX = entity.m_20185_();
               double oldY = entity.m_20186_();
               double oldZ = entity.m_20189_();
               entity.m_20256_(motion);
               entity.m_6478_(MoverType.SELF, motion);
               Vec3 moved = new Vec3(entity.m_20185_() - oldX, entity.m_20186_() - oldY, entity.m_20189_() - oldZ);
               boolean groundedAfter = VariableGravityHandler.isOnGravityGround(entity, gravityDirection);
               entity.m_6853_(groundedAfter);
               Vec3 finalMotion = entity.m_20184_();
               if (groundedAfter) {
                  finalMotion = VariableGravityHandler.removeGravityComponent(finalMotion, gravityDirection);
                  finalMotion = VariableGravityHandler.applyGroundFriction(finalMotion, gravityDirection, 0.72);
                  entity.f_19789_ = 0.0F;
               } else {
                  finalMotion = VariableGravityHandler.applyAirDrag(finalMotion, gravityDirection);
               }

               finalMotion = VariableGravityHandler.clampGravitySpeed(entity, finalMotion, VariableGravityHandler.directionVec(gravityDirection));
               entity.m_20256_(finalMotion);
               VariableGravityHandler.updateWalkAnimation(entity, moved, gravityDirection);
               entity.f_19812_ = true;
               ci.cancel();
            }
         }
      }
   }
}
