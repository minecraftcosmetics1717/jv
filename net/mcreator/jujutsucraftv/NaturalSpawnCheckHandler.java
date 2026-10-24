package net.mcreator.jujutsucraftv;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModGameRules;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NaturalSpawnCheckHandler {
   private static final TagKey<EntityType<?>> NETHER_MOB_TAG;
   private static final TagKey<EntityType<?>> NOT_SPAWN_NETHER_OTHER_TAG;
   private static final TagKey<EntityType<?>> NOT_LIVING_TAG;
   private static final TagKey<EntityType<?>> RANGED_AMMO_TAG;
   private static final TagKey<EntityType<?>> RANGED_AMMO_NO_MOVE_TAG;

   @SubscribeEvent
   public static void onPositionCheck(MobSpawnEvent.PositionCheck event) {
      Mob entity = event.getEntity();
      if (jujutsucraftv$shouldDenySpawn(entity, event.getSpawnType())) {
         event.setResult(Result.DENY);
      }

   }

   @SubscribeEvent
   public static void onFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
      Mob entity = event.getEntity();
      if (jujutsucraftv$shouldDenySpawn(entity, event.getSpawnType())) {
         event.setSpawnCancelled(true);
      }

   }

   private static boolean jujutsucraftv$shouldDenySpawn(Mob entity, MobSpawnType spawnType) {
      if (entity == null) {
         return false;
      } else if (entity.m_9236_().m_5776_()) {
         return false;
      } else if (!jujutsucraftv$isNaturalSpawn(spawnType)) {
         return false;
      } else if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
         return false;
      } else {
         boolean isNether = entity.m_9236_().m_46472_() == Level.f_46429_;
         boolean isNetherMob = entity.m_6095_().m_204039_(NETHER_MOB_TAG);
         boolean isNotSpawnNetherOther = entity.m_6095_().m_204039_(NOT_SPAWN_NETHER_OTHER_TAG);
         if (isNetherMob && !isNether) {
            return true;
         } else if (!isNether) {
            return false;
         } else {
            boolean netherUniqueSpawn = entity.m_9236_().m_46469_().m_46207_(JujutsucraftvModGameRules.JJCV_NETHER_UNIQUE_ENTITY_SPAWN);
            if (!netherUniqueSpawn) {
               return false;
            } else if (isNotSpawnNetherOther) {
               return true;
            } else if (!jujutsucraftv$isNormalTargetEntity(entity)) {
               return false;
            } else {
               return !isNetherMob;
            }
         }
      }
   }

   private static boolean jujutsucraftv$isNaturalSpawn(MobSpawnType spawnType) {
      return spawnType == MobSpawnType.NATURAL || spawnType == MobSpawnType.CHUNK_GENERATION;
   }

   private static boolean jujutsucraftv$isNormalTargetEntity(Mob entity) {
      EntityType<?> type = entity.m_6095_();
      if (type.m_204039_(NOT_LIVING_TAG)) {
         return false;
      } else if (type.m_204039_(RANGED_AMMO_TAG)) {
         return false;
      } else {
         return !type.m_204039_(RANGED_AMMO_NO_MOVE_TAG);
      }
   }

   static {
      NETHER_MOB_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:nether_mob"));
      NOT_SPAWN_NETHER_OTHER_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_spawn_nether_other"));
      NOT_LIVING_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"));
      RANGED_AMMO_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"));
      RANGED_AMMO_NO_MOVE_TAG = TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move"));
   }
}
