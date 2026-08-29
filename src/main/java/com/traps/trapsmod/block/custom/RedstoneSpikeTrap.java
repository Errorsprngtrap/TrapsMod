package com.traps.trapsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class RedstoneSpikeTrap extends SpikeTrap{
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");

    public RedstoneSpikeTrap(Holder<MobEffect> effects, Float damage, Properties properties) {
        super(effects, damage, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()){
            if (state.getValue(POWERED)){
                level.setBlock(pos, state.setValue(POWERED, false), Block.UPDATE_ALL);
            } else {
                level.setBlock(pos, state.setValue(POWERED, true), Block.UPDATE_ALL);
            }

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}
