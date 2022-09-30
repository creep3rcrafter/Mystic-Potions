package net.creep3rcrafter.mysticpotions.quilt;

import net.creep3rcrafter.mysticpotions.fabriclike.MysticPotionsFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class MysticPotionsQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        MysticPotionsFabricLike.init();
    }
}