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

public class ParticleDustTransitionOptions implements ParticleOptions {
   public static final ParticleOptions.Deserializer<ParticleDustTransitionOptions> DESERIALIZER = new ParticleOptions.Deserializer<ParticleDustTransitionOptions>() {
      public ParticleDustTransitionOptions fromCommand(ParticleType<ParticleDustTransitionOptions> type, StringReader reader) throws CommandSyntaxException {
         reader.expect(' ');
         float fromR = reader.readFloat();
         reader.expect(' ');
         float fromG = reader.readFloat();
         reader.expect(' ');
         float fromB = reader.readFloat();
         reader.expect(' ');
         float scale = reader.readFloat();
         reader.expect(' ');
         float toR = reader.readFloat();
         reader.expect(' ');
         float toG = reader.readFloat();
         reader.expect(' ');
         float toB = reader.readFloat();
         return new ParticleDustTransitionOptions(type, new Vector3f(fromR, fromG, fromB), scale, new Vector3f(toR, toG, toB));
      }

      public ParticleDustTransitionOptions fromNetwork(ParticleType<ParticleDustTransitionOptions> type, FriendlyByteBuf buffer) {
         return new ParticleDustTransitionOptions(type, new Vector3f(buffer.readFloat(), buffer.readFloat(), buffer.readFloat()), buffer.readFloat(), new Vector3f(buffer.readFloat(), buffer.readFloat(), buffer.readFloat()));
      }
   };
   private final ParticleType<ParticleDustTransitionOptions> type;
   private final Vector3f fromColor;
   private final Vector3f toColor;
   private final float scale;

   public static Codec<ParticleDustTransitionOptions> codec(ParticleType<ParticleDustTransitionOptions> type) {
      return RecordCodecBuilder.create((instance) -> instance.group(Codec.FLOAT.fieldOf("from_r").forGetter((options) -> options.fromColor.x()), Codec.FLOAT.fieldOf("from_g").forGetter((options) -> options.fromColor.y()), Codec.FLOAT.fieldOf("from_b").forGetter((options) -> options.fromColor.z()), Codec.FLOAT.fieldOf("scale").forGetter((options) -> options.scale), Codec.FLOAT.fieldOf("to_r").forGetter((options) -> options.toColor.x()), Codec.FLOAT.fieldOf("to_g").forGetter((options) -> options.toColor.y()), Codec.FLOAT.fieldOf("to_b").forGetter((options) -> options.toColor.z())).apply(instance, (fromR, fromG, fromB, scale, toR, toG, toB) -> new ParticleDustTransitionOptions(type, new Vector3f(fromR, fromG, fromB), scale, new Vector3f(toR, toG, toB))));
   }

   public ParticleDustTransitionOptions(ParticleType<ParticleDustTransitionOptions> type, Vector3f fromColor, float scale, Vector3f toColor) {
      this.type = type;
      this.fromColor = fromColor;
      this.toColor = toColor;
      this.scale = scale;
   }

   public Vector3f getFromColor() {
      return this.fromColor;
   }

   public Vector3f getToColor() {
      return this.toColor;
   }

   public float getScale() {
      return this.scale;
   }

   public ParticleType<?> m_6012_() {
      return this.type;
   }

   public void m_7711_(FriendlyByteBuf buffer) {
      buffer.writeFloat(this.fromColor.x());
      buffer.writeFloat(this.fromColor.y());
      buffer.writeFloat(this.fromColor.z());
      buffer.writeFloat(this.scale);
      buffer.writeFloat(this.toColor.x());
      buffer.writeFloat(this.toColor.y());
      buffer.writeFloat(this.toColor.z());
   }

   public String m_5942_() {
      return String.format(Locale.ROOT, "%.3f %.3f %.3f %.3f %.3f %.3f %.3f", this.fromColor.x(), this.fromColor.y(), this.fromColor.z(), this.scale, this.toColor.x(), this.toColor.y(), this.toColor.z());
   }
}
