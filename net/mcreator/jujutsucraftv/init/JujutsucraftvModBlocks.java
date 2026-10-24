package net.mcreator.jujutsucraftv.init;

import net.mcreator.jujutsucraftv.block.BarrierTreeBlock;
import net.mcreator.jujutsucraftv.block.BarrierTreeFenceBlock;
import net.mcreator.jujutsucraftv.block.BrightHalfRedstoneLampBlock;
import net.mcreator.jujutsucraftv.block.BrightRedstoneLampBlock;
import net.mcreator.jujutsucraftv.block.DirtyGlassBlock;
import net.mcreator.jujutsucraftv.block.DirtyGlassPaneBlock;
import net.mcreator.jujutsucraftv.block.DomainBeehive1Block;
import net.mcreator.jujutsucraftv.block.DomainBeehive2Block;
import net.mcreator.jujutsucraftv.block.DomainBlueMagma1Block;
import net.mcreator.jujutsucraftv.block.DomainBlueMagma2Block;
import net.mcreator.jujutsucraftv.block.DomainBlueRock1Block;
import net.mcreator.jujutsucraftv.block.DomainClayBlock;
import net.mcreator.jujutsucraftv.block.DomainDarkSmoothStoneBlock;
import net.mcreator.jujutsucraftv.block.DomainDrumBlock;
import net.mcreator.jujutsucraftv.block.DomainOrangeBlockBlock;
import net.mcreator.jujutsucraftv.block.DomainPaleOrangeBlockBlock;
import net.mcreator.jujutsucraftv.block.DomainRedRock1Block;
import net.mcreator.jujutsucraftv.block.DomainRedRock2Block;
import net.mcreator.jujutsucraftv.block.DomainRock1Block;
import net.mcreator.jujutsucraftv.block.DomainRock2Block;
import net.mcreator.jujutsucraftv.block.DomainSkyBlueBlock;
import net.mcreator.jujutsucraftv.block.DomainSkyEyeBlock;
import net.mcreator.jujutsucraftv.block.DomainSkyNightBlock;
import net.mcreator.jujutsucraftv.block.DomainSmoothStoneBlock;
import net.mcreator.jujutsucraftv.block.DomainTntBlock;
import net.mcreator.jujutsucraftv.block.ElevatorCarpetBlock;
import net.mcreator.jujutsucraftv.block.GrayDoorBlock;
import net.mcreator.jujutsucraftv.block.HalfRedstoneLampBlock;
import net.mcreator.jujutsucraftv.block.JujutsuLaptopBlock;
import net.mcreator.jujutsucraftv.block.NostalgistHandBlock;
import net.mcreator.jujutsucraftv.block.OneTimeSpawnerBlock;
import net.mcreator.jujutsucraftv.block.RedBarrierErosionDirtBlock;
import net.mcreator.jujutsucraftv.block.RockBarrierTreeBlock;
import net.mcreator.jujutsucraftv.block.RockBarrierTreeFenceBlock;
import net.mcreator.jujutsucraftv.block.SlightlyBrightHarfRedstoneLampBlock;
import net.mcreator.jujutsucraftv.block.SlightlyBrightRedstoneLampBlock;
import net.mcreator.jujutsucraftv.block.SlightlyBrightWoodenLanternBlock;
import net.mcreator.jujutsucraftv.block.TombOfTheStarDoorBlock;
import net.mcreator.jujutsucraftv.block.VendingMachineBlock;
import net.mcreator.jujutsucraftv.block.WoodenLanternBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftvModBlocks {
   public static final DeferredRegister<Block> REGISTRY;
   public static final RegistryObject<Block> BRIGHT_REDSTONE_LAMP;
   public static final RegistryObject<Block> SLIGHTLY_BRIGHT_REDSTONE_LAMP;
   public static final RegistryObject<Block> DIRTY_GLASS;
   public static final RegistryObject<Block> DIRTY_GLASS_PANE;
   public static final RegistryObject<Block> ONE_TIME_SPAWNER;
   public static final RegistryObject<Block> DOMAIN_TNT;
   public static final RegistryObject<Block> DOMAIN_RED_ROCK_1;
   public static final RegistryObject<Block> DOMAIN_RED_ROCK_2;
   public static final RegistryObject<Block> DOMAIN_ROCK_1;
   public static final RegistryObject<Block> DOMAIN_BLUE_ROCK_1;
   public static final RegistryObject<Block> DOMAIN_SMOOTH_STONE;
   public static final RegistryObject<Block> DOMAIN_CLAY;
   public static final RegistryObject<Block> DOMAIN_DRUM;
   public static final RegistryObject<Block> DOMAIN_DARK_SMOOTH_STONE;
   public static final RegistryObject<Block> DOMAIN_BLUE_MAGMA_1;
   public static final RegistryObject<Block> DOMAIN_BLUE_MAGMA_2;
   public static final RegistryObject<Block> DOMAIN_BEEHIVE_1;
   public static final RegistryObject<Block> DOMAIN_BEEHIVE_2;
   public static final RegistryObject<Block> DOMAIN_ROCK_2;
   public static final RegistryObject<Block> DOMAIN_ORANGE_BLOCK;
   public static final RegistryObject<Block> DOMAIN_PALE_ORANGE_BLOCK;
   public static final RegistryObject<Block> BARRIER_TREE;
   public static final RegistryObject<Block> BARRIER_TREE_FENCE;
   public static final RegistryObject<Block> TOMB_OF_THE_STAR_DOOR;
   public static final RegistryObject<Block> ELEVATOR_CARPET;
   public static final RegistryObject<Block> NOSTALGIST_HAND;
   public static final RegistryObject<Block> VENDING_MACHINE;
   public static final RegistryObject<Block> DOMAIN_SKY_BLUE;
   public static final RegistryObject<Block> DOMAIN_SKY_NIGHT;
   public static final RegistryObject<Block> DOMAIN_SKY_EYE;
   public static final RegistryObject<Block> ROCK_BARRIER_TREE;
   public static final RegistryObject<Block> ROCK_BARRIER_TREE_FENCE;
   public static final RegistryObject<Block> RED_BARRIER_EROSION_DIRT;
   public static final RegistryObject<Block> BRIGHT_HALF_REDSTONE_LAMP;
   public static final RegistryObject<Block> WOODEN_LANTERN;
   public static final RegistryObject<Block> SLIGHTLY_BRIGHT_WOODEN_LANTERN;
   public static final RegistryObject<Block> SLIGHTLY_BRIGHT_HARF_REDSTONE_LAMP;
   public static final RegistryObject<Block> HALF_REDSTONE_LAMP;
   public static final RegistryObject<Block> JUJUTSU_LAPTOP;
   public static final RegistryObject<Block> GRAY_DOOR;

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "jujutsucraftv");
      BRIGHT_REDSTONE_LAMP = REGISTRY.register("bright_redstone_lamp", () -> new BrightRedstoneLampBlock());
      SLIGHTLY_BRIGHT_REDSTONE_LAMP = REGISTRY.register("slightly_bright_redstone_lamp", () -> new SlightlyBrightRedstoneLampBlock());
      DIRTY_GLASS = REGISTRY.register("dirty_glass", () -> new DirtyGlassBlock());
      DIRTY_GLASS_PANE = REGISTRY.register("dirty_glass_pane", () -> new DirtyGlassPaneBlock());
      ONE_TIME_SPAWNER = REGISTRY.register("one_time_spawner", () -> new OneTimeSpawnerBlock());
      DOMAIN_TNT = REGISTRY.register("domain_tnt", () -> new DomainTntBlock());
      DOMAIN_RED_ROCK_1 = REGISTRY.register("domain_red_rock_1", () -> new DomainRedRock1Block());
      DOMAIN_RED_ROCK_2 = REGISTRY.register("domain_red_rock_2", () -> new DomainRedRock2Block());
      DOMAIN_ROCK_1 = REGISTRY.register("domain_rock_1", () -> new DomainRock1Block());
      DOMAIN_BLUE_ROCK_1 = REGISTRY.register("domain_blue_rock_1", () -> new DomainBlueRock1Block());
      DOMAIN_SMOOTH_STONE = REGISTRY.register("domain_smooth_stone", () -> new DomainSmoothStoneBlock());
      DOMAIN_CLAY = REGISTRY.register("domain_clay", () -> new DomainClayBlock());
      DOMAIN_DRUM = REGISTRY.register("domain_drum", () -> new DomainDrumBlock());
      DOMAIN_DARK_SMOOTH_STONE = REGISTRY.register("domain_dark_smooth_stone", () -> new DomainDarkSmoothStoneBlock());
      DOMAIN_BLUE_MAGMA_1 = REGISTRY.register("domain_blue_magma_1", () -> new DomainBlueMagma1Block());
      DOMAIN_BLUE_MAGMA_2 = REGISTRY.register("domain_blue_magma_2", () -> new DomainBlueMagma2Block());
      DOMAIN_BEEHIVE_1 = REGISTRY.register("domain_beehive_1", () -> new DomainBeehive1Block());
      DOMAIN_BEEHIVE_2 = REGISTRY.register("domain_beehive_2", () -> new DomainBeehive2Block());
      DOMAIN_ROCK_2 = REGISTRY.register("domain_rock_2", () -> new DomainRock2Block());
      DOMAIN_ORANGE_BLOCK = REGISTRY.register("domain_orange_block", () -> new DomainOrangeBlockBlock());
      DOMAIN_PALE_ORANGE_BLOCK = REGISTRY.register("domain_pale_orange_block", () -> new DomainPaleOrangeBlockBlock());
      BARRIER_TREE = REGISTRY.register("barrier_tree", () -> new BarrierTreeBlock());
      BARRIER_TREE_FENCE = REGISTRY.register("barrier_tree_fence", () -> new BarrierTreeFenceBlock());
      TOMB_OF_THE_STAR_DOOR = REGISTRY.register("tomb_of_the_star_door", () -> new TombOfTheStarDoorBlock());
      ELEVATOR_CARPET = REGISTRY.register("elevator_carpet", () -> new ElevatorCarpetBlock());
      NOSTALGIST_HAND = REGISTRY.register("nostalgist_hand", () -> new NostalgistHandBlock());
      VENDING_MACHINE = REGISTRY.register("vending_machine", () -> new VendingMachineBlock());
      DOMAIN_SKY_BLUE = REGISTRY.register("domain_sky_blue", () -> new DomainSkyBlueBlock());
      DOMAIN_SKY_NIGHT = REGISTRY.register("domain_sky_night", () -> new DomainSkyNightBlock());
      DOMAIN_SKY_EYE = REGISTRY.register("domain_sky_eye", () -> new DomainSkyEyeBlock());
      ROCK_BARRIER_TREE = REGISTRY.register("rock_barrier_tree", () -> new RockBarrierTreeBlock());
      ROCK_BARRIER_TREE_FENCE = REGISTRY.register("rock_barrier_tree_fence", () -> new RockBarrierTreeFenceBlock());
      RED_BARRIER_EROSION_DIRT = REGISTRY.register("red_barrier_erosion_dirt", () -> new RedBarrierErosionDirtBlock());
      BRIGHT_HALF_REDSTONE_LAMP = REGISTRY.register("bright_half_redstone_lamp", () -> new BrightHalfRedstoneLampBlock());
      WOODEN_LANTERN = REGISTRY.register("wooden_lantern", () -> new WoodenLanternBlock());
      SLIGHTLY_BRIGHT_WOODEN_LANTERN = REGISTRY.register("slightly_bright_wooden_lantern", () -> new SlightlyBrightWoodenLanternBlock());
      SLIGHTLY_BRIGHT_HARF_REDSTONE_LAMP = REGISTRY.register("slightly_bright_harf_redstone_lamp", () -> new SlightlyBrightHarfRedstoneLampBlock());
      HALF_REDSTONE_LAMP = REGISTRY.register("half_redstone_lamp", () -> new HalfRedstoneLampBlock());
      JUJUTSU_LAPTOP = REGISTRY.register("jujutsu_laptop", () -> new JujutsuLaptopBlock());
      GRAY_DOOR = REGISTRY.register("gray_door", () -> new GrayDoorBlock());
   }

   @EventBusSubscriber(
      bus = Bus.MOD,
      value = {Dist.CLIENT}
   )
   public static class BlocksClientSideHandler {
      @SubscribeEvent
      public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
         DirtyGlassBlock.blockColorLoad(event);
         DirtyGlassPaneBlock.blockColorLoad(event);
         OneTimeSpawnerBlock.blockColorLoad(event);
      }
   }
}
