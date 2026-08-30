package com.traps.trapsmod.block.custom;

import com.traps.trapsmod.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BearTrapBlock extends Block {
    public static final BooleanProperty CLOSED = BooleanProperty.create("closed");
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 4, 16);
    private static final VoxelShape COLLISION_SHAPE = Block.box(0,0,0,16,1,16);

    public BearTrapBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLOSED, false));

    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CLOSED);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (!level.isClientSide()) {
            boolean isOn = state.getValue(CLOSED);
            if (!isOn) {
                level.setBlock(pos,state.setValue(CLOSED,true), 3);
                if (level instanceof ServerLevel serverLevel) {
                    entity.hurtServer(serverLevel, serverLevel.damageSources().generic(),8);

                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.addEffect(new MobEffectInstance(
                                ModEffects.BLEED_EFFECT,260,1,false,true
                        ));
                        livingEntity.addEffect(new MobEffectInstance(
                                MobEffects.SLOWNESS,260,4,false,false
                        ));
                    }

                }

            }
        }
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }

}
