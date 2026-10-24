package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.util.Locale;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class JjcvDomainBlockInsideProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, final CommandContext<CommandSourceStack> arguments) {
      if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(StringArgumentType.getString(arguments, "set_domain_block").toLowerCase(Locale.ENGLISH))) instanceof BlockItem) {
         String _setval = StringArgumentType.getString(arguments, "set_domain_block");
         ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity().getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.domain_block_set_inside = _setval;
            capability.syncPlayerVariables(((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity());
         });
         boolean _setval = true;
         ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity().getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerDomainInside = _setval;
            capability.syncPlayerVariables(((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity());
         });
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }
      } else {
         Entity var9 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var9 instanceof Player) {
            Player _player = (Player)var9;
            if (!_player.m_9236_().m_5776_()) {
               String var10001 = StringArgumentType.getString(arguments, "set_domain_block");
               _player.m_5661_(Component.m_237113_(var10001 + Component.m_237115_("jjcv.message.not_item_is_block").getString()), false);
            }
         }
      }

   }
}
