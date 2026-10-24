package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class JjcvItemDataSetSlashColorProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, final CommandContext<CommandSourceStack> arguments) {
      String color = "";
      Entity var11 = ((<undefinedtype>)(new Object() {
         public Entity getEntity() {
            try {
               return EntityArgument.m_91452_(arguments, "entity");
            } catch (CommandSyntaxException e) {
               e.printStackTrace();
               return null;
            }
         }
      })).getEntity();
      ItemStack var10000;
      if (var11 instanceof LivingEntity _livEnt) {
         var10000 = _livEnt.m_21205_();
      } else {
         var10000 = ItemStack.f_41583_;
      }

      if (var10000.m_41720_() == Blocks.f_50016_.m_5456_()) {
         var11 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var11 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var11;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == Blocks.f_50016_.m_5456_()) {
            Entity var19 = ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity();
            if (var19 instanceof Player) {
               Player _player = (Player)var19;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), false);
                  return;
               }
            }

            return;
         }
      }

      if (DoubleArgumentType.getDouble(arguments, "num") == (double)0.0F) {
         color = "slash_blue";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)1.0F) {
         color = "slash_black";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)2.0F) {
         color = "slash_white";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)3.0F) {
         color = "slash_red";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)4.0F) {
         color = "slash_blue2";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)5.0F) {
         color = "slash_green";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)6.0F) {
         color = "slash_yellow";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)7.0F) {
         color = "slash_purple";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)8.0F) {
         color = "slash_flame";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)9.0F) {
         color = "slash_flame_blue";
      } else if (DoubleArgumentType.getDouble(arguments, "num") == (double)10.0F) {
         color = "slash_flame_green";
      }

      if (BoolArgumentType.getBool(arguments, "offhand")) {
         Entity var12 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var12 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var12;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         var10000.m_41784_().m_128359_("slash_color", color);
      } else {
         Entity var18 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var18 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var18;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         var10000.m_41784_().m_128359_("slash_color", color);
      }

      if (world instanceof Level _level) {
         if (_level.m_5776_()) {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
         }
      }

   }
}
