package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.level.LevelAccessor;

public class PlayAnimationVProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity instanceof LivingEntity livingEntity) {
         if (livingEntity.m_21204_().m_22171_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get())) {
            AttributeInstance instance = livingEntity.m_21051_((Attribute)JujutsucraftvModAttributes.ANIMATION_V_1.get());
            if (instance != null) {
               int ani1 = (int)Math.round(instance.m_22115_());
               switch (ani1) {
                  case 101 -> SetupAnimationsProcedure.playResolved(world, entity, 101, "back_swing_right");
                  case 201 -> SetupAnimationsProcedure.playResolved(world, entity, 201, "domain_expansion2");
                  case 301 -> SetupAnimationsProcedure.playResolved(world, entity, 301, "hakoku_right1");
                  case 302 -> SetupAnimationsProcedure.playResolved(world, entity, 302, "hakoku_right2");
                  case 303 -> SetupAnimationsProcedure.playResolved(world, entity, 303, "rude_buster");
               }

            }
         }
      }
   }
}
