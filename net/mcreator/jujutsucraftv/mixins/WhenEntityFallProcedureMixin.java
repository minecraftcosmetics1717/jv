package net.mcreator.jujutsucraftv.mixins;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.WhenEntityFallProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.procedures.ReturnEnergyColor2Procedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(
   value = {WhenEntityFallProcedure.class},
   remap = false
)
public abstract class WhenEntityFallProcedureMixin {
   @Overwrite
   private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double distance) {
      if (entity != null) {
         boolean logic_fall = false;
         double distance_power = distance - (double)8.0F;
         if (entity instanceof Player) {
            logic_fall = entity.m_6144_() && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX >= (double)6000.0F;
         } else {
            logic_fall = entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               logic_fall = logic_fall || !(entity instanceof Player) || entity.m_6144_();
            }

            if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
               logic_fall = true;
            }

            if (_livEnt.m_21023_((MobEffect)JujutsucraftvModMobEffects.RAINBOW_EYE.get())) {
               logic_fall = true;
            }
         }

         if (distance_power > (double)0.0F) {
            double x_pos = entity.m_20185_();
            double y_pos = entity.m_20186_();
            double z_pos = entity.m_20189_();
            distance_power = Math.sqrt(distance_power + (double)1.0F);
            if (distance_power > (double)4.0F) {
               entity.getPersistentData().m_128347_("BlockRange", Math.min(distance_power, (double)4.0F) + (double)entity.m_20205_());
               entity.getPersistentData().m_128347_("BlockDamage", (double)0.25F * distance_power);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (!world.m_5776_()) {
                  _livEnt.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 15, 6, false, false));
               }

               if (_livEnt.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livEnt.m_21051_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_((double)-10.0F);
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (logic_fall && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               SimpleParticleType particleType = ReturnEnergyColor2Procedure.execute(entity);
               double particle_amount = Math.min(Math.pow(distance_power, (double)2.5F) + (double)20.0F, (double)100.0F);
               double particle_speed = Math.min(distance_power * 0.1, (double)1.5F);
               _level.m_8767_(particleType, x_pos, y_pos, z_pos, (int)particle_amount, (double)entity.m_20205_() * (double)0.75F, (double)0.0F, (double)entity.m_20205_() * (double)0.75F, particle_speed);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               BlockPos _pos = BlockPos.m_274561_(x_pos, y_pos, z_pos);
               _level.m_5594_((Player)null, _pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * (double)0.5F), (float)Mth.m_216263_(RandomSource.m_216327_(), 0.9, 1.1));
               _level.m_5594_((Player)null, _pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.6));
               _level.m_5594_((Player)null, _pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, (float)Mth.m_216263_(RandomSource.m_216327_(), (double)0.5F, 0.6));
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
               }
            }
         }

         if (logic_fall && event instanceof LivingFallEvent) {
            LivingFallEvent _fallEvent = (LivingFallEvent)event;
            if (_fallEvent.isCancelable()) {
               _fallEvent.setCanceled(true);
            }
         }

         int jump_limit = 0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            if (_livEnt.m_21023_(MobEffects.f_19603_)) {
               jump_limit = _livEnt.m_21124_(MobEffects.f_19603_).m_19564_() + 1 + 5;
            }
         }

         if (distance < (double)jump_limit && event instanceof LivingFallEvent) {
            LivingFallEvent _fallEvent = (LivingFallEvent)event;
            if (_fallEvent.isCancelable()) {
               _fallEvent.setCanceled(true);
            }
         }

      }
   }
}
