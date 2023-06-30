package net.creep3rcrafter.mysticpotions;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.creep3rcrafter.mysticpotions.register.ModPotions;
import net.minecraft.world.entity.item.PrimedTnt;

public class MysticPotions {
    public static final String MOD_ID = "mysticpotions";

    public static void init() {
        ModEffects.EFFECTS.register();
        ModPotions.POTIONS.register();
    }
}
