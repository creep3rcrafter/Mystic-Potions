package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEffectInstance.class)
public abstract class MobEffectInstanceMixin {
    @Shadow @Final private MobEffect effect;

    @Shadow public int amplifier;

    @Inject(method = "applyEffect", at = @At("HEAD"), cancellable = true)
    public void inject2(LivingEntity livingEntity, CallbackInfo ci) {
        int nullAmplifier = 0;
        System.out.println("apply");
        if (effect != ModEffects.NULLIFIER.get()) {
            System.out.println("");
            if (livingEntity.hasEffect(ModEffects.NULLIFIER.get())){
                System.out.println("has nullifier");
                nullAmplifier = livingEntity.getEffect(ModEffects.NULLIFIER.get()).amplifier;
                if (nullAmplifier >= amplifier){
                    System.out.println("is weaker");
                    System.out.println("canceled");
                    ci.cancel();
                }
            }
        }
    }
}
