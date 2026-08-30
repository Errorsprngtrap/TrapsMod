package com.traps.trapsmod.effect;

import com.traps.trapsmod.datagen.ModDamageTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BleedEffect extends MobEffect {

    public BleedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
        mob.hurtServer(serverLevel, ModDamageTypes.create(serverLevel,ModDamageTypes.BLEED_DAMAGE),1.0f);
        return super.applyEffectTick(serverLevel, mob, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        int interval = 100 >> amplification;
        return interval <= 0 || tickCount % interval == 0;
    }
}
