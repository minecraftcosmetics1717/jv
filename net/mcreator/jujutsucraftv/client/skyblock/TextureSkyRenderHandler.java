package net.mcreator.jujutsucraftv.client.skyblock;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Map;
import net.mcreator.jujutsucraftv.block.TextureSkyBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE,
   value = {Dist.CLIENT}
)
public final class TextureSkyRenderHandler {
   private static final int MAX_ACTIVE_SKIES = 254;
   private static final float MIN = 0.0F;
   private static final float MAX = 1.0F;
   private static final Object2ObjectLinkedOpenHashMap<ResourceLocation, LongOpenHashSet> QUEUED_SKIES = new Object2ObjectLinkedOpenHashMap();
   private static final ResourceLocation[] ACTIVE_IDS = new ResourceLocation[254];
   private static final TextureSkyDefinition[] ACTIVE_DEFINITIONS = new TextureSkyDefinition[254];
   private static final LongOpenHashSet[] ACTIVE_POSITIONS = new LongOpenHashSet[254];
   private static int activeSkyCount;

   private TextureSkyRenderHandler() {
   }

   public static void submit(ResourceLocation skyId, BlockPos pos) {
      if (skyId != null && pos != null) {
         ((LongOpenHashSet)QUEUED_SKIES.computeIfAbsent(skyId, (key) -> new LongOpenHashSet())).add(pos.m_121878_());
      }
   }

   @SubscribeEvent
   public static void onRenderLevelStage(RenderLevelStageEvent event) {
      if (event.getStage() == Stage.AFTER_ENTITIES) {
         clearQueuedPositions();
      } else if (event.getStage() == Stage.AFTER_PARTICLES) {
         Minecraft minecraft = Minecraft.m_91087_();
         if (minecraft.f_91073_ != null && !QUEUED_SKIES.isEmpty()) {
            prepareActiveSkies();
            if (activeSkyCount == 0) {
               clearQueuedPositions();
            } else {
               RenderTarget renderTarget = minecraft.m_91385_();
               if (!renderTarget.isStencilEnabled()) {
                  renderTarget.enableStencil();
                  clearQueuedPositions();
               } else {
                  renderTarget.m_83947_(false);

                  try {
                     renderMasks(event);
                     renderSkies(event);
                  } finally {
                     restoreRenderState();
                     clearQueuedPositions();
                  }

               }
            }
         } else {
            clearQueuedPositions();
         }
      }
   }

   private static void prepareActiveSkies() {
      activeSkyCount = 0;
      ObjectBidirectionalIterator var0 = QUEUED_SKIES.entrySet().iterator();

      while(var0.hasNext()) {
         Map.Entry<ResourceLocation, LongOpenHashSet> entry = (Map.Entry)var0.next();
         if (activeSkyCount >= 254) {
            break;
         }

         LongOpenHashSet positions = (LongOpenHashSet)entry.getValue();
         if (!positions.isEmpty()) {
            TextureSkyDefinition definition = TextureSkyManager.get((ResourceLocation)entry.getKey());
            if (definition != null) {
               ACTIVE_IDS[activeSkyCount] = (ResourceLocation)entry.getKey();
               ACTIVE_DEFINITIONS[activeSkyCount] = definition;
               ACTIVE_POSITIONS[activeSkyCount] = positions;
               ++activeSkyCount;
            }
         }
      }

   }

   private static void renderMasks(RenderLevelStageEvent event) {
      GL11.glEnable(2960);
      GL11.glStencilMask(255);
      GL11.glClearStencil(0);
      GL11.glClear(1024);
      RenderSystem.colorMask(false, false, false, false);
      RenderSystem.depthMask(false);
      RenderSystem.enableDepthTest();
      RenderSystem.depthFunc(515);
      RenderSystem.disableBlend();
      RenderSystem.disableCull();
      RenderSystem.setShader(GameRenderer::m_172808_);
      GL11.glEnable(32823);
      GL11.glPolygonOffset(-1.0F, -2.0F);
      GL11.glStencilOp(7680, 7680, 7681);

      for(int index = 0; index < activeSkyCount; ++index) {
         GL11.glStencilFunc(519, index + 1, 255);
         drawMask(event, ACTIVE_IDS[index], ACTIVE_POSITIONS[index]);
      }

      GL11.glPolygonOffset(0.0F, 0.0F);
      GL11.glDisable(32823);
   }

   private static void renderSkies(RenderLevelStageEvent event) {
      GL11.glPolygonOffset(0.0F, 0.0F);
      GL11.glDisable(32823);
      Minecraft minecraft = Minecraft.m_91087_();
      ClientLevel level = minecraft.f_91073_;
      if (level != null) {
         Matrix4f poseMatrix = new Matrix4f(event.getPoseStack().m_85850_().m_252922_());
         Matrix4f projectionMatrix = new Matrix4f(event.getProjectionMatrix());
         Vec3 cameraPosition = event.getCamera().m_90583_();
         RenderSystem.colorMask(true, true, true, true);
         RenderSystem.depthMask(false);
         RenderSystem.disableDepthTest();
         RenderSystem.disableCull();
         RenderSystem.disableBlend();
         GL11.glEnable(2960);
         GL11.glStencilMask(0);
         GL11.glStencilOp(7680, 7680, 7680);

         for(int index = 0; index < activeSkyCount; ++index) {
            GL11.glStencilFunc(514, index + 1, 255);
            TextureSkyDefinition definition = ACTIVE_DEFINITIONS[index];
            if (definition.vanilla()) {
               VanillaSkyPortalRenderer.render(minecraft, event.getLevelRenderer(), poseMatrix, projectionMatrix, event.getCamera(), event.getPartialTick(), definition.night());
            } else {
               TextureSkyPortalMesh.render(definition, level, poseMatrix, projectionMatrix, cameraPosition, event.getPartialTick());
            }
         }

      }
   }

   private static void drawMask(RenderLevelStageEvent event, ResourceLocation skyId, LongOpenHashSet positions) {
      Minecraft minecraft = Minecraft.m_91087_();
      ClientLevel level = minecraft.f_91073_;
      if (level != null && !positions.isEmpty()) {
         Vec3 cameraPosition = event.getCamera().m_90583_();
         Matrix4f matrix = new Matrix4f(event.getPoseStack().m_85850_().m_252922_());
         BufferBuilder builder = Tesselator.m_85913_().m_85915_();
         builder.m_166779_(Mode.QUADS, DefaultVertexFormat.f_85814_);
         BlockPos.MutableBlockPos neighbourPos = new BlockPos.MutableBlockPos();
         LongIterator iterator = positions.iterator();
         boolean hasFaces = false;

         while(iterator.hasNext()) {
            long packedPos = iterator.nextLong();
            int blockX = BlockPos.m_121983_(packedPos);
            int blockY = BlockPos.m_122008_(packedPos);
            int blockZ = BlockPos.m_122015_(packedPos);
            float x = (float)((double)blockX - cameraPosition.f_82479_);
            float y = (float)((double)blockY - cameraPosition.f_82480_);
            float z = (float)((double)blockZ - cameraPosition.f_82481_);
            if (shouldRenderFace(level, skyId, neighbourPos, blockX, blockY, blockZ, Direction.NORTH)) {
               addNorth(builder, matrix, x, y, z);
               hasFaces = true;
            }

            if (shouldRenderFace(level, skyId, neighbourPos, blockX, blockY, blockZ, Direction.SOUTH)) {
               addSouth(builder, matrix, x, y, z);
               hasFaces = true;
            }

            if (shouldRenderFace(level, skyId, neighbourPos, blockX, blockY, blockZ, Direction.WEST)) {
               addWest(builder, matrix, x, y, z);
               hasFaces = true;
            }

            if (shouldRenderFace(level, skyId, neighbourPos, blockX, blockY, blockZ, Direction.EAST)) {
               addEast(builder, matrix, x, y, z);
               hasFaces = true;
            }

            if (shouldRenderFace(level, skyId, neighbourPos, blockX, blockY, blockZ, Direction.UP)) {
               addUp(builder, matrix, x, y, z);
               hasFaces = true;
            }

            if (shouldRenderFace(level, skyId, neighbourPos, blockX, blockY, blockZ, Direction.DOWN)) {
               addDown(builder, matrix, x, y, z);
               hasFaces = true;
            }
         }

         BufferBuilder.RenderedBuffer renderedBuffer = builder.m_231175_();
         if (hasFaces) {
            BufferUploader.m_231202_(renderedBuffer);
         } else {
            renderedBuffer.m_231200_();
         }

      }
   }

   private static boolean shouldRenderFace(ClientLevel level, ResourceLocation skyId, BlockPos.MutableBlockPos neighbourPos, int x, int y, int z, Direction direction) {
      neighbourPos.m_122178_(x + direction.m_122429_(), y + direction.m_122430_(), z + direction.m_122431_());
      Block neighbourBlock = level.m_8055_(neighbourPos).m_60734_();
      if (neighbourBlock instanceof TextureSkyBlock neighbourSkyBlock) {
         return !skyId.equals(neighbourSkyBlock.getSkyId());
      } else {
         return true;
      }
   }

   private static void addNorth(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      vertex(builder, matrix, x + 1.0F, y + 0.0F, z + 0.0F);
      vertex(builder, matrix, x + 0.0F, y + 0.0F, z + 0.0F);
      vertex(builder, matrix, x + 0.0F, y + 1.0F, z + 0.0F);
      vertex(builder, matrix, x + 1.0F, y + 1.0F, z + 0.0F);
   }

   private static void addSouth(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      vertex(builder, matrix, x + 0.0F, y + 0.0F, z + 1.0F);
      vertex(builder, matrix, x + 1.0F, y + 0.0F, z + 1.0F);
      vertex(builder, matrix, x + 1.0F, y + 1.0F, z + 1.0F);
      vertex(builder, matrix, x + 0.0F, y + 1.0F, z + 1.0F);
   }

   private static void addWest(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      vertex(builder, matrix, x + 0.0F, y + 0.0F, z + 0.0F);
      vertex(builder, matrix, x + 0.0F, y + 0.0F, z + 1.0F);
      vertex(builder, matrix, x + 0.0F, y + 1.0F, z + 1.0F);
      vertex(builder, matrix, x + 0.0F, y + 1.0F, z + 0.0F);
   }

   private static void addEast(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      vertex(builder, matrix, x + 1.0F, y + 0.0F, z + 1.0F);
      vertex(builder, matrix, x + 1.0F, y + 0.0F, z + 0.0F);
      vertex(builder, matrix, x + 1.0F, y + 1.0F, z + 0.0F);
      vertex(builder, matrix, x + 1.0F, y + 1.0F, z + 1.0F);
   }

   private static void addUp(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      vertex(builder, matrix, x + 0.0F, y + 1.0F, z + 1.0F);
      vertex(builder, matrix, x + 1.0F, y + 1.0F, z + 1.0F);
      vertex(builder, matrix, x + 1.0F, y + 1.0F, z + 0.0F);
      vertex(builder, matrix, x + 0.0F, y + 1.0F, z + 0.0F);
   }

   private static void addDown(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      vertex(builder, matrix, x + 0.0F, y + 0.0F, z + 0.0F);
      vertex(builder, matrix, x + 1.0F, y + 0.0F, z + 0.0F);
      vertex(builder, matrix, x + 1.0F, y + 0.0F, z + 1.0F);
      vertex(builder, matrix, x + 0.0F, y + 0.0F, z + 1.0F);
   }

   private static void vertex(BufferBuilder builder, Matrix4f matrix, float x, float y, float z) {
      builder.m_252986_(matrix, x, y, z).m_5752_();
   }

   private static void restoreRenderState() {
      GL11.glPolygonOffset(0.0F, 0.0F);
      GL11.glDisable(32823);
      GL11.glStencilMask(255);
      GL11.glDisable(2960);
      RenderSystem.colorMask(true, true, true, true);
      RenderSystem.depthMask(true);
      RenderSystem.enableDepthTest();
      RenderSystem.depthFunc(515);
      RenderSystem.enableCull();
      RenderSystem.disableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private static void clearQueuedPositions() {
      ObjectIterator var0 = QUEUED_SKIES.values().iterator();

      while(var0.hasNext()) {
         LongOpenHashSet positions = (LongOpenHashSet)var0.next();
         positions.clear();
      }

      for(int index = 0; index < activeSkyCount; ++index) {
         ACTIVE_IDS[index] = null;
         ACTIVE_DEFINITIONS[index] = null;
         ACTIVE_POSITIONS[index] = null;
      }

      activeSkyCount = 0;
   }
}
