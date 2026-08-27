package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.block.ModBlocks;
import com.traps.trapsmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

public class ModModelProviders extends ModelProvider {

    public ModModelProviders(PackOutput output) {
        super(output, TrapsMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //items
        itemModels.generateFlatItem(ModItems.TEST_ITEM.get(), ModelTemplates.FLAT_ITEM);

        //blocks
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(ModBlocks.MINE.get(),
                BlockModelGenerators.plainVariant(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/mine"))));

        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(ModBlocks.IMPROVED_MINE.get(),
                BlockModelGenerators.plainVariant(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/improved_mine"))));

        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(ModBlocks.BARBED_WIRE.get(),
                BlockModelGenerators.plainVariant(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/barbed_wire"))));
    }
}
