package net.creep3rcrafter.mysticpotions.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.creep3rcrafter.mysticpotions.utils.Utils;
import net.minecraft.core.Registry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(MysticPotions.MOD_ID, Registry.MOB_EFFECT_REGISTRY);

    public static final RegistrySupplier<MobEffect> THUNDEROUS = EFFECTS.register("thunderous", () -> new MobEffect(MobEffectCategory.HARMFUL,10485759){
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            ServerLevel level = livingEntity.createCommandSourceStack().getLevel();
            Utils.lightning(livingEntity, level, amplifier);
        }
        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            ServerLevel level = livingEntity.createCommandSourceStack().getLevel();
            Utils.lightning(livingEntity, level, amplifier);
        }
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }
        public boolean isInstantenous() {
            return true;
        }
    });
    public static final RegistrySupplier<MobEffect> EXPLOSIVE = EFFECTS.register("explosive", () -> new MobEffect(MobEffectCategory.HARMFUL,1514264){
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            ServerLevel level = livingEntity.createCommandSourceStack().getLevel();
            if(!livingEntity.isSpectator()){
                if(livingEntity.getLevel().dimension() == level.NETHER){
                    Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                }else{
                    if (amplifier > 4){
                        Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                    }else{
                        Utils.explode(level, livingEntity.blockPosition(), amplifier);
                    }
                }
            }
        }
        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            ServerLevel level = livingEntity.createCommandSourceStack().getLevel();
            if(!livingEntity.isSpectator()){
                if(livingEntity.getLevel().dimension() == level.NETHER){
                    Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                }else{
                    if (amplifier > 4){
                        Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                    }else{
                        Utils.explode(level, livingEntity.blockPosition(), amplifier);
                    }
                }
            }
        }
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }
        public boolean isInstantenous() {
            return true;
        }
    });
    public static final RegistrySupplier<MobEffect> BURNING = EFFECTS.register("burning", () -> new MobEffect(MobEffectCategory.HARMFUL,16740608){
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            livingEntity.setSecondsOnFire(1);
        }
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }
        public boolean isInstantenous() {
            return false;
        }
    });
    public static final RegistrySupplier<MobEffect> WARMING = EFFECTS.register("warming", () -> new MobEffect(MobEffectCategory.BENEFICIAL,16757504){
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            livingEntity.setTicksFrozen(0);
            if (livingEntity instanceof SnowGolem && livingEntity.getLevel() != null && livingEntity.getLevel().getServer().getTickCount() % 20 == 0){
                livingEntity.hurt(DamageSource.MAGIC, amplifier + 1);
            }
        }
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }
        public boolean isInstantenous() {
            return false;
        }
    });
    public static final RegistrySupplier<MobEffect> FREEZING = EFFECTS.register("freezing", () -> new MobEffect(MobEffectCategory.HARMFUL,1572863){
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (livingEntity.canFreeze()){
                livingEntity.setIsInPowderSnow(true);
            }
        }
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }
        public boolean isInstantenous() {
            return false;
        }
    });
    public static final RegistrySupplier<MobEffect> CORROSIVE = EFFECTS.register("corrosive", () -> new MobEffect(MobEffectCategory.HARMFUL,65420){
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            ServerLevel level = livingEntity.createCommandSourceStack().getLevel();
            Random random = new Random();
            if (!livingEntity.isSpectator() && level != null && level.getServer().getTickCount() % 10 == 0) {
                MinecraftServer server = level.getServer();
                if(livingEntity instanceof ServerPlayer){
                    List<Item> items = new ArrayList<Item>();
                    items.add(Items.IRON_NUGGET);
                    items.add(Items.IRON_ORE);
                    items.add(Items.IRON_INGOT);
                    items.add(Items.COPPER_INGOT);
                    items.add(Items.NETHERITE_SCRAP);
                    items.add(Items.NETHERITE_INGOT);

                    List<Item> results = Utils.recipesContainsItems(server, RecipeType.CRAFTING, items);
                    results.addAll(Utils.recipesContainsItems(server, RecipeType.SMELTING, items));
                    results.addAll(Utils.recipesContainsItems(server, RecipeType.SMITHING, items));
                    results.addAll(Utils.recipesContainsItems(server, RecipeType.BLASTING, items));
                    results.addAll(Utils.recipesContainsItems(server, RecipeType.SMOKING, items));
                    results.addAll(Utils.recipesContainsItems(server, RecipeType.STONECUTTING, items));
                    results.addAll(Utils.recipesContainsItems(server, RecipeType.CAMPFIRE_COOKING, items));

                    List<Item> resultsWithoutDuplicates = new ArrayList<Item>(new HashSet<>(results));

                    Inventory inventory = ((ServerPlayer) livingEntity).getInventory();
                    for (int i = 0; i < inventory.getContainerSize(); i++){
                        Item item = inventory.getItem(i).getItem();
                        ItemStack itemStack = inventory.getItem(i);
                        if(itemStack.isDamageableItem()){
                            Utils.damageItem(livingEntity, itemStack, 1 + amplifier);
                        }else if(!itemStack.isDamageableItem() && resultsWithoutDuplicates.contains(item)){
                            if (random.nextInt(100) >= 90){
                                if (random.nextInt(3) <= amplifier){
                                    itemStack.shrink(1);
                                    //livingEntity.playSound(Registry.SOUND_EVENT.get(new ResourceLocation("entity.item.break")));
                                }
                            }
                        }
                    }
                }else if (livingEntity instanceof IronGolem){
                    livingEntity.hurt(DamageSource.MAGIC,1f + amplifier);//take iron damage
                }else{
                    if (livingEntity.hasItemInSlot(EquipmentSlot.MAINHAND)){
                        Utils.damageItem(livingEntity, EquipmentSlot.MAINHAND, 1 + amplifier);
                    }
                    if (livingEntity.hasItemInSlot(EquipmentSlot.OFFHAND)){
                        Utils.damageItem(livingEntity, EquipmentSlot.OFFHAND, 1 + amplifier);
                    }
                    if (livingEntity.hasItemInSlot(EquipmentSlot.HEAD)){
                        Utils.damageItem(livingEntity, EquipmentSlot.HEAD, 1 + amplifier);
                    }
                    if (livingEntity.hasItemInSlot(EquipmentSlot.CHEST)){
                        Utils.damageItem(livingEntity, EquipmentSlot.CHEST, 1 + amplifier);
                    }
                    if (livingEntity.hasItemInSlot(EquipmentSlot.LEGS)){
                        Utils.damageItem(livingEntity, EquipmentSlot.LEGS, 1 + amplifier);
                    }
                    if (livingEntity.hasItemInSlot(EquipmentSlot.FEET)){
                        Utils.damageItem(livingEntity, EquipmentSlot.FEET, 1 + amplifier);
                    }
                }
            }
        }
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }
        public boolean isInstantenous() {
            return false;
        }
    });

    public static RegistrySupplier<MobEffect> register(String name, Supplier<MobEffect> mobEffect){
        return EFFECTS.register(name, mobEffect);
    }
}
