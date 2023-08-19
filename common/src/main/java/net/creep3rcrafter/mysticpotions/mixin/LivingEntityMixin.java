package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public abstract boolean removeAllEffects();

    @Shadow
    public abstract boolean addEffect(MobEffectInstance mobEffectInstance);

    @Shadow
    public void setHealth(float v) {
    }

    @Shadow
    public abstract boolean hasEffect(MobEffect mobEffect);

    @Shadow
    public abstract boolean removeEffect(MobEffect mobEffect);

    @Shadow
    @Nullable
    public abstract MobEffectInstance getEffect(MobEffect mobEffect);

    @Inject(method = "checkTotemDeathProtection", at = @At("HEAD"), cancellable = true)//return
    public void inject1(DamageSource damageSource, CallbackInfoReturnable<Boolean> callback) {
        if (this.hasEffect(ModEffects.UNDYING.get())) {
            this.setHealth(1.0F);
            this.removeEffect(ModEffects.UNDYING.get());
            this.removeAllEffects();
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            this.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
            this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            this.getLevel().broadcastEntityEvent(this, (byte) 35);
            callback.setReturnValue(true);
        }
    }

    @ModifyVariable(method = "travel", at = @At("LOAD"), name = "f2", ordinal = 0, index = 8)//return
    public float inject2(float value) {
        if (this.hasEffect(ModEffects.SPLIPPERY.get()) && this.isOnGround()) {
            int amplifier = this.getEffect(ModEffects.SPLIPPERY.get()).getAmplifier();
            return (((amplifier / (-300f)) + 1) * 0.98f);
        }
        return value;
    }

    @ModifyVariable(method = "travel", at = @At("LOAD"), name = "d0", ordinal = 0, index = 2)//return
    public double inject3(double value) {
        if (this.hasEffect(ModEffects.GRAVITATION.get())) {
            if (this.isCrouching()) {
                return 0.08D;
            } else {
                return -0.04;
            }
        }
        return value;
    }
    /*

    @Inject(method = "getEyeHeight", at = @At("RETURN"), cancellable = true)//return
    public void inject4(Pose pose, EntityDimensions entityDimensions, CallbackInfoReturnable<Float> cir) {
        if (this.hasEffect(ModEffects.GRAVITATION.get())) {
            cir.setReturnValue(pose == Pose.SLEEPING ? 0.2F : entityDimensions.height * 0.15f);
        }else{
            cir.setReturnValue(pose == Pose.SLEEPING ? 0.2F : entityDimensions.height * 0.85f);
        }
    }
     */
}

//explosive crashes when not instant