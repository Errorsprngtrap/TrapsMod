package com.traps.trapsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MineBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(6,0,6,10,1,10);
    private final int radius;

    public MineBlock(int radius,Properties properties) {
        super(properties);
        this.radius = radius;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        explode(level,pos);
    }

    protected void explode(Level level,BlockPos pos) {
        if (level instanceof ServerLevel) {
            level.explode(null,(double) pos.getX(),(double) pos.getY(),(double) pos.getZ(),radius,Level.ExplosionInteraction.MOB);
        }
    }
}
