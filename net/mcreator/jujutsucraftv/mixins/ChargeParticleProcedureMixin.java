package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.ChargeParticleProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEnergyColorProcedure;
import net.mcreator.jujutsucraft.procedures.ReturnEntitySizeProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ChargeParticleProcedure.class})
public abstract class ChargeParticleProcedureMixin {
   @Inject(
      method = {"execute"},
      at = {@At("HEAD")},
      cancellable = true,
      remap = false
   )
   private static void onExecute(LevelAccessor world, Entity entity, double mode, CallbackInfo ci) {
      double entity_size = ReturnEntitySizeProcedure.execute(entity);
      double select_color = (double)0.0F;
      double random_color = (double)0.0F;
      if (mode == (double)0.0F) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123797_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
         }
      } else if (mode == (double)1.0F) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_8767_(ParticleTypes.f_123808_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
         }
      } else if (mode == (double)10.0F) {
         select_color = ReturnEnergyColorProcedure.execute(entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            SimpleParticleType particleType = null;
            if (select_color == (double)1.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get();
            } else if (select_color == (double)2.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get();
            } else if (select_color == (double)3.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get();
            } else if (select_color == (double)4.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get();
            } else if (select_color == (double)5.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get();
            } else if (select_color == (double)6.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_YELLOW.get();
            } else if (select_color == (double)7.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_RED.get();
            } else if (select_color == (double)8.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_BLUE.get();
            } else if (select_color == (double)9.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_GREEN.get();
            } else if (select_color == (double)10.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_BLACK.get();
            } else if (select_color == (double)11.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_WHITE.get();
            } else if (select_color == (double)12.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_RAINBOW.get();
            } else if (select_color == (double)13.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_RED.get();
            } else if (select_color == (double)14.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_ORANGE_TO_PURPLE.get();
            } else if (select_color == (double)15.0F) {
               random_color = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 5);
               if (random_color <= (double)2.0F) {
                  particleType = ParticleTypes.f_123746_;
               } else {
                  particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_BLACK.get();
               }
            } else if (select_color == (double)16.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_ZAWAZAWA.get();
            } else if (select_color == (double)17.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get();
            } else if (select_color == (double)18.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get();
            } else if (select_color == (double)19.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get();
            } else if (select_color == (double)20.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get();
            } else if (select_color == (double)21.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get();
            } else if (select_color == (double)22.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get();
            } else if (select_color == (double)23.0F) {
               particleType = ParticleTypes.f_123809_;
            } else if (select_color == (double)24.0F) {
               particleType = ParticleTypes.f_123810_;
            } else if (select_color == (double)25.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_RICE.get();
            } else if (select_color == (double)26.0F) {
               particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_MEDIUM.get();
            } else if (select_color == (double)27.0F) {
               particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get();
            }

            if (particleType != null) {
               _level.m_8767_(particleType, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)1.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
            } else {
               _level.m_8767_(ParticleTypes.f_123808_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * (double)0.5F, entity.m_20189_(), (int)((double)2.0F * entity_size), (double)entity.m_20205_() * (double)0.5F, (double)entity.m_20206_() * (double)0.5F, (double)entity.m_20205_() * (double)0.5F, (double)0.0F);
            }
         }
      }

      ci.cancel();
   }
}
