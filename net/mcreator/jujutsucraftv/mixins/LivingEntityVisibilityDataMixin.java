package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraftv.JJCVVisibilityEntity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({LivingEntity.class})
public abstract class LivingEntityVisibilityDataMixin implements JJCVVisibilityEntity {
}
