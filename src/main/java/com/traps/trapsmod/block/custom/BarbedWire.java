package com.traps.trapsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class BarbedWire extends HorizontalDirectionalBlock {
    public static final MapCodec<BarbedWire> CODEC = simpleCodec(properties -> new BarbedWire(1,1,properties));
    private final float damage;
    private final float speedMult;

    public BarbedWire(float damage,float speedMult,Properties properties) {
        super(properties);
        this.damage = damage;
        this.speedMult = speedMult;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        double normalMult = (double) speedMult;
        Vec3 speedMultiplier = new Vec3(normalMult, normalMult * 0.1, normalMult);
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(MobEffects.WEAVING)) {
                double newNormalMult = (double) speedMult * 2;
                speedMultiplier = new Vec3(newNormalMult, newNormalMult * 2, newNormalMult);
            }
        }

        if (level instanceof ServerLevel serverLevel) {
            entity.hurtServer(serverLevel, serverLevel.damageSources().generic(),damage);
        }

        entity.makeStuckInBlock(state, speedMultiplier);
    }
}
