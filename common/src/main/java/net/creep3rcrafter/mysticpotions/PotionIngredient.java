package net.creep3rcrafter.mysticpotions;

import net.minecraft.world.item.crafting.Ingredient;

import java.util.stream.Stream;

public class PotionIngredient extends Ingredient {
    public PotionIngredient(Stream<? extends Value> stream) {
        super(stream);
    }
}
