package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.procedures.AttackWeakSwordProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(
   value = {AttackWeakSwordProcedure.class},
   remap = false
)
public abstract class AttackWeakSwordProcedureMixin {
   @Redirect(
      method = {"execute"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/level/Level;m_5594_(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"
),
      require = 0
   )
   private static void jujutsucraftv$replaceWeakServerSound(Level level, Player player, BlockPos pos, SoundEvent sound, SoundSource source, float volume, float pitch, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (jujutsucraftv$shouldReplace(sound, entity)) {
         SoundEvent saberSwing = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:light_saber_swing"));
         if (saberSwing != null) {
            float saberPitch = 1.2F + (float)Math.random() * 0.2F;
            level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), saberSwing, SoundSource.NEUTRAL, 1.0F, saberPitch);
            return;
         }
      }

      level.m_5594_(player, pos, sound, source, volume, pitch);
   }

   @Redirect(
      method = {"execute"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/level/Level;m_7785_(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"
),
      require = 0
   )
   private static void jujutsucraftv$replaceWeakClientSound(Level level, double soundX, double soundY, double soundZ, SoundEvent sound, SoundSource source, float volume, float pitch, boolean distanceDelay, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (jujutsucraftv$shouldReplace(sound, entity)) {
         SoundEvent saberSwing = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:light_saber_swing"));
         if (saberSwing != null) {
            float saberPitch = 1.2F + (float)Math.random() * 0.2F;
            level.m_7785_(x, y, z, saberSwing, SoundSource.NEUTRAL, 1.0F, saberPitch, false);
            return;
         }
      }

      level.m_7785_(soundX, soundY, soundZ, sound, source, volume, pitch, distanceDelay);
   }

   private static boolean jujutsucraftv$shouldReplace(SoundEvent sound, Entity entity) {
      if (sound != null && entity != null) {
         ResourceLocation soundId = ForgeRegistries.SOUND_EVENTS.getKey(sound);
         if (!(new ResourceLocation("entity.player.attack.sweep")).equals(soundId)) {
            return false;
         } else {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity livingEntity = (LivingEntity)entity;
               var10000 = livingEntity.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            ItemStack stack = var10000;
            return stack.m_41720_() == JujutsucraftvModItems.CURSE_POWER_SABER.get() && stack.m_41782_() && stack.m_41783_().m_128471_("act");
         }
      } else {
         return false;
      }
   }
}
