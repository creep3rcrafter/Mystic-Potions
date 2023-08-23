package net.creep3rcrafter.mysticpotions.utils;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class Tester {
    public static boolean testEffect (MobEffectInstance mobEffectInstance, LivingEntity livingEntity, Level level){
        if (!level.isClientSide) {
            level.addFreshEntity(livingEntity);
            livingEntity.addEffect(mobEffectInstance);
            MobEffect mobEffect = mobEffectInstance.getEffect();
            if (mobEffect == ModEffects.AIR_SWIM.get()){

            }
        }
        return false;
    }

}
