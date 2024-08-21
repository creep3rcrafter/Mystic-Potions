package net.creep3rcrafter.mysticpotions.utils;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Tuple;
import net.minecraft.world.Container;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class Utils {
    public static void lightning(LivingEntity livingEntity, ServerLevel serverLevel, int amplifier) {
        lightning(livingEntity, serverLevel);
        for (int i = 0; i < amplifier; i++) {
            Random random = new Random();
            BlockPos entityPos = livingEntity.blockPosition();
            BlockPos blockPos = entityPos.offset(random.nextInt(amplifier) - (amplifier / 2), random.nextInt(amplifier) - (amplifier / 2), random.nextInt(amplifier) - (amplifier / 2));
            LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
            lightningbolt.moveTo(Vec3.atBottomCenterOf(blockPos));
            lightningbolt.setCause(livingEntity instanceof ServerPlayer ? (ServerPlayer) livingEntity : null);
            serverLevel.addFreshEntity(lightningbolt);
        }
    }

    public static void lightning(LivingEntity livingEntity, ServerLevel serverLevel) {
        BlockPos entityPos = livingEntity.blockPosition();
        LightningBolt LightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
        LightningBolt.moveTo(Vec3.atBottomCenterOf(entityPos));
        LightningBolt.setCause(livingEntity instanceof ServerPlayer ? (ServerPlayer) livingEntity : null);
        serverLevel.addFreshEntity(LightningBolt);
    }

    public static void explode(Level level, BlockPos blockPos) {
        explode(level, blockPos, 4f);
    }

    public static void explode(Level level, BlockPos blockPos, float radius) {
        explode(level, blockPos, radius, false);
    }

    public static void explode(Level level, BlockPos blockPos, float radius, boolean fire) {
        level.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), radius, fire, Explosion.BlockInteraction.BREAK);
    }

    public static void explode(ServerLevel level, BlockPos blockPos) {
        explode(level, blockPos, 4f);
    }

    public static void explode(ServerLevel level, BlockPos blockPos, float radius) {
        explode(level, blockPos, radius, false);
    }

    public static void explode(ServerLevel level, BlockPos blockPos, float radius, boolean fire) {
        level.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), radius, fire, Explosion.BlockInteraction.BREAK);
    }

    public static int cropAgeToIndex(int age) {
        if (age > 6) {
            return 3;
        } else if (age > 3) {
            return 2;
        } else if (age > 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void dropXP(ServerLevel level, BlockPos blockPos) {
        int i = 3 + level.random.nextInt(5) + level.random.nextInt(5);
        while (i > 0) {
            int j = ExperienceOrb.getExperienceValue(i);
            i -= j;
            level.addFreshEntity(new ExperienceOrb(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), j));
        }
    }

    public static void damageItem(LivingEntity livingEntity, EquipmentSlot equipmentSlot, int amplifier, Random random) {
        if (livingEntity.getItemBySlot(equipmentSlot).isDamageableItem()) {
            int chance = random.nextInt(10);
            if (chance >= 5) {
                Item item = livingEntity.getItemBySlot(equipmentSlot).getItem();

                if (ItemDamage.getItemDamageType(item) == ItemDamage.ItemDamageType.IRON) {
                    livingEntity.getItemBySlot(equipmentSlot).hurtAndBreak((ItemDamage.ItemDamageType.IRON.damage / 2) * amplifier, livingEntity, source -> {
                        source.broadcastBreakEvent(equipmentSlot);
                    });
                }
                if (ItemDamage.getItemDamageType(item) == ItemDamage.ItemDamageType.NETHERITE) {
                    livingEntity.getItemBySlot(equipmentSlot).hurtAndBreak((ItemDamage.ItemDamageType.NETHERITE.damage / 2) * amplifier, livingEntity, source -> {
                        source.broadcastBreakEvent(equipmentSlot);
                    });
                }
            }
        }
    }

    public static void damageItem(LivingEntity livingEntity, EquipmentSlot equipmentSlot, int damage) {
        if (livingEntity.getItemBySlot(equipmentSlot).isDamageableItem()) {
            livingEntity.getItemBySlot(equipmentSlot).hurtAndBreak(damage, livingEntity, source -> {
                source.broadcastBreakEvent(equipmentSlot);
            });
        }
    }

    public static void damageItem(LivingEntity livingEntity, ItemStack itemStack, int damage) {
        if (itemStack.isDamageableItem()) {
            itemStack.hurtAndBreak(damage, livingEntity, source -> {
                source.broadcastBreakEvent(EquipmentSlot.CHEST);
            });
        }
    }

    public static <C extends Container, T extends Recipe<C>> List<Item> recipesContainsItems(MinecraftServer server, RecipeType<T> recipeType, List<Item> containsList) {
        List<Item> results = new ArrayList<Item>();
        server.getRecipeManager().getAllRecipesFor(recipeType).forEach(recipe -> {
            recipe.getIngredients().forEach(ingredient -> {
                for (Item item : containsList) {
                    if (ingredient.test(new ItemStack(item))) {
                        results.add(recipe.getResultItem().getItem());
                    }
                }
            });
        });
        return new ArrayList<Item>(new HashSet<>(results));
    }

    public int getDistanceToEntity(LivingEntity livingEntity, BlockPos pos) {
        double deltaX = livingEntity.getX() - pos.getX();
        double deltaY = livingEntity.getY() - pos.getY();
        double deltaZ = livingEntity.getZ() - pos.getZ();
        return (int) Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
    }

    public List<BlockPos> getNearbyBlocks(LivingEntity livingEntity, int radius) {
        List<BlockPos> blockPositions = new ArrayList<BlockPos>();
        for (int x = livingEntity.blockPosition().getX() - radius; x <= livingEntity.blockPosition().getX() + radius; x++) {
            for (int y = livingEntity.blockPosition().getY() - radius; y <= livingEntity.blockPosition().getY() + radius; y++) {
                for (int z = livingEntity.blockPosition().getZ() - radius; z <= livingEntity.blockPosition().getZ() + radius; z++) {
                    blockPositions.add(new BlockPos(x, y, z));
                }
            }
        }
        return blockPositions;
    }
    public static boolean removeWaterBreadthFirstSearch(Level level, BlockPos blockPos) {
        Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
        queue.add(new Tuple(blockPos, 0));
        int i = 0;

        while(!queue.isEmpty()) {
            Tuple<BlockPos, Integer> tuple = (Tuple)queue.poll();
            BlockPos blockPos2 = (BlockPos)tuple.getA();
            int j = (Integer)tuple.getB();
            Direction[] var8 = Direction.values();
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Direction direction = var8[var10];
                BlockPos blockPos3 = blockPos2.relative(direction);
                BlockState blockState = level.getBlockState(blockPos3);
                FluidState fluidState = level.getFluidState(blockPos3);
                Material material = blockState.getMaterial();
                if (fluidState.is(FluidTags.WATER)) {
                    if (blockState.getBlock() instanceof BucketPickup && !((BucketPickup)blockState.getBlock()).pickupBlock(level, blockPos3, blockState).isEmpty()) {
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple(blockPos3, j + 1));
                        }
                    } else if (blockState.getBlock() instanceof LiquidBlock) {
                        level.setBlock(blockPos3, Blocks.AIR.defaultBlockState(), 3);
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple(blockPos3, j + 1));
                        }
                    } else if (material == Material.WATER_PLANT || material == Material.REPLACEABLE_WATER_PLANT) {
                        BlockEntity blockEntity = blockState.hasBlockEntity() ? level.getBlockEntity(blockPos3) : null;
                        Block.dropResources(blockState, level, blockPos3, blockEntity);
                        level.setBlock(blockPos3, Blocks.AIR.defaultBlockState(), 3);
                        ++i;
                        if (j < 6) {
                            queue.add(new Tuple(blockPos3, j + 1));
                        }
                    }
                }
            }

            if (i > 64) {
                break;
            }
        }

        return i > 0;
    }
}
