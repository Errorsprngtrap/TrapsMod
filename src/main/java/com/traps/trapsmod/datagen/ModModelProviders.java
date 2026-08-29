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
    private static final TextureSlot BARBED_WIRE_TEXTURE_SLOT = TextureSlot.create("0");
    private static final TextureSlot FAKE_FLOOR_TEXTURE_SLOT = TextureSlot.create("0");
    private static final TextureSlot SPIKE_TRAP_ON_TEXTURE_SLOT = TextureSlot.create("0");
    private static final TextureSlot SPIKE_TRAP_OFF_TEXTURE_SLOT = TextureSlot.create("0");

    public ModModelProviders(PackOutput output) {
        super(output, TrapsMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //items
        itemModels.generateFlatItem(ModItems.TEST_ITEM.get(), ModelTemplates.FLAT_ITEM);

        //Blocks
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

        //Barbed WIRE
        List<Block> barbedWireBlocks = new ArrayList<>();
        barbedWireBlocks.add(ModBlocks.BARBED_WIRE.get());

        for (Block barbedWireBlock : barbedWireBlocks) {
            Identifier modelID = barbedWireModel.create(
                    barbedWireBlock,
                    new TextureMapping().put(BARBED_WIRE_TEXTURE_SLOT,TextureMapping.getBlockTexture(barbedWireBlock)),
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createSimpleBlock(barbedWireBlock,
                            BlockModelGenerators.plainVariant(modelID))
                                    .with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING)
            );
        }

        //FakeFloor
        List<Block> fakeFloorBlocks = new ArrayList<>();
        fakeFloorBlocks.add(ModBlocks.DIRT_FAKE_FLOOR.get());
        fakeFloorBlocks.add(ModBlocks.GRASS_FAKE_FLOOR.get());

        for (Block fakeFloorBlock : fakeFloorBlocks) {
            Identifier modelID = fakeFloorModel.create(
                    fakeFloorBlock,
                    new TextureMapping().put(FAKE_FLOOR_TEXTURE_SLOT,TextureMapping.getBlockTexture(fakeFloorBlock)),
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createSimpleBlock(fakeFloorBlock,
                                    BlockModelGenerators.plainVariant(modelID))
            );
        }

        //Classic SpikeTrap
        List<Block> Spikeblocks = new ArrayList<>();
        Spikeblocks.add(ModBlocks.SPIKE_TRAP.get());
        Spikeblocks.add(ModBlocks.POISON_SPIKE_TRAP.get());

        for (Block spikeblock : Spikeblocks) {
            Identifier modelID = spikeTrapOn.create(
                    spikeblock,
                    new TextureMapping().put(SPIKE_TRAP_ON_TEXTURE_SLOT,TextureMapping.getBlockTexture(spikeblock)),
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createSimpleBlock(spikeblock,
                            BlockModelGenerators.plainVariant(modelID))
            );
        }

    }

    ModelTemplate mineModel = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/mine_template_model")),
            Optional.empty(),
            MINE_TEXTURE_SLOT
    );

    ModelTemplate barbedWireModel = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/barbed_wire_template_model")),
            Optional.empty(),
            BARBED_WIRE_TEXTURE_SLOT
    );

    ModelTemplate fakeFloorModel = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/fake_floor_template_model")),
            Optional.empty(),
            FAKE_FLOOR_TEXTURE_SLOT
    );

    ModelTemplate spikeTrapOn = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/spiketrap_template_model")),
            Optional.empty(),
            SPIKE_TRAP_ON_TEXTURE_SLOT
    );

    ModelTemplate spikeTrapOff = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(TrapsMod.MOD_ID,"block/spiketrap_off_template_model")),
            Optional.empty(),
            SPIKE_TRAP_OFF_TEXTURE_SLOT
    );


}
