package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SkillBoogieWoogieCombinedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = (double)0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + (double)1.0F);
         if (entity.getPersistentData().m_128459_("cnt1") == (double)1.0F) {
            entity.getPersistentData().m_128347_("boogie_count", (double)0.0F);
            entity.getPersistentData().m_128379_("fin_boogie", false);
            if (entity instanceof Player) {
               if (GetFlagShiftProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("shift_tec", (double)1.0F);
               } else {
                  entity.getPersistentData().m_128347_("shift_tec", (double)2.0F);
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > (double)3.0F) {
            if (!entity.getPersistentData().m_128471_("fin_boogie")) {
               if (entity instanceof Player) {
                  if (entity.getPersistentData().m_128459_("shift_tec") == (double)1.0F) {
                     SkillBoogieWoogieVProcedure.execute(world, x, y, z, entity, true, false, (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6), (double)20.0F);
                  } else {
                     SkillBoogieWoogieVProcedure.execute(world, x, y, z, entity, true, true, (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6), (double)20.0F);
                  }
               } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, 2) == 2) {
                  SkillBoogieWoogieVProcedure.execute(world, x, y, z, entity, true, false, (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6), (double)20.0F);
               } else {
                  SkillBoogieWoogieVProcedure.execute(world, x, y, z, entity, true, true, (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 6), (double)20.0F);
               }
            } else if (entity.getPersistentData().m_128471_("fin_boogie") && !(entity.getPersistentData().m_128459_("boogie_count") > (double)4.0F)) {
               entity.getPersistentData().m_128379_("fin_boogie", false);
            } else {
               if (entity instanceof Player) {
                  entity.getPersistentData().m_128347_("shift_tec", (double)0.0F);
               }

               entity.getPersistentData().m_128347_("skill", (double)0.0F);
            }
         }

      }
   }
}
