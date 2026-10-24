package net.mcreator.jujutsucraftv.mixins;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Mob.class})
public abstract class VillagerSideJujutsuSorcererTargetMixin {
   private static final TagKey<EntityType<?>> VILLAGER_SIDE;

   @Inject(
      method = {"setTarget"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void jujutsucraftv$preventSorcererTarget(LivingEntity target, CallbackInfo ci) {
      Mob mob = (Mob)this;
      if (mob.m_6095_().m_204039_(VILLAGER_SIDE)) {
         if (target != null) {
            if (target.getPersistentData().m_128471_("JujutsuSorcerer")) {
               ci.cancel();
            }

         }
      }
   }

   static {
      VILLAGER_SIDE = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "villager_side"));
   }
}
