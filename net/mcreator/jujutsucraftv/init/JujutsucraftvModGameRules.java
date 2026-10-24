package net.mcreator.jujutsucraftv.init;

import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Category;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftvModGameRules {
   public static final GameRules.Key<GameRules.BooleanValue> JJCV_VANILLA_MOB_SPAWN;
   public static final GameRules.Key<GameRules.BooleanValue> JJCV_ORIGINAL_MOB_SPAWN;
   public static final GameRules.Key<GameRules.BooleanValue> JJCV_SUKUNA_UNDER_GROUND_SPAWN;
   public static final GameRules.Key<GameRules.BooleanValue> JJCV_NETHER_UNIQUE_ENTITY_SPAWN;
   public static final GameRules.Key<GameRules.BooleanValue> JJCV_PLAY_BOSS_BGM;

   static {
      JJCV_VANILLA_MOB_SPAWN = GameRules.m_46189_("jjcvVanillaMobSpawn", Category.SPAWNING, BooleanValue.m_46250_(false));
      JJCV_ORIGINAL_MOB_SPAWN = GameRules.m_46189_("jjcvOriginalMobSpawn", Category.SPAWNING, BooleanValue.m_46250_(true));
      JJCV_SUKUNA_UNDER_GROUND_SPAWN = GameRules.m_46189_("jjcvSukunaUnderGroundSpawn", Category.SPAWNING, BooleanValue.m_46250_(false));
      JJCV_NETHER_UNIQUE_ENTITY_SPAWN = GameRules.m_46189_("jjcvNetherUniqueEntitySpawn", Category.SPAWNING, BooleanValue.m_46250_(true));
      JJCV_PLAY_BOSS_BGM = GameRules.m_46189_("jjcvPlayBossBGM", Category.MISC, BooleanValue.m_46250_(true));
   }
}
