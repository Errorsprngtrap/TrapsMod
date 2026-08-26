package com.traps.trapsmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class BarbedWire extends HorizontalDirectionalBlock {
    public BarbedWire(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }
}
