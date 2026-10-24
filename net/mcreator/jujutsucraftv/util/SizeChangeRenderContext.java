package net.mcreator.jujutsucraftv.util;

public class SizeChangeRenderContext {
   private static final ThreadLocal<Integer> INVENTORY_RENDER_DEPTH = ThreadLocal.withInitial(() -> 0);

   public static void beginInventoryRender() {
      INVENTORY_RENDER_DEPTH.set((Integer)INVENTORY_RENDER_DEPTH.get() + 1);
   }

   public static void endInventoryRender() {
      int depth = (Integer)INVENTORY_RENDER_DEPTH.get() - 1;
      if (depth <= 0) {
         INVENTORY_RENDER_DEPTH.remove();
      } else {
         INVENTORY_RENDER_DEPTH.set(depth);
      }

   }

   public static boolean isInventoryRender() {
      return (Integer)INVENTORY_RENDER_DEPTH.get() > 0;
   }
}
