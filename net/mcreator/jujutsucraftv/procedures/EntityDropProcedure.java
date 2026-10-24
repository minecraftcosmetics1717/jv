package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.NanamiKentoEntity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade01Entity;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityDropProcedure {
   @SubscribeEvent
   public static void onEntityDeath(LivingDeathEvent event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getEntity().m_20185_(), event.getEntity().m_20186_(), event.getEntity().m_20189_(), event.getEntity());
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double random = (double)0.0F;
         if (entity instanceof CursedSpiritGrade01Entity) {
            random = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 2);
            if (entity.getPersistentData().m_128471_("drop_chance_record") && random == (double)2.0F && world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               ItemEntity _itemEntity = (ItemEntity)EntityType.f_20461_.m_20615_(_serverLevel);
               if (_itemEntity != null) {
                  _itemEntity.m_32045_(new ItemStack((ItemLike)JujutsucraftvModItems.MUSIC_DISC_NOSTALGIA.get()));
                  _itemEntity.m_32010_(5);
                  ((Entity)_itemEntity).m_6034_(x, y, z);
                  if (_itemEntity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_itemEntity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19619_, Integer.MAX_VALUE, 1, false, false));
                     }
                  }

                  _serverLevel.m_7967_(_itemEntity);
               }
            }
         }

         if (entity instanceof NanamiKentoEntity) {
            random = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 20);
            if (random == (double)20.0F && world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               ItemEntity _itemEntity = (ItemEntity)EntityType.f_20461_.m_20615_(_serverLevel);
               if (_itemEntity != null) {
                  _itemEntity.m_32045_(new ItemStack((ItemLike)JujutsucraftvModItems.NANAMI_WRISTWATCH.get()));
                  _itemEntity.m_32010_(5);
                  ((Entity)_itemEntity).m_6034_(x, y, z);
                  if (_itemEntity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_itemEntity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19619_, Integer.MAX_VALUE, 1, false, false));
                     }
                  }

                  _serverLevel.m_7967_(_itemEntity);
               }
            }
         }

      }
   }
}
