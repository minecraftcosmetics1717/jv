package net.mcreator.jujutsucraftv.init;

import com.mojang.datafixers.types.Type;
import net.mcreator.jujutsucraftv.block.entity.DomainBeehive1BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainBeehive2BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainBlueMagma1BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainBlueMagma2BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainBlueRock1BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainClayBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainDarkSmoothStoneBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainDrumBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainOrangeBlockBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainPaleOrangeBlockBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainRedRock1BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainRedRock2BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainRock1BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainRock2BlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainSkyBlueBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainSkyEyeBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainSkyNightBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainSmoothStoneBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.DomainTntBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.ElevatorCarpetBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.NostalgistHandTileEntity;
import net.mcreator.jujutsucraftv.block.entity.OneTimeSpawnerBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.TombOfTheStarDoorBlockEntity;
import net.mcreator.jujutsucraftv.block.entity.VendingMachineTileEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftvModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY;
   public static final RegistryObject<BlockEntityType<?>> ONE_TIME_SPAWNER;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_TNT;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_RED_ROCK_1;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_RED_ROCK_2;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_ROCK_1;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BLUE_ROCK_1;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_SMOOTH_STONE;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_CLAY;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_DRUM;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_DARK_SMOOTH_STONE;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BLUE_MAGMA_1;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BLUE_MAGMA_2;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BEEHIVE_1;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_BEEHIVE_2;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_ROCK_2;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_ORANGE_BLOCK;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_PALE_ORANGE_BLOCK;
   public static final RegistryObject<BlockEntityType<?>> TOMB_OF_THE_STAR_DOOR;
   public static final RegistryObject<BlockEntityType<?>> ELEVATOR_CARPET;
   public static final RegistryObject<BlockEntityType<NostalgistHandTileEntity>> NOSTALGIST_HAND;
   public static final RegistryObject<BlockEntityType<VendingMachineTileEntity>> VENDING_MACHINE;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_SKY_BLUE;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_SKY_NIGHT;
   public static final RegistryObject<BlockEntityType<?>> DOMAIN_SKY_EYE;

   private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> Builder.m_155273_(supplier, new Block[]{(Block)block.get()}).m_58966_((Type)null));
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "jujutsucraftv");
      ONE_TIME_SPAWNER = register("one_time_spawner", JujutsucraftvModBlocks.ONE_TIME_SPAWNER, OneTimeSpawnerBlockEntity::new);
      DOMAIN_TNT = register("domain_tnt", JujutsucraftvModBlocks.DOMAIN_TNT, DomainTntBlockEntity::new);
      DOMAIN_RED_ROCK_1 = register("domain_red_rock_1", JujutsucraftvModBlocks.DOMAIN_RED_ROCK_1, DomainRedRock1BlockEntity::new);
      DOMAIN_RED_ROCK_2 = register("domain_red_rock_2", JujutsucraftvModBlocks.DOMAIN_RED_ROCK_2, DomainRedRock2BlockEntity::new);
      DOMAIN_ROCK_1 = register("domain_rock_1", JujutsucraftvModBlocks.DOMAIN_ROCK_1, DomainRock1BlockEntity::new);
      DOMAIN_BLUE_ROCK_1 = register("domain_blue_rock_1", JujutsucraftvModBlocks.DOMAIN_BLUE_ROCK_1, DomainBlueRock1BlockEntity::new);
      DOMAIN_SMOOTH_STONE = register("domain_smooth_stone", JujutsucraftvModBlocks.DOMAIN_SMOOTH_STONE, DomainSmoothStoneBlockEntity::new);
      DOMAIN_CLAY = register("domain_clay", JujutsucraftvModBlocks.DOMAIN_CLAY, DomainClayBlockEntity::new);
      DOMAIN_DRUM = register("domain_drum", JujutsucraftvModBlocks.DOMAIN_DRUM, DomainDrumBlockEntity::new);
      DOMAIN_DARK_SMOOTH_STONE = register("domain_dark_smooth_stone", JujutsucraftvModBlocks.DOMAIN_DARK_SMOOTH_STONE, DomainDarkSmoothStoneBlockEntity::new);
      DOMAIN_BLUE_MAGMA_1 = register("domain_blue_magma_1", JujutsucraftvModBlocks.DOMAIN_BLUE_MAGMA_1, DomainBlueMagma1BlockEntity::new);
      DOMAIN_BLUE_MAGMA_2 = register("domain_blue_magma_2", JujutsucraftvModBlocks.DOMAIN_BLUE_MAGMA_2, DomainBlueMagma2BlockEntity::new);
      DOMAIN_BEEHIVE_1 = register("domain_beehive_1", JujutsucraftvModBlocks.DOMAIN_BEEHIVE_1, DomainBeehive1BlockEntity::new);
      DOMAIN_BEEHIVE_2 = register("domain_beehive_2", JujutsucraftvModBlocks.DOMAIN_BEEHIVE_2, DomainBeehive2BlockEntity::new);
      DOMAIN_ROCK_2 = register("domain_rock_2", JujutsucraftvModBlocks.DOMAIN_ROCK_2, DomainRock2BlockEntity::new);
      DOMAIN_ORANGE_BLOCK = register("domain_orange_block", JujutsucraftvModBlocks.DOMAIN_ORANGE_BLOCK, DomainOrangeBlockBlockEntity::new);
      DOMAIN_PALE_ORANGE_BLOCK = register("domain_pale_orange_block", JujutsucraftvModBlocks.DOMAIN_PALE_ORANGE_BLOCK, DomainPaleOrangeBlockBlockEntity::new);
      TOMB_OF_THE_STAR_DOOR = register("tomb_of_the_star_door", JujutsucraftvModBlocks.TOMB_OF_THE_STAR_DOOR, TombOfTheStarDoorBlockEntity::new);
      ELEVATOR_CARPET = register("elevator_carpet", JujutsucraftvModBlocks.ELEVATOR_CARPET, ElevatorCarpetBlockEntity::new);
      NOSTALGIST_HAND = REGISTRY.register("nostalgist_hand", () -> Builder.m_155273_(NostalgistHandTileEntity::new, new Block[]{(Block)JujutsucraftvModBlocks.NOSTALGIST_HAND.get()}).m_58966_((Type)null));
      VENDING_MACHINE = REGISTRY.register("vending_machine", () -> Builder.m_155273_(VendingMachineTileEntity::new, new Block[]{(Block)JujutsucraftvModBlocks.VENDING_MACHINE.get()}).m_58966_((Type)null));
      DOMAIN_SKY_BLUE = register("domain_sky_blue", JujutsucraftvModBlocks.DOMAIN_SKY_BLUE, DomainSkyBlueBlockEntity::new);
      DOMAIN_SKY_NIGHT = register("domain_sky_night", JujutsucraftvModBlocks.DOMAIN_SKY_NIGHT, DomainSkyNightBlockEntity::new);
      DOMAIN_SKY_EYE = register("domain_sky_eye", JujutsucraftvModBlocks.DOMAIN_SKY_EYE, DomainSkyEyeBlockEntity::new);
   }
}
