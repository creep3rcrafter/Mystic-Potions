package net.creep3rcrafter.mysticpotions.mixin;

import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {

    /*
    @Inject(method = "getDestroyProgress", at = @At("RETURN"), cancellable = true)
    public void inject1(BlockState blockState, Player player, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Float> cir) {
        float f = blockState.getDestroySpeed(blockGetter, blockPos);
        if (f == -1.0F) {
            cir.setReturnValue(0.0F);
        } else {
            int i = player.hasCorrectToolForDrops(blockState) ? 30 : 100;
            if (player.hasEffect(ModEffects.IRON_FIST.get())
                    && (player.getInventory().getSelected().isEmpty() || player.getInventory().getSelected().getItem() instanceof BlockItem)){
                cir.setReturnValue(((player.getDestroySpeed(blockState) + 4) * 1.5f) / f / (float)i);
            }else{
                cir.setReturnValue(player.getDestroySpeed(blockState) / f / (float)i);
            }
        }
    }
     */
}
