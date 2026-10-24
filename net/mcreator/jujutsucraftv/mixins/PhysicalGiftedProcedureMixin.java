package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AttackContinueProcedure;
import net.mcreator.jujutsucraft.procedures.AttackJumpProcedure;
import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.AttackStrongProcedure;
import net.mcreator.jujutsucraft.procedures.AttackTackleProcedure;
import net.mcreator.jujutsucraft.procedures.AttackWeakProcedure;
import net.mcreator.jujutsucraft.procedures.AvoidanceProcedure;
import net.mcreator.jujutsucraft.procedures.PhysicalGiftedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {PhysicalGiftedProcedure.class},
   remap = false
)
public abstract class PhysicalGiftedProcedureMixin {
   @Overwrite(
      remap = false
   )
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = entity.getPersistentData().m_128459_("skill") + (double)100.0F;
         if (skill == (double)0.0F) {
            AttackWeakProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)1.0F) {
            AttackStrongProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)2.0F) {
            AttackContinueProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)5.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)6.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)7.0F) {
            AttackTackleProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)110.0F) {
            AvoidanceProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Physical gifted"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity = (LivingEntity)entity;
               _livingEntity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
