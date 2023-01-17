package net.creep3rcrafter.mysticpotions.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.TippedArrowRecipe;

public class BetterPotionRecipe{
    public final Potion inputPotion;
    public final Potion ingredientPotion;
    public final Potion outputPotion;

    public BetterPotionRecipe(Potion inputPotion, Potion ingredientPotion, Potion outputPotion) {
        this.inputPotion = inputPotion;
        this.ingredientPotion = ingredientPotion;
        this.outputPotion = outputPotion;
    }

    public boolean isInput(ItemStack input) {
        return PotionUtils.getPotion(input) == this.inputPotion;
    }

    public boolean isIngredient(ItemStack ingredientPotionItemStack) {
        return PotionUtils.getPotion(ingredientPotionItemStack) == ingredientPotion;
    }

    public ItemStack getOutput(ItemStack inputPotionItemStack, ItemStack ingredientPotionItemStack) {
        if (!this.isInput(inputPotionItemStack) || !this.isIngredient(ingredientPotionItemStack)) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStack = new ItemStack(inputPotionItemStack.getItem());
        itemStack.setTag(new CompoundTag());
        PotionUtils.setPotion(itemStack, outputPotion);
        return itemStack;
    }
}
