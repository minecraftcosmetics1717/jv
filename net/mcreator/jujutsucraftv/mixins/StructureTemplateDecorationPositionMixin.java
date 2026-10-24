package net.mcreator.jujutsucraftv.mixins;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({StructureTemplate.class})
public abstract class StructureTemplateDecorationPositionMixin {
   @Inject(
      method = {"processEntityInfos"},
      at = {@At("RETURN")},
      cancellable = true,
      remap = false
   )
   private static void jujutsucraftv$fixHangingDecorationPositions(StructureTemplate template, LevelAccessor world, BlockPos structurePos, StructurePlaceSettings settings, List<StructureTemplate.StructureEntityInfo> rawEntityInfos, CallbackInfoReturnable<List<StructureTemplate.StructureEntityInfo>> cir) {
      List<StructureTemplate.StructureEntityInfo> processed = (List)cir.getReturnValue();
      if (processed != null && !processed.isEmpty()) {
         List<StructureTemplate.StructureEntityInfo> corrected = null;

         for(int index = 0; index < processed.size(); ++index) {
            StructureTemplate.StructureEntityInfo info = (StructureTemplate.StructureEntityInfo)processed.get(index);
            CompoundTag nbt = info.f_74685_;
            if (nbt != null && nbt.m_128425_("TileX", 3) && nbt.m_128425_("TileY", 3) && nbt.m_128425_("TileZ", 3)) {
               if (corrected == null) {
                  corrected = new ArrayList(processed);
               }

               BlockPos anchor = info.f_74684_;
               CompoundTag correctedNbt = nbt.m_6426_();
               correctedNbt.m_128405_("TileX", anchor.m_123341_());
               correctedNbt.m_128405_("TileY", anchor.m_123342_());
               correctedNbt.m_128405_("TileZ", anchor.m_123343_());
               Vec3 anchorCenter = Vec3.m_82512_(anchor);
               corrected.set(index, new StructureTemplate.StructureEntityInfo(anchorCenter, anchor, correctedNbt));
            }
         }

         if (corrected != null) {
            cir.setReturnValue(corrected);
         }

      }
   }
}
