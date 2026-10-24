package net.mcreator.jujutsucraftv.init;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModVillagerProfessions {
   private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap();
   public static final DeferredRegister<VillagerProfession> PROFESSIONS;
   public static final RegistryObject<VillagerProfession> JUJUTSU_WINDOW;

   private static RegistryObject<VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
      POI_TYPES.put(name, new ProfessionPoiType(block, (Holder)null));
      return PROFESSIONS.register(name, () -> {
         Predicate<Holder<PoiType>> poiPredicate = (poiTypeHolder) -> ((ProfessionPoiType)POI_TYPES.get(name)).poiType != null && poiTypeHolder.get() == ((ProfessionPoiType)POI_TYPES.get(name)).poiType.get();
         return new VillagerProfession("jujutsucraftv:" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), (SoundEvent)soundEvent.get());
      });
   }

   @SubscribeEvent
   public static void registerProfessionPointsOfInterest(RegisterEvent event) {
      event.register(Keys.POI_TYPES, (registerHelper) -> {
         for(Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
            Block block = (Block)((ProfessionPoiType)entry.getValue()).block.get();
            String name = (String)entry.getKey();
            Optional<Holder<PoiType>> existingCheck = PoiTypes.m_218075_(block.m_49966_());
            if (existingCheck.isPresent()) {
               JujutsucraftvMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + String.valueOf(block) + " that is already in use by " + String.valueOf(existingCheck));
            } else {
               PoiType poiType = new PoiType(ImmutableSet.copyOf(block.m_49965_().m_61056_()), 1, 1);
               registerHelper.register(name, poiType);
               ((ProfessionPoiType)entry.getValue()).poiType = (Holder)ForgeRegistries.POI_TYPES.getHolder(poiType).get();
            }
         }

      });
   }

   static {
      PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, "jujutsucraftv");
      JUJUTSU_WINDOW = registerProfession("jujutsu_window", () -> (Block)JujutsucraftvModBlocks.JUJUTSU_LAPTOP.get(), () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:keyboard_sound")));
   }

   private static class ProfessionPoiType {
      final Supplier<Block> block;
      Holder<PoiType> poiType;

      ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
         this.block = block;
         this.poiType = poiType;
      }
   }
}
