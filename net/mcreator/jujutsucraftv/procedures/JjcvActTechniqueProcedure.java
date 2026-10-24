package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class JjcvActTechniqueProcedure {
   public static void execute(final CommandContext<CommandSourceStack> arguments) {
      double cost = (double)0.0F;
      double cost_a = (double)0.0F;
      if (!GetCanUseTechniqueProcedure.execute(((<undefinedtype>)(new Object() {
         public Entity getEntity() {
            try {
               return EntityArgument.m_91452_(arguments, "entity");
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return null;
            }
         }
      })).getEntity())) {
         cost_a = ((JujutsucraftModVariables.PlayerVariables)((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity().getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - DoubleArgumentType.getDouble(arguments, "cost");
         if (!(cost_a < (double)0.0F)) {
            ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().getPersistentData().m_128347_("skill", DoubleArgumentType.getDouble(arguments, "select_technique"));
            ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().getPersistentData().m_128347_("cost", DoubleArgumentType.getDouble(arguments, "cost"));
            ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().getPersistentData().m_128379_("PRESS_Z", true);
            Entity var6 = ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity();
            if (var6 instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)var6;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.COUNT_TIME.get(), (int)((DoubleArgumentType.getDouble(arguments, "charge") + (double)5.0F) * (double)20.0F), (int)DoubleArgumentType.getDouble(arguments, "charge"), false, false));
               }
            }

            Entity _ent = ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity();
            if (!_ent.m_9236_().m_5776_() && _ent.m_20194_() != null) {
               Commands var10000 = _ent.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent);
               double var10002 = DoubleArgumentType.getDouble(arguments, "charge") + (double)1.0F;
               var10000.m_230957_(var10001, "/effect give @s jujutsucraft:cursed_technique " + Math.round(var10002 * (double)5.0F) + " 0 true");
            }

            cost = ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().getPersistentData().m_128459_("cost") * (double)-1.0F;
            if (DoubleArgumentType.getDouble(arguments, "cost") > (double)0.0F) {
               _ent = ((<undefinedtype>)(new Object() {
                  public Entity getEntity() {
                     try {
                        return EntityArgument.m_91452_(arguments, "entity");
                     } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                     }
                  }
               })).getEntity();
               if (!_ent.m_9236_().m_5776_() && _ent.m_20194_() != null) {
                  _ent.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, _ent.m_20182_(), _ent.m_20155_(), _ent.m_9236_() instanceof ServerLevel ? (ServerLevel)_ent.m_9236_() : null, 4, _ent.m_7755_().getString(), _ent.m_5446_(), _ent.m_9236_().m_7654_(), _ent), "/jjc_cursepower " + Math.round(cost) + " @s");
               }
            }
         } else {
            Entity var13 = ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity();
            if (var13 instanceof Player) {
               Player _player = (Player)var13;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
               }
            }
         }
      } else {
         Entity var14 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var14 instanceof Player) {
            Player _player = (Player)var14;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), true);
            }
         }
      }

   }
}
