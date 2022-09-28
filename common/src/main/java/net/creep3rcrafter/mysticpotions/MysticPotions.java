package net.creep3rcrafter.mysticpotions;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.creep3rcrafter.mysticpotions.register.ModPotions;

public class MysticPotions {
    public static final String MOD_ID = "mysticpotions";
    
    public static void init() {
        ModEffects.EFFECTS.register();
        ModPotions.POTIONS.register();

        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
