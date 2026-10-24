package net.mcreator.jujutsucraftv.mixins;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueDecideProcedure;
import net.mcreator.jujutsucraftv.procedures.AkurooProcedure;
import net.mcreator.jujutsucraftv.procedures.AmaiProcedure;
import net.mcreator.jujutsucraftv.procedures.BagmaskProcedure;
import net.mcreator.jujutsucraftv.procedures.BayerProcedure;
import net.mcreator.jujutsucraftv.procedures.BlindnessProcedure;
import net.mcreator.jujutsucraftv.procedures.CrystalOreProcedure;
import net.mcreator.jujutsucraftv.procedures.DaburaProcedure;
import net.mcreator.jujutsucraftv.procedures.DebuggerProcedure;
import net.mcreator.jujutsucraftv.procedures.DhruvLakdawallaProcedure;
import net.mcreator.jujutsucraftv.procedures.DoodleProcedure;
import net.mcreator.jujutsucraftv.procedures.EsoKechizuProcedure;
import net.mcreator.jujutsucraftv.procedures.ForestProcedure;
import net.mcreator.jujutsucraftv.procedures.GakuganjiProcedure;
import net.mcreator.jujutsucraftv.procedures.GaneshaProcedure;
import net.mcreator.jujutsucraftv.procedures.HMimikoProcedure;
import net.mcreator.jujutsucraftv.procedures.HNanakoProcedure;
import net.mcreator.jujutsucraftv.procedures.HanakoProcedure;
import net.mcreator.jujutsucraftv.procedures.HazenokiProcedure;
import net.mcreator.jujutsucraftv.procedures.InsectProcedure;
import net.mcreator.jujutsucraftv.procedures.KakuronSProcedure;
import net.mcreator.jujutsucraftv.procedures.KashimoProcedure;
import net.mcreator.jujutsucraftv.procedures.KuchisakeonnaProcedure;
import net.mcreator.jujutsucraftv.procedures.MahoragaProcedure;
import net.mcreator.jujutsucraftv.procedures.MammothProcedure;
import net.mcreator.jujutsucraftv.procedures.MayflyProcedure;
import net.mcreator.jujutsucraftv.procedures.MiguelProcedure;
import net.mcreator.jujutsucraftv.procedures.MouseProcedure;
import net.mcreator.jujutsucraftv.procedures.NanamiProcedure;
import net.mcreator.jujutsucraftv.procedures.NecknecklaceProcedure;
import net.mcreator.jujutsucraftv.procedures.NostalgiaProcedure;
import net.mcreator.jujutsucraftv.procedures.OTsurugiProcedure;
import net.mcreator.jujutsucraftv.procedures.RindouProcedure;
import net.mcreator.jujutsucraftv.procedures.RippingProcedure;
import net.mcreator.jujutsucraftv.procedures.RozetsuProcedure;
import net.mcreator.jujutsucraftv.procedures.SamuraiarmorProcedure;
import net.mcreator.jujutsucraftv.procedures.ShigemoProcedure;
import net.mcreator.jujutsucraftv.procedures.SukunaProcedure;
import net.mcreator.jujutsucraftv.procedures.TamamonomaeIncarnateProcedure;
import net.mcreator.jujutsucraftv.procedures.TojiProcedure;
import net.mcreator.jujutsucraftv.procedures.TsuchigumoProcedure;
import net.mcreator.jujutsucraftv.procedures.UiuiSProcedure;
import net.mcreator.jujutsucraftv.procedures.UtahimeProcedure;
import net.mcreator.jujutsucraftv.procedures.WhackamoleProcedure;
import net.mcreator.jujutsucraftv.procedures.WithoutCursedTechniqueProcedure;
import net.mcreator.jujutsucraftv.procedures.YukiProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({KeyChangeTechniqueOnKeyPressedProcedure.class})
public class KeyChangeTechniqueOnKeyPressedProcedureMixin {
   private static final Map<Integer, BiFunction<Player, Integer, Boolean>> PROCEDURE_MAP = new HashMap();
   private static final Map<Integer, Map<Integer, DisplayInfo>> DISPLAY_MAP = new HashMap();

   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity instanceof Player player) {
         JujutsucraftModVariables.PlayerVariables playerVariables = (JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY).orElse(new JujutsucraftModVariables.PlayerVariables());
         int selected = (int)playerVariables.PlayerSelectCurseTechnique;
         int pSkill1 = getSelectedSkill(playerVariables);
         if (PROCEDURE_MAP.containsKey(pSkill1)) {
            if (!playerVariables.noChangeTechnique) {
               selected += player.m_6144_() ? -1 : 1;
            }

            if (processTechniques(player, selected, pSkill1)) {
               updatePlayerVariables(player, playerVariables);
               ci.cancel();
            }

         }
      }
   }

   @Inject(
      method = {"execute"},
      at = {@At("RETURN")},
      remap = false
   )
   private static void afterExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      if (entity instanceof Player player) {
         JujutsucraftModVariables.PlayerVariables cap = (JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY).orElse(new JujutsucraftModVariables.PlayerVariables());
         int technique = getSelectedSkill(cap);
         int selected = (int)cap.PlayerSelectCurseTechnique;
         DisplayInfo info = getDisplayInfo(technique, selected);
         if (info != null) {
            info.apply(player, technique, selected);
         }

      }
   }

   private static int getSelectedSkill(JujutsucraftModVariables.PlayerVariables playerVariables) {
      return (int)(playerVariables.SecondTechnique ? playerVariables.PlayerCurseTechnique2 : playerVariables.PlayerCurseTechnique);
   }

   private static boolean processTechniques(Player player, int selected, int pSkill1) {
      BiFunction<Player, Integer, Boolean> procedure = (BiFunction)PROCEDURE_MAP.get(pSkill1);
      if (procedure == null) {
         return false;
      } else {
         for(int i = 0; i < 52; ++i) {
            if (selected == (player.m_6144_() ? -1 : 50)) {
               selected = player.m_6144_() ? 50 : 0;
            }

            if ((Boolean)procedure.apply(player, selected)) {
               return true;
            }

            selected += player.m_6144_() ? -1 : 1;
         }

         return false;
      }
   }

   private static void updatePlayerVariables(Player player, JujutsucraftModVariables.PlayerVariables cap) {
      MobEffectInstance starRage = player.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
      MobEffectInstance sixEyes = player.m_21124_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get());
      MobEffectInstance sukuna = player.m_21124_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
      MobEffectInstance domain = player.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
      double cost = cap.PlayerSelectCurseTechniqueCost;
      if (starRage != null && cap.PhysicalAttack && domain == null) {
         cost += (double)10.0F + (double)(9 * (starRage.m_19564_() + 1));
      }

      if (sukuna != null) {
         cost *= (double)0.5F;
      }

      if (sixEyes != null) {
         cost *= Math.pow(0.1, (double)(sixEyes.m_19564_() + 1));
      }

      if (player.m_21120_(InteractionHand.MAIN_HAND).m_150930_((Item)JujutsucraftModItems.LOUDSPEAKER.get())) {
         cost = (double)0.0F;
      }

      cap.PlayerSelectCurseTechniqueCost = cost;
      cap.syncPlayerVariables(player);
   }

   private static void registerDisplay(int technique, int selected, String name, double cost, boolean passive, boolean physical) {
      ((Map)DISPLAY_MAP.computeIfAbsent(technique, (key) -> new HashMap())).put(selected, new DisplayInfo(name, cost, passive, physical));
   }

   private static DisplayInfo getDisplayInfo(int technique, int selected) {
      Map<Integer, DisplayInfo> map = (Map)DISPLAY_MAP.get(technique);
      return map == null ? null : (DisplayInfo)map.get(selected);
   }

   static {
      registerDisplay(27, 10, "jujutsu.technique.attack8", (double)200.0F, false, true);
      PROCEDURE_MAP.put(-1, (BiFunction)(player, selected) -> TojiProcedure.execute(player, selected));
      PROCEDURE_MAP.put(1, (BiFunction)(player, selected) -> SukunaProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(7, (BiFunction)(player, selected) -> KashimoProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(13, (BiFunction)(player, selected) -> NanamiProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(16, (BiFunction)(player, selected) -> MahoragaProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(30, (BiFunction)(player, selected) -> MiguelProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(37, (BiFunction)(player, selected) -> DhruvLakdawallaProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(43, (BiFunction)(player, selected) -> RozetsuProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(699, (BiFunction)(player, selected) -> DebuggerProcedure.execute(player, selected));
      PROCEDURE_MAP.put(601, (BiFunction)(player, selected) -> WithoutCursedTechniqueProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(602, (BiFunction)(player, selected) -> BlindnessProcedure.execute(player, selected));
      PROCEDURE_MAP.put(603, (BiFunction)(player, selected) -> TamamonomaeIncarnateProcedure.execute(player, selected));
      PROCEDURE_MAP.put(604, (BiFunction)(player, selected) -> ForestProcedure.execute(player, selected));
      PROCEDURE_MAP.put(605, (BiFunction)(player, selected) -> InsectProcedure.execute(player, selected));
      PROCEDURE_MAP.put(606, (BiFunction)(player, selected) -> MammothProcedure.execute(player, selected));
      PROCEDURE_MAP.put(607, (BiFunction)(player, selected) -> GaneshaProcedure.execute(player, selected));
      PROCEDURE_MAP.put(608, (BiFunction)(player, selected) -> KuchisakeonnaProcedure.execute(player, selected));
      PROCEDURE_MAP.put(609, (BiFunction)(player, selected) -> BayerProcedure.execute(player, selected));
      PROCEDURE_MAP.put(610, (BiFunction)(player, selected) -> BagmaskProcedure.execute(player, selected));
      PROCEDURE_MAP.put(611, (BiFunction)(player, selected) -> UiuiSProcedure.execute(player, selected));
      PROCEDURE_MAP.put(612, (BiFunction)(player, selected) -> EsoKechizuProcedure.execute(player, selected));
      PROCEDURE_MAP.put(613, (BiFunction)(player, selected) -> WhackamoleProcedure.execute(player, selected));
      PROCEDURE_MAP.put(614, (BiFunction)(player, selected) -> NecknecklaceProcedure.execute(player, selected));
      PROCEDURE_MAP.put(615, (BiFunction)(player, selected) -> GakuganjiProcedure.execute(player, selected));
      PROCEDURE_MAP.put(616, (BiFunction)(player, selected) -> UtahimeProcedure.execute(player, selected));
      PROCEDURE_MAP.put(617, (BiFunction)(player, selected) -> HazenokiProcedure.execute(player, selected));
      PROCEDURE_MAP.put(618, (BiFunction)(player, selected) -> CrystalOreProcedure.execute(player, selected));
      PROCEDURE_MAP.put(619, (BiFunction)(player, selected) -> OTsurugiProcedure.execute(player, selected));
      PROCEDURE_MAP.put(620, (BiFunction)(player, selected) -> YukiProcedure.execute(player, selected));
      PROCEDURE_MAP.put(621, (BiFunction)(player, selected) -> RindouProcedure.execute(player, selected));
      PROCEDURE_MAP.put(622, (BiFunction)(player, selected) -> AmaiProcedure.execute(player, selected));
      PROCEDURE_MAP.put(623, (BiFunction)(player, selected) -> SamuraiarmorProcedure.execute(player, selected));
      PROCEDURE_MAP.put(624, (BiFunction)(player, selected) -> AkurooProcedure.execute(player, selected));
      PROCEDURE_MAP.put(625, (BiFunction)(player, selected) -> HanakoProcedure.execute(player, selected));
      PROCEDURE_MAP.put(626, (BiFunction)(player, selected) -> MouseProcedure.execute(player, selected));
      PROCEDURE_MAP.put(627, (BiFunction)(player, selected) -> DoodleProcedure.execute(player, selected));
      PROCEDURE_MAP.put(628, (BiFunction)(player, selected) -> HMimikoProcedure.execute(player, selected));
      PROCEDURE_MAP.put(629, (BiFunction)(player, selected) -> HNanakoProcedure.execute(player, selected));
      PROCEDURE_MAP.put(630, (BiFunction)(player, selected) -> DaburaProcedure.execute(player.m_20193_(), player, selected));
      PROCEDURE_MAP.put(631, (BiFunction)(player, selected) -> TsuchigumoProcedure.execute(player, selected));
      PROCEDURE_MAP.put(632, (BiFunction)(player, selected) -> NostalgiaProcedure.execute(player, selected));
      PROCEDURE_MAP.put(633, (BiFunction)(player, selected) -> MayflyProcedure.execute(player, selected));
      PROCEDURE_MAP.put(634, (BiFunction)(player, selected) -> ShigemoProcedure.execute(player, selected));
      PROCEDURE_MAP.put(635, (BiFunction)(player, selected) -> RippingProcedure.execute(player, selected));
      PROCEDURE_MAP.put(636, (BiFunction)(player, selected) -> KakuronSProcedure.execute(player, selected));
   }

   private static class DisplayInfo {
      private final String name;
      private final double cost;
      private final boolean passive;
      private final boolean physical;

      private DisplayInfo(String name, double cost, boolean passive, boolean physical) {
         this.name = name;
         this.cost = cost;
         this.passive = passive;
         this.physical = physical;
      }

      private void apply(Player player, int technique, int selected) {
         TechniqueDecideProcedure.execute(player, this.passive, this.physical, this.cost, (double)technique, (double)selected, Component.m_237115_(this.name).getString());
      }
   }
}
