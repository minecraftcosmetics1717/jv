package net.mcreator.jujutsucraftv.handler;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

public class VariableGravityHandler {
   public static final double GRAVITY_POWER = 0.08;
   public static final double GROUND_CHECK_DISTANCE = 0.08;
   public static final double MAX_FALL_SPEED = 3.92;

   public static boolean hasVariableGravity(LivingEntity entity) {
      return entity.m_21023_((MobEffect)JujutsucraftvModMobEffects.VARIABLE_GRAVITY.get());
   }

   public static Direction getGravityDirection(LivingEntity entity) {
      if (!hasVariableGravity(entity)) {
         return Direction.DOWN;
      } else {
         MobEffectInstance effect = entity.m_21124_((MobEffect)JujutsucraftvModMobEffects.VARIABLE_GRAVITY.get());
         if (effect == null) {
            return Direction.DOWN;
         } else {
            int amplifier = effect.m_19564_();
            Direction var10000;
            switch (amplifier) {
               case 0 -> var10000 = Direction.UP;
               case 1 -> var10000 = Direction.EAST;
               case 2 -> var10000 = Direction.WEST;
               case 3 -> var10000 = Direction.SOUTH;
               case 4 -> var10000 = Direction.NORTH;
               default -> var10000 = Direction.DOWN;
            }

            return var10000;
         }
      }
   }

   public static Vec3 directionVec(Direction direction) {
      return new Vec3((double)direction.m_122429_(), (double)direction.m_122430_(), (double)direction.m_122431_());
   }

   public static boolean isOnGravityGround(LivingEntity entity, Direction gravityDirection) {
      Vec3 gravity = directionVec(gravityDirection);
      return !entity.m_9236_().m_45756_(entity, entity.m_20191_().m_82386_(gravity.f_82479_ * 0.08, gravity.f_82480_ * 0.08, gravity.f_82481_ * 0.08));
   }

   public static Vec3 removeGravityComponent(Vec3 motion, Direction gravityDirection) {
      Vec3 gravity = directionVec(gravityDirection);
      return motion.m_82546_(gravity.m_82490_(motion.m_82526_(gravity)));
   }

   public static Vec3 projectToGravityPlane(Vec3 vector, Direction gravityDirection) {
      Vec3 gravity = directionVec(gravityDirection);
      return vector.m_82546_(gravity.m_82490_(vector.m_82526_(gravity)));
   }

   public static Vec3 getTravelSurfaceInput(LivingEntity entity, Vec3 travelVector, Direction gravityDirection) {
      Vec3 gravity = directionVec(gravityDirection);
      Vec3 forward = projectToGravityPlane(entity.m_20154_(), gravityDirection);
      if (forward.m_82556_() < 1.0E-7) {
         forward = fallbackForward(gravityDirection);
      }

      forward = forward.m_82541_();
      Vec3 left = gravity.m_82537_(forward);
      if (left.m_82556_() < 1.0E-7) {
         left = fallbackLeft(gravityDirection);
      }

      left = left.m_82541_();
      Vec3 input = forward.m_82490_(travelVector.f_82481_).m_82549_(left.m_82490_(travelVector.f_82479_));
      if (entity instanceof Mob mob) {
         Vec3 mobMove = getMobWantedMove(mob);
         if (mobMove != null && mobMove.m_82556_() > 1.0E-7) {
            Vec3 projectedMobMove = projectToGravityPlane(mobMove, gravityDirection);
            if (projectedMobMove.m_82556_() > 1.0E-7) {
               if (input.m_82556_() < 1.0E-7) {
                  input = projectedMobMove;
               } else {
                  input = input.m_82549_(projectedMobMove.m_82541_().m_82490_((double)0.5F));
               }
            }
         }
      }

      if (input.m_82556_() > (double)1.0F) {
         input = input.m_82541_();
      }

      return input;
   }

   public static Vec3 getMobWantedMove(Mob mob) {
      LivingEntity target = mob.m_5448_();
      if (target != null && target.m_6084_()) {
         return target.m_20182_().m_82546_(mob.m_20182_());
      } else {
         Path path = mob.m_21573_().m_26570_();
         return path != null && !path.m_77392_() ? path.m_77380_(mob).m_82546_(mob.m_20182_()) : null;
      }
   }

   public static Vec3 applyTravelAcceleration(LivingEntity entity, Vec3 motion, Vec3 input, boolean grounded) {
      if (input.m_82556_() < 1.0E-7) {
         return motion;
      } else {
         double speed = (double)entity.m_6113_();
         if (entity instanceof Mob) {
            speed = Math.max(speed, 0.2);
         }

         double acceleration = grounded ? speed * 0.28 : speed * 0.11;
         return motion.m_82549_(input.m_82541_().m_82490_(acceleration));
      }
   }

   public static Vec3 applyGravity(LivingEntity entity, Direction gravityDirection, Vec3 motion, boolean grounded) {
      Vec3 gravity = directionVec(gravityDirection);
      motion = motion.m_82549_(gravity.m_82490_(getGravityPower(entity)));
      if (grounded) {
         double gravitySpeed = motion.m_82526_(gravity);
         if (gravitySpeed > (double)0.0F) {
            motion = motion.m_82546_(gravity.m_82490_(gravitySpeed));
         }

         entity.f_19789_ = 0.0F;
      }

      if (entity.m_21023_(MobEffects.f_19591_)) {
         entity.f_19789_ = 0.0F;
      }

      return clampGravitySpeed(entity, motion, gravity);
   }

   public static double getGravityPower(LivingEntity entity) {
      MobEffectInstance slowFalling = entity.m_21124_(MobEffects.f_19591_);
      if (slowFalling == null) {
         return 0.08;
      } else {
         int level = slowFalling.m_19564_() + 1;
         return Math.max(0.003, 0.01 / (double)level);
      }
   }

   public static double getMaxGravitySpeed(LivingEntity entity) {
      MobEffectInstance slowFalling = entity.m_21124_(MobEffects.f_19591_);
      if (slowFalling == null) {
         return 3.92;
      } else {
         int level = slowFalling.m_19564_() + 1;
         return Math.max(0.04, (double)0.125F / (double)level);
      }
   }

   public static double getGravityJumpPower(LivingEntity entity, float baseJumpPower) {
      return Math.max(0.58, (double)baseJumpPower * 1.35);
   }

   public static Vec3 applyGroundFriction(Vec3 motion, Direction gravityDirection, double friction) {
      Vec3 gravity = directionVec(gravityDirection);
      double gravitySpeed = motion.m_82526_(gravity);
      Vec3 gravityPart = gravity.m_82490_(gravitySpeed);
      Vec3 surfacePart = motion.m_82546_(gravityPart).m_82490_(friction);
      return gravityPart.m_82549_(surfacePart);
   }

   public static Vec3 applyAirDrag(Vec3 motion, Direction gravityDirection) {
      Vec3 gravity = directionVec(gravityDirection);
      double gravitySpeed = motion.m_82526_(gravity);
      Vec3 gravityPart = gravity.m_82490_(gravitySpeed).m_82490_(0.98);
      Vec3 surfacePart = motion.m_82546_(gravity.m_82490_(gravitySpeed)).m_82490_(0.91);
      return gravityPart.m_82549_(surfacePart);
   }

   public static Vec3 clampGravitySpeed(LivingEntity entity, Vec3 motion, Vec3 gravity) {
      double gravitySpeed = motion.m_82526_(gravity);
      double maxFallSpeed = getMaxGravitySpeed(entity);
      if (gravitySpeed > maxFallSpeed) {
         motion = motion.m_82546_(gravity.m_82490_(gravitySpeed - maxFallSpeed));
      }

      return motion;
   }

   public static Vec3 clampSurfaceSpeed(Vec3 motion, Direction gravityDirection, double maxSpeed) {
      Vec3 gravity = directionVec(gravityDirection);
      double gravitySpeed = motion.m_82526_(gravity);
      Vec3 gravityPart = gravity.m_82490_(gravitySpeed);
      Vec3 surfacePart = motion.m_82546_(gravityPart);
      if (surfacePart.m_82556_() > maxSpeed * maxSpeed) {
         surfacePart = surfacePart.m_82541_().m_82490_(maxSpeed);
      }

      return gravityPart.m_82549_(surfacePart);
   }

   public static void updateWalkAnimation(LivingEntity entity, Vec3 moved, Direction gravityDirection) {
      Vec3 surfaceMoved = projectToGravityPlane(moved, gravityDirection);
      float speed = Math.min((float)(surfaceMoved.m_82553_() * (double)6.0F), 1.0F);
      if (speed < 0.01F) {
         speed = 0.0F;
      }

      entity.f_267362_.m_267566_(speed, 0.4F);
   }

   public static Vec3 fallbackForward(Direction gravityDirection) {
      Vec3 var10000;
      switch (gravityDirection) {
         case UP:
            var10000 = new Vec3((double)0.0F, (double)0.0F, (double)1.0F);
            break;
         case EAST:
         case WEST:
            var10000 = new Vec3((double)0.0F, (double)0.0F, (double)1.0F);
            break;
         case SOUTH:
         case NORTH:
            var10000 = new Vec3((double)1.0F, (double)0.0F, (double)0.0F);
            break;
         default:
            var10000 = new Vec3((double)0.0F, (double)0.0F, (double)1.0F);
      }

      return var10000;
   }

   public static Vec3 fallbackLeft(Direction gravityDirection) {
      Vec3 var10000;
      switch (gravityDirection) {
         case UP:
            var10000 = new Vec3((double)1.0F, (double)0.0F, (double)0.0F);
            break;
         case EAST:
         case WEST:
            var10000 = new Vec3((double)0.0F, (double)1.0F, (double)0.0F);
            break;
         case SOUTH:
         case NORTH:
            var10000 = new Vec3((double)0.0F, (double)1.0F, (double)0.0F);
            break;
         default:
            var10000 = new Vec3((double)1.0F, (double)0.0F, (double)0.0F);
      }

      return var10000;
   }

   public static float getCameraRoll(Direction gravityDirection) {
      float var10000;
      switch (gravityDirection) {
         case UP -> var10000 = 180.0F;
         case EAST -> var10000 = 90.0F;
         case WEST -> var10000 = -90.0F;
         case SOUTH -> var10000 = 90.0F;
         case NORTH -> var10000 = -90.0F;
         default -> var10000 = 0.0F;
      }

      return var10000;
   }

   public static float getCameraPitchOffset(Direction gravityDirection) {
      return 0.0F;
   }
}
