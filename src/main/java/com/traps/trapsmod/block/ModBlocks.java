package com.traps.trapsmod.block;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.block.custom.BarbedWire;
import com.traps.trapsmod.block.custom.MineBlock;
import com.traps.trapsmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TrapsMod.MOD_ID);

    public static final DeferredBlock<Block> STEALTH_MINE = registerBlock(
            "stealth_mine",
            properties -> new MineBlock(4,properties.noCollision())
    );

    public static final DeferredBlock<Block> MINE = registerBlock(
            "mine",
            properties -> new MineBlock(3,properties.noCollision())
    );

    public static final DeferredBlock<Block> IMPROVED_MINE = registerBlock(
            "improved_mine",
            properties -> new MineBlock(6,properties.noCollision())
    );

    public static final DeferredBlock<Block> BARBED_WIRE = registerBlock(
            "barbed_wire",
            properties -> new BarbedWire(1,0.25F,properties.noOcclusion().noCollision())
    );


    //Register Block Item
    private static  <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties,T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name,function);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    //Create an item for the block
    private static <T extends Block> void registerBlockItem(String name,DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name,properties -> new BlockItem(block.get(),properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
