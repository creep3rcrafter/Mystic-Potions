package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.world.effect.MobEffect;
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

    @Shadow @Nullable private String descriptionId;

    @Inject(method = "applyEffectTick(Lnet/minecraft/world/entity/LivingEntity;I)V", at = @At("HEAD"), cancellable = true)
    public void inject(LivingEntity livingEntity, int i, CallbackInfo ci) {
        if (livingEntity.hasEffect(ModEffects.NULLIFIER.get())) {
            System.out.println(descriptionId);
            ci.cancel();
        }
    }

    @Inject(method = "applyInstantenousEffect(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/LivingEntity;ID)V", at = @At("HEAD"), cancellable = true)
    public void inject2(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int i, double d, CallbackInfo ci) {
        if (livingEntity.hasEffect(ModEffects.NULLIFIER.get())) {
            System.out.println(descriptionId + " Instant");
            ci.cancel();
        }
    }
}
