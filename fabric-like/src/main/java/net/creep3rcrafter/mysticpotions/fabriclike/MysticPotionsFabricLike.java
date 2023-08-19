package net.creep3rcrafter.mysticpotions.fabriclike;

import net.creep3rcrafter.mysticpotions.BrewingRecipes;
import net.creep3rcrafter.mysticpotions.MysticPotions;

public class MysticPotionsFabricLike {
    public static void init() {
        MysticPotions.init();
        new BrewingRecipes();
    }
}
