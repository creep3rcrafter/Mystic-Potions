package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
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
    public void setHealth(float v) {}

    @Shadow
    public abstract boolean hasEffect(MobEffect mobEffect);

    @Shadow
    public void defineSynchedData() {}

    @Shadow
    public void readAdditionalSaveData(CompoundTag compoundTag) {}

    @Shadow
    public void addAdditionalSaveData(CompoundTag compoundTag) {}

    @Shadow
    public Packet<?> getAddEntityPacket() {return null;}

    @Shadow public abstract boolean removeEffect(MobEffect mobEffect);

    @Inject(method = "checkTotemDeathProtection(Lnet/minecraft/world/damagesource/DamageSource;)Z", at = @At("HEAD"), cancellable = true)//return
    public void inject(DamageSource damageSource, CallbackInfoReturnable callback) {
        if (this.hasEffect(ModEffects.UNDYING.get())) {
            this.setHealth(1.0F);
            this.removeEffect(ModEffects.UNDYING.get());
            this.removeAllEffects();
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            this.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
            this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            this.level.broadcastEntityEvent(this, (byte) 35);
            callback.setReturnValue(true);
        }
    }
}
