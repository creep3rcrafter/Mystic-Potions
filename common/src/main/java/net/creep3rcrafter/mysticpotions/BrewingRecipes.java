package net.creep3rcrafter.mysticpotions;

import net.creep3rcrafter.mysticpotions.register.ModPotions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;

public class BrewingRecipes {
    public BrewingRecipes() {
        //Explosive
        PotionBrewing.addMix(Potions.AWKWARD, Items.TNT, ModPotions.EXPLOSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.EXPLOSIVE_POTION.get(), Items.TNT, ModPotions.STRONG_EXPLOSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.STRONG_EXPLOSIVE_POTION.get(), Items.TNT, ModPotions.EXTRA_STRONG_EXPLOSIVE_POTION.get());
        //PotionBrewing.addMix(ModPotions.EXPLOSIVE_POTION.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.EXPLOSIVE_POTION.get()).getItem(), ModPotions.STRONG_EXPLOSIVE_POTION.get());
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
        PotionBrewing.addMix(ModPotions.LONG_WARMING_POTION.get(), Items.BLAZE_POWDER, ModPotions.LONG_BURNING_POTION.get());
        //Corrosive
        PotionBrewing.addMix(Potions.STRONG_POISON, Items.GHAST_TEAR, ModPotions.CORROSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.CORROSIVE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_CORROSIVE_POTION.get());
        //Thunderous
        PotionBrewing.addMix(ModPotions.THUNDEROUS_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_THUNDEROUS_POTION.get());
        //Teleportation
        PotionBrewing.addMix(Potions.AWKWARD, Items.CHORUS_FRUIT, ModPotions.TELEPORTATION_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.REDSTONE, ModPotions.LONG_TELEPORTATION_POTION.get());
        //Homing
        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof BedItem) {
                PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), item, ModPotions.HOMING_POTION.get());
            }
        }
        //Recovery
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.RECOVERY_COMPASS, ModPotions.RECOVERY_POTION.get());
        //Undying
        PotionBrewing.addMix(Potions.AWKWARD, Items.TOTEM_OF_UNDYING, ModPotions.UNDYING_POTION.get());
        PotionBrewing.addMix(ModPotions.UNDYING_POTION.get(), Items.REDSTONE, ModPotions.LONG_UNDYING_POTION.get());
        /*
        //Nullifier
        PotionBrewing.addMix(Potions.AWKWARD, Items.MILK_BUCKET, ModPotions.NULLIFIER_POTION_1.get());
        PotionBrewing.addMix(ModPotions.NULLIFIER_POTION_1.get(), Items.GLOWSTONE_DUST, ModPotions.NULLIFIER_POTION_2.get());
        PotionBrewing.addMix(ModPotions.NULLIFIER_POTION_2.get(), Items.GLOWSTONE_DUST, ModPotions.NULLIFIER_POTION_3.get());
        PotionBrewing.addMix(ModPotions.NULLIFIER_POTION_4.get(), Items.GLOWSTONE_DUST, ModPotions.NULLIFIER_POTION_4.get());
        PotionBrewing.addMix(ModPotions.NULLIFIER_POTION_4.get(), Items.GLOWSTONE_DUST, ModPotions.NULLIFIER_POTION_5.get());
        PotionBrewing.addMix(ModPotions.NULLIFIER_POTION_5.get(), Items.GLOWSTONE_DUST, ModPotions.NULLIFIER_POTION_6.get());
         */
        //Dolphins Grace
        PotionBrewing.addMix(Potions.AWKWARD, Items.NAUTILUS_SHELL, ModPotions.DOLPHINS_GRACE_POTION.get());
        PotionBrewing.addMix(ModPotions.DOLPHINS_GRACE_POTION.get(), Items.REDSTONE, ModPotions.LONG_DOLPHINS_GRACE_POTION.get());
        PotionBrewing.addMix(ModPotions.DOLPHINS_GRACE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_DOLPHINS_GRACE_POTION.get());
        //Air Swim
        PotionBrewing.addMix(ModPotions.DOLPHINS_GRACE_POTION.get(), Items.PHANTOM_MEMBRANE, ModPotions.AIR_SWIM_POTION.get());
        PotionBrewing.addMix(ModPotions.AIR_SWIM_POTION.get(), Items.REDSTONE, ModPotions.LONG_AIR_SWIM_POTION.get());
        //Levitating
        PotionBrewing.addMix(Potions.SLOW_FALLING, Items.SHULKER_SHELL, ModPotions.LEVITATION_POTION.get());
        PotionBrewing.addMix(Potions.LONG_SLOW_FALLING, Items.SHULKER_SHELL, ModPotions.LONG_LEVITATION_POTION.get());
        PotionBrewing.addMix(ModPotions.LEVITATION_POTION.get(), Items.REDSTONE, ModPotions.LONG_LEVITATION_POTION.get());
        //Iron Fist
        PotionBrewing.addMix(Potions.AWKWARD, Items.IRON_PICKAXE, ModPotions.IRON_FIST_POTION.get());
        PotionBrewing.addMix(Potions.AWKWARD, Items.IRON_AXE, ModPotions.IRON_FIST_POTION.get());
        PotionBrewing.addMix(ModPotions.IRON_FIST_POTION.get(), Items.REDSTONE, ModPotions.LONG_IRON_FIST_POTION.get());
        //Gravitation
        PotionBrewing.addMix(ModPotions.LEVITATION_POTION.get(), Items.NETHER_STAR, ModPotions.GRAVITATION_POTION.get());
        //Slippery
        PotionBrewing.addMix(Potions.AWKWARD, Items.BLUE_ICE, ModPotions.SlIPPERY_POTION.get());
        PotionBrewing.addMix(ModPotions.SlIPPERY_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.LONG_SlIPPERY_POTION.get());
    }
}
