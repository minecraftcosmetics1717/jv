package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraftv.JujutsucraftvMod;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class WeaponUseProcedure {
   public static void execute(final LevelAccessor world, final Entity entity) {
      if (entity != null) {
         ItemStack reset_item = ItemStack.f_41583_;
         double set_num = (double)0.0F;
         double set_num2 = (double)0.0F;
         if (entity.m_6144_()) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            label325: {
               if (var10000.m_41720_() == JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get());
                        _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                     }

                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get());
                        _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F);
                        } else {
                           _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F, false);
                        }
                     }

                     JujutsucraftvMod.queueServerWork(3, () -> {
                        if (entity instanceof Player _player) {
                           ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get())).m_41777_();
                           _setstack.m_41764_(1);
                           ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }

                     });
                     break label325;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F, false);
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get());
                     _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                  }

                  JujutsucraftvMod.queueServerWork(3, () -> {
                     if (entity instanceof Player _player) {
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get())).m_41777_();
                        _setstack.m_41764_(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     if (entity instanceof Player _player) {
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get())).m_41777_();
                        _setstack.m_41764_(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                  });
               }
            }

            if ((GetSelectCursedTechniqueProcedure.execute(entity, (double)1.0F) == (double)-1.0F || GetSelectCursedTechniqueProcedure.execute(entity, (double)2.0F) == (double)-1.0F) && GetPlayerCursePowerFormerProcedure.execute(entity) <= (double)0.0F && !entity.getPersistentData().m_128471_("use_playful_cloud")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemCooldowns var67 = _player.m_36335_();
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.m_21205_();
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     var67.m_41524_(var10001.m_41720_(), 5);
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "/attribute @s jujutsucraft:animation_1 base set -17");
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:grind_metal")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2, (double)1.5F));
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftv:grind_metal")), SoundSource.NEUTRAL, 1.0F, (float)Mth.m_216263_(RandomSource.m_216327_(), 1.2, (double)1.5F), false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Commands var68 = _level.m_7654_().m_129892_();
                     CommandSourceStack var90 = (new CommandSourceStack(CommandSource.f_80164_, new Vec3(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_();
                     double var10002 = (double)entity.m_20206_();
                     var68.m_230957_(var90, "particle jujutsucraft:particle_fire_spark ~ ~" + var10002 * 0.6 + " ~ 0.1 0.1 0.1 0.7 3");
                  }

                  if (((<undefinedtype>)(new Object() {
                     public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                           return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                        } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                           return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                        } else {
                           return false;
                        }
                     }
                  })).checkGamemode(entity)) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get());
                        _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                     }

                     JujutsucraftvMod.queueServerWork(3, () -> {
                        if (entity instanceof Player _player) {
                           ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SHARPENED_PLAYFUL_CLOUD.get())).m_41777_();
                           _setstack.m_41764_(1);
                           ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }

                     });
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21205_();
                        } else {
                           var10000 = ItemStack.f_41583_;
                        }

                        ItemStack _ist = var10000;
                        if (_ist.m_220157_(300, RandomSource.m_216327_(), (ServerPlayer)null)) {
                           _ist.m_41774_(1);
                           _ist.m_41721_(0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     if (var10000.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                        ItemStack var91;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var91 = _livEnt.m_21205_();
                        } else {
                           var91 = ItemStack.f_41583_;
                        }

                        if (1500 < var91.m_41773_()) {
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get());
                              _player.m_150109_().m_36022_((p) -> _stktoremove.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                           }

                           JujutsucraftvMod.queueServerWork(3, () -> {
                              if (entity instanceof Player _player) {
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SHARPENED_PLAYFUL_CLOUD.get())).m_41777_();
                                 _setstack.m_41764_(1);
                                 ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                              }

                           });
                        }
                     }
                  }
               }
            }
         } else {
            ItemStack var72;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var72 = _livEnt.m_21205_();
            } else {
               var72 = ItemStack.f_41583_;
            }

            if (var72.m_41720_() != JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var72 = _livEnt.m_21205_();
               } else {
                  var72 = ItemStack.f_41583_;
               }

               if (var72.m_41720_() != JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21206_();
                  } else {
                     var72 = ItemStack.f_41583_;
                  }

                  if (var72.m_41720_() != JujutsucraftvModItems.CHAIN_OF_A_THOUSAND_MILES.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var72 = _livEnt.m_21206_();
                     } else {
                        var72 = ItemStack.f_41583_;
                     }

                     if (var72.m_41720_() != JujutsucraftvModItems.COMBINED_CHAIN_OF_A_THOUSAND_MILES_AND_INVERTED_SPEAR_OF_HEAVEN.get()) {
                        return;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21206_();
                  } else {
                     var72 = ItemStack.f_41583_;
                  }

                  if (var72.m_41784_().m_128459_("Reach") == (double)1.0F) {
                     set_num = (double)5.0F;
                     set_num2 = (double)1.0F;
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("Middle"), false);
                        }
                     }
                  } else {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var72 = _livEnt.m_21206_();
                     } else {
                        var72 = ItemStack.f_41583_;
                     }

                     if (var72.m_41784_().m_128459_("Reach") == (double)5.0F) {
                        set_num = (double)10.0F;
                        set_num2 = (double)5.0F;
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.m_9236_().m_5776_()) {
                              _player.m_5661_(Component.m_237113_("Long"), false);
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var72 = _livEnt.m_21206_();
                        } else {
                           var72 = ItemStack.f_41583_;
                        }

                        if (var72.m_41784_().m_128459_("Reach") == (double)10.0F) {
                           set_num = (double)1.0F;
                           set_num2 = (double)0.25F;
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_("Short"), false);
                              }
                           }
                        } else {
                           set_num = (double)1.0F;
                           set_num2 = (double)0.25F;
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.m_9236_().m_5776_()) {
                                 _player.m_5661_(Component.m_237113_("Short"), false);
                              }
                           }
                        }
                     }
                  }

                  ((<undefinedtype>)(new Object() {
                     void timedLoop(int _timedLoopIterator, int _timedLoopTotal, int _timedLoopTicks) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F);
                           } else {
                              _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F, false);
                           }
                        }

                        JujutsucraftvMod.queueServerWork(_timedLoopTicks, () -> {
                           if (_timedLoopTotal > _timedLoopIterator + 1) {
                              this.timedLoop(_timedLoopIterator + 1, _timedLoopTotal, _timedLoopTicks);
                           }

                        });
                     }
                  })).timedLoop(0, 6, 1);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21206_();
                  } else {
                     var72 = ItemStack.f_41583_;
                  }

                  var72.m_41784_().m_128347_("Reach", set_num);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21206_();
                  } else {
                     var72 = ItemStack.f_41583_;
                  }

                  var72.m_41784_().m_128347_("Power", set_num2);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21206_();
                  } else {
                     var72 = ItemStack.f_41583_;
                  }

                  WeaponDataDisplayUpdateProcedure.execute(var72);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemCooldowns var89 = _player.m_36335_();
                     ItemStack var93;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var93 = _livEnt.m_21206_();
                     } else {
                        var93 = ItemStack.f_41583_;
                     }

                     var89.m_41524_(var93.m_41720_(), 20);
                  }

                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var72 = _livEnt.m_21205_();
            } else {
               var72 = ItemStack.f_41583_;
            }

            if (var72.m_41784_().m_128459_("Reach") == (double)1.0F) {
               set_num = (double)5.0F;
               set_num2 = (double)1.0F;
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.m_9236_().m_5776_()) {
                     _player.m_5661_(Component.m_237113_("Middle"), false);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var72 = _livEnt.m_21205_();
               } else {
                  var72 = ItemStack.f_41583_;
               }

               if (var72.m_41784_().m_128459_("Reach") == (double)5.0F) {
                  set_num = (double)10.0F;
                  set_num2 = (double)5.0F;
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_("Long"), false);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var72 = _livEnt.m_21205_();
                  } else {
                     var72 = ItemStack.f_41583_;
                  }

                  if (var72.m_41784_().m_128459_("Reach") == (double)10.0F) {
                     set_num = (double)1.0F;
                     set_num2 = (double)0.25F;
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("Short"), false);
                        }
                     }
                  } else {
                     set_num = (double)1.0F;
                     set_num2 = (double)0.25F;
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        if (!_player.m_9236_().m_5776_()) {
                           _player.m_5661_(Component.m_237113_("Short"), false);
                        }
                     }
                  }
               }
            }

            ((<undefinedtype>)(new Object() {
               void timedLoop(int _timedLoopIterator, int _timedLoopTotal, int _timedLoopTicks) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F);
                     } else {
                        _level.m_7785_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, 1.0F, 0.9F, false);
                     }
                  }

                  JujutsucraftvMod.queueServerWork(_timedLoopTicks, () -> {
                     if (_timedLoopTotal > _timedLoopIterator + 1) {
                        this.timedLoop(_timedLoopIterator + 1, _timedLoopTotal, _timedLoopTicks);
                     }

                  });
               }
            })).timedLoop(0, 6, 1);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var72 = _livEnt.m_21205_();
            } else {
               var72 = ItemStack.f_41583_;
            }

            var72.m_41784_().m_128347_("Reach", set_num);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var72 = _livEnt.m_21205_();
            } else {
               var72 = ItemStack.f_41583_;
            }

            var72.m_41784_().m_128347_("Power", set_num2);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var72 = _livEnt.m_21205_();
            } else {
               var72 = ItemStack.f_41583_;
            }

            WeaponDataDisplayUpdateProcedure.execute(var72);
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               ItemCooldowns var80 = _player.m_36335_();
               ItemStack var92;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var92 = _livEnt.m_21205_();
               } else {
                  var92 = ItemStack.f_41583_;
               }

               var80.m_41524_(var92.m_41720_(), 20);
            }
         }

      }
   }
}
