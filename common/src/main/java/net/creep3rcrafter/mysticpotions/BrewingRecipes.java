package net.creep3rcrafter.mysticpotions;

import net.creep3rcrafter.mysticpotions.register.ModPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
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
        PotionBrewing.addMix(ModPotions.WARMING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.BURNING_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_WARMING_POTION.get(), Items.BLAZE_POWDER, ModPotions.LONG_BURNING_POTION.get());
        PotionBrewing.addMix(ModPotions.LONG_WARMING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.LONG_BURNING_POTION.get());
        //Corrosive
        PotionBrewing.addMix(Potions.STRONG_POISON, Items.GHAST_TEAR, ModPotions.CORROSIVE_POTION.get());
        PotionBrewing.addMix(ModPotions.CORROSIVE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_CORROSIVE_POTION.get());
        //Thunderous
        PotionBrewing.addMix(ModPotions.THUNDEROUS_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_THUNDEROUS_POTION.get());
        //Teleportation
        PotionBrewing.addMix(Potions.AWKWARD, Items.CHORUS_FRUIT, ModPotions.TELEPORTATION_POTION.get());
        //Homing
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.WHITE_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.ORANGE_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.MAGENTA_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.LIGHT_BLUE_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.YELLOW_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.LIME_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.PINK_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.GRAY_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.LIGHT_GRAY_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.CYAN_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.PURPLE_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.BROWN_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.GREEN_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.RED_BED, ModPotions.HOMING_POTION.get());
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.BLACK_BED, ModPotions.HOMING_POTION.get());
        //Recovery
        PotionBrewing.addMix(ModPotions.TELEPORTATION_POTION.get(), Items.RECOVERY_COMPASS, ModPotions.RECOVERY_POTION.get());
        //Undying
        PotionBrewing.addMix(Potions.AWKWARD, Items.TOTEM_OF_UNDYING, ModPotions.UNDYING_POTION.get());
        //Nullifier
        PotionBrewing.addMix(Potions.AWKWARD, Items.MILK_BUCKET, ModPotions.NULLIFIER_POTION.get());
        //Dolphins Grace
        PotionBrewing.addMix(Potions.AWKWARD, Items.NAUTILUS_SHELL, ModPotions.DOLPHINS_GRACE_POTION.get());
        //Air Swim
        PotionBrewing.addMix(ModPotions.DOLPHINS_GRACE_POTION.get(), Items.PHANTOM_MEMBRANE, ModPotions.AIR_SWIM_POTION.get());
        //Levitating
        PotionBrewing.addMix(Potions.SLOW_FALLING, Items.SHULKER_SHELL, ModPotions.LEVITATION_POTION.get());
        PotionBrewing.addMix(Potions.LONG_SLOW_FALLING, Items.SHULKER_SHELL, ModPotions.LONG_LEVITATION_POTION.get());
        PotionBrewing.addMix(ModPotions.LEVITATION_POTION.get(), Items.REDSTONE, ModPotions.LEVITATION_POTION.get());



    }
    public static void addMix(Potion potionIn, Potion potionIn2, Potion potionOut) {
        PotionBrewing.POTION_MIXES.add(new Mix(potionIn, potionIn2, potionOut));
    }
    public static class Mix<T> {
        final T from;
        final T from2;
        final T to;

        public Mix(T object, T from2, T object2) {
            this.from = object;
            this.from2 = from2;
            this.to = object2;
        }
    }
}
