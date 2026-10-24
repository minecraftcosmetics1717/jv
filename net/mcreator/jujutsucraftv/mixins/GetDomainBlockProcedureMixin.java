package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.GetDomainBlockProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GetDomainBlockProcedure.class})
public abstract class GetDomainBlockProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("TAIL")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(Entity entity, CallbackInfo ci) {
      CompoundTag persistentData = entity.getPersistentData();
      JujutsucraftModVariables.PlayerVariables playerVariables = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
      String outside = persistentData.m_128461_("domain_outside");
      String inside = persistentData.m_128461_("domain_inside");
      String floor = persistentData.m_128461_("domain_floor");
      double domainNum = persistentData.m_128459_("select") > (double)0.0F ? persistentData.m_128459_("select") : persistentData.m_128459_("skill_domain");
      if (domainNum == (double)30.0F) {
         inside = "jujutsucraftv:domain_dark_smooth_stone";
         floor = "jujutsucraftv:domain_drum";
      } else if (domainNum == (double)14.0F) {
         inside = "jujutsucraftv:domain_sky_blue";
      } else if (domainNum == (double)37.0F) {
         inside = "jujutsucraft:domain_white";
         floor = "jujutsucraftv:domain_smooth_stone";
      } else if (domainNum == (double)43.0F) {
         inside = "jujutsucraftv:domain_red_rock_1";
         floor = "jujutsucraftv:domain_red_rock_2";
      } else if (domainNum == (double)699.0F) {
         inside = "jujutsucraftv:domain_sky_eye";
         floor = "jujutsucraftv:domain_sky_eye";
      } else if (domainNum == (double)601.0F) {
         inside = "jujutsucraft:domain_bone";
         floor = "jujutsucraft:domain_bone";
      } else if (domainNum == (double)602.0F) {
         inside = "jujutsucraft:block_universe";
         floor = "jujutsucraft:block_universe";
      } else if (domainNum == (double)603.0F) {
         inside = "jujutsucraft:block_universe";
         floor = "jujutsucraft:block_gravel";
      } else if (domainNum == (double)604.0F) {
         inside = "jujutsucraftv:domain_blue_magma_1";
         floor = "jujutsucraftv:domain_blue_magma_2";
      } else if (domainNum == (double)605.0F) {
         inside = "jujutsucraft:domain_stone_bricks";
         floor = "jujutsucraft:domain_stone_bricks";
      } else if (domainNum == (double)606.0F) {
         inside = "jujutsucraft:domain_blue_sky";
         floor = "jujutsucraft:domain_blue_sky";
      } else if (domainNum == (double)607.0F) {
         inside = "jujutsucraft:domain_blue_sky";
         floor = "jujutsucraft:domain_blue_sky";
      } else if (domainNum == (double)608.0F) {
         inside = "jujutsucraft:domain_bone";
         floor = "jujutsucraft:domain_bone";
      } else if (domainNum == (double)610.0F) {
         inside = "jujutsucraft:block_universe";
         floor = "jujutsucraft:domain_sand";
      } else if (domainNum == (double)613.0F) {
         inside = "jujutsucraftv:domain_rock_1";
         floor = "jujutsucraftv:domain_rock_1";
      } else if (domainNum == (double)614.0F) {
         inside = "jujutsucraft:block_gravel";
         floor = "jujutsucraft:domain_bone";
      } else if (domainNum == (double)615.0F) {
         inside = "jujutsucraftv:domain_smooth_stone";
         floor = "jujutsucraftv:domain_clay";
      } else if (domainNum == (double)618.0F) {
         inside = "jujutsucraftv:domain_rock_2";
         floor = "jujutsucraftv:domain_rock_2";
      } else if (domainNum == (double)622.0F) {
         inside = "jujutsucraftv:domain_pale_orange_block";
         floor = "jujutsucraftv:domain_orange_block";
      } else if (domainNum == (double)630.0F) {
         inside = "jujutsucraft:domain_white";
         floor = "jujutsucraft:domain_white";
      }

      if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerDomainInside) {
         inside = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).domain_block_set_inside;
      }

      if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerDomainFloor) {
         floor = ((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).domain_block_set_floor;
      }

      persistentData.m_128359_("domain_outside", outside);
      persistentData.m_128359_("domain_inside", inside);
      persistentData.m_128359_("domain_floor", floor);
   }
}
