package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;

public class GetEntityFriendlyProcedure {
   public static boolean execute(Entity source, Entity target) {
      if (source != null && target != null) {
         boolean var8;
         label62: {
            boolean logic = false;
            if (source instanceof LivingEntity && !(source instanceof ItemEntity) && !source.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living")))) {
               LivingEntity var10000;
               if (target instanceof Mob) {
                  Mob _mobEnt = (Mob)target;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 != source) {
                  if (source instanceof Mob) {
                     Mob _mobEnt = (Mob)source;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 != target) {
                     if (source.getPersistentData().m_128471_("JujutsuSorcerer") == target.getPersistentData().m_128471_("JujutsuSorcerer") || source.getPersistentData().m_128471_("CursedSpirit") == target.getPersistentData().m_128471_("CursedSpirit") || source.getPersistentData().m_128471_("CurseUser") == target.getPersistentData().m_128471_("CurseUser")) {
                        break label62;
                     }

                     if (source instanceof TamableAnimal) {
                        TamableAnimal _tamIsTamedBy = (TamableAnimal)source;
                        if (target instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)target;
                           if (_tamIsTamedBy.m_21830_(_livEnt)) {
                              break label62;
                           }
                        }
                     }

                     if (source.getPersistentData().m_128461_("OWNER_UUID").equals(target.m_20149_())) {
                        break label62;
                     }
                  }
               }
            }

            var8 = false;
            return var8;
         }

         var8 = true;
         return var8;
      } else {
         return false;
      }
   }
}
