package net.mcreator.jujutsucraftv;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModAttributes;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlocks;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModEntities;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMenus;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModParticleTypes;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModSounds;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModTabs;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModVillagerProfessions;
import net.mcreator.jujutsucraftv.world.features.StructureFeature;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("jujutsucraftv")
public class JujutsucraftvMod {
   public static final Logger LOGGER = LogManager.getLogger(JujutsucraftvMod.class);
   public static final String MODID = "jujutsucraftv";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("jujutsucraftv", "jujutsucraftv"), () -> "1", "1"::equals, "1"::equals);
   private static int messageID = 0;
   private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue();

   public JujutsucraftvMod() {
      MinecraftForge.EVENT_BUS.register(this);
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      JujutsucraftvModSounds.REGISTRY.register(bus);
      JujutsucraftvModBlocks.REGISTRY.register(bus);
      JujutsucraftvModBlockEntities.REGISTRY.register(bus);
      JujutsucraftvModItems.REGISTRY.register(bus);
      JujutsucraftvModEntities.REGISTRY.register(bus);
      JujutsucraftvModTabs.REGISTRY.register(bus);
      StructureFeature.REGISTRY.register(bus);
      JujutsucraftvModMobEffects.REGISTRY.register(bus);
      JujutsucraftvModParticleTypes.REGISTRY.register(bus);
      JujutsucraftvModVillagerProfessions.PROFESSIONS.register(bus);
      JujutsucraftvModMenus.REGISTRY.register(bus);
      JujutsucraftvModAttributes.REGISTRY.register(bus);
   }

   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      ++messageID;
   }

   public static void queueServerWork(int tick, Runnable action) {
      if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
         workQueue.add(new AbstractMap.SimpleEntry(action, tick));
      }

   }

   @SubscribeEvent
   public void tick(TickEvent.ServerTickEvent event) {
      if (event.phase == Phase.END) {
         List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList();
         workQueue.forEach((work) -> {
            work.setValue((Integer)work.getValue() - 1);
            if ((Integer)work.getValue() == 0) {
               actions.add(work);
            }

         });
         actions.forEach((e) -> ((Runnable)e.getKey()).run());
         workQueue.removeAll(actions);
      }

   }
}
