package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.entity.ai.WaterAirMoveControl;
import net.mcreator.jujutsucraftv.entity.ai.WaterGroundMoveControl;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Mob.class})
public abstract class MobWaterMovementMixin {
   @Shadow
   protected MoveControl f_21342_;
   @Shadow
   protected PathNavigation f_21344_;
   @Unique
   private static final TagKey<EntityType<?>> JJCV_WATER_GROUND;
   @Unique
   private static final TagKey<EntityType<?>> JJCV_WATER_AIR;
   @Unique
   private static final byte JJCV_MODE_UNINITIALIZED = 0;
   @Unique
   private static final byte JJCV_MODE_NONE = 1;
   @Unique
   private static final byte JJCV_MODE_WATER_GROUND = 2;
   @Unique
   private static final byte JJCV_MODE_WATER_AIR = 3;
   @Unique
   private byte jjcv$waterMovementMode = 0;
   @Unique
   private boolean jjcv$waterAirStateInitialized;
   @Unique
   private boolean jjcv$waterAirWasInWater;

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   private void jjcv$waterMovementTick(CallbackInfo ci) {
      Mob mob = (Mob)this;
      if (this.jjcv$waterMovementMode == 0) {
         this.jjcv$initializeWaterMovement(mob);
      }

      if (this.jjcv$waterMovementMode != 1) {
         mob.m_20301_(mob.m_6062_());
         if (this.jjcv$waterMovementMode == 3) {
            boolean inWater = mob.m_20072_();
            mob.m_20242_(!inWater);
            if (!this.jjcv$waterAirStateInitialized || this.jjcv$waterAirWasInWater != inWater) {
               this.jjcv$switchWaterAirNavigation(mob, inWater);
               this.jjcv$waterAirWasInWater = inWater;
               this.jjcv$waterAirStateInitialized = true;
            }
         }

      }
   }

   @Unique
   private void jjcv$initializeWaterMovement(Mob mob) {
      if (mob.m_6095_().m_204039_(JJCV_WATER_AIR)) {
         this.jjcv$waterMovementMode = 3;
         mob.m_21441_(BlockPathTypes.WATER, 0.0F);
         mob.m_21441_(BlockPathTypes.WATER_BORDER, 0.0F);
         this.f_21342_ = new WaterAirMoveControl(mob);
         this.jjcv$addWaterAirFallbackGoals(mob);
      } else if (mob.m_6095_().m_204039_(JJCV_WATER_GROUND)) {
         this.jjcv$waterMovementMode = 2;
         mob.m_21441_(BlockPathTypes.WATER, 0.0F);
         mob.m_21441_(BlockPathTypes.WATER_BORDER, 0.0F);
         if (this.f_21344_ != null) {
            this.f_21344_.m_26573_();
         }

         AmphibiousPathNavigation amphibiousNavigation = new AmphibiousPathNavigation(mob, mob.m_9236_());
         amphibiousNavigation.m_7008_(true);
         this.f_21344_ = amphibiousNavigation;
         this.f_21342_ = new WaterGroundMoveControl(mob);
         this.jjcv$addWaterGroundFallbackGoals(mob);
      } else {
         this.jjcv$waterMovementMode = 1;
      }
   }

   @Unique
   private void jjcv$switchWaterAirNavigation(Mob mob, boolean inWater) {
      if (this.f_21344_ != null) {
         this.f_21344_.m_26573_();
      }

      if (inWater) {
         this.f_21344_ = new WaterBoundPathNavigation(mob, mob.m_9236_());
      } else {
         this.f_21344_ = new FlyingPathNavigation(mob, mob.m_9236_());
      }

   }

   @Unique
   private void jjcv$addWaterGroundFallbackGoals(Mob mob) {
      if (mob instanceof final PathfinderMob pathfinderMob) {
         boolean hasFindWaterGoal = mob.f_21345_.m_148105_().stream().map((wrappedGoal) -> wrappedGoal.m_26015_()).anyMatch((goal) -> goal instanceof TryFindWaterGoal);
         boolean hasSwimmingGoal = mob.f_21345_.m_148105_().stream().map((wrappedGoal) -> wrappedGoal.m_26015_()).anyMatch((goal) -> goal instanceof RandomSwimmingGoal);
         boolean hasGroundStrollGoal = mob.f_21345_.m_148105_().stream().map((wrappedGoal) -> wrappedGoal.m_26015_()).anyMatch(this::jjcv$isGroundStrollGoal);
         if (!hasFindWaterGoal) {
            mob.f_21345_.m_25352_(6, new TryFindWaterGoal(pathfinderMob));
         }

         if (!hasSwimmingGoal) {
            mob.f_21345_.m_25352_(7, new RandomSwimmingGoal(pathfinderMob, (double)1.0F, 40) {
               public boolean m_8036_() {
                  return pathfinderMob.m_20072_() && super.m_8036_();
               }

               public boolean m_8045_() {
                  return pathfinderMob.m_20072_() && super.m_8045_();
               }
            });
         }

         if (!hasGroundStrollGoal) {
            mob.f_21345_.m_25352_(8, new RandomStrollGoal(pathfinderMob, 0.8, 120) {
               public boolean m_8036_() {
                  return !pathfinderMob.m_20072_() && super.m_8036_();
               }

               public boolean m_8045_() {
                  return !pathfinderMob.m_20072_() && super.m_8045_();
               }
            });
         }

      }
   }

   @Unique
   private void jjcv$addWaterAirFallbackGoals(Mob mob) {
      if (mob instanceof final PathfinderMob pathfinderMob) {
         boolean hasFindWaterGoal = mob.f_21345_.m_148105_().stream().map((wrappedGoal) -> wrappedGoal.m_26015_()).anyMatch((goal) -> goal instanceof TryFindWaterGoal);
         boolean hasSwimmingGoal = mob.f_21345_.m_148105_().stream().map((wrappedGoal) -> wrappedGoal.m_26015_()).anyMatch((goal) -> goal instanceof RandomSwimmingGoal);
         boolean hasFlyingGoal = mob.f_21345_.m_148105_().stream().map((wrappedGoal) -> wrappedGoal.m_26015_()).anyMatch((goal) -> goal instanceof WaterAvoidingRandomFlyingGoal);
         if (!hasFindWaterGoal) {
            mob.f_21345_.m_25352_(6, new TryFindWaterGoal(pathfinderMob));
         }

         if (!hasSwimmingGoal) {
            mob.f_21345_.m_25352_(7, new RandomSwimmingGoal(pathfinderMob, (double)1.0F, 40) {
               public boolean m_8036_() {
                  return pathfinderMob.m_20072_() && super.m_8036_();
               }

               public boolean m_8045_() {
                  return pathfinderMob.m_20072_() && super.m_8045_();
               }
            });
         }

         if (!hasFlyingGoal) {
            mob.f_21345_.m_25352_(8, new WaterAvoidingRandomFlyingGoal(pathfinderMob, 0.8) {
               public boolean m_8036_() {
                  return !pathfinderMob.m_20072_() && super.m_8036_();
               }

               public boolean m_8045_() {
                  return !pathfinderMob.m_20072_() && super.m_8045_();
               }
            });
         }

      }
   }

   @Unique
   private boolean jjcv$isGroundStrollGoal(Goal goal) {
      return goal instanceof RandomStrollGoal && !(goal instanceof RandomSwimmingGoal) && !(goal instanceof WaterAvoidingRandomFlyingGoal);
   }

   static {
      JJCV_WATER_GROUND = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "water_ground"));
      JJCV_WATER_AIR = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "water_air"));
   }
}
