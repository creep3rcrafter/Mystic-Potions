package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BasePressurePlateBlock.class)
public class PressurePlateMixin {
    @Inject(method = "checkPressed", at = @At("HEAD"),cancellable = true)
    public void inject1(Entity entity, Level level, BlockPos blockPos, BlockState blockState, int i, CallbackInfo ci) {
        if (entity instanceof LivingEntity && ((LivingEntity)entity).hasEffect(ModEffects.NIMBLE.get())){
            ci.cancel();
        }
    }
}
