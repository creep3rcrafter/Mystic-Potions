package net.creep3rcrafter.mysticpotions.mixin;

import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    protected abstract boolean isInRain();

    @Shadow
    public abstract boolean updateFluidHeightAndDoFluidPushing(TagKey<Fluid> tagKey, double d);

    @Inject(method = "isInWaterOrRain()Z", at = @At("HEAD"), cancellable = true)
    public void inject(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.updateFluidHeightAndDoFluidPushing(FluidTags.WATER, 0.014D) || this.isInRain());
    }
}
