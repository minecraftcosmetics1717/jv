package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

@Mixin(
   targets = {"net.mcreator.jujutsucraft.procedures.LogicSwordProcedure"},
   remap = false
)
public abstract class LogicSwordProcedureMixin {
   @Overwrite(
      remap = false
   )
   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         ItemStack mainHandItem = ItemStack.f_41583_;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            mainHandItem = livingEntity.m_21205_().m_41777_();
         }

         if (jujutsucraft$hasItemTag(mainHandItem, "forge:knuckle")) {
            return false;
         } else if (jujutsucraft$hasItemTag(mainHandItem, "forge:shift_sword") && !entity.m_6144_()) {
            return false;
         } else if (!(mainHandItem.m_41720_() instanceof SwordItem) && !(mainHandItem.m_41720_() instanceof AxeItem) && !(mainHandItem.m_41720_() instanceof PickaxeItem) && !(mainHandItem.m_41720_() instanceof ShovelItem) && !(mainHandItem.m_41720_() instanceof HoeItem) && !jujutsucraft$hasItemTag(mainHandItem, "forge:sword") && !jujutsucraft$hasItemTag(mainHandItem, "forge:whip") && (!jujutsucraft$hasItemTag(mainHandItem, "forge:metallic") || !jujutsucraft$hasItemTag(mainHandItem, "minecraft:pickaxes") || jujutsucraft$hasItemTag(mainHandItem, "forge:knuckle"))) {
            if (jujutsucraft$hasEntityTypeTag(entity, "forge:have_claws")) {
               return true;
            } else if (jujutsucraft$hasEntityTypeTag(entity, "forge:iron_body")) {
               return true;
            } else {
               ItemStack chestItem = ItemStack.f_41583_;
               if (entity instanceof LivingEntity) {
                  LivingEntity livingEntity = (LivingEntity)entity;
                  chestItem = livingEntity.m_6844_(EquipmentSlot.CHEST);
               }

               return chestItem.m_41720_() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get();
            }
         } else {
            return true;
         }
      }
   }

   @Unique
   private static boolean jujutsucraft$hasItemTag(ItemStack stack, String tagId) {
      return !stack.m_41619_() && stack.m_204117_(TagKey.m_203882_(Registries.f_256913_, new ResourceLocation(tagId)));
   }

   @Unique
   private static boolean jujutsucraft$hasEntityTypeTag(Entity entity, String tagId) {
      return entity != null && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation(tagId)));
   }
}
