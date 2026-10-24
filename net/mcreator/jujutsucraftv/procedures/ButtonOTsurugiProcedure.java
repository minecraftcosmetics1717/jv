package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class ButtonOTsurugiProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerCurseTechnique = (double)619.0F;
            capability.syncPlayerVariables(entity);
         });
         if (CheckGamemodeCreativeProcedure.execute(entity)) {
            if (!CheckHaveItemProcedure.execute(world, entity, new ItemStack((ItemLike)JujutsucraftvModItems.NIGHT_OF_FIRE_ART.get())) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.NIGHT_OF_FIRE_ART.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (!CheckHaveItemProcedure.execute(world, entity, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_HELMET.get())) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_HELMET.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (!CheckHaveItemProcedure.execute(world, entity, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_CHESTPLATE.get())) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_CHESTPLATE.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (!CheckHaveItemProcedure.execute(world, entity, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_LEGGINGS.get())) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_LEGGINGS.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (!CheckHaveItemProcedure.execute(world, entity, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_BOOTS.get())) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_OKKOTSU_TSURUGI_BOOTS.get())).m_41777_();
               _setstack.m_41764_(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }
         }

         CursedTechniqueSelectedProcedure.execute(world, x, y, z, entity);
      }
   }
}
