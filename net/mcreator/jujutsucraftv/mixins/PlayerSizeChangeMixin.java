package net.mcreator.jujutsucraftv.mixins;

import com.mojang.authlib.GameProfile;
import net.mcreator.jujutsucraftv.potion.SizeChangeMobEffect;
import net.mcreator.jujutsucraftv.util.SizeChangeReady;
import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Player.class})
public abstract class PlayerSizeChangeMixin implements SizeChangeReady {
   @Unique
   private static final EntityDataAccessor<Float> jjcv$SIZE_CHANGE_SCALE;
   @Unique
   private boolean jjcv$sizeChangeDataDefined;
   @Unique
   private boolean jjcv$sizeChangeReady = false;
   @Unique
   private float jjcv$forcedSizeChangeScale = Float.NaN;

   public boolean jjcv$isSizeChangeReady() {
      return this.jjcv$sizeChangeReady;
   }

   public float jjcv$getForcedSizeChangeScale() {
      return this.jjcv$forcedSizeChangeScale;
   }

   public float jjcv$getSyncedSizeChangeScale() {
      Player player = (Player)this;
      return !this.jjcv$sizeChangeDataDefined ? 1.0F : (Float)player.m_20088_().m_135370_(jjcv$SIZE_CHANGE_SCALE);
   }

   public void jjcv$setSyncedSizeChangeScale(float scale) {
      if (this.jjcv$sizeChangeDataDefined) {
         Player player = (Player)this;
         float safeScale = Math.max(0.1F, Math.min(10.0F, scale));
         player.m_20088_().m_135381_(jjcv$SIZE_CHANGE_SCALE, safeScale);
      }
   }

   public boolean jjcv$isSizeChangeScaleData(EntityDataAccessor<?> accessor) {
      return accessor == jjcv$SIZE_CHANGE_SCALE;
   }

   @Inject(
      method = {"defineSynchedData()V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$defineSizeChangeDataDev(CallbackInfo ci) {
      this.jjcv$defineSizeChangeData();
   }

   @Inject(
      method = {"m_8097_()V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$defineSizeChangeDataProd(CallbackInfo ci) {
      this.jjcv$defineSizeChangeData();
   }

   @Unique
   private void jjcv$defineSizeChangeData() {
      if (!this.jjcv$sizeChangeDataDefined) {
         Player player = (Player)this;
         player.m_20088_().m_135372_(jjcv$SIZE_CHANGE_SCALE, 1.0F);
         this.jjcv$sizeChangeDataDefined = true;
      }
   }

   @Inject(
      method = {"<init>"},
      at = {@At("TAIL")},
      remap = false
   )
   private void jjcv$finishSizeChangeInit(Level level, BlockPos blockPos, float rotation, GameProfile gameProfile, CallbackInfo ci) {
      this.jjcv$sizeChangeReady = true;
      this.jjcv$forcedSizeChangeScale = Float.NaN;
   }

   @Inject(
      method = {"getDimensions(Lnet/minecraft/world/entity/Pose;)Lnet/minecraft/world/entity/EntityDimensions;"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false,
      require = 0
   )
   private void jjcv$scalePlayerDimensionsDev(Pose pose, CallbackInfoReturnable<EntityDimensions> cir) {
      this.jjcv$applyScaledDimensions(cir);
   }

   @Inject(
      method = {"m_6972_(Lnet/minecraft/world/entity/Pose;)Lnet/minecraft/world/entity/EntityDimensions;"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false,
      require = 0
   )
   private void jjcv$scalePlayerDimensionsProd(Pose pose, CallbackInfoReturnable<EntityDimensions> cir) {
      this.jjcv$applyScaledDimensions(cir);
   }

   @Unique
   private void jjcv$applyScaledDimensions(CallbackInfoReturnable<EntityDimensions> cir) {
      if (this.jjcv$sizeChangeReady) {
         Player player = (Player)this;
         float scale = SizeChangeUtil.getScale(player);
         if (!(Math.abs(scale - 1.0F) < 1.0E-4F)) {
            EntityDimensions dimensions = (EntityDimensions)cir.getReturnValue();
            if (dimensions != null) {
               cir.setReturnValue(dimensions.m_20388_(scale));
            }
         }
      }
   }

   @Inject(
      method = {"getStandingEyeHeight(Lnet/minecraft/world/entity/Pose;Lnet/minecraft/world/entity/EntityDimensions;)F"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false,
      require = 0
   )
   private void jjcv$scalePlayerEyeHeightDev(Pose pose, EntityDimensions dimensions, CallbackInfoReturnable<Float> cir) {
      this.jjcv$applyScaledEyeHeight(pose, dimensions, cir);
   }

   @Inject(
      method = {"m_6431_(Lnet/minecraft/world/entity/Pose;Lnet/minecraft/world/entity/EntityDimensions;)F"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false,
      require = 0
   )
   private void jjcv$scalePlayerEyeHeightProd(Pose pose, EntityDimensions dimensions, CallbackInfoReturnable<Float> cir) {
      this.jjcv$applyScaledEyeHeight(pose, dimensions, cir);
   }

   @Unique
   private void jjcv$applyScaledEyeHeight(Pose pose, EntityDimensions dimensions, CallbackInfoReturnable<Float> cir) {
      if (this.jjcv$sizeChangeReady) {
         Player player = (Player)this;
         float scale = SizeChangeUtil.getScale(player);
         if (!(Math.abs(scale - 1.0F) < 1.0E-4F)) {
            float eyeHeight;
            if (pose == Pose.CROUCHING) {
               eyeHeight = dimensions.f_20378_ * 0.8466667F;
            } else if (pose != Pose.SWIMMING && pose != Pose.FALL_FLYING && pose != Pose.SPIN_ATTACK) {
               if (pose == Pose.DYING) {
                  eyeHeight = dimensions.f_20378_ * 0.5F;
               } else {
                  eyeHeight = dimensions.f_20378_ * 0.9F;
               }
            } else {
               eyeHeight = dimensions.f_20378_ * 0.6666667F;
            }

            if (scale < 1.0F) {
               float maxEyeHeight = dimensions.f_20378_ * 0.9F;
               float minEyeHeight = Math.min(0.16F, maxEyeHeight);
               eyeHeight = Math.max(eyeHeight, minEyeHeight);
               eyeHeight = Math.min(eyeHeight, maxEyeHeight);
            }

            cir.setReturnValue(eyeHeight);
         }
      }
   }

   public void jjcv$refreshSizeChange(float scale) {
      if (this.jjcv$sizeChangeReady) {
         Player player = (Player)this;
         float safeScale = Math.max(0.1F, Math.min(10.0F, scale));
         if (!player.m_9236_().m_5776_()) {
            this.jjcv$setSyncedSizeChangeScale(safeScale);
         }

         this.jjcv$forcedSizeChangeScale = safeScale;

         try {
            player.m_6210_();
         } finally {
            this.jjcv$forcedSizeChangeScale = Float.NaN;
         }

         player.m_183634_();
      }
   }

   @Inject(
      method = {"readAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$refreshSizeChangeAfterLoadDev(CompoundTag tag, CallbackInfo ci) {
      this.jjcv$refreshAfterLoad();
   }

   @Inject(
      method = {"m_7378_(Lnet/minecraft/nbt/CompoundTag;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$refreshSizeChangeAfterLoadProd(CompoundTag tag, CallbackInfo ci) {
      this.jjcv$refreshAfterLoad();
   }

   @Unique
   private void jjcv$refreshAfterLoad() {
      if (this.jjcv$sizeChangeReady) {
         Player player = (Player)this;
         float scale = 1.0F;

         for(MobEffectInstance effectInstance : player.m_21220_()) {
            if (effectInstance.m_19544_() instanceof SizeChangeMobEffect) {
               scale = SizeChangeMobEffect.getScale(effectInstance.m_19564_());
               break;
            }
         }

         this.jjcv$refreshSizeChange(scale);
      }
   }

   static {
      jjcv$SIZE_CHANGE_SCALE = SynchedEntityData.m_135353_(Player.class, EntityDataSerializers.f_135029_);
   }
}
