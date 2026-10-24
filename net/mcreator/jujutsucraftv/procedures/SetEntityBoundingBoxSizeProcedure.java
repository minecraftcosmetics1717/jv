package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.ForgeRegistries;

public class SetEntityBoundingBoxSizeProcedure {
   public static double execute(Entity entity) {
      return entity == null ? (double)0.0F : ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22115_() * (double)0.5F;
   }
}
