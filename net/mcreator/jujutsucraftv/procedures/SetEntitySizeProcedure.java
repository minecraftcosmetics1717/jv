package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class SetEntitySizeProcedure {
   public static double execute(Entity entity) {
      if (entity == null) {
         return (double)0.0F;
      } else {
         double size = (double)0.0F;
         double var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity0 = (LivingEntity)entity;
            if (_livingEntity0.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               var10000 = _livingEntity0.m_21051_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
               return var10000;
            }
         }

         var10000 = (double)0.0F;
         return var10000;
      }
   }
}
