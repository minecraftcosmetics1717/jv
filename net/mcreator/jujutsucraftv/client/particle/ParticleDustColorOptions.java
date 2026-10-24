package net.mcreator.jujutsucraftv.client.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Locale;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import org.joml.Vector3f;

public class ParticleDustColorOptions implements ParticleOptions {
   public static final ParticleOptions.Deserializer<ParticleDustColorOptions> DESERIALIZER = new ParticleOptions.Deserializer<ParticleDustColorOptions>() {
      public ParticleDustColorOptions fromCommand(ParticleType<ParticleDustColorOptions> type, StringReader reader) throws CommandSyntaxException {
         reader.expect(' ');
         float r = reader.readFloat();
         reader.expect(' ');
         float g = reader.readFloat();
         reader.expect(' ');
         float b = reader.readFloat();
         reader.expect(' ');
         float scale = reader.readFloat();
         return new ParticleDustColorOptions(type, new Vector3f(r, g, b), scale);
      }

      public ParticleDustColorOptions fromNetwork(ParticleType<ParticleDustColorOptions> type, FriendlyByteBuf buffer) {
         return new ParticleDustColorOptions(type, new Vector3f(buffer.readFloat(), buffer.readFloat(), buffer.readFloat()), buffer.readFloat());
      }
   };
   private final ParticleType<ParticleDustColorOptions> type;
   private final Vector3f color;
   private final float scale;

   public static Codec<ParticleDustColorOptions> codec(ParticleType<ParticleDustColorOptions> type) {
      return RecordCodecBuilder.create((instance) -> instance.group(Codec.FLOAT.fieldOf("r").forGetter((options) -> options.color.x()), Codec.FLOAT.fieldOf("g").forGetter((options) -> options.color.y()), Codec.FLOAT.fieldOf("b").forGetter((options) -> options.color.z()), Codec.FLOAT.fieldOf("scale").forGetter((options) -> options.scale)).apply(instance, (r, g, b, scale) -> new ParticleDustColorOptions(type, new Vector3f(r, g, b), scale)));
   }

   public ParticleDustColorOptions(ParticleType<ParticleDustColorOptions> type, Vector3f color, float scale) {
      this.type = type;
      this.color = color;
      this.scale = scale;
   }

   public Vector3f getColor() {
      return this.color;
   }

   public float getScale() {
      return this.scale;
   }

   public ParticleType<?> m_6012_() {
      return this.type;
   }

   public void m_7711_(FriendlyByteBuf buffer) {
      buffer.writeFloat(this.color.x());
      buffer.writeFloat(this.color.y());
      buffer.writeFloat(this.color.z());
      buffer.writeFloat(this.scale);
   }

   public String m_5942_() {
      return String.format(Locale.ROOT, "%.2f %.2f %.2f %.2f", this.color.x(), this.color.y(), this.color.z(), this.scale);
   }
}
