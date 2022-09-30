package net.creep3rcrafter.mysticpotions;

import net.creep3rcrafter.mysticpotions.register.ModPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;

public class BrewingRecipes {
    public BrewingRecipes(){
        //Explosive
        PotionBrewing.addMix(Potions.AWKWARD, Items.TNT, ModPotions.EXPLOSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.EXPLOSIVE_POTION.get(), Items.TNT, ModPotions.STRONG_EXPLOSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.STRONG_EXPLOSIVE_POTION.get(), Items.TNT, ModPotions.EXTRA_STRONG_EXPLOSIVE_POTION.get());
        //Decay
        PotionBrewing.addMix(Potions.AWKWARD, Items.WITHER_ROSE, ModPotions.DECAY_POTION.get());
        PotionBrewing.addMix(ModPotions.DECAY_POTION.get(), Items.REDSTONE, ModPotions.LONG_DECAY_POTION.get());
        PotionBrewing.addMix(ModPotions.DECAY_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_DECAY_POTION.get());
        //Blindness
        PotionBrewing.addMix(Potions.NIGHT_VISION, Items.INK_SAC, ModPotions.BLINDNESS_POTION.get());
        PotionBrewing.addMix(Potions.LONG_NIGHT_VISION, Items.INK_SAC, ModPotions.LONG_BLINDNESS_POTION.get());
        PotionBrewing.addMix(ModPotions.BLINDNESS_POTION.get(), Items.REDSTONE, ModPotions.LONG_BLINDNESS_POTION.get());
        //Darkness
        PotionBrewing.addMix(ModPotions.BLINDNESS_POTION.get(), Items.SCULK, ModPotions.DARKNESS_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_BLINDNESS_POTION.get(), Items.SCULK, ModPotions.LONG_DARKNESS_POTION.get());
        PotionBrewing.addMix(ModPotions.BLINDNESS_POTION.get(), Items.ECHO_SHARD, ModPotions.DARKNESS_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_BLINDNESS_POTION.get(), Items.ECHO_SHARD, ModPotions.LONG_DARKNESS_POTION.get());
        PotionBrewing.addMix(ModPotions.DARKNESS_POTION.get(), Items.REDSTONE, ModPotions.LONG_DARKNESS_POTION.get());
        //Freezing
        PotionBrewing.addMix(Potions.AWKWARD, Items.POWDER_SNOW_BUCKET, ModPotions.FREEZING_POTION.get());
        PotionBrewing.addMix(ModPotions.FREEZING_POTION.get(), Items.REDSTONE, ModPotions.LONG_FREEZING_POTION.get());
        //Warming
        PotionBrewing.addMix(ModPotions.FREEZING_POTION.get(), Items.BLAZE_POWDER, ModPotions.WARMING_POTION.get());
        PotionBrewing.addMix(ModPotions.FREEZING_POTION.get(), Items.REDSTONE, ModPotions.LONG_WARMING_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_FREEZING_POTION.get(), Items.BLAZE_POWDER, ModPotions.LONG_WARMING_POTION.get());
        //Burning
        PotionBrewing.addMix(ModPotions.WARMING_POTION.get(), Items.BLAZE_POWDER, ModPotions.BURNING_POTION.get());
        PotionBrewing.addMix(ModPotions.WARMING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.BURNING_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_WARMING_POTION.get(), Items.BLAZE_POWDER, ModPotions.LONG_BURNING_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_WARMING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.LONG_BURNING_POTION.get());
        //Corrosive
        PotionBrewing.addMix(Potions.STRONG_POISON, Items.GHAST_TEAR, ModPotions.CORROSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.CORROSIVE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_CORROSIVE_POTION.get());
        //Thunderous
        PotionBrewing.addMix(ModPotions.THUNDEROUS_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_THUNDEROUS_POTION.get());
    }
}
