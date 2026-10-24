package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade15Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class EntityDeathDropProcedure {
   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof CursedSpiritGrade15Entity && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ItemEntity entityToSpawn = new ItemEntity(_level, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), new ItemStack((ItemLike)JujutsucraftModItems.SUKUNA_FINGER.get()));
            entityToSpawn.m_32010_(5);
            _level.m_7967_(entityToSpawn);
         }

      }
   }
}
