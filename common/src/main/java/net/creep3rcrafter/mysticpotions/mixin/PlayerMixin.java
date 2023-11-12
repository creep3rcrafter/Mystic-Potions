package net.creep3rcrafter.mysticpotions.mixin;

import net.creep3rcrafter.mysticpotions.register.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    /*
    @Shadow
    public abstract Inventory getInventory();

    @Inject(method = "hasCorrectToolForDrops", at = @At("RETURN"), cancellable = true)
    public void inject(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        ItemStack selected = this.getInventory().getSelected();
        if ((this.hasEffect(ModEffects.IRON_FIST.get()) && (selected.isEmpty() || selected.getItem() instanceof BlockItem)) || cir.getReturnValue()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getDestroySpeed", at = @At("RETURN"), cancellable = true)
    public void inject2(BlockState blockState, CallbackInfoReturnable<Float> cir) {
        ItemStack selected = this.getInventory().getSelected();
        if (this.hasEffect(ModEffects.IRON_FIST.get()) && (selected.isEmpty() || selected.getItem() instanceof BlockItem)) {
            int i = this.getEffect(ModEffects.IRON_FIST.get()).amplifier;
            cir.setReturnValue(cir.getReturnValue() + 5f + i);
        }
    }
     */

    @Inject(method = "attack", at = @At("RETURN"))
    public void inject2(Entity entity, CallbackInfo ci) {
        if (this.hasEffect(ModEffects.INFECTION.get())){
            if (entity instanceof LivingEntity){
                ((LivingEntity)entity).addEffect(new MobEffectInstance(ModEffects.INFECTION.get(),1200));
            }
        }
    }
}