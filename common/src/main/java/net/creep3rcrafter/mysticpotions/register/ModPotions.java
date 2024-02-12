package net.creep3rcrafter.mysticpotions.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(MysticPotions.MOD_ID, Registries.POTION);


    //
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
    /*
    //Iron Fist
    public static final RegistrySupplier<Potion> IRON_FIST_POTION = POTIONS.register("iron_fist", () -> new Potion("iron_fist", new MobEffectInstance(ModEffects.IRON_FIST.get(), 300)));
    public static final RegistrySupplier<Potion> LONG_IRON_FIST_POTION = POTIONS.register("long_iron_fist", () -> new Potion("iron_fist", new MobEffectInstance(ModEffects.IRON_FIST.get(), 600)));
     */
    //Gravitation
    public static final RegistrySupplier<Potion> GRAVITATION_POTION = POTIONS.register("gravitation", () -> new Potion("gravitation", new MobEffectInstance(ModEffects.GRAVITATION.get(), 200)));
    //Slippery
    public static final RegistrySupplier<Potion> SlIPPERY_POTION = POTIONS.register("slippery", () -> new Potion("slippery", new MobEffectInstance(ModEffects.SPLIPPERY.get(), 300)));
    public static final RegistrySupplier<Potion> LONG_SlIPPERY_POTION = POTIONS.register("long_slippery", () -> new Potion("slippery", new MobEffectInstance(ModEffects.SPLIPPERY.get(), 400)));


    public static final RegistrySupplier<Potion> ABSORPTION_POTION = POTIONS.register("absorption", () -> new Potion("absorption", new MobEffectInstance(MobEffects.ABSORPTION, 400)));
    public static final RegistrySupplier<Potion> LONG_ABSORPTION_POTION = POTIONS.register("long_absorption", () -> new Potion("absorption", new MobEffectInstance(MobEffects.ABSORPTION, 800)));
    public static final RegistrySupplier<Potion> STRONG_ABSORPTION_POTION = POTIONS.register("strong_absorption", () -> new Potion("absorption", new MobEffectInstance(MobEffects.ABSORPTION, 400, 1)));
    public static final RegistrySupplier<Potion> PROTECTION_POTION = POTIONS.register("protection", () -> new Potion("protection", new MobEffectInstance(ModEffects.PROTECTION.get(), 600, 1)));
    public static final RegistrySupplier<Potion> LONG_PROTECTION_POTION = POTIONS.register("long_protection", () -> new Potion("protection", new MobEffectInstance(ModEffects.PROTECTION.get(), 1200, 1)));
    public static final RegistrySupplier<Potion> STRONG_PROTECTION_POTION = POTIONS.register("strong_protection", () -> new Potion("protection", new MobEffectInstance(ModEffects.PROTECTION.get(), 400, 3)));
    public static final RegistrySupplier<Potion> HEALTH_BOOST_POTION = POTIONS.register("health_boost", () -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 400)));
    public static final RegistrySupplier<Potion> LONG_HEALTH_BOOST_POTION = POTIONS.register("long_health_boost", () -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 800)));
    public static final RegistrySupplier<Potion> STRONG_HEALTH_BOOST_POTION = POTIONS.register("strong_health_boost", () -> new Potion("health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 1)));
    public static final RegistrySupplier<Potion> GLOWING_POTION = POTIONS.register("glowing", () -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 600)));
    public static final RegistrySupplier<Potion> LONG_GLOWING_POTION = POTIONS.register("long_glowing", () -> new Potion("glowing", new MobEffectInstance(MobEffects.GLOWING, 1200)));
    public static final RegistrySupplier<Potion> SATURATION_POTION = POTIONS.register("saturation", () -> new Potion("saturation", new MobEffectInstance(MobEffects.SATURATION, 1, 5)));
    public static final RegistrySupplier<Potion> STRONG_SATURATION_POTION = POTIONS.register("strong_saturation", () -> new Potion("saturation", new MobEffectInstance(MobEffects.SATURATION, 1, 10)));
    public static final RegistrySupplier<Potion> HUNGER_POTION = POTIONS.register("hunger", () -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 400)));
    public static final RegistrySupplier<Potion> LONG_HUNGER_POTION = POTIONS.register("long_hunger", () -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 800)));
    public static final RegistrySupplier<Potion> STRONG_HUNGER_POTION = POTIONS.register("strong_hunger", () -> new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 400, 1)));
    public static final RegistrySupplier<Potion> CONFUSION_POTION = POTIONS.register("confusion", () -> new Potion("confusion", new MobEffectInstance(MobEffects.CONFUSION, 400)));
    public static final RegistrySupplier<Potion> LONG_CONFUSION_POTION = POTIONS.register("long_confusion", () -> new Potion("confusion", new MobEffectInstance(MobEffects.CONFUSION, 800)));
    public static final RegistrySupplier<Potion> STRONG_CONFUSION_POTION = POTIONS.register("strong_confusion", () -> new Potion("confusion", new MobEffectInstance(MobEffects.CONFUSION, 400, 1)));
    public static final RegistrySupplier<Potion> MINING_FATIGUE_POTION = POTIONS.register("mining_fatigue", () -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400)));
    public static final RegistrySupplier<Potion> LONG_MINING_FATIGUE_POTION = POTIONS.register("long_mining_fatigue", () -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 800)));
    public static final RegistrySupplier<Potion> STRONG_MINING_FATIGUE_POTION = POTIONS.register("strong_mining_fatigue", () -> new Potion("mining_fatigue", new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 1)));
    public static final RegistrySupplier<Potion> HASTE_POTION = POTIONS.register("haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 800)));
    public static final RegistrySupplier<Potion> LONG_HASTE_POTION = POTIONS.register("long_haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 1600)));
    public static final RegistrySupplier<Potion> STRONG_HASTE_POTION = POTIONS.register("strong_haste", () -> new Potion("haste", new MobEffectInstance(MobEffects.DIG_SPEED, 800, 1)));
    public static final RegistrySupplier<Potion> FATAL_POISON_POTION = POTIONS.register("fatal_poison", () -> new Potion("fatal_poison", new MobEffectInstance(ModEffects.FATAL_POISON.get(), 400)));
    public static final RegistrySupplier<Potion> LONG_FATAL_POISON_POTION = POTIONS.register("long_fatal_poison", () -> new Potion("fatal_poison", new MobEffectInstance(ModEffects.FATAL_POISON.get(), 800)));
    public static final RegistrySupplier<Potion> STRONG_FATAL_POISON_POTION = POTIONS.register("strong_fatal_poison", () -> new Potion("fatal_poison", new MobEffectInstance(ModEffects.FATAL_POISON.get(), 400, 1)));
    public static final RegistrySupplier<Potion> SILENCE_POTION = POTIONS.register("silence", () -> new Potion("silence", new MobEffectInstance(ModEffects.SILENCE.get(), 600)));
    public static final RegistrySupplier<Potion> LONG_SILENCE_POTION = POTIONS.register("long_silence", () -> new Potion("silence", new MobEffectInstance(ModEffects.SILENCE.get(), 1200)));
    public static final RegistrySupplier<Potion> NULLIFIER_POTION = POTIONS.register("nullifier", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 200)));
    public static final RegistrySupplier<Potion> LONG_NULLIFIER_POTION = POTIONS.register("long_nullifier", () -> new Potion("nullifier", new MobEffectInstance(ModEffects.NULLIFIER.get(), 400)));
    public static final RegistrySupplier<Potion> INFECTION = POTIONS.register("infection", () -> new Potion("infection", new MobEffectInstance(ModEffects.INFECTION.get(), 1200)));
    public static final RegistrySupplier<Potion> LONG_INFECTION = POTIONS.register("long_infection", () -> new Potion("infection", new MobEffectInstance(ModEffects.INFECTION.get(), 2400)));
    /*
    public static final RegistrySupplier<Potion> CRUSHING_MIND_POTION = POTIONS.register("crushing_mind", () -> new Potion("crushing_mind",
            new MobEffectInstance(MobEffects.BLINDNESS, 400),
            new MobEffectInstance(MobEffects.DARKNESS, 400),
            new MobEffectInstance(MobEffects.CONFUSION, 400)));
    public static final RegistrySupplier<Potion> SOULFULL_POTION = POTIONS.register("soulfull", () -> new Potion("soulfull",
            new MobEffectInstance(MobEffects.REGENERATION, 400),
            new MobEffectInstance(MobEffects.ABSORPTION, 400),
            new MobEffectInstance(MobEffects.HEALTH_BOOST, 400)));
     */
}