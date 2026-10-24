package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber
public class DrinkDrinkProcedure {
   @SubscribeEvent
   public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
      if (event != null && event.getEntity() != null) {
         execute(event, event.getEntity().m_9236_(), event.getEntity(), event.getItem());
      }

   }

   public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
      execute((Event)null, world, entity, itemstack);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_1.get()) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "jjc_cursepower 100 @s");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_2.get()) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "jjc_cursepower 200 @s");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_3.get()) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "jjc_cursepower 300 @s");
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               float var10001;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.m_21223_();
               } else {
                  var10001 = -1.0F;
               }

               _entity.m_21153_(var10001 + 6.0F);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 0.8F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
               }
            }
         }

         if (itemstack.m_41720_() == JujutsucraftvModItems.DRINKS_4.get()) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "jjc_cursepower 1000 @s");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 0.8F);
               } else {
                  _level.m_7785_(entity.m_20185_(), entity.m_20186_() + (double)1.0F, entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:heal1")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
               }
            }
         }

      }
   }
}
