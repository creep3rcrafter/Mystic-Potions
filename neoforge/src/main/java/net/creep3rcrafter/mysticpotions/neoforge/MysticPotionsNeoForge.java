package net.creep3rcrafter.mysticpotions.neoforge;

import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.creep3rcrafter.mysticpotions.BrewingRecipes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.NeoForge;

import static net.creep3rcrafter.mysticpotions.MysticPotions.MOD_ID;

@Mod(MOD_ID)
public class MysticPotionsNeoForge {
    public MysticPotionsNeoForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        NeoForge.EVENT_BUS.register(this);
        MysticPotions.init();
        eventBus.addListener(this::commonSetupEvent);
    }
    @SubscribeEvent
    private void commonSetupEvent(FMLCommonSetupEvent event) {
        //IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        new BrewingRecipes();
    }
}
