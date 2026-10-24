package net.mcreator.jujutsucraftv.util;

import net.minecraft.network.syncher.EntityDataAccessor;

public interface SizeChangeReady {
   boolean jjcv$isSizeChangeReady();

   float jjcv$getForcedSizeChangeScale();

   float jjcv$getSyncedSizeChangeScale();

   void jjcv$setSyncedSizeChangeScale(float var1);

   boolean jjcv$isSizeChangeScaleData(EntityDataAccessor<?> var1);

   void jjcv$refreshSizeChange(float var1);
}
