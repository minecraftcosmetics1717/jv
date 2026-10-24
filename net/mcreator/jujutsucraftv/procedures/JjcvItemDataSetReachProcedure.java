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

public class JjcvItemDataSetReachProcedure {
   public static void execute(LevelAccessor world, final CommandContext<CommandSourceStack> arguments) {
      Entity var4 = ((<undefinedtype>)(new Object() {
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
      if (var4 instanceof LivingEntity _livEnt) {
         var10000 = _livEnt.m_21205_();
      } else {
         var10000 = ItemStack.f_41583_;
      }

      if (var10000.m_41720_() == Blocks.f_50016_.m_5456_()) {
         var4 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var4 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var4;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == Blocks.f_50016_.m_5456_()) {
            Entity var16 = ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity();
            if (var16 instanceof Player) {
               Player _player = (Player)var16;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_(Component.m_237115_("jjcv.cant_use").getString()), false);
                  return;
               }
            }

            return;
         }
      }

      if (BoolArgumentType.getBool(arguments, "offhand")) {
         Entity var5 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var5 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var5;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         var10000.m_41784_().m_128347_("Reach", DoubleArgumentType.getDouble(arguments, "num"));
         var5 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var5 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var5;
            var10000 = _livEnt.m_21206_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         WeaponDataDisplayUpdateProcedure.execute(var10000);
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
         if (var14 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var14;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         var10000.m_41784_().m_128347_("Reach", DoubleArgumentType.getDouble(arguments, "num"));
         var14 = ((<undefinedtype>)(new Object() {
            public Entity getEntity() {
               try {
                  return EntityArgument.m_91452_(arguments, "entity");
               } catch (CommandSyntaxException e) {
                  e.printStackTrace();
                  return null;
               }
            }
         })).getEntity();
         if (var14 instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)var14;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         WeaponDataDisplayUpdateProcedure.execute(var10000);
      }

      if (world instanceof Level _level) {
         if (_level.m_5776_()) {
            _level.m_7785_(((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().m_20185_(), ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().m_20186_(), ((<undefinedtype>)(new Object() {
               public Entity getEntity() {
                  try {
                     return EntityArgument.m_91452_(arguments, "entity");
                  } catch (CommandSyntaxException e) {
                     e.printStackTrace();
                     return null;
                  }
               }
            })).getEntity().m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
         }
      }

   }
}
