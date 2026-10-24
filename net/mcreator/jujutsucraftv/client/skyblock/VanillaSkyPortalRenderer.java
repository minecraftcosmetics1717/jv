package net.mcreator.jujutsucraftv.client.skyblock;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexBuffer.Usage;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;

public final class VanillaSkyPortalRenderer {
   private static final int HORIZONTAL_SEGMENTS = 32;
   private static final int VERTICAL_SEGMENTS = 16;
   private static final int STAR_COUNT = 220;
   private static final float SKY_RADIUS = 48.0F;
   private static final float STAR_RADIUS = 46.0F;
   private static VertexBuffer daySkyBuffer;
   private static VertexBuffer nightSkyBuffer;
   private static VertexBuffer starBuffer;

   private VanillaSkyPortalRenderer() {
   }

   public static void render(Minecraft minecraft, LevelRenderer levelRenderer, Matrix4f poseMatrix, Matrix4f projectionMatrix, Camera camera, float partialTick, boolean night) {
      ensureBuffers(night);
      ShaderInstance shader = GameRenderer.m_172811_();
      if (shader != null) {
         VertexBuffer skyBuffer = night ? nightSkyBuffer : daySkyBuffer;
         if (skyBuffer != null) {
            RenderSystem.colorMask(true, true, true, true);
            RenderSystem.depthMask(false);
            RenderSystem.disableDepthTest();
            RenderSystem.disableCull();
            RenderSystem.disableBlend();
            RenderSystem.setShader(() -> shader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            skyBuffer.m_85921_();
            skyBuffer.m_253207_(new Matrix4f(poseMatrix), new Matrix4f(projectionMatrix), shader);
            if (night && starBuffer != null) {
               starBuffer.m_85921_();
               starBuffer.m_253207_(new Matrix4f(poseMatrix), new Matrix4f(projectionMatrix), shader);
            }

            VertexBuffer.m_85931_();
         }
      }
   }

   private static void ensureBuffers(boolean night) {
      if (night) {
         if (nightSkyBuffer == null) {
            nightSkyBuffer = createSkyBuffer(true);
         }

         if (starBuffer == null) {
            starBuffer = createStarBuffer();
         }
      } else if (daySkyBuffer == null) {
         daySkyBuffer = createSkyBuffer(false);
      }

   }

   private static VertexBuffer createSkyBuffer(boolean night) {
      RenderSystem.assertOnRenderThread();
      BufferBuilder builder = Tesselator.m_85913_().m_85915_();
      builder.m_166779_(Mode.QUADS, DefaultVertexFormat.f_85815_);

      for(int vertical = 0; vertical < 16; ++vertical) {
         float v0 = (float)vertical / 16.0F;
         float v1 = (float)(vertical + 1) / 16.0F;
         double theta0 = Math.PI * (double)v0;
         double theta1 = Math.PI * (double)v1;

         for(int horizontal = 0; horizontal < 32; ++horizontal) {
            float u0 = (float)horizontal / 32.0F;
            float u1 = (float)(horizontal + 1) / 32.0F;
            double phi0 = (Math.PI * 2D) * (double)u0;
            double phi1 = (Math.PI * 2D) * (double)u1;
            addSkyVertex(builder, theta0, phi0, night);
            addSkyVertex(builder, theta1, phi0, night);
            addSkyVertex(builder, theta1, phi1, night);
            addSkyVertex(builder, theta0, phi1, night);
         }
      }

      VertexBuffer buffer = new VertexBuffer(Usage.STATIC);
      buffer.m_85921_();
      buffer.m_231221_(builder.m_231175_());
      VertexBuffer.m_85931_();
      return buffer;
   }

   private static VertexBuffer createStarBuffer() {
      RenderSystem.assertOnRenderThread();
      BufferBuilder builder = Tesselator.m_85913_().m_85915_();
      builder.m_166779_(Mode.QUADS, DefaultVertexFormat.f_85815_);
      Random random = new Random(10842L);

      for(int index = 0; index < 220; ++index) {
         float directionX;
         float directionY;
         float directionZ;
         float lengthSquared;
         do {
            directionX = random.nextFloat() * 2.0F - 1.0F;
            directionY = random.nextFloat() * 2.0F - 1.0F;
            directionZ = random.nextFloat() * 2.0F - 1.0F;
            lengthSquared = directionX * directionX + directionY * directionY + directionZ * directionZ;
         } while(lengthSquared <= 0.01F || lengthSquared > 1.0F);

         float inverseLength = 1.0F / Mth.m_14116_(lengthSquared);
         directionX *= inverseLength;
         directionY *= inverseLength;
         directionZ *= inverseLength;
         float centerX = directionX * 46.0F;
         float centerY = directionY * 46.0F;
         float centerZ = directionZ * 46.0F;
         float refX;
         float refY;
         float refZ;
         if (Math.abs(directionY) < 0.9F) {
            refX = 0.0F;
            refY = 1.0F;
            refZ = 0.0F;
         } else {
            refX = 1.0F;
            refY = 0.0F;
            refZ = 0.0F;
         }

         float tangentX = directionY * refZ - directionZ * refY;
         float tangentY = directionZ * refX - directionX * refZ;
         float tangentZ = directionX * refY - directionY * refX;
         float tangentLength = Mth.m_14116_(tangentX * tangentX + tangentY * tangentY + tangentZ * tangentZ);
         tangentX /= tangentLength;
         tangentY /= tangentLength;
         tangentZ /= tangentLength;
         float bitangentX = directionY * tangentZ - directionZ * tangentY;
         float bitangentY = directionZ * tangentX - directionX * tangentZ;
         float bitangentZ = directionX * tangentY - directionY * tangentX;
         float size = 0.08F + random.nextFloat() * 0.2F;
         float brightness = 0.72F + random.nextFloat() * 0.28F;
         addStarVertex(builder, centerX - tangentX * size - bitangentX * size, centerY - tangentY * size - bitangentY * size, centerZ - tangentZ * size - bitangentZ * size, brightness);
         addStarVertex(builder, centerX + tangentX * size - bitangentX * size, centerY + tangentY * size - bitangentY * size, centerZ + tangentZ * size - bitangentZ * size, brightness);
         addStarVertex(builder, centerX + tangentX * size + bitangentX * size, centerY + tangentY * size + bitangentY * size, centerZ + tangentZ * size + bitangentZ * size, brightness);
         addStarVertex(builder, centerX - tangentX * size + bitangentX * size, centerY - tangentY * size + bitangentY * size, centerZ - tangentZ * size + bitangentZ * size, brightness);
      }

      VertexBuffer buffer = new VertexBuffer(Usage.STATIC);
      buffer.m_85921_();
      buffer.m_231221_(builder.m_231175_());
      VertexBuffer.m_85931_();
      return buffer;
   }

   private static void addSkyVertex(BufferBuilder builder, double theta, double phi, boolean night) {
      float horizontalRadius = (float)Math.sin(theta);
      float x = (float)Math.sin(phi) * horizontalRadius * 48.0F;
      float y = (float)Math.cos(theta) * 48.0F;
      float z = (float)Math.cos(phi) * horizontalRadius * 48.0F;
      float normalizedY = y / 48.0F;
      float blend = Mth.m_14036_((1.0F - normalizedY) * 0.5F, 0.0F, 1.0F);
      float red;
      float green;
      float blue;
      if (night) {
         red = lerp(0.004F, 0.025F, blend);
         green = lerp(0.008F, 0.055F, blend);
         blue = lerp(0.055F, 0.16F, blend);
      } else {
         red = lerp(0.32F, 0.75F, blend);
         green = lerp(0.58F, 0.88F, blend);
         blue = 1.0F;
      }

      builder.m_5483_((double)x, (double)y, (double)z).m_85950_(red, green, blue, 1.0F).m_5752_();
   }

   private static void addStarVertex(BufferBuilder builder, float x, float y, float z, float brightness) {
      builder.m_5483_((double)x, (double)y, (double)z).m_85950_(brightness, brightness, Math.min(1.0F, brightness + 0.08F), 1.0F).m_5752_();
   }

   private static float lerp(float start, float end, float delta) {
      return start + (end - start) * delta;
   }
}
