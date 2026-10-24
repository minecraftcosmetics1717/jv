package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.entity.ChosoEntity;
import net.mcreator.jujutsucraft.entity.EsoEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.KechizuEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.ReturnInsideItemProcedure;
import net.mcreator.jujutsucraftv.entity.RozetsuShikigamiShrineEntity;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {ReturnInsideItemProcedure.class},
   remap = false
)
public abstract class ReturnInsideItemProcedureMixin {
   @Overwrite
   public static ItemStack execute(Entity entity) {
      if (entity == null) {
         return ItemStack.f_41583_;
      } else {
         ItemStack item_a = ItemStack.f_41583_;
         if (entity instanceof Player) {
            item_a = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).BodyItem.m_41777_();
         } else {
            if (entity instanceof ItadoriYujiShinjukuEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get())).m_41777_();
               item_a.m_41764_(6);
            } else if (entity instanceof ItadoriYujiShibuyaEntity) {
               if (entity instanceof ItadoriYujiShibuyaEntity) {
                  ItadoriYujiShibuyaEntity _datEntL4 = (ItadoriYujiShibuyaEntity)entity;
                  if ((Boolean)_datEntL4.m_20088_().m_135370_(ItadoriYujiShibuyaEntity.DATA_sukuna)) {
                     item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
                     item_a.m_41764_(16);
                  }
               }
            } else if (entity instanceof ItadoriYujiEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
               item_a.m_41764_(3);
            }

            if (entity instanceof ChosoEntity || entity instanceof EsoEntity || entity instanceof KechizuEntity) {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.DEATH_PAINTING.get())).m_41777_();
               item_a.m_41764_(1);
            }

            if (!(entity instanceof SukunaFushiguroEntity) && !(entity instanceof SukunaPerfectEntity)) {
               if (entity instanceof SukunaEntity) {
                  item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
                  item_a.m_41764_(16);
               }
            } else {
               item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
               item_a.m_41764_(20);
            }
         }

         if (entity.getPersistentData().m_128471_("CursedSpirit")) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModBlocks.IN_BARRIER.get())).m_41777_();
         }

         if (entity instanceof RozetsuShikigamiShrineEntity) {
            item_a = (new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get())).m_41777_();
            item_a.m_41764_(2);
         }

         return item_a;
      }
   }
}
