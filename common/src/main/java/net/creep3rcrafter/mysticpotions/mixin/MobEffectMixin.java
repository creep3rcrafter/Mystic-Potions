package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEffect.class)
public abstract class MobEffectMixin {
    /*
    @Inject(method = "applyEffectTick", at = @At("HEAD"), cancellable = true)
    public void inject2(LivingEntity livingEntity, int i, CallbackInfo ci) {
        int nullAmplifier = 0;
        if (livingEntity.hasEffect(ModEffects.NULLIFIER.get()) && livingEntity.getEffect(ModEffects.NULLIFIER.get()) != null){
            nullAmplifier = livingEntity.getEffect(ModEffects.NULLIFIER.get()).amplifier;
            if (nullAmplifier >= i){
                ci.cancel();
            }
        }
    }
    @Inject(method = "applyInstantenousEffect", at = @At("HEAD"), cancellable = true)
    public void inject2(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int i, double d, CallbackInfo ci) {
        int nullAmplifier = 0;
        if (livingEntity.hasEffect(ModEffects.NULLIFIER.get()) && livingEntity.getEffect(ModEffects.NULLIFIER.get()) != null){
            nullAmplifier = livingEntity.getEffect(ModEffects.NULLIFIER.get()).amplifier;
            if (nullAmplifier >= i){
                ci.cancel();
            }
        }
    }
     */
}
