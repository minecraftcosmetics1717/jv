package net.mcreator.jujutsucraftv.procedures;

import java.util.stream.IntStream;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityBiomeTickProcedure {
   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         if (entity.f_19797_ % Math.max(1, 60) == 0 && entity.m_9236_().m_204166_(entity.m_20183_()).m_203373_(new ResourceLocation("jujutsucraftv:grand_barrier_forest")) && !entity.getPersistentData().m_128471_("CursedSpirit")) {
            if (entity instanceof Player) {
               Player _ppvPlayerHotbar = (Player)entity;
               if (IntStream.range(0, 9).anyMatch((_ppvSlot) -> _ppvPlayerHotbar.m_150109_().m_8020_(_ppvSlot).m_150930_((new ItemStack((ItemLike)JujutsucraftvModItems.FOUNDATION_STONE.get())).m_41720_()))) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.DAMAGE_INCREASE.get(), 100, 29, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.ATTACK_DAMAGE_REDUCTION.get(), 100, 29, false, false));
               }
            }
         }

      }
   }
}
