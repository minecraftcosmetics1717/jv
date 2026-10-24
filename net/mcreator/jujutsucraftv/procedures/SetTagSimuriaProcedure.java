package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.entity.DaburaKarabaAfterShinjukuEntity;
import net.mcreator.jujutsucraftv.entity.DaburaKarabaEntity;
import net.minecraft.world.entity.Entity;

public class SetTagSimuriaProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("Simuria", true);
         if (!(entity instanceof DaburaKarabaEntity) && !(entity instanceof DaburaKarabaAfterShinjukuEntity)) {
            entity.getPersistentData().m_128379_("Rumel", true);
         } else {
            entity.getPersistentData().m_128379_("Deskunte", true);
         }

         entity.getPersistentData().m_128379_("jjkChara", true);
      }
   }
}
