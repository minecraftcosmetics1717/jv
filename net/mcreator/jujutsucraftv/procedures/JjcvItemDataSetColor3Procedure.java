package net.mcreator.jujutsucraftv.procedures;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
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

public class JjcvItemDataSetColor3Procedure {
   public static void execute(LevelAccessor world, double x, double y, double z, final CommandContext<CommandSourceStack> arguments) {
      Entity var10 = ((<undefinedtype>)(new Object() {
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
      if (var10 instanceof LivingEntity _livEnt) {
         var10000 = _livEnt.m_21205_();
      } else {
         var10000 = ItemStack.f_41583_;
      }

      if (var10000.m_41720_() == Blocks.f_50016_.m_5456_()) {
         var10 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var10 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var10;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == Blocks.f_50016_.m_5456_()) {
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
            if (var18 instanceof Player) {
               Player _player = (Player)var18;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), false);
                  return;
               }
            }

            return;
         }
      }

      if (BoolArgumentType.getBool(arguments, "offhand")) {
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
         if (var11 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var11;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         var10000.m_41784_().m_128359_("color3", StringArgumentType.getString(arguments, "particle_id"));
      } else {
         Entity var17 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var17 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var17;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         var10000.m_41784_().m_128359_("color3", StringArgumentType.getString(arguments, "particle_id"));
      }

      if (world instanceof Level _level) {
         if (_level.m_5776_()) {
            _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
         }
      }

   }
}
