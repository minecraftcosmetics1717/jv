package net.mcreator.jujutsucraftv.procedures;

import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade06Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade08Entity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade212Entity;
import net.mcreator.jujutsucraft.entity.EntityImpactWaveEntity;
import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.mcreator.jujutsucraft.entity.FushiguroMegumiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.KukuruEntity;
import net.mcreator.jujutsucraft.entity.KumiyaJuzoEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.MimikoEntity;
import net.mcreator.jujutsucraft.entity.NanakoEntity;
import net.mcreator.jujutsucraft.entity.NobaraKugisakiEntity;
import net.mcreator.jujutsucraft.entity.RozetsuEntity;
import net.mcreator.jujutsucraft.entity.SeaSerpentEntity;
import net.mcreator.jujutsucraft.entity.ShigemoHarutaEntity;
import net.mcreator.jujutsucraft.entity.TakadaEntity;
import net.mcreator.jujutsucraft.entity.TransfiguredHumanEntity;
import net.mcreator.jujutsucraft.entity.ZeninNobuakiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModItems;
import net.mcreator.jujutsucraftv.init.JujutsucraftvModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class JujutsuEntitySpawnSetProcedure {
   @SubscribeEvent
   public static void onEntitySpawned(EntityJoinLevelEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double colorCode = (double)0.0F;
         if (entity instanceof KukuruEntity) {
            if (Mth.m_216271_(RandomSource.m_216327_(), 1, 10) <= 6) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_KUKURU.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 3) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_KUKURU.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (Mth.m_216271_(RandomSource.m_216327_(), 1, 3) == 1) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_KUKURU.get()));
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_KUKURU.get()));
                     }
                  }
               }
            } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, 2) == 1) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.KNIFE_KUKURU.get())).m_41777_();
                  _setstack.m_41764_(1);
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (Mth.m_216271_(RandomSource.m_216327_(), 1, 5) == 5) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.KNIFE_KUKURU.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.KNIFE_KUKURU.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.NAGINATA_KUKURU.get())).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         }

         if (entity instanceof MahitoEntity) {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_HELMET.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_HELMET.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_CHESTPLATE.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_CHESTPLATE.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_LEGGINGS.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_LEGGINGS.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_BOOTS.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_MAHITO_BOOTS.get()));
            }
         }

         if (entity instanceof SeaSerpentEntity && entity instanceof SeaSerpentEntity) {
            SeaSerpentEntity animatable = (SeaSerpentEntity)entity;
            double var32 = Math.random();
            animatable.setTexture("dagon_fish" + Math.round(Math.ceil(var32 * (double)10.0F)));
         }

         if (entity instanceof TransfiguredHumanEntity && entity instanceof TransfiguredHumanEntity) {
            TransfiguredHumanEntity animatable = (TransfiguredHumanEntity)entity;
            double var33 = Math.random();
            animatable.setTexture("idle_transfiguration_skin" + Math.round(Math.ceil(var33 * (double)13.0F)));
         }

         if (entity instanceof FushiguroMegumiShibuyaEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.IRON_GREAT_SWORD.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof FushiguroMegumiEntity && Math.random() * (double)3.0F == (double)3.0F) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.WOODEN_TONFA.get())).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.WOODEN_TONFA.get())).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         }

         if (entity instanceof CursedSpiritGrade06Entity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.AKURO_O_OTAKE_AXE.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof CursedSpiritGrade08Entity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_SAMURAI_IN_ARMOR.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof KumiyaJuzoEntity) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != JujutsucraftModItems.DRAGON_BONE.get() && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.KUMIYA_AXE.get())).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         }

         if (entity instanceof NanakoEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.NANAKO_SMARTPHONE.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof MimikoEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.MIMIKO_DOLL.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof ZeninNobuakiEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SWORD_NOBUAKI.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof FushiguroTojiBugEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.SHARPENED_PLAYFUL_CLOUD.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

         if (entity instanceof TakadaEntity) {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_HELMET.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_HELMET.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_CHESTPLATE.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_CHESTPLATE.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_LEGGINGS.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_LEGGINGS.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_BOOTS.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftvModItems.CLOTHES_TAKADA_UNIFORM_BOOTS.get()));
            }
         }

         if (entity instanceof NobaraKugisakiEntity) {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_HELMET.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_HELMET.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_CHESTPLATE.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_CHESTPLATE.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_LEGGINGS.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_LEGGINGS.get()));
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               _player.m_150109_().f_35975_.set(0, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_BOOTS.get()));
               _player.m_150109_().m_6596_();
            } else if (entity instanceof LivingEntity) {
               LivingEntity _living = (LivingEntity)entity;
               _living.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)JujutsucraftvModItems.UNIFORM_KUGISAKI_BOOTS.get()));
            }
         }

         if (entity instanceof EntityImpactWaveEntity && entity.getPersistentData().m_128471_("owner_set_curse_power_color") && entity instanceof EntityImpactWaveEntity) {
            EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entity;
            colorCode = entity.getPersistentData().m_128459_("set_curse_power_color");
            if (colorCode == (double)0.0F) {
               animatable.setTexture("white");
               colorCode = (double)11.0F;
            } else {
               if (colorCode == (double)1.0F || colorCode == (double)17.0F || colorCode == (double)19.0F) {
                  animatable.setTexture("blue");
                  colorCode = (double)1.0F;
               }

               if (colorCode == (double)3.0F || colorCode == (double)20.0F || colorCode == (double)21.0F) {
                  animatable.setTexture("red");
                  colorCode = (double)3.0F;
               }

               if (colorCode == (double)4.0F) {
                  animatable.setTexture("green");
                  colorCode = (double)4.0F;
               }

               if (colorCode == (double)5.0F || colorCode == (double)14.0F) {
                  animatable.setTexture("purple");
                  colorCode = (double)5.0F;
               }

               if (colorCode == (double)6.0F || colorCode == (double)26.0F) {
                  animatable.setTexture("yellow");
                  colorCode = (double)6.0F;
               }

               if (colorCode == (double)7.0F) {
                  animatable.setTexture("pink");
                  colorCode = (double)7.0F;
               }

               if (colorCode == (double)8.0F || colorCode == (double)18.0F) {
                  animatable.setTexture("deep_blue");
                  colorCode = (double)8.0F;
               }

               if (colorCode == (double)9.0F) {
                  animatable.setTexture("deep_green");
                  colorCode = (double)9.0F;
               }

               if (colorCode == (double)10.0F || colorCode == (double)13.0F || colorCode == (double)16.0F || colorCode == (double)15.0F || colorCode == (double)22.0F) {
                  animatable.setTexture("black");
                  colorCode = (double)10.0F;
               }

               if (colorCode == (double)11.0F || colorCode == (double)12.0F || colorCode == (double)23.0F || colorCode == (double)24.0F || colorCode == (double)25.0F) {
                  animatable.setTexture("white");
                  colorCode = (double)11.0F;
               }
            }

            entity.m_20088_().m_135381_(EntityImpactWaveEntity.DATA_mode, (int)colorCode + 5);
         }

         if (entity instanceof ShigemoHarutaEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftvModMobEffects.EFFECT_MIRACLE_SAVINGS.get(), Integer.MAX_VALUE, 6, false, false));
            }
         }

         if (entity instanceof CursedSpiritGrade212Entity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CLEAVER.get())).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.CLEAVER.get())).m_41777_();
               _setstack.m_41764_(1);
               _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.m_150109_().m_6596_();
               }
            }
         }

         if (entity instanceof RozetsuEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftvModItems.ROZETSU_HAND.get())).m_41777_();
            _setstack.m_41764_(1);
            _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
            if (_entity instanceof Player) {
               Player _player = (Player)_entity;
               _player.m_150109_().m_6596_();
            }
         }

      }
   }
}
