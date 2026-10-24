package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AttackJumpProcedure;
import net.mcreator.jujutsucraft.procedures.AttackOverheadProcedure;
import net.mcreator.jujutsucraft.procedures.CursedTechniqueRozetsuProcedure;
import net.mcreator.jujutsucraft.procedures.RozetsuDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueHanakoHand2Procedure;
import net.mcreator.jujutsucraft.procedures.TechniqueHanakoHandProcedure;
import net.mcreator.jujutsucraftv.procedures.CheckFerociousUnitProcedure;
import net.mcreator.jujutsucraftv.procedures.SkillBoogieWoogieCombinedProcedure;
import net.mcreator.jujutsucraftv.procedures.SkillDabura4CancelProcedure;
import net.mcreator.jujutsucraftv.procedures.SkillFerociousUnitProcedure;
import net.mcreator.jujutsucraftv.procedures.SkillRouzetsuDismantleAroundProcedure;
import net.mcreator.jujutsucraftv.procedures.SkillRouzetsuDismantleProcedure;
import net.mcreator.jujutsucraftv.procedures.SkillSummonRozetsuShikigamiProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {CursedTechniqueRozetsuProcedure.class},
   remap = false
)
public abstract class CursedTechniqueRozetsuProcedureMixin {
   @Overwrite(
      remap = false
   )
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = (double)Math.round(entity.getPersistentData().m_128459_("skill"));
         if (skill == (double)4303.0F) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4304.0F) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4305.0F) {
            SkillSummonRozetsuShikigamiProcedure.execute(world, x, y, z, entity, (double)1.0F);
         } else if (skill == (double)4306.0F) {
            SkillSummonRozetsuShikigamiProcedure.execute(world, x, y, z, entity, (double)2.0F);
         } else if (skill == (double)4307.0F) {
            SkillSummonRozetsuShikigamiProcedure.execute(world, x, y, z, entity, (double)3.0F);
         } else if (skill == (double)4308.0F) {
            SkillSummonRozetsuShikigamiProcedure.execute(world, x, y, z, entity, (double)4.0F);
         } else if (skill == (double)4309.0F) {
            SkillSummonRozetsuShikigamiProcedure.execute(world, x, y, z, entity, (double)5.0F);
         } else if (skill == (double)4320.0F) {
            RozetsuDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4314.0F) {
            if (CheckFerociousUnitProcedure.execute(entity)) {
               SkillFerociousUnitProcedure.execute(world, x, y, z, entity);
            } else {
               SkillDabura4CancelProcedure.execute(world, x, y, z, entity);
            }
         } else if (skill == (double)4315.0F) {
            SkillRouzetsuDismantleProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4316.0F) {
            SkillRouzetsuDismantleAroundProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4317.0F) {
            SkillBoogieWoogieCombinedProcedure.execute(world, x, y, z, entity);
         } else if (skill == (double)4330.0F) {
            TechniqueHanakoHandProcedure.execute(world, entity);
         } else if (skill == (double)4331.0F) {
            TechniqueHanakoHand2Procedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player player = (Player)entity;
               if (!player.m_9236_().m_5776_()) {
                  player.m_5661_(Component.m_237113_("WIP Rozetsu"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity livingEntity = (LivingEntity)entity;
               livingEntity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
