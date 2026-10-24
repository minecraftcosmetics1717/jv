package net.mcreator.jujutsucraftv.client.skyblock;

import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import org.slf4j.Logger;

public final class TextureSkyManager extends SimplePreparableReloadListener<Map<ResourceLocation, TextureSkyDefinition>> {
   private static final Logger LOGGER = LogUtils.getLogger();
   private static final String DIRECTORY = "skyblocks";
   private static final String JSON_SUFFIX = ".json";
   private static final ResourceLocation DEFAULT_DAY_SKY_ID = new ResourceLocation("jujutsucraftv", "domain_sky_blue");
   private static final ResourceLocation DEFAULT_NIGHT_SKY_ID = new ResourceLocation("jujutsucraftv", "domain_sky_night");
   private static final TextureSkyDefinition DEFAULT_DAY_SKY = new TextureSkyDefinition(true, false, (ResourceLocation)null, 1, 48.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F);
   private static final TextureSkyDefinition DEFAULT_NIGHT_SKY = new TextureSkyDefinition(true, true, (ResourceLocation)null, 1, 48.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F);
   private static volatile Map<ResourceLocation, TextureSkyDefinition> definitions = Map.of();

   public static TextureSkyDefinition get(ResourceLocation id) {
      TextureSkyDefinition definition = (TextureSkyDefinition)definitions.get(id);
      if (definition != null) {
         return definition;
      } else if (DEFAULT_DAY_SKY_ID.equals(id)) {
         return DEFAULT_DAY_SKY;
      } else {
         return DEFAULT_NIGHT_SKY_ID.equals(id) ? DEFAULT_NIGHT_SKY : null;
      }
   }

   protected Map<ResourceLocation, TextureSkyDefinition> prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
      Map<ResourceLocation, TextureSkyDefinition> loadedDefinitions = new HashMap();
      Map<ResourceLocation, Resource> resources = resourceManager.m_214159_("skyblocks", (location) -> location.m_135815_().endsWith(".json"));

      for(Map.Entry<ResourceLocation, Resource> entry : resources.entrySet()) {
         ResourceLocation fileLocation = (ResourceLocation)entry.getKey();

         try {
            Reader reader = ((Resource)entry.getValue()).m_215508_();

            try {
               JsonObject json = GsonHelper.m_13859_(reader);
               ResourceLocation skyId = getSkyId(fileLocation);
               TextureSkyDefinition definition = readDefinition(json);
               loadedDefinitions.put(skyId, definition);
            } catch (Throwable var13) {
               if (reader != null) {
                  try {
                     reader.close();
                  } catch (Throwable var12) {
                     var13.addSuppressed(var12);
                  }
               }

               throw var13;
            }

            if (reader != null) {
               reader.close();
            }
         } catch (Exception exception) {
            LOGGER.error("Failed to load sky {}", fileLocation, exception);
         }
      }

      return loadedDefinitions;
   }

   protected void apply(Map<ResourceLocation, TextureSkyDefinition> prepared, ResourceManager resourceManager, ProfilerFiller profiler) {
      definitions = Map.copyOf(prepared);
   }

   private static TextureSkyDefinition readDefinition(JsonObject json) {
      String type = getString(json, "type", "texture");
      boolean night = type.equalsIgnoreCase("night");
      boolean vanilla = night || type.equalsIgnoreCase("day") || type.equalsIgnoreCase("vanilla");
      ResourceLocation texture = null;
      if (!vanilla) {
         texture = new ResourceLocation(GsonHelper.m_13906_(json, "texture"));
      }

      return new TextureSkyDefinition(vanilla, night, texture, getInt(json, "layers", 1), getFloat(json, "base_radius", 48.0F), getFloat(json, "layer_spacing", 0.0F), getFloat(json, "parallax", 0.0F), getFloat(json, "rotation_speed", 0.0F), getFloat(json, "rotation_offset", 0.0F), getFloat(json, "layer_alpha", 1.0F), getFloat(json, "brightness", 1.0F));
   }

   private static String getString(JsonObject json, String key, String defaultValue) {
      return json.has(key) ? GsonHelper.m_13906_(json, key) : defaultValue;
   }

   private static int getInt(JsonObject json, String key, int defaultValue) {
      return json.has(key) ? GsonHelper.m_13927_(json, key) : defaultValue;
   }

   private static float getFloat(JsonObject json, String key, float defaultValue) {
      return json.has(key) ? GsonHelper.m_13915_(json, key) : defaultValue;
   }

   private static ResourceLocation getSkyId(ResourceLocation fileLocation) {
      String path = fileLocation.m_135815_();
      String prefix = "skyblocks/";
      String idPath = path.substring(prefix.length(), path.length() - ".json".length());
      return new ResourceLocation(fileLocation.m_135827_(), idPath);
   }
}
