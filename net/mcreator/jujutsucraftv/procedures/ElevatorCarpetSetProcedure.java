package net.mcreator.jujutsucraftv.procedures;

import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ElevatorCarpetSetProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         if (guistate.containsKey("checkboxin:up_check") && ((String)guistate.get("checkboxin:up_check")).equals("true") && !world.m_5776_()) {
            BlockPos _bp = BlockPos.m_274561_(x, y, z);
            BlockEntity _blockEntity = world.m_7702_(_bp);
            BlockState _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("up_num", ((<undefinedtype>)(new Object() {
                  double convert(String s) {
                     try {
                        return Double.parseDouble(s.trim());
                     } catch (Exception var3) {
                        return (double)0.0F;
                     }
                  }
               })).convert(guistate.containsKey("textin:up_num") ? (String)guistate.get("textin:up_num") : ""));
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (guistate.containsKey("checkboxin:down_check") && ((String)guistate.get("checkboxin:down_check")).equals("true") && !world.m_5776_()) {
            BlockPos _bp = BlockPos.m_274561_(x, y, z);
            BlockEntity _blockEntity = world.m_7702_(_bp);
            BlockState _bs = world.m_8055_(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().m_128347_("down_num", ((<undefinedtype>)(new Object() {
                  double convert(String s) {
                     try {
                        return Double.parseDouble(s.trim());
                     } catch (Exception var3) {
                        return (double)0.0F;
                     }
                  }
               })).convert(guistate.containsKey("textin:down_num") ? (String)guistate.get("textin:down_num") : ""));
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_6915_();
         }

      }
   }
}
