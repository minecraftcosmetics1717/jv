package net.mcreator.jujutsucraftv.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "jujutsucraftv",
   bus = Bus.FORGE,
   value = {Dist.CLIENT}
)
public class PlayerRenderCore {
}
