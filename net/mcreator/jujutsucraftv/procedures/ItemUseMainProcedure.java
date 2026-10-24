package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemUseMainProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String txt = "";
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "");
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftvModItems.FOUNDATION_STONE.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41784_().m_128459_("tex") == (double)5.0F) {
               txt = "0.8 0 0.8 0.5";
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41784_().m_128459_("tex") == (double)7.0F) {
                  txt = "1 0 0 0.5";
               } else {
                  txt = "0 0.7 1 0.5";
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 0.65F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 0.65F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraftv:particle_barrier_shard_dust " + txt + " ~ ~1 ~ 0.1 0.1 0.1 0.03 5");
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack(Blocks.f_50016_)).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         }

      }
   }
}
