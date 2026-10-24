package net.mcreator.jujutsucraftv.procedures;

import net.mcreator.jujutsucraftv.network.JujutsucraftvModVariables;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ReturnEnergyColor3Procedure {
   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String color_txt = "";
         double random = (double)0.0F;
         if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleSet) {
            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)15.0F) {
               random = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 5);
               if (random == (double)1.0F) {
                  color_txt = "minecraft:soul";
               } else if (random >= (double)2.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_black";
               }
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)1.0F) {
               color_txt = "jujutsucraft:particle_curse_power_blue";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)2.0F) {
               color_txt = "jujutsucraft:particle_curse_power_orange";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)3.0F) {
               color_txt = "jujutsucraft:particle_curse_power_red";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)4.0F) {
               color_txt = "jujutsucraft:particle_curse_power_green";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)5.0F) {
               color_txt = "jujutsucraft:particle_curse_power_purple";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)6.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_yellow";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)7.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_deep_red";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)8.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_deep_blue";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)9.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_deep_green";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)10.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_black";
            } else if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)11.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_white";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)12.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_rainbow";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)13.0F) {
               color_txt = "jujutsucraftv:particle_thunder_red";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)14.0F) {
               color_txt = "jujutsucraftv:particle_curse_power_orange_to_purple";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)16.0F) {
               color_txt = "jujutsucraftv:particle_zawazawa";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)17.0F) {
               color_txt = "jujutsucraftv:particle_thunder_blue";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)18.0F) {
               color_txt = "jujutsucraft:particle_water_2";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)19.0F) {
               color_txt = "jujutsucraft:particle_ice";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)20.0F) {
               color_txt = "jujutsucraft:particle_magma";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)21.0F) {
               color_txt = "jujutsucraft:particle_blood_red";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)22.0F) {
               color_txt = "jujutsucraft:particle_cockroach";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)23.0F) {
               color_txt = "minecraft:enchant";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)24.0F) {
               color_txt = "minecraft:end_rod";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)25.0F) {
               color_txt = "jujutsucraftv:particle_rice";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)26.0F) {
               color_txt = "jujutsucraftv:particle_light_medium";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)27.0F) {
               color_txt = "jujutsucraft:particle_flower";
            }

            if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)0.0F) {
               color_txt = "";
            }
         } else {
            if (ReturnEnergyColorVProcedure.execute(entity) == (double)1.0F) {
               color_txt = "jujutsucraft:particle_curse_power_blue";
            }

            if (ReturnEnergyColorVProcedure.execute(entity) == (double)2.0F) {
               color_txt = "jujutsucraft:particle_curse_power_orange";
            }

            if (ReturnEnergyColorVProcedure.execute(entity) == (double)3.0F) {
               color_txt = "jujutsucraft:particle_curse_power_red";
            }

            if (ReturnEnergyColorVProcedure.execute(entity) == (double)4.0F) {
               color_txt = "jujutsucraft:particle_curse_power_green";
            }

            if (ReturnEnergyColorVProcedure.execute(entity) == (double)5.0F) {
               color_txt = "jujutsucraft:particle_curse_power_purple";
            }
         }

         if (!(entity instanceof Player)) {
            if (entity.getPersistentData().m_128471_("EntityParticleSet")) {
               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)15.0F) {
                  random = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 5);
                  if (random == (double)1.0F) {
                     color_txt = "minecraft:soul";
                  } else if (random >= (double)2.0F) {
                     color_txt = "jujutsucraftv:particle_curse_power_black";
                  }
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)1.0F) {
                  color_txt = "jujutsucraft:particle_curse_power_blue";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)2.0F) {
                  color_txt = "jujutsucraft:particle_curse_power_orange";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)3.0F) {
                  color_txt = "jujutsucraft:particle_curse_power_red";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)4.0F) {
                  color_txt = "jujutsucraft:particle_curse_power_green";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)5.0F) {
                  color_txt = "jujutsucraft:particle_curse_power_purple";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)6.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_yellow";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)7.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_deep_red";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)8.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_deep_blue";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)9.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_deep_green";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)10.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_black";
               } else if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)11.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_white";
               }

               if (((JujutsucraftvModVariables.PlayerVariables)entity.getCapability(JujutsucraftvModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftvModVariables.PlayerVariables())).PlayerParticleColor == (double)12.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_rainbow";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)13.0F) {
                  color_txt = "jujutsucraftv:particle_thunder_red";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)14.0F) {
                  color_txt = "jujutsucraftv:particle_curse_power_orange_to_purple";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)16.0F) {
                  color_txt = "jujutsucraftv:particle_zawazawa";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)17.0F) {
                  color_txt = "jujutsucraftv:particle_thunder_blue";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)18.0F) {
                  color_txt = "jujutsucraft:particle_water_2";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)19.0F) {
                  color_txt = "jujutsucraft:particle_ice";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)20.0F) {
                  color_txt = "jujutsucraft:particle_magma";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)21.0F) {
                  color_txt = "jujutsucraft:particle_blood_red";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)22.0F) {
                  color_txt = "jujutsucraft:particle_cockroach";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)23.0F) {
                  color_txt = "minecraft:enchant";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)24.0F) {
                  color_txt = "minecraft:end_rod";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)25.0F) {
                  color_txt = "jujutsucraftv:particle_rice";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)26.0F) {
                  color_txt = "jujutsucraftv:particle_light_medium";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)27.0F) {
                  color_txt = "jujutsucraft:particle_flower";
               }

               if (entity.getPersistentData().m_128459_("EntitySetParticle") == (double)0.0F) {
                  color_txt = "";
               }
            } else if (entity.getPersistentData().m_128471_("CursedSpirit")) {
               color_txt = "jujutsucraft:particle_curse_power_purple";
            } else {
               color_txt = "jujutsucraft:particle_curse_power_blue";
            }
         }

         return color_txt;
      }
   }
}
