package net.creep3rcrafter.mysticpotions.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(MysticPotions.MOD_ID, Registry.POTION_REGISTRY);

    /* IDEAS
    Nullifer
    Luminous
     */

    //Thunderous
    public static final RegistrySupplier<Potion> THUNDEROUS_POTION = POTIONS.register("thunderous", () -> new Potion("thunderous", new MobEffectInstance(ModEffects.THUNDEROUS.get(), 1)));
    public static final RegistrySupplier<Potion> STRONG_THUNDEROUS_POTION = POTIONS.register("strong_thunderous", () -> new Potion("thunderous", new MobEffectInstance(ModEffects.THUNDEROUS.get(), 1, 4)));
    //Explosive
    public static final RegistrySupplier<Potion> EXPLOSIVE_POTION = POTIONS.register("explosive", () -> new Potion("explosive", new MobEffectInstance(ModEffects.EXPLOSIVE.get(), 1, 2)));
    public static final RegistrySupplier<Potion> STRONG_EXPLOSIVE_POTION = POTIONS.register("strong_explosive", () -> new Potion("explosive", new MobEffectInstance(ModEffects.EXPLOSIVE.get(), 1, 3)));
    public static final RegistrySupplier<Potion> EXTRA_STRONG_EXPLOSIVE_POTION = POTIONS.register("extra_strong_explosive", () -> new Potion("explosive", new MobEffectInstance(ModEffects.EXPLOSIVE.get(), 1, 5)));
    //Burning
    public static final RegistrySupplier<Potion> BURNING_POTION = POTIONS.register("burning", () -> new Potion("burning", new MobEffectInstance(ModEffects.BURNING.get(), 300)));
    public static final RegistrySupplier<Potion> LONG_BURNING_POTION = POTIONS.register("long_burning", () -> new Potion("burning", new MobEffectInstance(ModEffects.BURNING.get(), 600)));
    //Warming
    public static final RegistrySupplier<Potion> WARMING_POTION = POTIONS.register("warming", () -> new Potion("warming", new MobEffectInstance(ModEffects.WARMING.get(), 1800)));
    public static final RegistrySupplier<Potion> LONG_WARMING_POTION = POTIONS.register("long_warming", () -> new Potion("warming", new MobEffectInstance(ModEffects.WARMING.get(), 2400)));
    //Freezing
    public static final RegistrySupplier<Potion> FREEZING_POTION = POTIONS.register("freezing", () -> new Potion("freezing", new MobEffectInstance(ModEffects.FREEZING.get(), 600)));
    public static final RegistrySupplier<Potion> LONG_FREEZING_POTION = POTIONS.register("long_freezing", () -> new Potion("freezing", new MobEffectInstance(ModEffects.FREEZING.get(), 1200)));
    //Corrosive
    public static final RegistrySupplier<Potion> CORROSIVE_POTION = POTIONS.register("corrosive", () -> new Potion("corrosive", new MobEffectInstance(ModEffects.CORROSIVE.get(), 400)));
    public static final RegistrySupplier<Potion> STRONG_CORROSIVE_POTION = POTIONS.register("strong_corrosive", () -> new Potion("corrosive", new MobEffectInstance(ModEffects.CORROSIVE.get(), 400, 2)));
    //Blindness
    public static final RegistrySupplier<Potion> BLINDNESS_POTION = POTIONS.register("blindness", () -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 900)));
    public static final RegistrySupplier<Potion> LONG_BLINDNESS_POTION = POTIONS.register("long_blindness", () -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 1800)));
    //Decay
    public static final RegistrySupplier<Potion> DECAY_POTION = POTIONS.register("decay", () -> new Potion("decay", new MobEffectInstance(MobEffects.WITHER, 200)));
    public static final RegistrySupplier<Potion> LONG_DECAY_POTION = POTIONS.register("long_decay", () -> new Potion("decay", new MobEffectInstance(MobEffects.WITHER, 360)));
    public static final RegistrySupplier<Potion> STRONG_DECAY_POTION = POTIONS.register("strong_decay", () -> new Potion("decay", new MobEffectInstance(MobEffects.WITHER, 200, 1)));
    //Darkness
    public static final RegistrySupplier<Potion> DARKNESS_POTION = POTIONS.register("darkness", () -> new Potion("darkness", new MobEffectInstance(MobEffects.DARKNESS, 900)));
    public static final RegistrySupplier<Potion> LONG_DARKNESS_POTION = POTIONS.register("long_darkness", () -> new Potion("darkness", new MobEffectInstance(MobEffects.DARKNESS, 1800)));


    public static RegistrySupplier<Potion> register(String name, Supplier<Potion> potion) {
        return POTIONS.register(name, potion);
    }
}
