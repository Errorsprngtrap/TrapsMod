package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import com.traps.trapsmod.block.ModBlocks;
import com.traps.trapsmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.obj.ObjMaterialLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModModelProviders extends ModelProvider {
    private static final TextureSlot MINE_TEXTURE_SLOT = TextureSlot.create("0");

    public ModModelProviders(PackOutput output) {
        super(output, TrapsMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //items
        itemModels.generateFlatItem(ModItems.TEST_ITEM.get(), ModelTemplates.FLAT_ITEM);

        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(ModBlocks.BARBED_WIRE.get(),
                BlockModelGenerators.plainVariant(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/barbed_wire")))
                .with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));

        //Mine
        List<Block> mineBlocks = new ArrayList<>();
        mineBlocks.add(ModBlocks.MINE.get());
        mineBlocks.add(ModBlocks.IMPROVED_MINE.get());
        mineBlocks.add(ModBlocks.STEALTH_MINE.get());

        for (Block mineBlock : mineBlocks) {
            Identifier modelID = mineModel.create(
                    mineBlock,
                    new TextureMapping().put(MINE_TEXTURE_SLOT,TextureMapping.getBlockTexture(mineBlock)),
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createSimpleBlock(mineBlock,
                            BlockModelGenerators.plainVariant(modelID))
            );
        }

    }

    ModelTemplate mineModel = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/mine_template_model")),
            Optional.empty(),
            MINE_TEXTURE_SLOT
    );



    //base for generator
//    public static MultiVariantGenerator createSimpleBlock(Block block, MultiVariant variant) {
//        return MultiVariantGenerator.dispatch(block, variant);
//    }

}
