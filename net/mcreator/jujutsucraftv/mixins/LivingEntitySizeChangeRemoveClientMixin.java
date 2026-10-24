package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.potion.SizeChangeMobEffect;
import net.mcreator.jujutsucraftv.util.SizeChangeCameraAccess;
import net.mcreator.jujutsucraftv.util.SizeChangeReady;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({LivingEntity.class})
public abstract class LivingEntitySizeChangeRemoveClientMixin {
   @Inject(
      method = {"onSyncedDataUpdated(Lnet/minecraft/network/syncher/EntityDataAccessor;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeScaleSyncedDev(EntityDataAccessor<?> accessor, CallbackInfo ci) {
      this.jjcv$handleSyncedScale(accessor);
   }

   @Inject(
      method = {"m_7350_(Lnet/minecraft/network/syncher/EntityDataAccessor;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeScaleSyncedProd(EntityDataAccessor<?> accessor, CallbackInfo ci) {
      this.jjcv$handleSyncedScale(accessor);
   }

   @Inject(
      method = {"onEffectAdded(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeAddedDev(MobEffectInstance effectInstance, Entity source, CallbackInfo ci) {
      this.jjcv$handleSizeChangeAdded(effectInstance);
   }

   @Inject(
      method = {"m_142540_(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeAddedProd(MobEffectInstance effectInstance, Entity source, CallbackInfo ci) {
      this.jjcv$handleSizeChangeAdded(effectInstance);
   }

   @Inject(
      method = {"onEffectUpdated(Lnet/minecraft/world/effect/MobEffectInstance;ZLnet/minecraft/world/entity/Entity;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeUpdatedDev(MobEffectInstance effectInstance, boolean reapplyEffect, Entity source, CallbackInfo ci) {
      this.jjcv$handleSizeChangeAdded(effectInstance);
   }

   @Inject(
      method = {"m_141973_(Lnet/minecraft/world/effect/MobEffectInstance;ZLnet/minecraft/world/entity/Entity;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeUpdatedProd(MobEffectInstance effectInstance, boolean reapplyEffect, Entity source, CallbackInfo ci) {
      this.jjcv$handleSizeChangeAdded(effectInstance);
   }

   @Inject(
      method = {"onEffectRemoved(Lnet/minecraft/world/effect/MobEffectInstance;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeRemovedDev(MobEffectInstance effectInstance, CallbackInfo ci) {
      this.jjcv$handleSizeChangeRemoved(effectInstance);
   }

   @Inject(
      method = {"m_7285_(Lnet/minecraft/world/effect/MobEffectInstance;)V"},
      at = {@At("TAIL")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeRemovedProd(MobEffectInstance effectInstance, CallbackInfo ci) {
      this.jjcv$handleSizeChangeRemoved(effectInstance);
   }

   @Inject(
      method = {"removeEffectNoUpdate(Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;"},
      at = {@At("RETURN")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeRemoveNoUpdateDev(MobEffect effect, CallbackInfoReturnable<MobEffectInstance> cir) {
      this.jjcv$handleSizeChangeRemoved((MobEffectInstance)cir.getReturnValue());
   }

   @Inject(
      method = {"m_6234_(Lnet/minecraft/world/effect/MobEffect;)Lnet/minecraft/world/effect/MobEffectInstance;"},
      at = {@At("RETURN")},
      remap = false,
      require = 0
   )
   private void jjcv$sizeChangeRemoveNoUpdateProd(MobEffect effect, CallbackInfoReturnable<MobEffectInstance> cir) {
      this.jjcv$handleSizeChangeRemoved((MobEffectInstance)cir.getReturnValue());
   }

   @Unique
   private void jjcv$handleSyncedScale(EntityDataAccessor<?> accessor) {
      LivingEntity livingEntity = (LivingEntity)this;
      if (livingEntity.m_9236_().m_5776_()) {
         if (livingEntity instanceof Player) {
            Player player = (Player)livingEntity;
            if (player instanceof SizeChangeReady) {
               SizeChangeReady ready = (SizeChangeReady)player;
               if (ready.jjcv$isSizeChangeScaleData(accessor)) {
                  float scale = ready.jjcv$getSyncedSizeChangeScale();
                  ready.jjcv$refreshSizeChange(scale);
                  this.jjcv$refreshCamera(player);
               }
            }
         }
      }
   }

   @Unique
   private void jjcv$handleSizeChangeAdded(MobEffectInstance effectInstance) {
      LivingEntity livingEntity = (LivingEntity)this;
      if (livingEntity.m_9236_().m_5776_()) {
         if (livingEntity instanceof Player) {
            Player player = (Player)livingEntity;
            if (effectInstance.m_19544_() instanceof SizeChangeMobEffect) {
               float scale = SizeChangeMobEffect.getScale(effectInstance.m_19564_());
               if (player instanceof SizeChangeReady) {
                  SizeChangeReady ready = (SizeChangeReady)player;
                  ready.jjcv$refreshSizeChange(scale);
               }

               this.jjcv$refreshCamera(player);
            }
         }
      }
   }

   @Unique
   private void jjcv$handleSizeChangeRemoved(MobEffectInstance effectInstance) {
      if (effectInstance != null) {
         LivingEntity livingEntity = (LivingEntity)this;
         if (livingEntity.m_9236_().m_5776_()) {
            if (livingEntity instanceof Player) {
               Player player = (Player)livingEntity;
               if (effectInstance.m_19544_() instanceof SizeChangeMobEffect) {
                  if (player instanceof SizeChangeReady) {
                     SizeChangeReady ready = (SizeChangeReady)player;
                     ready.jjcv$refreshSizeChange(1.0F);
                  }

                  this.jjcv$refreshCamera(player);
               }
            }
         }
      }
   }

   @Unique
   private void jjcv$refreshCamera(Player player) {
      Minecraft minecraft = Minecraft.m_91087_();
      if (minecraft.f_91074_ == player) {
         if (minecraft.f_91063_.m_109153_().m_90592_() == player) {
            Camera var4 = minecraft.f_91063_.m_109153_();
            if (var4 instanceof SizeChangeCameraAccess) {
               SizeChangeCameraAccess camera = (SizeChangeCameraAccess)var4;
               camera.jjcv$resetSizeChangeEyeHeight(player);
            }

         }
      }
   }
}
