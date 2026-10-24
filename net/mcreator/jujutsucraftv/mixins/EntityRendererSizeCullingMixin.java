package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.util.SizeChangeUtil;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityRenderer.class})
public abstract class EntityRendererSizeCullingMixin {
   @Inject(
      method = {"shouldRender(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/client/renderer/culling/Frustum;DDD)Z"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void jjcv$fixSmallPlayerCulling(Entity entity, Frustum frustum, double cameraX, double cameraY, double cameraZ, CallbackInfoReturnable<Boolean> cir) {
      if (!(Boolean)cir.getReturnValue()) {
         if (entity instanceof Player) {
            Player player = (Player)entity;
            float scale = SizeChangeUtil.getScale(player);
            if (!(scale >= 1.0F)) {
               double dx = entity.m_20185_() - cameraX;
               double dy = entity.m_20186_() - cameraY;
               double dz = entity.m_20189_() - cameraZ;
               if (!(dx * dx + dy * dy + dz * dz > (double)16384.0F)) {
                  AABB box = entity.m_6921_();
                  if (Double.isFinite(box.f_82288_) && Double.isFinite(box.f_82289_) && Double.isFinite(box.f_82290_) && Double.isFinite(box.f_82291_) && Double.isFinite(box.f_82292_) && Double.isFinite(box.f_82293_)) {
                     if (frustum.m_113029_(box.m_82400_((double)1.0F))) {
                        cir.setReturnValue(true);
                     }

                  }
               }
            }
         }
      }
   }
}
