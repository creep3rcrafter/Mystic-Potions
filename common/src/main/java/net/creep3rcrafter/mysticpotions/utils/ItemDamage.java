package net.creep3rcrafter.mysticpotions.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.List;

public class ItemDamage {

    public static List<Item> items = new ArrayList<Item>();

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
}