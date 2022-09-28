package net.creep3rcrafter.mysticpotions.utils;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registries;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemDamage {

    public static List<Item> items = new ArrayList<Item>();
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MysticPotions.MOD_ID));

    public static List<Item> getItems(){
        items.add(Items.ACTIVATOR_RAIL);
        items.add(Items.ANVIL);
        items.add(Items.BLAST_FURNACE);
        items.add(Items.IRON_BLOCK);
        items.add(Items.BUCKET);
        items.add(Items.LAVA_BUCKET);
        items.add(Items.WATER_BUCKET);
        items.add(Items.MILK_BUCKET);
        items.add(Items.CAULDRON);
        items.add(Items.CHAIN);
        items.add(Items.DETECTOR_RAIL);
        items.add(Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
        items.add(Items.HOPPER);
        items.add(Items.IRON_BARS);
        items.add(Items.IRON_DOOR);
        items.add(Items.IRON_TRAPDOOR);
        items.add(Items.IRON_NUGGET);
        items.add(Items.MINECART);
        items.add(Items.PISTON);
        items.add(Items.RAIL);
        items.add(Items.SMITHING_TABLE);
        items.add(Items.STONECUTTER);
        items.add(Items.TRIPWIRE_HOOK);
        return items;
    }

    public enum ItemDamageType {
        IRON(10),
        NETHERITE(20);
        public final int damage;

        ItemDamageType(int damage) {
            this.damage = damage;
        }
    }

    public void testing(MinecraftServer server){
        //server.getRecipeManager().getAllRecipesFor()
        server.getRecipeManager().getRecipes().forEach(recipe ->{
            recipe.getIngredients().forEach(ingredient -> {
                if (ingredient.getItems()[0].getItem() == Items.IRON_INGOT){
                    System.out.println(ingredient);
                }
            });
        });
    }

    public static ItemDamageType getItemDamageType(Item item) {
        if (item instanceof ArmorItem) {
            if (((ArmorItem) item).getMaterial() == ArmorMaterials.IRON || ((ArmorItem) item).getMaterial() == ArmorMaterials.CHAIN) {
                return ItemDamageType.IRON;
            }
            if (((ArmorItem) item).getMaterial() == ArmorMaterials.NETHERITE) {
                return ItemDamageType.NETHERITE;
            }
        } else if (item instanceof TieredItem) {
            if (((TieredItem) item).getTier() == Tiers.IRON) {
                return ItemDamageType.IRON;
            }
            if (((TieredItem) item).getTier() == Tiers.NETHERITE) {
                return ItemDamageType.NETHERITE;
            }
        } else if (item instanceof ShieldItem
                || item instanceof CrossbowItem
                || item instanceof FlintAndSteelItem
                || item instanceof ShearsItem) {
            return ItemDamageType.IRON;
        }
        return null;
    }

    public static ItemDamageType getEntityDamageType(LivingEntity livingEntity) {
        if (livingEntity instanceof IronGolem || (Entity)livingEntity instanceof AbstractMinecart) {
            return ItemDamageType.IRON;
        }
        return null;
    }
}