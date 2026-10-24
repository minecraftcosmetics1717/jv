package net.mcreator.jujutsucraftv.client.skyblock;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexBuffer.Usage;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.mojang.math.Axis;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public final class TextureSkyPortalMesh {
   private static final int HORIZONTAL_SEGMENTS = 32;
   private static final int VERTICAL_SEGMENTS = 16;
   private static VertexBuffer vertexBuffer;

   private TextureSkyPortalMesh() {
   }

   public static void render(TextureSkyDefinition definition, ClientLevel level, Matrix4f poseMatrix, Matrix4f projectionMatrix, Vec3 cameraPosition, float partialTick) {
      ensureBuffer();
      ShaderInstance shader = GameRenderer.m_172817_();
      if (shader != null && vertexBuffer != null) {
         float time = (float)level.m_46467_() + partialTick;
         int layers = definition.layers();
         RenderSystem.setShader(() -> shader);
         RenderSystem.setShaderTexture(0, definition.texture());
         RenderSystem.enableBlend();
         RenderSystem.defaultBlendFunc();
         RenderSystem.disableCull();
         RenderSystem.depthMask(false);
         vertexBuffer.m_85921_();

         for(int layer = layers - 1; layer >= 0; --layer) {
            float layerPosition = layers <= 1 ? 0.0F : (float)layer / (float)(layers - 1);
            float nearStrength = 1.0F - layerPosition;
            float radius = definition.baseRadius() + definition.layerSpacing() * (float)layer;
            float movementStrength = definition.parallax() * (0.2F + nearStrength * 0.8F);
            double offsetX = Math.sin(cameraPosition.f_82479_ * 0.025 + cameraPosition.f_82481_ * 0.006 + (double)layer * 1.731) * (double)radius * 0.09 * (double)movementStrength;
            double offsetY = Math.sin(cameraPosition.f_82480_ * 0.018 + cameraPosition.f_82479_ * 0.004 + (double)layer * 0.913) * (double)radius * 0.04 * (double)movementStrength;
            double offsetZ = Math.cos(cameraPosition.f_82481_ * 0.025 - cameraPosition.f_82479_ * 0.006 + (double)layer * 1.417) * (double)radius * 0.09 * (double)movementStrength;
            float rotation = definition.rotationOffset() + time * definition.rotationSpeed() + (float)layer * 13.5F;
            float verticalRotation = (float)Math.sin((double)time * 0.0025 + (double)layer * (double)0.75F) * (2.0F + nearStrength * 3.0F);
            float alpha = layer == layers - 1 ? 1.0F : definition.layerAlpha() * (0.45F + nearStrength * 0.55F);
            PoseStack poseStack = new PoseStack();
            poseStack.m_252931_(new Matrix4f(poseMatrix));
            poseStack.m_85837_(offsetX, offsetY, offsetZ);
            poseStack.m_252781_(Axis.f_252436_.m_252977_(rotation));
            poseStack.m_252781_(Axis.f_252529_.m_252977_(verticalRotation));
            poseStack.m_85841_(radius, radius, radius);
            RenderSystem.setShaderColor(definition.brightness(), definition.brightness(), definition.brightness(), alpha);
            vertexBuffer.m_253207_(poseStack.m_85850_().m_252922_(), projectionMatrix, shader);
         }

         VertexBuffer.m_85931_();
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private static void ensureBuffer() {
      if (vertexBuffer == null) {
         RenderSystem.assertOnRenderThread();
         BufferBuilder builder = Tesselator.m_85913_().m_85915_();
         builder.m_166779_(Mode.QUADS, DefaultVertexFormat.f_85817_);

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
               addVertex(builder, theta0, phi0, u0, v0);
               addVertex(builder, theta1, phi0, u0, v1);
               addVertex(builder, theta1, phi1, u1, v1);
               addVertex(builder, theta0, phi1, u1, v0);
            }
         }

         vertexBuffer = new VertexBuffer(Usage.STATIC);
         vertexBuffer.m_85921_();
         vertexBuffer.m_231221_(builder.m_231175_());
         VertexBuffer.m_85931_();
      }
   }

   private static void addVertex(BufferBuilder builder, double theta, double phi, float u, float v) {
      float horizontalRadius = (float)Math.sin(theta);
      float x = (float)Math.sin(phi) * horizontalRadius;
      float y = (float)Math.cos(theta);
      float z = (float)Math.cos(phi) * horizontalRadius;
      builder.m_5483_((double)x, (double)y, (double)z).m_7421_(u, v).m_5752_();
   }
}
