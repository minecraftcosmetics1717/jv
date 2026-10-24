package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KugisakiNailProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class OldHammerRightClickProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double requiredCursePower = (double)0.0F;
         boolean hasNail = false;
         boolean hasRequiredSkill = false;
         hasRequiredSkill = entity.getPersistentData().m_128459_("skill") == (double)0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            boolean var10000 = hasRequiredSkill & livingEntity.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
         }

         if (entity instanceof Player) {
            Player player = (Player)entity;

            for(ItemStack stack : player.m_150109_().f_35974_) {
               if (stack.m_41720_() == JujutsucraftModItems.NAIL.get()) {
                  hasNail = true;
                  break;
               }
            }
         }

         boolean isCreativeMode = checkGamemode(entity, GameType.CREATIVE);
         if (isCreativeMode) {
            hasNail = true;
         }

         boolean hasEnoughCursePower = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange >= requiredCursePower;
         if (hasNail && hasEnoughCursePower) {
            double newCursePowerChange = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - requiredCursePower;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.PlayerCursePowerChange = newCursePowerChange;
               capability.syncPlayerVariables(entity);
            });
            playSound(world, x, y, z);
            if (checkGamemode(entity, GameType.SURVIVAL) && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.NAIL.get());
               _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
            }

            KugisakiNailProcedure.execute(world, x, y, z, entity);
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_36335_().m_41524_((Item)JujutsucraftvModItems.OLD_HAMMER.get(), 3);
            }
         } else if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
            }
         }

      }
   }

   private static boolean checkGamemode(Entity entity, GameType gameType) {
      if (entity instanceof ServerPlayer serverPlayer) {
         return serverPlayer.f_8941_.m_9290_() == gameType;
      } else if (entity.m_9236_().m_5776_() && entity instanceof Player player) {
         return Minecraft.m_91087_().m_91403_().m_104949_(player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(player.m_36316_().getId()).m_105325_() == gameType;
      } else {
         return false;
      }
   }

   private static void playSound(LevelAccessor world, double x, double y, double z) {
      if (world instanceof Level level) {
         if (!level.m_5776_()) {
            level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.NEUTRAL, 1.0F, 0.95F);
         } else {
            level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.NEUTRAL, 1.0F, 0.95F, false);
         }
      }

   }
}
