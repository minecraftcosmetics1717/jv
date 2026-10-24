package net.mcreator.jujutsucraftv.entity.model;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.mcreator.jujutsucraftv.entity.CloneDomainObjectEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.HttpTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.loading.FMLPaths;
import software.bernie.geckolib.model.GeoModel;

public class CloneDomainObjectModel extends GeoModel<CloneDomainObjectEntity> {
   private static final MinecraftSessionService sessionService = Minecraft.m_91087_().m_91108_();
   private final TextureManager textureManager = Minecraft.m_91087_().m_91097_();
   private final Map<UUID, ResourceLocation> skinCache = new HashMap();

   public ResourceLocation getAnimationResource(CloneDomainObjectEntity entity) {
      return new ResourceLocation("jujutsucraftv", "animations/domain_object_clone.animation.json");
   }

   public ResourceLocation getModelResource(CloneDomainObjectEntity entity) {
      return new ResourceLocation("jujutsucraftv", "geo/domain_object_clone.geo.json");
   }

   public ResourceLocation getTextureResource(CloneDomainObjectEntity entity) {
      UUID ownerUUID = entity.m_21805_();
      if (ownerUUID != null) {
         if (this.skinCache.containsKey(ownerUUID)) {
            return (ResourceLocation)this.skinCache.get(ownerUUID);
         } else {
            ResourceLocation skin = this.getPlayerSkin(ownerUUID);
            this.skinCache.put(ownerUUID, skin);
            return skin;
         }
      } else {
         return new ResourceLocation("jujutsucraftv", "textures/entities/" + entity.getTexture() + ".png");
      }
   }

   private ResourceLocation getPlayerSkin(UUID uuid) {
      GameProfile profile = new GameProfile(uuid, (String)null);
      Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> textures = sessionService.getTextures(sessionService.fillProfileProperties(profile, false), false);
      if (textures.containsKey(Type.SKIN)) {
         MinecraftProfileTexture profileTexture = (MinecraftProfileTexture)textures.get(Type.SKIN);
         String skinUrl = profileTexture.getUrl();
         String skinHash = profileTexture.getHash();
         ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash);
         File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
         File skinFile = new File(skinDir, skinHash + ".png");
         if (!skinDir.exists()) {
            skinDir.mkdirs();
         }

         if (!skinFile.exists()) {
            try {
               this.downloadSkin(skinUrl, skinFile);
            } catch (IOException e) {
               e.printStackTrace();
               return DefaultPlayerSkin.m_118627_(uuid);
            }
         }

         HttpTexture httpTexture = new HttpTexture(skinFile, skinUrl, DefaultPlayerSkin.m_118627_(uuid), false, (Runnable)null);
         this.textureManager.m_118495_(resourceLocation, httpTexture);
         return resourceLocation;
      } else {
         return DefaultPlayerSkin.m_118627_(uuid);
      }
   }

   private void downloadSkin(String skinUrl, File skinFile) throws IOException {
      HttpURLConnection connection = (HttpURLConnection)(new URL(skinUrl)).openConnection();
      connection.setRequestMethod("GET");
      connection.setConnectTimeout(3000);
      connection.setReadTimeout(3000);

      try {
         InputStream inputStream = connection.getInputStream();

         try {
            Files.copy(inputStream, skinFile.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
         } catch (Throwable var12) {
            if (inputStream != null) {
               try {
                  inputStream.close();
               } catch (Throwable var11) {
                  var12.addSuppressed(var11);
               }
            }

            throw var12;
         }

         if (inputStream != null) {
            inputStream.close();
         }
      } finally {
         connection.disconnect();
      }

   }
}
