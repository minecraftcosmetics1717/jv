package net.mcreator.jujutsucraftv.mixins;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({LivingEntityRenderer.class})
public abstract class LivingEntityRendererMixin<T extends LivingEntity> {
}
