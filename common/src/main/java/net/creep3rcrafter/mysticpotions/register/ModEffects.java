package net.creep3rcrafter.mysticpotions.register;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creep3rcrafter.mysticpotions.MysticPotions;
import net.creep3rcrafter.mysticpotions.utils.Utils;
import net.minecraft.advancements.critereon.UsedTotemTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(MysticPotions.MOD_ID, Registry.MOB_EFFECT_REGISTRY);


    /* IDEAS
    Inversion - Swaps good/bad potions with eachother
    Luminous - things glow
    Menacing - mobs are scared of you
    Iron Fist - break blocks with your fist with an iron pick effeciency
    Light Footed - Doesnt set off pressure plates or trip wire
    Energized - messes with redstone
    Water Miner - you can mine faster underwater
    Calming - stops angered mobs from being angry
    Xp boost - xp multipliyer
    Smelting - smelts items in your inventory
    Refinement/Potency - Makes potion effects last longer or stronger
    Herding - makes all animals follow you
    Knock-back resistance - self explanitory
    Stealth - you dont make noises
    Nureshment potion
    Invincibility/overkilled- but delayed damage and make stackable - maybe make antidote
    Holy Water - hurts hostile mobs and if they hurt you they also take the same ammount of damage
    fast falling

    Done------------------------------------
    Undying - totem of undieing just without the item
    Homing - teleports you to your bed
    Recovery - sends you to your last death location
    Extension/Extension Cooldown
    Nullifier - removes all potion effects and stops all potion effects from happening
    Air Swim - swim in the air
    */

    //Beneficial
    public static final RegistrySupplier<MobEffect> UNDYING = EFFECTS.register("undying", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 16766527) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return false;
        }
    });//New
    public static final RegistrySupplier<MobEffect> AIR_SWIM = EFFECTS.register("air_swim", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 24991) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            float f;
            //livingEntity.updateFluidHeightAndDoFluidPushing(FluidTags.WATER, 0.014D);
            if(livingEntity.isSprinting()){
                livingEntity.resetFallDistance();
                livingEntity.wasEyeInWater = true;
                livingEntity.wasTouchingWater = true;
                livingEntity.setSwimming(true);
                livingEntity.updateFluidHeightAndDoFluidPushing(FluidTags.WATER, 0.014D);
                Vec3 vec32 = livingEntity.getDeltaMovement();
                f = 1.08f;
                if (livingEntity.horizontalCollision && livingEntity.onClimbable()) {
                    vec32 = new Vec3(vec32.x, 0.25D, vec32.z);
                }
                livingEntity.setDeltaMovement(vec32.multiply(f, f + 0.05, f));
                livingEntity.gameEvent(GameEvent.SWIM);

            }
            //livingEntity.updateSwimming();
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return false;
        }
    });//New
    public static final RegistrySupplier<MobEffect> NULLIFIER = EFFECTS.register("nullifier", () -> new MobEffect(MobEffectCategory.NEUTRAL, 0) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            for (int i = 0; i < livingEntity.getActiveEffects().size(); i++){
                if (((MobEffectInstance)livingEntity.getActiveEffects().toArray()[i]).getEffect() != NULLIFIER.get()){
                    ((MobEffectInstance)livingEntity.getActiveEffects().toArray()[i]).duration = 0;
                    ((MobEffectInstance)livingEntity.getActiveEffects().toArray()[i]).amplifier = 0;
                }
            }
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return false;
        }
    });//New



    public static final RegistrySupplier<MobEffect> WARMING = EFFECTS.register("warming", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 16757504) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            livingEntity.setTicksFrozen(0);
            if (livingEntity instanceof SnowGolem && livingEntity.getLevel() != null && livingEntity.getLevel().getServer().getTickCount() % 20 == 0) {
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
    public static final RegistrySupplier<MobEffect> EXTENSION = EFFECTS.register("extension", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 16711935) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (livingEntity.getActiveEffects().size() > 0) {
                boolean hasCooldown = false;
                int duration = 0;
                for (int i = 0; i < livingEntity.getActiveEffects().size(); i++) {
                    if(((MobEffectInstance) livingEntity.getActiveEffects().toArray()[i]).getEffect() == ModEffects.EXTENSION_COOLDOWN.get()){
                        hasCooldown = true;
                    }
                }
                if (!hasCooldown){
                    for (int i = 0; i < livingEntity.getActiveEffects().size(); i++) {
                        MobEffectInstance effect = (MobEffectInstance) livingEntity.getActiveEffects().toArray()[i];
                        if (!(effect.getEffect() == ModEffects.EXTENSION_COOLDOWN.get())) {
                            if (!effect.getEffect().isInstantenous()) {
                                int a = (effect.duration * 2);
                                int b = (effect.duration / 3);
                                effect.duration = a - b;
                                if ((a-b) > duration){
                                    duration = a - b;
                                }
                                effect.update(effect);
                            }
                        }
                    }
                    livingEntity.addEffect(new MobEffectInstance(ModEffects.EXTENSION_COOLDOWN.get(), duration + 120));
                }
            }
        }

        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            if (livingEntity.getActiveEffects().size() > 0) {
                boolean hasCooldown = false;
                int duration = 0;
                for (int i = 0; i < livingEntity.getActiveEffects().size(); i++) {
                    if(((MobEffectInstance) livingEntity.getActiveEffects().toArray()[i]).getEffect() == ModEffects.EXTENSION_COOLDOWN.get()){
                        hasCooldown = true;
                    }
                }
                if (!hasCooldown){
                    for (int i = 0; i < livingEntity.getActiveEffects().size(); i++) {
                        MobEffectInstance effect = (MobEffectInstance) livingEntity.getActiveEffects().toArray()[i];
                        if (!(effect.getEffect() == ModEffects.EXTENSION_COOLDOWN.get())) {
                            if (!effect.getEffect().isInstantenous()) {
                                int a = (effect.duration * 2);
                                int b = (effect.duration / 3);
                                effect.duration = a - b;
                                if ((a-b) > duration){
                                    duration = a - b;
                                }
                                effect.update(effect);
                            }
                        }
                    }
                    livingEntity.addEffect(new MobEffectInstance(ModEffects.EXTENSION_COOLDOWN.get(), duration + 120));
                }
            }
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return true;
        }
    });//New
    public static final RegistrySupplier<MobEffect> POTENCY = EFFECTS.register("potency", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 16711935) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {

        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return false;
        }
    });//New
    //Neutral
    public static final RegistrySupplier<MobEffect> HOMING = EFFECTS.register("homing", () -> new MobEffect(MobEffectCategory.NEUTRAL, 36863) {

        public void applyEffectTick(LivingEntity livingEntity, int i) {
            if (livingEntity instanceof ServerPlayer && !livingEntity.isSpectator()) {
                ServerPlayer serverPlayer = ((ServerPlayer) livingEntity);
                Vec3 pos;
                if (serverPlayer.getRespawnPosition() != null && (serverPlayer.getLevel().getBlockState(serverPlayer.getRespawnPosition()).getBlock() instanceof BedBlock)) {
                    pos = Vec3.atBottomCenterOf(serverPlayer.getRespawnPosition());
                    serverPlayer.connection.teleport(pos.x, pos.y, pos.z, Mth.wrapDegrees(serverPlayer.getYRot()), Mth.wrapDegrees(serverPlayer.getXRot()));
                } else {
                    pos = Vec3.atBottomCenterOf(serverPlayer.getLevel().getSharedSpawnPos());
                    serverPlayer.connection.teleport(pos.x, pos.y, pos.z, Mth.wrapDegrees(serverPlayer.getYRot()), Mth.wrapDegrees(serverPlayer.getXRot()));
                }
            } else {
                Vec3 pos = Vec3.atBottomCenterOf(livingEntity.getLevel().getSharedSpawnPos());
                livingEntity.teleportTo(pos.x, pos.y, pos.z);
            }
        }

        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            if (livingEntity instanceof ServerPlayer && !livingEntity.isSpectator()) {
                ServerPlayer serverPlayer = ((ServerPlayer) livingEntity);
                Vec3 pos;
                if (serverPlayer.getRespawnPosition() != null && (serverPlayer.getLevel().getBlockState(serverPlayer.getRespawnPosition()).getBlock() instanceof BedBlock)) {
                    pos = Vec3.atBottomCenterOf(serverPlayer.getRespawnPosition());
                    serverPlayer.connection.teleport(pos.x, pos.y, pos.z, Mth.wrapDegrees(serverPlayer.getYRot()), Mth.wrapDegrees(serverPlayer.getXRot()));
                } else {
                    pos = Vec3.atBottomCenterOf(serverPlayer.getLevel().getSharedSpawnPos());
                    serverPlayer.connection.teleport(pos.x, pos.y, pos.z, Mth.wrapDegrees(serverPlayer.getYRot()), Mth.wrapDegrees(serverPlayer.getXRot()));
                }
            } else {
                Vec3 pos = Vec3.atBottomCenterOf(livingEntity.getLevel().getSharedSpawnPos());
                livingEntity.teleportTo(pos.x, pos.y, pos.z);
            }
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return true;
        }
    });//New
    public static final RegistrySupplier<MobEffect> RECOVERY = EFFECTS.register("recovery", () -> new MobEffect(MobEffectCategory.NEUTRAL, 14948064) {
        public void applyEffectTick(LivingEntity livingEntity, int i) {
            if (livingEntity instanceof ServerPlayer && !livingEntity.isSpectator()) {
                ServerPlayer serverPlayer = ((ServerPlayer) livingEntity);
                System.out.println("is player");
                if (serverPlayer.getLastDeathLocation().isPresent()) {
                    System.out.println("Has death location");
                    if (serverPlayer.getLevel().dimension() == serverPlayer.getLastDeathLocation().get().dimension()) {
                        System.out.println("is in the same world");
                        Vec3 pos = Vec3.atBottomCenterOf(serverPlayer.getLastDeathLocation().get().pos());
                        serverPlayer.connection.teleport(pos.x, pos.y, pos.z, Mth.wrapDegrees(serverPlayer.getYRot()), Mth.wrapDegrees(serverPlayer.getXRot()));
                    }
                }
            }
        }

        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            if (livingEntity instanceof ServerPlayer && !livingEntity.isSpectator()) {
                ServerPlayer serverPlayer = ((ServerPlayer) livingEntity);
                System.out.println("is player");
                if (serverPlayer.getLastDeathLocation().isPresent()) {
                    System.out.println("Has death location");
                    if (serverPlayer.getLevel().dimension() == serverPlayer.getLastDeathLocation().get().dimension()) {
                        System.out.println("is in the same world");
                        Vec3 pos = Vec3.atBottomCenterOf(serverPlayer.getLastDeathLocation().get().pos());
                        serverPlayer.connection.teleport(pos.x, pos.y, pos.z, Mth.wrapDegrees(serverPlayer.getYRot()), Mth.wrapDegrees(serverPlayer.getXRot()));
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
    });//New
    //Harmful
    public static final RegistrySupplier<MobEffect> THUNDEROUS = EFFECTS.register("thunderous", () -> new MobEffect(MobEffectCategory.HARMFUL, 10485759) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            Utils.lightning(livingEntity, null, amplifier);
        }

        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            Utils.lightning(livingEntity, null, amplifier);
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return true;
        }
    });
    public static final RegistrySupplier<MobEffect> EXPLOSIVE = EFFECTS.register("explosive", () -> new MobEffect(MobEffectCategory.HARMFUL, 1514264) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (livingEntity.getLevel() != null) {
                ServerLevel level = (ServerLevel) livingEntity.getLevel();
                if (!livingEntity.isSpectator()) {
                    if (livingEntity.getLevel().dimension() == level.NETHER) {
                        Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                    } else {
                        if (amplifier > 4) {
                            Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                        } else {
                            Utils.explode(level, livingEntity.blockPosition(), amplifier);
                        }
                    }
                }
            }
        }

        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int amplifier, double damage) {
            if (livingEntity.getLevel() != null) {
                ServerLevel level = (ServerLevel) livingEntity.getLevel();
                if (!livingEntity.isSpectator()) {
                    if (livingEntity.getLevel().dimension() == level.NETHER) {
                        Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                    } else {
                        if (amplifier > 4) {
                            Utils.explode(level, livingEntity.blockPosition(), amplifier, true);
                        } else {
                            Utils.explode(level, livingEntity.blockPosition(), amplifier);
                        }
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
    public static final RegistrySupplier<MobEffect> BURNING = EFFECTS.register("burning", () -> new MobEffect(MobEffectCategory.HARMFUL, 16740608) {
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
    public static final RegistrySupplier<MobEffect> FREEZING = EFFECTS.register("freezing", () -> new MobEffect(MobEffectCategory.HARMFUL, 1572863) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (livingEntity.canFreeze()) {
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
    public static final RegistrySupplier<MobEffect> CORROSIVE = EFFECTS.register("corrosive", () -> new MobEffect(MobEffectCategory.HARMFUL, 65420) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
            if (livingEntity.getLevel() != null) {
                ServerLevel level = (ServerLevel) livingEntity.getLevel();
                Random random = new Random();
                if (!livingEntity.isSpectator() && level != null && level.getServer().getTickCount() % 10 == 0) {
                    MinecraftServer server = level.getServer();
                    if (livingEntity instanceof ServerPlayer) {
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
                        for (int i = 0; i < inventory.getContainerSize(); i++) {
                            Item item = inventory.getItem(i).getItem();
                            ItemStack itemStack = inventory.getItem(i);
                            if (itemStack.isDamageableItem()) {
                                Utils.damageItem(livingEntity, itemStack, 1 + amplifier);
                            } else if (!itemStack.isDamageableItem() && resultsWithoutDuplicates.contains(item)) {
                                if (random.nextInt(100) >= 90) {
                                    if (random.nextInt(3) <= amplifier) {
                                        itemStack.shrink(1);
                                        //livingEntity.playSound(Registry.SOUND_EVENT.get(new ResourceLocation("entity.item.break")));
                                    }
                                }
                            }
                        }
                    } else if (livingEntity instanceof IronGolem) {
                        livingEntity.hurt(DamageSource.MAGIC, 1f + amplifier);//take iron damage
                    } else {
                        if (livingEntity.hasItemInSlot(EquipmentSlot.MAINHAND)) {
                            Utils.damageItem(livingEntity, EquipmentSlot.MAINHAND, 1 + amplifier);
                        }
                        if (livingEntity.hasItemInSlot(EquipmentSlot.OFFHAND)) {
                            Utils.damageItem(livingEntity, EquipmentSlot.OFFHAND, 1 + amplifier);
                        }
                        if (livingEntity.hasItemInSlot(EquipmentSlot.HEAD)) {
                            Utils.damageItem(livingEntity, EquipmentSlot.HEAD, 1 + amplifier);
                        }
                        if (livingEntity.hasItemInSlot(EquipmentSlot.CHEST)) {
                            Utils.damageItem(livingEntity, EquipmentSlot.CHEST, 1 + amplifier);
                        }
                        if (livingEntity.hasItemInSlot(EquipmentSlot.LEGS)) {
                            Utils.damageItem(livingEntity, EquipmentSlot.LEGS, 1 + amplifier);
                        }
                        if (livingEntity.hasItemInSlot(EquipmentSlot.FEET)) {
                            Utils.damageItem(livingEntity, EquipmentSlot.FEET, 1 + amplifier);
                        }
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
    //Cooldown
    public static final RegistrySupplier<MobEffect> EXTENSION_COOLDOWN = EFFECTS.register("extension_cooldown", () -> new MobEffect(MobEffectCategory.NEUTRAL, 16711935) {
        public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        }

        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration >= 1;
        }

        public boolean isInstantenous() {
            return false;
        }
    });//New

    public static RegistrySupplier<MobEffect> register(String name, Supplier<MobEffect> mobEffect) {
        return EFFECTS.register(name, mobEffect);
    }
}
