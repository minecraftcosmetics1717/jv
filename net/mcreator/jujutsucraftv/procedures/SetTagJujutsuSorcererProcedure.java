package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraftv.entity.IoriUtahimeEntity;
import net.mcreator.jujutsucraftv.entity.JohnKaisenEntity;
import net.mcreator.jujutsucraftv.entity.KugisakiGrandMotherEntity;
import net.mcreator.jujutsucraftv.entity.YakumaruEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class SetTagJujutsuSorcererProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
         entity.getPersistentData().m_128379_("jjkChara", true);
         if (entity instanceof KugisakiGrandMotherEntity) {
            entity.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_TODO_AOI_LEGGINGS.get()));
            entity.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
         }

         if (entity instanceof IoriUtahimeEntity) {
            entity.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_ZENIN_BOOTS.get()));
         }

         if (entity instanceof YakumaruEntity) {
            entity.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_BOOTS.get()));
         }

         if (entity instanceof JohnKaisenEntity) {
            entity.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_CHESTPLATE.get()));
            entity.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.UNIFORM_NORMAL_LEGGINGS.get()));
         }

      }
   }
}
