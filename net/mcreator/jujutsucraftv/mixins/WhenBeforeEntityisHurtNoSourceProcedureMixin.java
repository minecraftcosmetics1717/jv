package net.mcreator.jujutsucraftv.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({LivingEntity.class})
public abstract class WhenBeforeEntityisHurtNoSourceProcedureMixin {
   private LivingEntity self = (LivingEntity)this;

   @Inject(
      method = {"hurt"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
      if (source != null && this.self != null) {
         double T1 = (double)0.0F;
         double T2 = (double)0.0F;
         if (!source.m_269533_(TagKey.m_203882_(Registries.f_268580_, new ResourceLocation("forge:animation"))) && !source.m_276093_(DamageTypes.f_268468_) && this.self instanceof Player && this.self.m_9236_().m_7654_().m_129900_().m_46207_(JujutsucraftModGameRules.JUJUTSU_GAIN_FAME)) {
            T1 = ((JujutsucraftModVariables.PlayerVariables)this.self.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
            T2 = ((JujutsucraftModVariables.PlayerVariables)this.self.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
            if (T1 > (double)0.0F || T2 > (double)0.0F) {
               if (T1 != (double)45.0F && T2 != (double)45.0F && T1 != (double)617.0F && T2 != (double)617.0F) {
                  if ((T1 == (double)10.0F || T2 == (double)10.0F || T1 == (double)630.0F || T2 == (double)630.0F) && Math.random() < 0.075 && this.self instanceof ServerPlayer) {
                     ServerPlayer _player = (ServerPlayer)this.self;
                     if (_player.m_9236_() instanceof ServerLevel && _player.m_8960_().m_135996_(_player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                        if (this.self instanceof ServerPlayer) {
                           ServerPlayer _player2 = (ServerPlayer)this.self;
                           Advancement _adv = _player2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"));
                           AdvancementProgress _ap = _player2.m_8960_().m_135996_(_adv);
                           if (!_ap.m_8193_()) {
                              for(String criteria : _ap.m_8219_()) {
                                 _player2.m_8960_().m_135988_(_adv, criteria);
                              }
                           }
                        }
                     } else if (this.self instanceof ServerPlayer) {
                        ServerPlayer _player2 = (ServerPlayer)this.self;
                        Advancement _adv = _player2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"));
                        AdvancementProgress _ap = _player2.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player2.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  }
               } else if (Math.random() < 0.1 && this.self instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)this.self;
                  if (_player.m_9236_() instanceof ServerLevel && _player.m_8960_().m_135996_(_player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                     if (this.self instanceof ServerPlayer) {
                        ServerPlayer _player2 = (ServerPlayer)this.self;
                        Advancement _adv = _player2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"));
                        AdvancementProgress _ap = _player2.m_8960_().m_135996_(_adv);
                        if (!_ap.m_8193_()) {
                           for(String criteria : _ap.m_8219_()) {
                              _player2.m_8960_().m_135988_(_adv, criteria);
                           }
                        }
                     }
                  } else if (this.self instanceof ServerPlayer) {
                     ServerPlayer _player2 = (ServerPlayer)this.self;
                     Advancement _adv = _player2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"));
                     AdvancementProgress _ap = _player2.m_8960_().m_135996_(_adv);
                     if (!_ap.m_8193_()) {
                        for(String criteria : _ap.m_8219_()) {
                           _player2.m_8960_().m_135988_(_adv, criteria);
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
