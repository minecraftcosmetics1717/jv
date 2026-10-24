package net.mcreator.jujutsucraftv.procedures;

import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class OneTimeSpawnerGuiSelectProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
      if (entity != null && guistate != null) {
         BlockPos _bp = BlockPos.m_274561_(x, y, z);
         BlockEntity _blockEntity = world.m_7702_(_bp);
         BlockState _bs = world.m_8055_(_bp);
         if (_blockEntity != null && !world.m_5776_()) {
            String eid = guistate.containsKey("textin:spawn_entity_id") ? (String)guistate.get("textin:spawn_entity_id") : "";
            _blockEntity.getPersistentData().m_128359_("entity_id", eid);
            String countStr = guistate.containsKey("textin:count") ? (String)guistate.get("textin:count") : "1";

            double countVal;
            try {
               countVal = Double.parseDouble(countStr.trim());
            } catch (Exception var17) {
               countVal = (double)1.0F;
            }

            if (countVal <= (double)0.0F) {
               countVal = (double)1.0F;
            }

            _blockEntity.getPersistentData().m_128347_("entity_count", countVal);
            _blockEntity.getPersistentData().m_128379_("selected", true);
            _blockEntity.m_6596_();
            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.m_7260_(_bp, _bs, _bs, 3);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (_level.m_5776_()) {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.button.click")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.m_6915_();
         }

      }
   }
}
