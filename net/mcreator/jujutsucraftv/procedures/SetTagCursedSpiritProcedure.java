package net.mcreator.jujutsucraftv.procedures;

import java.text.DecimalFormat;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade12Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade13Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade15Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade215Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade216Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritGrade220Entity;
import net.mcreator.jujutsucraftv.entity.CursedSpiritNetherGrade22Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.ForgeRegistries;

public class SetTagCursedSpiritProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("CursedSpirit", true);
         entity.getPersistentData().m_128379_("jjkChara", true);
         if (entity instanceof CursedSpiritGrade12Entity) {
            entity.getPersistentData().m_128379_("EntityParticleSet", true);
            entity.getPersistentData().m_128347_("EntitySetParticle", (double)7.0F);
         }

         if (entity instanceof CursedSpiritGrade15Entity) {
            entity.getPersistentData().m_128379_("EntityParticleSet", true);
            entity.getPersistentData().m_128347_("EntitySetParticle", (double)2.0F);
         }

         if (entity instanceof CursedSpiritGrade13Entity) {
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)2.0F);
         }

         if (entity instanceof CursedSpiritGrade215Entity && entity instanceof CursedSpiritGrade215Entity) {
            CursedSpiritGrade215Entity animatable = (CursedSpiritGrade215Entity)entity;
            DecimalFormat var10001 = new DecimalFormat("##");
            RandomSource var10002 = RandomSource.m_216327_();
            animatable.setTexture("cursedspirit_monkey" + var10001.format((long)Mth.m_216271_(var10002, 1, 3)));
         }

         if (entity instanceof CursedSpiritGrade216Entity) {
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_((double)1.5F);
         }

         if (entity instanceof CursedSpiritGrade220Entity || entity instanceof CursedSpiritNetherGrade22Entity) {
            if (entity instanceof CursedSpiritNetherGrade22Entity) {
               if (LogicBiomeProcedure.execute(entity, "minecraft:crimson_forest")) {
                  if (entity instanceof CursedSpiritNetherGrade22Entity) {
                     CursedSpiritNetherGrade22Entity animatable = (CursedSpiritNetherGrade22Entity)entity;
                     animatable.setTexture("cursedspirit_birch_crimson");
                  }
               } else if (LogicBiomeProcedure.execute(entity, "minecraft:warped_forest")) {
                  if (entity instanceof CursedSpiritNetherGrade22Entity) {
                     CursedSpiritNetherGrade22Entity animatable = (CursedSpiritNetherGrade22Entity)entity;
                     animatable.setTexture("cursedspirit_birch_warped");
                  }
               } else if (Mth.m_216271_(RandomSource.m_216327_(), 1, 2) == 2) {
                  if (entity instanceof CursedSpiritNetherGrade22Entity) {
                     CursedSpiritNetherGrade22Entity animatable = (CursedSpiritNetherGrade22Entity)entity;
                     animatable.setTexture("cursedspirit_birch_warped");
                  }
               } else if (entity instanceof CursedSpiritNetherGrade22Entity) {
                  CursedSpiritNetherGrade22Entity animatable = (CursedSpiritNetherGrade22Entity)entity;
                  animatable.setTexture("cursedspirit_birch_crimson");
               }
            }

            entity.getPersistentData().m_128347_("ent_size", Mth.m_216263_(RandomSource.m_216327_(), (double)1.0F, (double)3.0F));
            ((LivingEntity)entity).m_21051_((Attribute)ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).m_22100_(entity.getPersistentData().m_128459_("ent_size"));
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity28 = (LivingEntity)entity;
               if (_livingEntity28.m_21204_().m_22171_(Attributes.f_22276_)) {
                  _livingEntity28.m_21051_(Attributes.f_22276_).m_22100_((double)100.0F * ((double)1.0F + 0.15 * entity.getPersistentData().m_128459_("ent_size")));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               float var9;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var9 = _livEnt.m_21233_();
               } else {
                  var9 = -1.0F;
               }

               _entity.m_21153_(var9);
            }
         }

      }
   }
}
