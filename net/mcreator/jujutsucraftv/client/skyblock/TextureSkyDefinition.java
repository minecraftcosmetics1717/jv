package net.mcreator.jujutsucraftv.client.skyblock;

import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public record TextureSkyDefinition(boolean vanilla, boolean night, ResourceLocation texture, int layers, float baseRadius, float layerSpacing, float parallax, float rotationSpeed, float rotationOffset, float layerAlpha, float brightness) {
   public TextureSkyDefinition(boolean vanilla, boolean night, ResourceLocation texture, int layers, float baseRadius, float layerSpacing, float parallax, float rotationSpeed, float rotationOffset, float layerAlpha, float brightness) {
      if (!vanilla) {
         Objects.requireNonNull(texture);
      }

      layers = Mth.m_14045_(layers, 1, 8);
      baseRadius = Mth.m_14036_(baseRadius, 8.0F, 128.0F);
      layerSpacing = Mth.m_14036_(layerSpacing, 0.0F, 32.0F);
      parallax = Mth.m_14036_(parallax, 0.0F, 1.0F);
      layerAlpha = Mth.m_14036_(layerAlpha, 0.0F, 1.0F);
      brightness = Mth.m_14036_(brightness, 0.0F, 2.0F);
      this.vanilla = vanilla;
      this.night = night;
      this.texture = texture;
      this.layers = layers;
      this.baseRadius = baseRadius;
      this.layerSpacing = layerSpacing;
      this.parallax = parallax;
      this.rotationSpeed = rotationSpeed;
      this.rotationOffset = rotationOffset;
      this.layerAlpha = layerAlpha;
      this.brightness = brightness;
   }
}
