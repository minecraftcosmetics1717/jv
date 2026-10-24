package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;

public class SwitchSkillProcedure {
   public static final MobEffect DOMAIN_EXPANSION_EFFECT;
   public static final ResourceLocation REVERSE_CURSE_TECHNIQUE_ADVANCEMENT;
   public static final ResourceLocation DOMAIN_EXPANSION_ADVANCEMENT;

   public static boolean setInfo(Player player, int selected, String name, double cost, boolean passive, boolean physical) {
      player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((cap) -> {
         cap.PlayerSelectCurseTechnique = (double)selected;
         cap.PlayerSelectCurseTechniqueName = name;
         cap.PlayerSelectCurseTechniqueCost = cost;
         cap.PlayerSelectCurseTechniqueCostOrgin = cost;
         cap.PassiveTechnique = passive;
         cap.PhysicalAttack = physical;
         cap.noChangeTechnique = false;
         cap.syncPlayerVariables(player);
      });
      return true;
   }

   public static boolean switchDefault(Player player, int selected) {
      if (selected >= 0 && selected <= 2) {
         return setInfo(player, selected, Component.m_237115_("jujutsu.technique.attack" + (selected + 1)).getString(), (double)0.0F, false, true);
      } else {
         return selected == 21 && player.m_21023_(DOMAIN_EXPANSION_EFFECT) ? setInfo(player, selected, Component.m_237115_("jujutsu.technique.cancel_domain").getString(), (double)0.0F, true, true) : false;
      }
   }

   public static boolean ignoreRequirements(Player player) {
      return hasAdvancement(player, REVERSE_CURSE_TECHNIQUE_ADVANCEMENT);
   }

   public static boolean canDomain(Player player) {
      return ignoreRequirements(player);
   }

   public static boolean canRCT(Player player) {
      return ignoreRequirements(player);
   }

   private static boolean hasAdvancement(Player player, ResourceLocation advancementId) {
      if (!(player instanceof ServerPlayer serverPlayer)) {
         return false;
      } else {
         Advancement advancement = serverPlayer.m_20194_().m_129889_().m_136041_(advancementId);
         return advancement != null && serverPlayer.m_8960_().m_135996_(advancement).m_8193_();
      }
   }

   static {
      DOMAIN_EXPANSION_EFFECT = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
      REVERSE_CURSE_TECHNIQUE_ADVANCEMENT = new ResourceLocation("jujutsucraft:reverse_cursed_technique_1");
      DOMAIN_EXPANSION_ADVANCEMENT = new ResourceLocation("jujutsucraft:mastery_domain_expansion");
   }
}
