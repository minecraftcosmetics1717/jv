package net.mcreator.jujutsucraftv.procedures;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class SetPosBackProcedure {
   public static void execute(Entity entity, double num) {
      if (entity != null) {
         float yaw = entity.m_146908_();
         double xOffset = Math.sin(Math.toRadians((double)yaw)) * num;
         double zOffset = -Math.cos(Math.toRadians((double)yaw)) * num;
         CompoundTag nbt = entity.getPersistentData();
         nbt.m_128347_("x_pos", entity.m_20185_() + xOffset);
         nbt.m_128347_("y_pos", entity.m_20186_());
         nbt.m_128347_("z_pos", entity.m_20189_() + zOffset);
      }
   }
}
