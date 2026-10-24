package net.mcreator.jujutsucraftv.init;

import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   private static final Map<ItemStack, PendingAnimation> PENDING_ANIMATIONS = new WeakHashMap();

   @SubscribeEvent
   public static void animatedItems(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.START) {
         Level var2 = event.player.m_9236_();
         if (var2 instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)var2;
            tickAnimationRequest(event.player.m_21205_(), serverLevel);
            tickAnimationRequest(event.player.m_21206_(), serverLevel);
            return;
         }
      }

   }

   private static void tickAnimationRequest(ItemStack stack, ServerLevel serverLevel) {
      if (!stack.m_41619_() && stack.m_41720_() instanceof GeoItem && stack.m_41782_()) {
         GeoItem.getOrAssignId(stack, serverLevel);
         String animation = stack.m_41783_().m_128461_("geckoAnim");
         long request = stack.m_41783_().m_128454_("geckoAnimRequest");
         if (!animation.isEmpty() && request != 0L) {
            PendingAnimation pending = (PendingAnimation)PENDING_ANIMATIONS.get(stack);
            if (pending != null && pending.request() == request) {
               if (pending.ticks() <= 1) {
                  stack.m_41783_().m_128473_("geckoAnim");
                  stack.m_41783_().m_128473_("geckoAnimRequest");
                  PENDING_ANIMATIONS.remove(stack);
               } else {
                  PENDING_ANIMATIONS.put(stack, new PendingAnimation(request, pending.ticks() - 1));
               }

            } else {
               PENDING_ANIMATIONS.put(stack, new PendingAnimation(request, 20));
            }
         } else {
            PENDING_ANIMATIONS.remove(stack);
         }
      } else {
         PENDING_ANIMATIONS.remove(stack);
      }
   }

   private static record PendingAnimation(long request, int ticks) {
   }
}
