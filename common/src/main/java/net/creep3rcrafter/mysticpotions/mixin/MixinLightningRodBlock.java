package net.creep3rcrafter.mysticpotions.mixin;
import net.creep3rcrafter.mysticpotions.register.ModPotions;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightningRodBlock.class)
public abstract class MixinLightningRodBlock {
    @Inject(method = "onLightningStrike(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V", at = @At("TAIL"))
    private void onLightningStrike(BlockState blockState, Level level, BlockPos blockPos, CallbackInfo info) {
        if(level.getBlockEntity(blockPos.below()) != null){
            if (level.getBlockEntity(blockPos.below()) instanceof BrewingStandBlockEntity){
                BrewingStandBlockEntity brewingStand = (BrewingStandBlockEntity) level.getBlockEntity(blockPos.below());
                for (int i = 0; i < brewingStand.items.size(); i++){
                    if (brewingStand.getItem(i).getItem() instanceof PotionItem){
                        if (PotionUtils.getPotion(brewingStand.getItem(i)) == Potions.AWKWARD){
                            PotionUtils.setPotion(brewingStand.getItem(i), ModPotions.THUNDEROUS_POTION.get());
                        }
                    }
                }
            }
        }

    }
}
