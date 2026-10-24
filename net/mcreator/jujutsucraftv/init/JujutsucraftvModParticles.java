package net.mcreator.jujutsucraftv.init;

import net.mcreator.jujutsucraftv.client.particle.ParticleBarrierDustParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleBarrierShardDustParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleBlueFlameParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerBlackParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerDeepBlueParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerDeepGreenParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerDeepRedParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerDustTransitionParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerOrangeToPurpleParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerRainbowParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerWhiteParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursePowerYellowParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursedText1Particle;
import net.mcreator.jujutsucraftv.client.particle.ParticleCursedText2Particle;
import net.mcreator.jujutsucraftv.client.particle.ParticleExplodeDustTransitionParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleFlameDustParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleFlameDustTransitionParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightAsh2Particle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightAshParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightAshRed2Particle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightAshRedParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightFlashDustParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightLargeParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightLargeRedParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightMediumParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightVerticalParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightVerticalRedParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleLightningHumanoidDustParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleNoteParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleRiceParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleSmokePurpleParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleThunderBlueParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleThunderMovableParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleThunderRainbowParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleThunderRedParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleTodoFaceParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleVermilionAshParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleVerticalBarrierBlackParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleVerticalImpactDustParticle;
import net.mcreator.jujutsucraftv.client.particle.ParticleZawazawaParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftvModParticles {
   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_BLACK.get(), ParticleCursePowerBlackParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_WHITE.get(), ParticleCursePowerWhiteParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_YELLOW.get(), ParticleCursePowerYellowParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_BLUE.get(), ParticleCursePowerDeepBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_RED.get(), ParticleThunderRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_BLUE_FLAME.get(), ParticleBlueFlameParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_ORANGE_TO_PURPLE.get(), ParticleCursePowerOrangeToPurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_GREEN.get(), ParticleCursePowerDeepGreenParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_ZAWAZAWA.get(), ParticleZawazawaParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_VERMILION_ASH.get(), ParticleVermilionAshParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_NOTE.get(), ParticleNoteParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSED_TEXT_1.get(), ParticleCursedText1Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSED_TEXT_2.get(), ParticleCursedText2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH.get(), ParticleLightAshParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_2.get(), ParticleLightAsh2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_LARGE.get(), ParticleLightLargeParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_MEDIUM.get(), ParticleLightMediumParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_SMOKE_PURPLE.get(), ParticleSmokePurpleParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_RICE.get(), ParticleRiceParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DEEP_RED.get(), ParticleCursePowerDeepRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_RAINBOW.get(), ParticleCursePowerRainbowParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_RAINBOW.get(), ParticleThunderRainbowParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_BLUE.get(), ParticleThunderBlueParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_VERTICAL.get(), ParticleLightVerticalParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_TODO_FACE.get(), ParticleTodoFaceParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED.get(), ParticleLightAshRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_VERTICAL_RED.get(), ParticleLightVerticalRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_LARGE_RED.get(), ParticleLightLargeRedParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_ASH_RED_2.get(), ParticleLightAshRed2Particle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_BARRIER_DUST.get(), ParticleBarrierDustParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_BARRIER_SHARD_DUST.get(), ParticleBarrierShardDustParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_VERTICAL_BARRIER_BLACK.get(), ParticleVerticalBarrierBlackParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_CURSE_POWER_DUST_TRANSITION.get(), ParticleCursePowerDustTransitionParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_FLAME_DUST_TRANSITION.get(), ParticleFlameDustTransitionParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_FLAME_DUST.get(), ParticleFlameDustParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_VERTICAL_IMPACT_DUST.get(), ParticleVerticalImpactDustParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_THUNDER_MOVABLE.get(), ParticleThunderMovableParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHTNING_HUMANOID_DUST.get(), ParticleLightningHumanoidDustParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_LIGHT_FLASH_DUST.get(), ParticleLightFlashDustParticle::provider);
      event.registerSpriteSet((ParticleType)JujutsucraftvModParticleTypes.PARTICLE_EXPLODE_DUST_TRANSITION.get(), ParticleExplodeDustTransitionParticle::provider);
   }
}
