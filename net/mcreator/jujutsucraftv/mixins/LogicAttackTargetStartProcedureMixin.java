package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.LogicAttackTargetStartProcedure;
import net.mcreator.jujutsucraftv.entity.OsukiEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {LogicAttackTargetStartProcedure.class},
   remap = false
)
public abstract class LogicAttackTargetStartProcedureMixin {
   private static final TagKey<EntityType<?>> VILLAGER_SIDE;

   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void jujutsucraftv$customTargetLogic(LevelAccessor world, Entity entity, CallbackInfoReturnable<Boolean> cir) {
      if (!world.m_5776_() && entity instanceof Mob mob) {
         LivingEntity target = mob.m_5448_();
         if (target != null) {
            if (entity instanceof OsukiEntity && entity.m_8077_() && "Johnny".equals(entity.m_7770_().getString())) {
               cir.setReturnValue(true);
            } else {
               CompoundTag entityData = entity.getPersistentData();
               CompoundTag targetData = target.getPersistentData();
               boolean entitySimuria = entityData.m_128471_("Simuria");
               boolean targetSimuria = targetData.m_128471_("Simuria");
               if (entitySimuria && targetSimuria) {
                  cir.setReturnValue(false);
               } else {
                  if (entity instanceof OsukiEntity) {
                     boolean targetCursedSpirit = targetData.m_128471_("CursedSpirit");
                     boolean targetRumel = targetData.m_128471_("Rumel");
                     if (targetCursedSpirit || targetRumel) {
                        cir.setReturnValue(false);
                        return;
                     }
                  }

                  boolean entitySorcerer = entityData.m_128471_("JujutsuSorcerer");
                  boolean targetVillagerSide = target.m_6095_().m_204039_(VILLAGER_SIDE);
                  if (entitySorcerer && targetVillagerSide) {
                     cir.setReturnValue(false);
                  }

               }
            }
         }
      }
   }

   @Redirect(
      method = {"execute"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/nbt/CompoundTag;getBoolean(Ljava/lang/String;)Z"
)
   )
   private static boolean jujutsucraft$redirectCursedSpiritCheck(CompoundTag tag, String key) {
      if (!"CursedSpirit".equals(key)) {
         return tag.m_128471_(key);
      } else {
         return tag.m_128471_("CursedSpirit") || tag.m_128471_("Rumel");
      }
   }

   static {
      VILLAGER_SIDE = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge", "villager_side"));
   }
}
