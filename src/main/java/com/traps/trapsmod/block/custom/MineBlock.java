package com.traps.trapsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MineBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(6,0,6,10,1,10);

    public MineBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        System.out.println("MineBlock::stepOn");
        explode(level,pos);
    }

    protected void explode(Level level,BlockPos pos) {
        System.out.println("MineBlock::explode entered");
        if (level instanceof ServerLevel) {
            System.out.println("MineBlock::level ok");
            level.explode(null,(double) pos.getX(),(double) pos.getY(),(double) pos.getZ(),10,Level.ExplosionInteraction.MOB);
            System.out.println("MineBlock::boom");
            //level.explode(null,pos.getX(),pos.getY(),pos.getZ(), Level.ExplosionInteraction.MOB);
            //level.explode((Entity)null, level.damageSources().badRespawnPointExplosion(boomPos), damageCalculator, boomPos, 5.0F, true, ExplosionInteraction.BLOCK);
        }
    }
}
