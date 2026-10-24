package net.mcreator.jujutsucraftv.mixins;

import java.util.Iterator;
import java.util.List;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade01Entity;
import net.mcreator.jujutsucraft.entity.DivineDogTotalityEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.MergedBeastAgitoEntity;
import net.mcreator.jujutsucraft.entity.NueEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.entity.RoundDeerEntity;
import net.mcreator.jujutsucraft.entity.RozetsuEntity;
import net.mcreator.jujutsucraft.entity.RozetsuShikigamiEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.ReturnInsideItemProcedure;
import net.mcreator.jujutsucraft.procedures.SixEyesOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.mcreator.jujutsucraftv.procedures.ReturnEnergyColor3Procedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({SixEyesOnEffectActiveTickProcedure.class})
public abstract class SixEyesOnEffectActiveTickProcedureMixin {
   @Overwrite(
      remap = false
   )
   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String color_name = "";
         boolean logic_a = false;
         double x_pos = (double)0.0F;
         double y_pos = (double)0.0F;
         double z_pos = (double)0.0F;
         double distance = (double)0.0F;
         double level_strength = (double)0.0F;
         double color = (double)0.0F;
         double num_loop = (double)0.0F;
         double speed = (double)0.0F;
         double amount = (double)0.0F;
         double CT1 = (double)0.0F;
         double CT2 = (double)0.0F;
         if (entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19611_, 219, 0, false, false));
               }
            }

            if (entity instanceof Player) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:blindfold")))) {
                  if (Math.random() < (double)0.25F) {
                     Vec3 _center = new Vec3(x, y, z);
                     List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)16.0F), (e) -> true);
                     Iterator var35 = _entfound.iterator();

                     while(true) {
                        Entity entityiterator;
                        while(true) {
                           if (!var35.hasNext()) {
                              return;
                           }

                           entityiterator = (Entity)var35.next();
                           if (entity != entityiterator) {
                              label343: {
                                 color = (double)0.0F;
                                 amount = (double)1.0F;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt6 = (LivingEntity)entityiterator;
                                    if (_livEnt6.m_21023_(MobEffects.f_19600_)) {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          var83 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       } else {
                                          var83 = 0;
                                       }

                                       ++var83;
                                       break label343;
                                    }
                                 }

                                 var83 = 0;
                              }

                              level_strength = (double)var83;
                              CT1 = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                              CT2 = ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt8 = (LivingEntity)entityiterator;
                                 if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    color = (double)2.0F;
                                    amount = (double)4.0F;
                                    break;
                                 }
                              }

                              label451: {
                                 if (entityiterator instanceof Player) {
                                    if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == (double)0.0F) {
                                       break label451;
                                    }
                                 } else if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:no_curse_power")))) {
                                    break label451;
                                 }

                                 if (entityiterator instanceof ItemEntity) {
                                    if (entityiterator instanceof ItemEntity) {
                                       ItemEntity _itemEnt = (ItemEntity)entityiterator;
                                       var10000 = _itemEnt.m_32055_();
                                    } else {
                                       var10000 = ItemStack.f_41583_;
                                    }

                                    if (!var10000.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                                       break label451;
                                    }
                                 }

                                 label452: {
                                    if (entityiterator instanceof Player) {
                                       if (CT1 == (double)5.0F || CT2 == (double)5.0F) {
                                          break label452;
                                       }
                                    } else if (entityiterator instanceof OkkotsuYutaEntity || entityiterator instanceof RikaEntity || entityiterator instanceof OkkotsuYutaCullingGameEntity || entityiterator instanceof Rika2Entity) {
                                       break label452;
                                    }

                                    label454: {
                                       if (entityiterator instanceof Player) {
                                          if (CT1 == (double)7.0F || CT2 == (double)7.0F) {
                                             break label454;
                                          }
                                       } else if (entityiterator instanceof KashimoHajimeEntity || entityiterator instanceof NueEntity || entityiterator instanceof MergedBeastAgitoEntity) {
                                          break label454;
                                       }

                                       label370: {
                                          if (entityiterator instanceof Player) {
                                             if (CT1 == (double)4.0F || CT2 == (double)4.0F || CT1 == (double)15.0F || CT2 == (double)15.0F || CT1 == (double)43.0F || CT2 == (double)43.0F) {
                                                break label370;
                                             }
                                          } else if (entityiterator instanceof RozetsuEntity || entityiterator instanceof RozetsuShikigamiEntity || entityiterator instanceof JogoEntity || entityiterator instanceof MahitoEntity) {
                                             break label370;
                                          }

                                          if (entityiterator instanceof CursedSpiritGrade01Entity) {
                                             color = (double)2.0F;
                                          } else if (entityiterator instanceof RoundDeerEntity) {
                                             color = (double)4.0F;
                                          } else if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                                             color = (double)5.0F;
                                          }
                                          break;
                                       }

                                       color = (double)5.0F;
                                       break;
                                    }

                                    color = (double)3.0F;
                                    break;
                                 }

                                 color = (double)1.0F;
                                 amount = (double)2.0F;
                                 break;
                              }

                              color = (double)-1.0F;
                              amount = (double)0.0F;
                              break;
                           }
                        }

                        if (entityiterator instanceof Player && ((JujutsucraftvModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet || entityiterator.getPersistentData().m_128471_("EntityParticleSet")) {
                           color = (double)600.0F;
                        }

                        if (entityiterator instanceof Player && (CT1 == (double)5.0F || CT2 == (double)5.0F)) {
                           amount = (double)2.0F;
                        }

                        if (amount > (double)0.0F) {
                           num_loop = (double)Math.max(Math.round(level_strength / (double)16.0F), 1L) * amount;

                           for(int index0 = 0; index0 < (int)Math.max(num_loop, (double)1.0F); ++index0) {
                              x_pos = entityiterator.m_20185_() + (double)entityiterator.m_20205_() * (Math.random() - (double)0.5F);
                              y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * Math.random();
                              z_pos = entityiterator.m_20189_() + (double)entityiterator.m_20205_() * (Math.random() - (double)0.5F);
                              speed = level_strength / (double)192.0F * amount * Math.random();
                              if (color == (double)1.0F) {
                                 color_name = "jujutsucraft:particle_curse_power_red";
                              } else if (color == (double)2.0F) {
                                 color_name = "jujutsucraft:particle_curse_power_orange";
                              } else if (color == (double)3.0F) {
                                 color_name = "jujutsucraft:particle_thunder_blue";
                                 if (entityiterator instanceof MergedBeastAgitoEntity) {
                                    if (Math.random() < 0.2) {
                                       color_name = "jujutsucraft:particle_curse_power_blue";
                                    }

                                    if (Math.random() < 0.2) {
                                       color_name = "minecraft:happy_villager";
                                    }
                                 }
                              } else if (color == (double)4.0F) {
                                 color_name = "minecraft:happy_villager";
                              } else if (color == (double)5.0F) {
                                 color_name = "jujutsucraft:particle_curse_power_purple";
                              } else if (color == (double)600.0F) {
                                 color_name = ReturnEnergyColor3Procedure.execute(entityiterator);
                              } else {
                                 color_name = "jujutsucraft:particle_curse_power_blue";
                              }

                              if (ReturnInsideItemProcedure.execute(entityiterator).m_41720_() == JujutsucraftModItems.SUKUNA_FINGER.get() && Math.random() < 0.1) {
                                 color_name = "jujutsucraft:particle_curse_power_orange";
                              }

                              if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))) && Math.random() < 0.1) {
                                 color_name = "jujutsucraft:particle_blood_red";
                              }

                              if (entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && Math.random() < 0.1) {
                                 color_name = "minecraft:squid_ink";
                              }

                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle " + color_name + " " + x_pos + " " + y_pos + " " + z_pos + " 0.1 0.1 0.1 " + speed + " 2 normal @s");
                              }
                           }
                        }
                     }
                  } else {
                     for(int index1 = 0; index1 < 8; ++index1) {
                        distance += (double)2.0F;
                        x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * distance;
                        y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20154_().f_82480_ * distance;
                        z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * distance;
                        logic_a = false;
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)2.0F), (e) -> true)) {
                           if (entityiterator != entity) {
                              logic_a = true;
                              entity.getPersistentData().m_128379_("flag_sixEyes", true);
                              if (!entity.getPersistentData().m_128461_("DataNameOld").equals(entityiterator.m_20149_())) {
                                 entity.getPersistentData().m_128359_("DataNameOld", entityiterator.m_20149_());
                                 entity.getPersistentData().m_128347_("cnt_sixEyes", (double)0.0F);
                              }

                              entity.getPersistentData().m_128359_("DataSixEyes1", entityiterator.m_5446_().getString());
                              CompoundTag var85 = entity.getPersistentData();
                              String var94;
                              if (entityiterator instanceof LivingEntity) {
                                 float var10002;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10002 = _livEnt.m_21223_();
                                 } else {
                                    var10002 = -1.0F;
                                 }

                                 int var93 = Math.round(var10002);
                                 float var10003;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var10003 = _livEnt.m_21233_();
                                 } else {
                                    var10003 = -1.0F;
                                 }

                                 var94 = "Health: " + var93 + "/" + Math.round(var10003);
                              } else {
                                 var94 = "";
                              }

                              var85.m_128359_("DataSixEyes2", var94);
                              var85 = entity.getPersistentData();
                              ItemStack var95;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var95 = _livEnt.m_21205_();
                              } else {
                                 var95 = ItemStack.f_41583_;
                              }

                              String var96;
                              if (var95.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                 var96 = "";
                              } else {
                                 ItemStack var97;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var97 = _livEnt.m_21205_();
                                 } else {
                                    var97 = ItemStack.f_41583_;
                                 }

                                 var96 = "Main Hand: " + var97.m_41611_().getString();
                              }

                              var85.m_128359_("DataSixEyes4", var96);
                              var85 = entity.getPersistentData();
                              ItemStack var98;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var98 = _livEnt.m_21206_();
                              } else {
                                 var98 = ItemStack.f_41583_;
                              }

                              String var99;
                              if (var98.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                 var99 = "";
                              } else {
                                 ItemStack var100;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    var100 = _livEnt.m_21206_();
                                 } else {
                                    var100 = ItemStack.f_41583_;
                                 }

                                 var99 = "Off Hand: " + var100.m_41611_().getString();
                              }

                              var85.m_128359_("DataSixEyes5", var99);
                              num_loop = (double)0.0F;

                              for(int index2 = 0; index2 < 4; ++index2) {
                                 var85 = entity.getPersistentData();
                                 String var10001 = "DataSixEyes" + Math.round(num_loop + (double)6.0F);
                                 ItemStack var101;
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                    var101 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)((double)3.0F - num_loop)));
                                 } else {
                                    var101 = ItemStack.f_41583_;
                                 }

                                 String var102;
                                 if (var101.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                                    var102 = "";
                                 } else {
                                    long var103 = Math.round(num_loop + (double)1.0F);
                                    ItemStack var107;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                       var107 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)((double)3.0F - num_loop)));
                                    } else {
                                       var107 = ItemStack.f_41583_;
                                    }

                                    var102 = "Armor" + var103 + ": " + var107.m_41611_().getString();
                                 }

                                 var85.m_128359_(var10001, var102);
                                 ++num_loop;
                              }

                              ItemStack var89;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 var89 = _livEnt.m_21205_();
                              } else {
                                 var89 = ItemStack.f_41583_;
                              }

                              if (var89.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                                 CompoundTag var90 = entity.getPersistentData();
                                 CompoundTag var104 = entity.getPersistentData();
                                 var90.m_128359_("DataSixEyes4", "§c" + var104.m_128461_("DataSixEyes4"));
                              }

                              entity.getPersistentData().m_128359_("DataSixEyes10", "");
                              if (entityiterator instanceof DivineDogTotalityEntity) {
                                 CompoundTag var91 = entity.getPersistentData();
                                 var99 = Component.m_237115_("entity.jujutsucraft.divine_dog_white").getString();
                                 var91.m_128359_("DataSixEyes10", "§7" + var99 + ", " + Component.m_237115_("entity.jujutsucraft.divine_dog_black").getString());
                              } else if (entityiterator instanceof MergedBeastAgitoEntity) {
                                 CompoundTag var92 = entity.getPersistentData();
                                 var99 = Component.m_237115_("entity.jujutsucraft.nue").getString();
                                 var92.m_128359_("DataSixEyes10", "§7" + var99 + ", " + Component.m_237115_("entity.jujutsucraft.great_serpent").getString() + ", " + Component.m_237115_("entity.jujutsucraft.round_deer").getString() + ", " + Component.m_237115_("entity.jujutsucraft.tiger_funeral").getString());
                              }

                              if (entityiterator instanceof SukunaEntity) {
                                 entity.getPersistentData().m_128359_("DataSixEyes10", "§7" + Component.m_237115_("gui.jujutsucraft.select_technique.button_itadori1").getString());
                                 break;
                              }

                              if (entityiterator instanceof SukunaFushiguroEntity || entityiterator instanceof SukunaPerfectEntity) {
                                 entity.getPersistentData().m_128359_("DataSixEyes10", "§7" + Component.m_237115_("gui.jujutsucraft.select_technique.button_megumi_fushiguro1").getString());
                              }
                              break;
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }

                     if (entity.getPersistentData().m_128471_("flag_sixEyes")) {
                        entity.getPersistentData().m_128347_("cnt_sixEyes", Math.max(entity.getPersistentData().m_128459_("cnt_sixEyes"), (double)0.0F) + (double)1.0F);
                        if (entity.getPersistentData().m_128459_("cnt_sixEyes") > (double)3.0F) {
                           entity.getPersistentData().m_128379_("flag_sixEyes", false);
                        } else {
                           num_loop = (double)0.0F;

                           for(int index3 = 0; index3 < 11; ++index3) {
                              if (!entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)).contains("§k")) {
                                 entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "§k" + entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)));
                              }

                              ++num_loop;
                           }
                        }
                     } else {
                        entity.getPersistentData().m_128347_("cnt_sixEyes", Math.min(entity.getPersistentData().m_128459_("cnt_sixEyes"), (double)0.0F) - (double)1.0F);
                        if (entity.getPersistentData().m_128459_("cnt_sixEyes") < (double)-15.0F) {
                           num_loop = (double)0.0F;
                           entity.getPersistentData().m_128359_("DataNameOld", "");

                           for(int index4 = 0; index4 < 11; ++index4) {
                              entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "");
                              ++num_loop;
                           }
                        } else if (entity.getPersistentData().m_128459_("cnt_sixEyes") < (double)-12.0F) {
                           num_loop = (double)0.0F;

                           for(int index5 = 0; index5 < 11; ++index5) {
                              if (!entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)).contains("§k")) {
                                 entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "§k" + entity.getPersistentData().m_128461_("DataSixEyes" + Math.round(num_loop)));
                              }

                              ++num_loop;
                           }
                        }
                     }
                  }
               } else {
                  num_loop = (double)0.0F;
                  if (!entity.getPersistentData().m_128461_("DataNameOld").equals("")) {
                     entity.getPersistentData().m_128359_("DataNameOld", "");

                     for(int index6 = 0; index6 < 11; ++index6) {
                        entity.getPersistentData().m_128359_("DataSixEyes" + Math.round(num_loop), "");
                        ++num_loop;
                     }
                  }
               }
            }
         }

      }
   }
}
