package net.creep3rcrafter.mysticpotions.forge;

import dev.architectury.platform.forge.EventBuses;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.creep3rcrafter.mysticpotions.register.BrewingRecipes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static net.creep3rcrafter.mysticpotions.MysticPotions.MOD_ID;

@Mod(MOD_ID)
public class MysticPotionsForge {
    public MysticPotionsForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(MOD_ID, eventBus);
        MysticPotions.init();
        eventBus.addListener(this::commonSetupEvent);
    }

    private void commonSetupEvent(FMLCommonSetupEvent event){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(new BrewingRecipes());
    }
}
