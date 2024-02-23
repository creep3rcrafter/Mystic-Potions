package net.creep3rcrafter.mysticpotions.neoforge;

import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.creep3rcrafter.mysticpotions.BrewingRecipes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.creep3rcrafter.mysticpotions.MysticPotions.MOD_ID;

@Mod(MOD_ID)
public class MysticPotionsNeoForge {
    public MysticPotionsNeoForge(IEventBus eventBus) {
        //NeoForge.EVENT_BUS.register(this);
        MysticPotions.init();
        eventBus.addListener(this::commonSetupEvent);
    }
    private void commonSetupEvent(FMLCommonSetupEvent event) {
        new BrewingRecipes();
    }
}
