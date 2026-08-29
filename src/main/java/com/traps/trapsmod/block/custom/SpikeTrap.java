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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpikeTrap extends Block {
    private final Holder<MobEffect> effects;
    private final Float damage;
    private static final VoxelShape SHAPE = Block.box(0,0,0,16,11,16);
    private static final VoxelShape COLLISION_SHAPE = Block.box(0,0,0,16,1,16);

    public SpikeTrap(Holder<MobEffect> effects,Float damage, Properties properties) {
        super(properties);
        this.effects = effects;
        this.damage = damage;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (entity instanceof LivingEntity livingEntity) {
            if (effects != null) {
                livingEntity.addEffect(new MobEffectInstance(effects, 140, 2));
            }
        }

        if (level instanceof ServerLevel serverLevel) {
            entity.hurtServer(serverLevel, serverLevel.damageSources().generic(),damage);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }
}
