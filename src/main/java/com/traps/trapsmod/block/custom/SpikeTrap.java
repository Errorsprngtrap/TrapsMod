package com.traps.trapsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpikeTrap extends Block {
    private final Holder<MobEffect> effects;
    private final Float damage;

    public SpikeTrap(Holder<MobEffect> effects,Float damage, Properties properties) {
        super(properties);
        this.effects = effects;
        this.damage = damage;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (entity instanceof LivingEntity livingEntity) {
            if (effects != null) {
                livingEntity.addEffect(new MobEffectInstance(effects, 200, 0));
            }
        }

        if (level instanceof ServerLevel serverLevel) {
            entity.hurtServer(serverLevel, serverLevel.damageSources().generic(),damage);
        }
    }
}
