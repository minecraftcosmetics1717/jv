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

public class ParticleMovableOptions implements ParticleOptions {
   public static final ParticleOptions.Deserializer<ParticleMovableOptions> DESERIALIZER = new ParticleOptions.Deserializer<ParticleMovableOptions>() {
      public ParticleMovableOptions fromCommand(ParticleType<ParticleMovableOptions> type, StringReader reader) throws CommandSyntaxException {
         reader.expect(' ');
         float r = reader.readFloat();
         reader.expect(' ');
         float g = reader.readFloat();
         reader.expect(' ');
         float b = reader.readFloat();
         reader.expect(' ');
         float scale = reader.readFloat();
         reader.expect(' ');
         int mode = reader.readInt();
         return new ParticleMovableOptions(type, new Vector3f(r, g, b), scale, mode);
      }

      public ParticleMovableOptions fromNetwork(ParticleType<ParticleMovableOptions> type, FriendlyByteBuf buffer) {
         return new ParticleMovableOptions(type, new Vector3f(buffer.readFloat(), buffer.readFloat(), buffer.readFloat()), buffer.readFloat(), buffer.readInt());
      }
   };
   private final ParticleType<ParticleMovableOptions> type;
   private final Vector3f color;
   private final float scale;
   private final int mode;

   public static Codec<ParticleMovableOptions> codec(ParticleType<ParticleMovableOptions> type) {
      return RecordCodecBuilder.create((instance) -> instance.group(Codec.FLOAT.fieldOf("r").forGetter((options) -> options.color.x()), Codec.FLOAT.fieldOf("g").forGetter((options) -> options.color.y()), Codec.FLOAT.fieldOf("b").forGetter((options) -> options.color.z()), Codec.FLOAT.fieldOf("scale").forGetter((options) -> options.scale), Codec.INT.fieldOf("mode").forGetter((options) -> options.mode)).apply(instance, (r, g, b, scale, mode) -> new ParticleMovableOptions(type, new Vector3f(r, g, b), scale, mode)));
   }

   public ParticleMovableOptions(ParticleType<ParticleMovableOptions> type, Vector3f color, float scale, int mode) {
      this.type = type;
      this.color = color;
      this.scale = scale;
      this.mode = mode;
   }

   public Vector3f getColor() {
      return this.color;
   }

   public float getScale() {
      return this.scale;
   }

   public int getMode() {
      return this.mode;
   }

   public ParticleType<?> m_6012_() {
      return this.type;
   }

   public void m_7711_(FriendlyByteBuf buffer) {
      buffer.writeFloat(this.color.x());
      buffer.writeFloat(this.color.y());
      buffer.writeFloat(this.color.z());
      buffer.writeFloat(this.scale);
      buffer.writeInt(this.mode);
   }

   public String m_5942_() {
      return String.format(Locale.ROOT, "%.2f %.2f %.2f %.2f %d", this.color.x(), this.color.y(), this.color.z(), this.scale, this.mode);
   }
}
