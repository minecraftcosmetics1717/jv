package net.mcreator.jujutsucraftv.mixins;

import java.util.LinkedHashMap;
import java.util.Map;
import net.mcreator.jujutsucraft.procedures.CursedTechniqueOnPotionActiveTickProcedure;
import net.mcreator.jujutsucraftv.procedures.ActAkurooProcedure;
import net.mcreator.jujutsucraftv.procedures.ActAmaiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActBagmaskProcedure;
import net.mcreator.jujutsucraftv.procedures.ActBayerProcedure;
import net.mcreator.jujutsucraftv.procedures.ActBlindnessProcedure;
import net.mcreator.jujutsucraftv.procedures.ActCrystalOreProcedure;
import net.mcreator.jujutsucraftv.procedures.ActDaburaProcedure;
import net.mcreator.jujutsucraftv.procedures.ActDebuggerProcedure;
import net.mcreator.jujutsucraftv.procedures.ActDoodleProcedure;
import net.mcreator.jujutsucraftv.procedures.ActEsoKechizuProcedure;
import net.mcreator.jujutsucraftv.procedures.ActForestProcedure;
import net.mcreator.jujutsucraftv.procedures.ActGakuganjiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActGaneshaProcedure;
import net.mcreator.jujutsucraftv.procedures.ActHMimikoProcedure;
import net.mcreator.jujutsucraftv.procedures.ActHNanakoProcedure;
import net.mcreator.jujutsucraftv.procedures.ActHanakoProcedure;
import net.mcreator.jujutsucraftv.procedures.ActHazenokiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActInsectProcedure;
import net.mcreator.jujutsucraftv.procedures.ActKakuronProcedure;
import net.mcreator.jujutsucraftv.procedures.ActKuchisakeonnaProcedure;
import net.mcreator.jujutsucraftv.procedures.ActMammothProcedure;
import net.mcreator.jujutsucraftv.procedures.ActMayflyProcedure;
import net.mcreator.jujutsucraftv.procedures.ActMiguelProcedure;
import net.mcreator.jujutsucraftv.procedures.ActMouseProcedure;
import net.mcreator.jujutsucraftv.procedures.ActNanamiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActNecknecklaceProcedure;
import net.mcreator.jujutsucraftv.procedures.ActNostalgiaProcedure;
import net.mcreator.jujutsucraftv.procedures.ActOtsurugiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActRindouProcedure;
import net.mcreator.jujutsucraftv.procedures.ActRippingProcedure;
import net.mcreator.jujutsucraftv.procedures.ActRozetsuProcedure;
import net.mcreator.jujutsucraftv.procedures.ActSamuraiarmorProcedure;
import net.mcreator.jujutsucraftv.procedures.ActShigemoProcedure;
import net.mcreator.jujutsucraftv.procedures.ActTamamonomaeIncarnateProcedure;
import net.mcreator.jujutsucraftv.procedures.ActTojiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActTsuchigumoProcedure;
import net.mcreator.jujutsucraftv.procedures.ActUiuiProcedure;
import net.mcreator.jujutsucraftv.procedures.ActUtahimeProcedure;
import net.mcreator.jujutsucraftv.procedures.ActWhackamoleProcedure;
import net.mcreator.jujutsucraftv.procedures.ActWithoutCursedTechniqueProcedure;
import net.mcreator.jujutsucraftv.procedures.ActYukiProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {CursedTechniqueOnPotionActiveTickProcedure.class},
   remap = false
)
public class CursedTechniqueEffectTickMixin {
   private static final Map<SkillRange, SkillProcedure> PROCEDURE_MAP = new LinkedHashMap();

   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity != null) {
         int skill = entity.getPersistentData().m_128451_("skill");

         for(Map.Entry<SkillRange, SkillProcedure> entry : PROCEDURE_MAP.entrySet()) {
            if (((SkillRange)entry.getKey()).isWithinRange(skill) && ((SkillProcedure)entry.getValue()).execute(world, x, y, z, entity, skill)) {
               ci.cancel();
               return;
            }
         }

      }
   }

   static {
      PROCEDURE_MAP.put(new SkillRange(-100, 100), (SkillProcedure)(world, x, y, z, entity, skill) -> ActTojiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(1300, 1400), (SkillProcedure)(world, x, y, z, entity, skill) -> ActNanamiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(3000, 3100), (SkillProcedure)(world, x, y, z, entity, skill) -> ActMiguelProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(3400, 3500), (SkillProcedure)(world, x, y, z, entity, skill) -> ActRozetsuProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(69900, 70000), (SkillProcedure)(world, x, y, z, entity, skill) -> ActDebuggerProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60100, 60200), (SkillProcedure)(world, x, y, z, entity, skill) -> ActWithoutCursedTechniqueProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60200, 60300), (SkillProcedure)(world, x, y, z, entity, skill) -> ActBlindnessProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60300, 60400), (SkillProcedure)(world, x, y, z, entity, skill) -> ActTamamonomaeIncarnateProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60400, 60500), (SkillProcedure)(world, x, y, z, entity, skill) -> ActForestProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60500, 60600), (SkillProcedure)(world, x, y, z, entity, skill) -> ActInsectProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60600, 60700), (SkillProcedure)(world, x, y, z, entity, skill) -> ActMammothProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60700, 60800), (SkillProcedure)(world, x, y, z, entity, skill) -> ActGaneshaProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60800, 60900), (SkillProcedure)(world, x, y, z, entity, skill) -> ActKuchisakeonnaProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(60900, 61000), (SkillProcedure)(world, x, y, z, entity, skill) -> ActBayerProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61000, 61100), (SkillProcedure)(world, x, y, z, entity, skill) -> ActBagmaskProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61100, 61200), (SkillProcedure)(world, x, y, z, entity, skill) -> ActUiuiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61200, 61300), (SkillProcedure)(world, x, y, z, entity, skill) -> ActEsoKechizuProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61300, 61400), (SkillProcedure)(world, x, y, z, entity, skill) -> ActWhackamoleProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61400, 61500), (SkillProcedure)(world, x, y, z, entity, skill) -> ActNecknecklaceProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61500, 61600), (SkillProcedure)(world, x, y, z, entity, skill) -> ActGakuganjiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61600, 61700), (SkillProcedure)(world, x, y, z, entity, skill) -> ActUtahimeProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61700, 61800), (SkillProcedure)(world, x, y, z, entity, skill) -> ActHazenokiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61800, 61900), (SkillProcedure)(world, x, y, z, entity, skill) -> ActCrystalOreProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(61900, 62000), (SkillProcedure)(world, x, y, z, entity, skill) -> ActOtsurugiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62000, 62100), (SkillProcedure)(world, x, y, z, entity, skill) -> ActYukiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62100, 62200), (SkillProcedure)(world, x, y, z, entity, skill) -> ActRindouProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62200, 62300), (SkillProcedure)(world, x, y, z, entity, skill) -> ActAmaiProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62300, 62400), (SkillProcedure)(world, x, y, z, entity, skill) -> ActSamuraiarmorProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62400, 62500), (SkillProcedure)(world, x, y, z, entity, skill) -> ActAkurooProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62500, 62600), (SkillProcedure)(world, x, y, z, entity, skill) -> ActHanakoProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62600, 62700), (SkillProcedure)(world, x, y, z, entity, skill) -> ActMouseProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62700, 62800), (SkillProcedure)(world, x, y, z, entity, skill) -> ActDoodleProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62800, 62900), (SkillProcedure)(world, x, y, z, entity, skill) -> ActHMimikoProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(62900, 63000), (SkillProcedure)(world, x, y, z, entity, skill) -> ActHNanakoProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63000, 63100), (SkillProcedure)(world, x, y, z, entity, skill) -> ActDaburaProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63100, 63200), (SkillProcedure)(world, x, y, z, entity, skill) -> ActTsuchigumoProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63200, 63300), (SkillProcedure)(world, x, y, z, entity, skill) -> ActNostalgiaProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63300, 63400), (SkillProcedure)(world, x, y, z, entity, skill) -> ActMayflyProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63400, 63500), (SkillProcedure)(world, x, y, z, entity, skill) -> ActShigemoProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63500, 63600), (SkillProcedure)(world, x, y, z, entity, skill) -> ActRippingProcedure.execute(world, x, y, z, entity, skill));
      PROCEDURE_MAP.put(new SkillRange(63600, 63700), (SkillProcedure)(world, x, y, z, entity, skill) -> ActKakuronProcedure.execute(world, x, y, z, entity, skill));
   }

   private static class SkillRange {
      private final int min;
      private final int max;

      private SkillRange(int min, int max) {
         this.min = min;
         this.max = max;
      }

      private boolean isWithinRange(int value) {
         return value >= this.min && value < this.max;
      }
   }

   @FunctionalInterface
   private interface SkillProcedure {
      boolean execute(LevelAccessor var1, double var2, double var4, double var6, Entity var8, int var9);
   }
}
