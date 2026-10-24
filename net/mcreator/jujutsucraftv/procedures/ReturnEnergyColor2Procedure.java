package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.ReturnEnergyColorProcedure;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

public class ReturnEnergyColor2Procedure {
   public static SimpleParticleType execute(Entity entity) {
      double curse_energy_color = ReturnEnergyColorProcedure.execute(entity);
      SimpleParticleType particleType = null;
      if (curse_energy_color == (double)1.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get();
      } else if (curse_energy_color == (double)2.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get();
      } else if (curse_energy_color == (double)3.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get();
      } else if (curse_energy_color == (double)4.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get();
      } else if (curse_energy_color == (double)5.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get();
      } else if (curse_energy_color == (double)6.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_YELLOW.get();
      } else if (curse_energy_color == (double)7.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_RED.get();
      } else if (curse_energy_color == (double)8.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_BLUE.get();
      } else if (curse_energy_color == (double)9.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_GREEN.get();
      } else if (curse_energy_color == (double)10.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_BLACK.get();
      } else if (curse_energy_color == (double)11.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_WHITE.get();
      } else if (curse_energy_color == (double)12.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_RAINBOW.get();
      } else if (curse_energy_color == (double)13.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_RED.get();
      } else if (curse_energy_color == (double)14.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_ORANGE_TO_PURPLE.get();
      } else if (curse_energy_color == (double)15.0F) {
         int random_color = Mth.m_216271_(RandomSource.m_216327_(), 1, 5);
         if (random_color <= 2) {
            particleType = ParticleTypes.f_123746_;
         } else {
            particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_BLACK.get();
         }
      } else if (curse_energy_color == (double)16.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_ZAWAZAWA.get();
      } else if (curse_energy_color == (double)17.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get();
      } else if (curse_energy_color == (double)18.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get();
      } else if (curse_energy_color == (double)19.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get();
      } else if (curse_energy_color == (double)20.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get();
      } else if (curse_energy_color == (double)21.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get();
      } else if (curse_energy_color == (double)22.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get();
      } else if (curse_energy_color == (double)23.0F) {
         particleType = ParticleTypes.f_123809_;
      } else if (curse_energy_color == (double)24.0F) {
         particleType = ParticleTypes.f_123810_;
      } else if (curse_energy_color == (double)25.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_RICE.get();
      } else if (curse_energy_color == (double)26.0F) {
         particleType = (SimpleParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_MEDIUM.get();
      } else if (curse_energy_color == (double)27.0F) {
         particleType = (SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get();
      }

      return particleType;
   }
}
