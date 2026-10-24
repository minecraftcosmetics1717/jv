package net.mcreator.jujutsucraftv.init;

import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ArmorAnimationFactory {
   private static final Map<ItemStack, PendingAnimation> PENDING_ANIMATIONS = new WeakHashMap();

   @SubscribeEvent
   public static void animatedArmors(LivingEvent.LivingTickEvent event) {
      LivingEntity living = event.getEntity();
      Level var3 = living.m_9236_();
      if (var3 instanceof ServerLevel serverLevel) {
         tickAnimationRequest(living.m_6844_(EquipmentSlot.HEAD), serverLevel);
         tickAnimationRequest(living.m_6844_(EquipmentSlot.CHEST), serverLevel);
         tickAnimationRequest(living.m_6844_(EquipmentSlot.LEGS), serverLevel);
         tickAnimationRequest(living.m_6844_(EquipmentSlot.FEET), serverLevel);
      }
   }

   private static void tickAnimationRequest(ItemStack stack, ServerLevel serverLevel) {
      if (!stack.m_41619_() && stack.m_41720_() instanceof ArmorItem && stack.m_41720_() instanceof GeoItem && stack.m_41782_()) {
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
