package net.creep3rcrafter.mysticpotions.fabriclike;

import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.creep3rcrafter.mysticpotions.register.BrewingRecipes;

public class MysticPotionsFabricLike {
    public static void init() {
        MysticPotions.init();
        new BrewingRecipes();
    }
}
