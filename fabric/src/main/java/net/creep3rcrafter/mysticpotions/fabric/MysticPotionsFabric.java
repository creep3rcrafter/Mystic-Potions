package net.creep3rcrafter.mysticpotions.fabric;

import net.creep3rcrafter.mysticpotions.BrewingRecipes;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.fabricmc.api.ModInitializer;

public class MysticPotionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MysticPotions.init();
        new BrewingRecipes();
    }
}
