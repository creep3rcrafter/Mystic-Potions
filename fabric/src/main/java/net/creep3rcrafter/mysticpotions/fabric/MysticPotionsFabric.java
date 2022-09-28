package net.creep3rcrafter.mysticpotions.fabric;

import net.creep3rcrafter.mysticpotions.fabriclike.MysticPotionsFabricLike;
import net.fabricmc.api.ModInitializer;

public class MysticPotionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MysticPotionsFabricLike.init();
    }
}
