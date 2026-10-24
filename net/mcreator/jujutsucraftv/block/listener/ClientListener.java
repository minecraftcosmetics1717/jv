package net.mcreator.jujutsucraftv.block.listener;

import net.mcreator.jujutsucraftv.block.renderer.NostalgistHandTileRenderer;
import net.mcreator.jujutsucraftv.block.renderer.VendingMachineTileRenderer;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.MOD
)
public class ClientListener {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
      event.registerBlockEntityRenderer((BlockEntityType)JujutsucraftvModBlockEntities.NOSTALGIST_HAND.get(), (context) -> new NostalgistHandTileRenderer());
      event.registerBlockEntityRenderer((BlockEntityType)JujutsucraftvModBlockEntities.VENDING_MACHINE.get(), (context) -> new VendingMachineTileRenderer());
   }
}
