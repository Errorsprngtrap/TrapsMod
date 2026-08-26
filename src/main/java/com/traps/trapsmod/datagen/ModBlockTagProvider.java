package com.traps.trapsmod.datagen;

import com.traps.trapsmod.TrapsMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TrapsMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //here you put tags ect with tag add ect
    }
}
