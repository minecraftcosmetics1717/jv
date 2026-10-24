package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.entity.ShigemoHarutaEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.WhenEntityDieProcedure;
import net.mcreator.jujutsucraftv.item.GloryBraceletItem;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.CuriosApi;

@Mixin(
   value = {WhenEntityDieProcedure.class},
   remap = false
)
public abstract class WhenEntityDieProcedureMixin {
   private static final ThreadLocal<Player> JUJUTSUCRAFTV_FAME_PLAYER = new ThreadLocal();

   @Inject(
      method = {"execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V"},
      at = {@At("HEAD")},
      remap = false
   )
   private static void jujutsucraftv$clearPlayerStart(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      JUJUTSUCRAFTV_FAME_PLAYER.remove();
   }

   @Redirect(
      method = {"execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/world/entity/Entity;getCapability(Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;"
),
      remap = false
   )
   private static <T> LazyOptional<T> jujutsucraftv$captureFamePlayer(Entity entity, Capability<T> capability, Direction direction) {
      if (capability == JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY && entity instanceof Player player) {
         JUJUTSUCRAFTV_FAME_PLAYER.set(player);
      }

      return entity.getCapability(capability, direction);
   }

   @ModifyVariable(
      method = {"execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V"},
      at = @At(
   value = "STORE",
   ordinal = 1
),
      index = 10,
      remap = false
   )
   private static double jujutsucraftv$modifyShigemoFameBase(double fameBase, LevelAccessor world, double x, double y, double z, Entity entity) {
      return entity instanceof ShigemoHarutaEntity ? (double)60.0F : fameBase;
   }

   @ModifyVariable(
      method = {"execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V"},
      at = @At("LOAD"),
      index = 10,
      remap = false
   )
   private static double jujutsucraftv$modifyFinalFameBase(double fameBase) {
      Player player = (Player)JUJUTSUCRAFTV_FAME_PLAYER.get();
      return player != null && jujutsucraftv$hasGloryBracelet(player) ? fameBase * 1.2 : fameBase;
   }

   @Inject(
      method = {"execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V"},
      at = {@At("RETURN")},
      remap = false
   )
   private static void jujutsucraftv$clearPlayerEnd(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
      JUJUTSUCRAFTV_FAME_PLAYER.remove();
   }

   private static boolean jujutsucraftv$hasGloryBracelet(Player player) {
      return CuriosApi.getCuriosInventory(player).resolve().flatMap((handler) -> handler.findFirstCurio((stack) -> stack.m_41720_() instanceof GloryBraceletItem)).isPresent();
   }
}
