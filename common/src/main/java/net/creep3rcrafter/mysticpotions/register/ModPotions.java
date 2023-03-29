package net.creep3rcrafter.mysticpotions.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(MysticPotions.MOD_ID, Registry.POTION_REGISTRY);


    //Thunderous
    public static final RegistrySupplier<Potion> THUNDEROUS_POTION = POTIONS.register("thunderous", () -> new Potion("thunderous", new MobEffectInstance(ModEffects.THUNDEROUS.get(), 1)));
    public static final RegistrySupplier<Potion> STRONG_THUNDEROUS_POTION = POTIONS.register("strong_thunderous", () -> new Potion("thunderous", new MobEffectInstance(ModEffects.THUNDEROUS.get(), 1, 4)));
    //Explosive
    public static final RegistrySupplier<Potion> EXPLOSIVE_POTION = POTIONS.register("explosive", () -> new Potion("explosive", new MobEffectInstance(ModEffects.EXPLOSIVE.get(), 1, 2)));
    public static final RegistrySupplier<Potion> STRONG_EXPLOSIVE_POTION = POTIONS.register("strong_explosive", () -> new Potion("explosive", new MobEffectInstance(ModEffects.EXPLOSIVE.get(), 1, 3)));
    public static final RegistrySupplier<Potion> EXTRA_STRONG_EXPLOSIVE_POTION = POTIONS.register("extra_strong_explosive", () -> new Potion("explosive", new MobEffectInstance(ModEffects.EXPLOSIVE.get(), 1, 5)));
    //Burning
    public static final RegistrySupplier<Potion> BURNING_POTION = POTIONS.register("burning", () -> new Potion("burning", new MobEffectInstance(ModEffects.BURNING.get(), 400)));
    public static final RegistrySupplier<Potion> LONG_BURNING_POTION = POTIONS.register("long_burning", () -> new Potion("burning", new MobEffectInstance(ModEffects.BURNING.get(), 500)));
    //Warming
    public static final RegistrySupplier<Potion> WARMING_POTION = POTIONS.register("warming", () -> new Potion("warming", new MobEffectInstance(ModEffects.WARMING.get(), 1800)));
    public static final RegistrySupplier<Potion> LONG_WARMING_POTION = POTIONS.register("long_warming", () -> new Potion("warming", new MobEffectInstance(ModEffects.WARMING.get(), 2400)));
    //Freezing
    public static final RegistrySupplier<Potion> FREEZING_POTION = POTIONS.register("freezing", () -> new Potion("freezing", new MobEffectInstance(ModEffects.FREEZING.get(), 600)));
    public static final RegistrySupplier<Potion> LONG_FREEZING_POTION = POTIONS.register("long_freezing", () -> new Potion("freezing", new MobEffectInstance(ModEffects.FREEZING.get(), 1200)));
    //Corrosive
    public static final RegistrySupplier<Potion> CORROSIVE_POTION = POTIONS.register("corrosive", () -> new Potion("corrosive", new MobEffectInstance(ModEffects.CORROSIVE.get(), 500)));
    public static final RegistrySupplier<Potion> STRONG_CORROSIVE_POTION = POTIONS.register("strong_corrosive", () -> new Potion("corrosive", new MobEffectInstance(ModEffects.CORROSIVE.get(), 500, 2)));
    //Blindness
    public static final RegistrySupplier<Potion> BLINDNESS_POTION = POTIONS.register("blindness", () -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 900)));
    public static final RegistrySupplier<Potion> LONG_BLINDNESS_POTION = POTIONS.register("long_blindness", () -> new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 1800)));
    //Decay
    public static final RegistrySupplier<Potion> DECAY_POTION = POTIONS.register("decay", () -> new Potion("decay", new MobEffectInstance(MobEffects.WITHER, 360)));
    public static final RegistrySupplier<Potion> LONG_DECAY_POTION = POTIONS.register("long_decay", () -> new Potion("decay", new MobEffectInstance(MobEffects.WITHER, 460)));
    public static final RegistrySupplier<Potion> STRONG_DECAY_POTION = POTIONS.register("strong_decay", () -> new Potion("decay", new MobEffectInstance(MobEffects.WITHER, 360, 1)));
    //Darkness
    public static final RegistrySupplier<Potion> DARKNESS_POTION = POTIONS.register("darkness", () -> new Potion("darkness", new MobEffectInstance(MobEffects.DARKNESS, 900)));
    public static final RegistrySupplier<Potion> LONG_DARKNESS_POTION = POTIONS.register("long_darkness", () -> new Potion("darkness", new MobEffectInstance(MobEffects.DARKNESS, 1800)));
    //1.1.0
    //Homing
    public static final RegistrySupplier<Potion> HOMING_POTION = POTIONS.register("homing", () -> new Potion("homing", new MobEffectInstance(ModEffects.HOMING.get(), 1)));
    //Recovery
    public static final RegistrySupplier<Potion> RECOVERY_POTION = POTIONS.register("recovery", () -> new Potion("recovery", new MobEffectInstance(ModEffects.RECOVERY.get(), 1)));
    //Undying
    public static final RegistrySupplier<Potion> UNDYING_POTION = POTIONS.register("undying", () -> new Potion("undying", new MobEffectInstance(ModEffects.UNDYING.get(), 12000)));
    public static final RegistrySupplier<Potion> LONG_UNDYING_POTION = POTIONS.register("long_undying", () -> new Potion("undying", new MobEffectInstance(ModEffects.UNDYING.get(), 13000)));
    //Air Swim
    public static final RegistrySupplier<Potion> AIR_SWIM_POTION = POTIONS.register("air_swim", () -> new Potion("air_swim", new MobEffectInstance(ModEffects.AIR_SWIM.get(), 1200)));
    public static final RegistrySupplier<Potion> LONG_AIR_SWIM_POTION = POTIONS.register("long_air_swim", () -> new Potion("air_swim", new MobEffectInstance(ModEffects.AIR_SWIM.get(), 1600)));
    /*
    //Nullifier
    public static final RegistrySupplier<Potion> NULLIFIER_POTION_1 = POTIONS.register("nullifier_1", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 600, 0)));
    public static final RegistrySupplier<Potion> NULLIFIER_POTION_2 = POTIONS.register("nullifier_2", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 500, 1)));
    public static final RegistrySupplier<Potion> NULLIFIER_POTION_3 = POTIONS.register("nullifier_3", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 400, 2)));
    public static final RegistrySupplier<Potion> NULLIFIER_POTION_4 = POTIONS.register("nullifier_4", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 300, 3)));
    public static final RegistrySupplier<Potion> NULLIFIER_POTION_5 = POTIONS.register("nullifier_5", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 200, 4)));
    public static final RegistrySupplier<Potion> NULLIFIER_POTION_6 = POTIONS.register("nullifier_6", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 100, 5)));
     */
    //Dolphins Grace
    public static final RegistrySupplier<Potion> DOLPHINS_GRACE_POTION = POTIONS.register("dolphins_grace", () -> new Potion("dolphins_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 600)));
    public static final RegistrySupplier<Potion> STRONG_DOLPHINS_GRACE_POTION = POTIONS.register("strong_dolphins_grace", () -> new Potion("dolphins_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 400, 2)));
    public static final RegistrySupplier<Potion> LONG_DOLPHINS_GRACE_POTION = POTIONS.register("long_dolphins_grace", () -> new Potion("dolphins_grace", new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 800)));
    //Teleportation
    public static final RegistrySupplier<Potion> TELEPORTATION_POTION = POTIONS.register("teleportation", () -> new Potion("teleportation", new MobEffectInstance(ModEffects.TELEPORTATION.get(), 150)));
    public static final RegistrySupplier<Potion> LONG_TELEPORTATION_POTION = POTIONS.register("long_teleportation", () -> new Potion("teleportation", new MobEffectInstance(ModEffects.TELEPORTATION.get(), 300)));
    //Extension
    //public static final RegistrySupplier<Potion> EXTENSION = POTIONS.register("extension", () -> new Potion("extension", new MobEffectInstance(ModEffects.EXTENSION.get(), 1)));
    //Levitation
    public static final RegistrySupplier<Potion> LEVITATION_POTION = POTIONS.register("levitation", () -> new Potion("levitation", new MobEffectInstance(MobEffects.LEVITATION, 200)));
    public static final RegistrySupplier<Potion> LONG_LEVITATION_POTION = POTIONS.register("long_levitation", () -> new Potion("levitation", new MobEffectInstance(MobEffects.LEVITATION, 300)));
}
