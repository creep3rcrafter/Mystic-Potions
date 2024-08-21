package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmBlock.class)
public class FarmBlockMixin {
    @Inject(method = "fallOn", at = @At("HEAD"),cancellable = true)
    public void inject1(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f, CallbackInfo ci) {
        if (entity instanceof LivingEntity && ((LivingEntity)entity).hasEffect(ModEffects.NIMBLE.get())){
            ci.cancel();
        }
    }
}