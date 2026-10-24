package net.mcreator.jujutsucraftv;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.Pack.Position;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.MOD
)
public final class JujutsuBuiltinDatapacks {
   public static final String NORMAL_UNDERGROUND_PACK_ID = "jjcv/optional_normal_underground_generation";

   @SubscribeEvent
   public static void addPackFinders(AddPackFindersEvent event) {
      if (event.getPackType() == PackType.SERVER_DATA) {
         event.addRepositorySource((consumer) -> {
            Pack pack = Pack.m_245429_("jjcv/optional_normal_underground_generation", Component.m_237113_("JJCV Normal Underground Generation"), false, (id) -> new PathPackResources(id, ModList.get().getModFileById("jujutsucraftv").getFile().findResource(new String[]{"builtin_datapacks/standard_dungeon_generation_jjcv"}), false), PackType.SERVER_DATA, Position.TOP, PackSource.f_244201_);
            if (pack != null) {
               consumer.accept(pack);
            }

         });
      }
   }

   private JujutsuBuiltinDatapacks() {
   }
}
