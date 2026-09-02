package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.block.ModBlocks;
import com.traps.trapsmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TrapsMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //here you put tags ect with tag add ect
        tag(ModTags.Blocks.BEARTRAP)
                .add(ModBlocks.BEARTRAP.get())
        ;

        tag(ModTags.Blocks.BARBED_WIRE)
            .add(ModBlocks.BARBED_WIRE.get())
        ;

        tag(ModTags.Blocks.FAKE_FLOOR)
                .add(ModBlocks.GRASS_FAKE_FLOOR.get())
                .add(ModBlocks.DIRT_FAKE_FLOOR.get())
        ;

        tag(ModTags.Blocks.SPIKE)
                .add(ModBlocks.SPIKE_TRAP.get())
                .add(ModBlocks.POISON_SPIKE_TRAP.get())
                .add(ModBlocks.REDSTONE_SPIKE_TRAP.get())
                .add(ModBlocks.REDSTONE_POISON_SPIKE_TRAP.get())
        ;

        tag(ModTags.Blocks.MINE)
                .add(ModBlocks.MINE.get())
                .add(ModBlocks.STEALTH_MINE.get())
                .add(ModBlocks.IMPROVED_MINE.get())
        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BEARTRAP.get())

                .add(ModBlocks.SPIKE_TRAP.get())
                .add(ModBlocks.POISON_SPIKE_TRAP.get())
                .add(ModBlocks.REDSTONE_SPIKE_TRAP.get())
                .add(ModBlocks.REDSTONE_POISON_SPIKE_TRAP.get())

                .add(ModBlocks.BARBED_WIRE.get())

                .add(ModBlocks.MINE.get())
                .add(ModBlocks.STEALTH_MINE.get())
                .add(ModBlocks.IMPROVED_MINE.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BEARTRAP.get())

                .add(ModBlocks.SPIKE_TRAP.get())
                .add(ModBlocks.POISON_SPIKE_TRAP.get())
                .add(ModBlocks.REDSTONE_SPIKE_TRAP.get())
                .add(ModBlocks.REDSTONE_POISON_SPIKE_TRAP.get())

                .add(ModBlocks.BARBED_WIRE.get())

                .add(ModBlocks.MINE.get())
                .add(ModBlocks.STEALTH_MINE.get())
                .add(ModBlocks.IMPROVED_MINE.get())
        ;

    }
}
