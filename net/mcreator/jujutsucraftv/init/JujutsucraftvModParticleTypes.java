package net.mcreator.jujutsucraftv.init;

import com.mojang.serialization.Codec;
import net.mcreator.jujutsucraftv.client.particle.ParticleDustColorOptions;
import net.mcreator.jujutsucraftv.client.particle.ParticleDustTransitionOptions;
import net.mcreator.jujutsucraftv.client.particle.ParticleMovableOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftvModParticleTypes {
   public static final DeferredRegister<ParticleType<?>> REGISTRY;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_BLACK;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_WHITE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_YELLOW;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_DEEP_BLUE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_THUNDER_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_BLUE_FLAME;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_ORANGE_TO_PURPLE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_DEEP_GREEN;
   public static final RegistryObject<SimpleParticleType> PARTICLE_ZAWAZAWA;
   public static final RegistryObject<SimpleParticleType> PARTICLE_VERMILION_ASH;
   public static final RegistryObject<SimpleParticleType> PARTICLE_NOTE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSED_TEXT_1;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSED_TEXT_2;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_ASH;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_ASH_2;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_LARGE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_MEDIUM;
   public static final RegistryObject<SimpleParticleType> PARTICLE_SMOKE_PURPLE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_RICE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_DEEP_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_CURSE_POWER_RAINBOW;
   public static final RegistryObject<SimpleParticleType> PARTICLE_THUNDER_RAINBOW;
   public static final RegistryObject<SimpleParticleType> PARTICLE_THUNDER_BLUE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_VERTICAL;
   public static final RegistryObject<SimpleParticleType> PARTICLE_TODO_FACE;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_ASH_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_VERTICAL_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_LARGE_RED;
   public static final RegistryObject<SimpleParticleType> PARTICLE_LIGHT_ASH_RED_2;
   public static final RegistryObject<ParticleType<ParticleDustColorOptions>> PARTICLE_BARRIER_DUST;
   public static final RegistryObject<ParticleType<ParticleDustColorOptions>> PARTICLE_BARRIER_SHARD_DUST;
   public static final RegistryObject<SimpleParticleType> PARTICLE_VERTICAL_BARRIER_BLACK;
   public static final RegistryObject<ParticleType<ParticleDustTransitionOptions>> PARTICLE_CURSE_POWER_DUST_TRANSITION;
   public static final RegistryObject<ParticleType<ParticleDustTransitionOptions>> PARTICLE_FLAME_DUST_TRANSITION;
   public static final RegistryObject<ParticleType<ParticleDustColorOptions>> PARTICLE_FLAME_DUST;
   public static final RegistryObject<ParticleType<ParticleDustColorOptions>> PARTICLE_VERTICAL_IMPACT_DUST;
   public static final RegistryObject<ParticleType<ParticleMovableOptions>> PARTICLE_THUNDER_MOVABLE;
   public static final RegistryObject<ParticleType<ParticleDustColorOptions>> PARTICLE_LIGHTNING_HUMANOID_DUST;
   public static final RegistryObject<ParticleType<ParticleDustColorOptions>> PARTICLE_LIGHT_FLASH_DUST;
   public static final RegistryObject<ParticleType<ParticleDustTransitionOptions>> PARTICLE_EXPLODE_DUST_TRANSITION;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "jujutsucraftv");
      PARTICLE_CURSE_POWER_BLACK = REGISTRY.register("particle_curse_power_black", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_WHITE = REGISTRY.register("particle_curse_power_white", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_YELLOW = REGISTRY.register("particle_curse_power_yellow", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_DEEP_BLUE = REGISTRY.register("particle_curse_power_deep_blue", () -> new SimpleParticleType(false));
      PARTICLE_THUNDER_RED = REGISTRY.register("particle_thunder_red", () -> new SimpleParticleType(false));
      PARTICLE_BLUE_FLAME = REGISTRY.register("particle_blue_flame", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_ORANGE_TO_PURPLE = REGISTRY.register("particle_curse_power_orange_to_purple", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_DEEP_GREEN = REGISTRY.register("particle_curse_power_deep_green", () -> new SimpleParticleType(false));
      PARTICLE_ZAWAZAWA = REGISTRY.register("particle_zawazawa", () -> new SimpleParticleType(false));
      PARTICLE_VERMILION_ASH = REGISTRY.register("particle_vermilion_ash", () -> new SimpleParticleType(false));
      PARTICLE_NOTE = REGISTRY.register("particle_note", () -> new SimpleParticleType(false));
      PARTICLE_CURSED_TEXT_1 = REGISTRY.register("particle_cursed_text_1", () -> new SimpleParticleType(false));
      PARTICLE_CURSED_TEXT_2 = REGISTRY.register("particle_cursed_text_2", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_ASH = REGISTRY.register("particle_light_ash", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_ASH_2 = REGISTRY.register("particle_light_ash_2", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_LARGE = REGISTRY.register("particle_light_large", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_MEDIUM = REGISTRY.register("particle_light_medium", () -> new SimpleParticleType(false));
      PARTICLE_SMOKE_PURPLE = REGISTRY.register("particle_smoke_purple", () -> new SimpleParticleType(false));
      PARTICLE_RICE = REGISTRY.register("particle_rice", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_DEEP_RED = REGISTRY.register("particle_curse_power_deep_red", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_RAINBOW = REGISTRY.register("particle_curse_power_rainbow", () -> new SimpleParticleType(false));
      PARTICLE_THUNDER_RAINBOW = REGISTRY.register("particle_thunder_rainbow", () -> new SimpleParticleType(false));
      PARTICLE_THUNDER_BLUE = REGISTRY.register("particle_thunder_blue", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_VERTICAL = REGISTRY.register("particle_light_vertical", () -> new SimpleParticleType(false));
      PARTICLE_TODO_FACE = REGISTRY.register("particle_todo_face", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_ASH_RED = REGISTRY.register("particle_light_ash_red", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_VERTICAL_RED = REGISTRY.register("particle_light_vertical_red", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_LARGE_RED = REGISTRY.register("particle_light_large_red", () -> new SimpleParticleType(false));
      PARTICLE_LIGHT_ASH_RED_2 = REGISTRY.register("particle_light_ash_red_2", () -> new SimpleParticleType(false));
      PARTICLE_BARRIER_DUST = REGISTRY.register("particle_barrier_dust", () -> new ParticleType<ParticleDustColorOptions>(false, ParticleDustColorOptions.DESERIALIZER) {
            public Codec<ParticleDustColorOptions> m_7652_() {
               return ParticleDustColorOptions.codec(this);
            }
         });
      PARTICLE_BARRIER_SHARD_DUST = REGISTRY.register("particle_barrier_shard_dust", () -> new ParticleType<ParticleDustColorOptions>(false, ParticleDustColorOptions.DESERIALIZER) {
            public Codec<ParticleDustColorOptions> m_7652_() {
               return ParticleDustColorOptions.codec(this);
            }
         });
      PARTICLE_VERTICAL_BARRIER_BLACK = REGISTRY.register("particle_vertical_barrier_black", () -> new SimpleParticleType(false));
      PARTICLE_CURSE_POWER_DUST_TRANSITION = REGISTRY.register("particle_curse_power_dust_transition", () -> new ParticleType<ParticleDustTransitionOptions>(false, ParticleDustTransitionOptions.DESERIALIZER) {
            public Codec<ParticleDustTransitionOptions> m_7652_() {
               return ParticleDustTransitionOptions.codec(this);
            }
         });
      PARTICLE_FLAME_DUST_TRANSITION = REGISTRY.register("particle_flame_dust_transition", () -> new ParticleType<ParticleDustTransitionOptions>(false, ParticleDustTransitionOptions.DESERIALIZER) {
            public Codec<ParticleDustTransitionOptions> m_7652_() {
               return ParticleDustTransitionOptions.codec(this);
            }
         });
      PARTICLE_FLAME_DUST = REGISTRY.register("particle_flame_dust", () -> new ParticleType<ParticleDustColorOptions>(false, ParticleDustColorOptions.DESERIALIZER) {
            public Codec<ParticleDustColorOptions> m_7652_() {
               return ParticleDustColorOptions.codec(this);
            }
         });
      PARTICLE_VERTICAL_IMPACT_DUST = REGISTRY.register("particle_vertical_impact_dust", () -> new ParticleType<ParticleDustColorOptions>(false, ParticleDustColorOptions.DESERIALIZER) {
            public Codec<ParticleDustColorOptions> m_7652_() {
               return ParticleDustColorOptions.codec(this);
            }
         });
      PARTICLE_THUNDER_MOVABLE = REGISTRY.register("particle_thunder_movable", () -> new ParticleType<ParticleMovableOptions>(false, ParticleMovableOptions.DESERIALIZER) {
            public Codec<ParticleMovableOptions> m_7652_() {
               return ParticleMovableOptions.codec(this);
            }
         });
      PARTICLE_LIGHTNING_HUMANOID_DUST = REGISTRY.register("particle_lightning_humanoid_dust", () -> new ParticleType<ParticleDustColorOptions>(false, ParticleDustColorOptions.DESERIALIZER) {
            public Codec<ParticleDustColorOptions> m_7652_() {
               return ParticleDustColorOptions.codec(this);
            }
         });
      PARTICLE_LIGHT_FLASH_DUST = REGISTRY.register("particle_light_flash_dust", () -> new ParticleType<ParticleDustColorOptions>(false, ParticleDustColorOptions.DESERIALIZER) {
            public Codec<ParticleDustColorOptions> m_7652_() {
               return ParticleDustColorOptions.codec(this);
            }
         });
      PARTICLE_EXPLODE_DUST_TRANSITION = REGISTRY.register("particle_explode_dust_transition", () -> new ParticleType<ParticleDustTransitionOptions>(false, ParticleDustTransitionOptions.DESERIALIZER) {
            public Codec<ParticleDustTransitionOptions> m_7652_() {
               return ParticleDustTransitionOptions.codec(this);
            }
         });
   }
}
