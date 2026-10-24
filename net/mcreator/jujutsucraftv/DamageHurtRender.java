package net.mcreator.jujutsucraftv;

import java.util.WeakHashMap;
import net.mcreator.jujutsucraftv.entity.SmallShrineEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.FORGE,
   value = {Dist.CLIENT}
)
public class DamageHurtRender {
   private static final TagKey<EntityType<?>> NOT_LIVING_TAG;
   private static final WeakHashMap<LivingEntity, Integer> savedHurtTimes;

   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void onRenderLivingPre(RenderLivingEvent.Pre<LivingEntity, ?> event) {
      LivingEntity entity = event.getEntity();
      if (shouldDisableHurtRender(entity)) {
         if (entity.f_20916_ > 0) {
            savedHurtTimes.put(entity, entity.f_20916_);
            entity.f_20916_ = 0;
         }

      }
   }

   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void onRenderLivingPost(RenderLivingEvent.Post<LivingEntity, ?> event) {
      LivingEntity entity = event.getEntity();
      Integer saved = (Integer)savedHurtTimes.remove(entity);
      if (saved != null) {
         entity.f_20916_ = saved;
      }

   }

   private static boolean shouldDisableHurtRender(LivingEntity entity) {
      return entity.m_6095_().m_204039_(NOT_LIVING_TAG) || entity instanceof SmallShrineEntity;
   }

   static {
      NOT_LIVING_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"));
      savedHurtTimes = new WeakHashMap();
   }
}
