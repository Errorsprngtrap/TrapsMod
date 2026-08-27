package com.traps.trapsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class BarbedWire extends HorizontalDirectionalBlock {
    public static final MapCodec<BarbedWire> CODEC = simpleCodec(BarbedWire::new);

    //public static final EnumProperty<Direction> FACING;

    public BarbedWire(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
